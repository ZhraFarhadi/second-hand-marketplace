# Favorite API

---

# Overview

The Favorite module allows authenticated users to save advertisements for later viewing.

Favorites are implemented as a **toggle operation**, meaning the same endpoint is used to both add and remove an advertisement from the user's favorites.

To support the frontend UI, advertisement-related responses also include favorite state information so the client can correctly display the favorite (heart) icon.

This feature includes:

- Toggle Favorite
- Get Favorite Advertisements
- Get Favorites Count

---

# Architecture

```text
Client
   │
   │ Toggle / List Favorites
   ▼
FavoriteController
   │
   ▼
FavoriteService
   │
   ▼
FavoriteRepository
   │
   ▼
PostgreSQL
```

---

# Favorite Flow

## Toggle Favorite

```text
Client
    │
POST /api/favorites/{advertisementId}
    │
    ▼
Authenticate User
    │
Load Advertisement
    │
Validate Advertisement
    │
Check Advertisement Owner
    │
Check Existing Favorite
    │
 ┌───────────────┐
 │ Exists ?      │
 └──────┬────────┘
        │
   Yes  │  No
        │
Delete  │  Create
Favorite│  Favorite
        │
        ▼
Return Updated Favorite State
```

---

## Get Favorite Advertisements

```text
Client
    │
GET /api/favorites
    │
    ▼
Authenticate User
    │
Load Favorites
    │
Exclude Deleted Advertisements
    │
Sort By CreatedAt DESC
    │
Return Advertisement List
```

---

## Get Favorites Count

```text
Client
    │
GET /api/favorites/count
    │
    ▼
Authenticate User
    │
Count Favorites
    │
Return Count
```

---

# Business Rules

A user can favorite only **ACTIVE** advertisements.

A user cannot favorite:

- Their own advertisements
- PENDING advertisements
- SOLD advertisements
- Deleted advertisements

Adding an advertisement that is already in favorites removes it from favorites.

Favorites are displayed from newest to oldest.

Only the authenticated user can access their own favorites.

---

# Frontend Behavior

Advertisement-related DTOs expose two fields:

- `isFavorite`
- `isOwner`

The frontend should use them as follows:

| isOwner | isFavorite | UI Behavior |
|----------|------------|-------------|
| true | - | Hide favorite icon |
| false | true | Show filled heart |
| false | false | Show empty heart |

### My Advertisements

`MyAdvertisementSummaryResponse` does **not** contain:

- `isFavorite`
- `isOwner`

Therefore, the frontend must never display the favorite icon on the **My Advertisements** page.

---

# API Endpoints

---

# Toggle Favorite

Adds or removes an advertisement from the authenticated user's favorites.

## Endpoint

```http
POST /api/favorites/{advertisementId}
```

### Authentication

Required

---

## Success Response

### Advertisement added

```json
{
  "advertisementId": 21,
  "favorite": true
}
```

### Advertisement removed

```json
{
  "advertisementId": 21,
  "favorite": false
}
```

---

## Possible Errors

| HTTP | ErrorCode |
|------|-----------|
| 401 | UNAUTHORIZED |
| 403 | CANNOT_FAVORITE_OWN_ADVERTISEMENT |
| 404 | ADVERTISEMENT_NOT_FOUND |

---

# Get Favorite Advertisements

Returns the authenticated user's favorite advertisements.

## Endpoint

```http
GET /api/favorites
```

### Authentication

Required

---

## Success Response

```json
[
  {
    "id": 21,
    "title": "iPhone 14 Pro",
    "price": 85000000,
    "primaryImageUrl": "...",
    "category": {
      "id": 3,
      "name": "Mobile Phones"
    },
    "seller": {
      "id": 8,
      "fullName": "John Doe"
    },
    "city": {
      "id": 15,
      "name": "Tehran"
    },
    "isFavorite": true,
    "isOwner": false
  }
]
```

---

## Notes

- Responses reuse `AdvertisementSummaryResponse`.
- `isFavorite` is always `true` for this endpoint.
- `isOwner` remains available for consistency across advertisement APIs.

---

## Possible Errors

| HTTP | ErrorCode |
|------|-----------|
| 401 | UNAUTHORIZED |

---

# Get Favorites Count

Returns the total number of favorite advertisements.

## Endpoint

```http
GET /api/favorites/count
```

### Authentication

Required

---

## Success Response

```json
{
  "count": 12
}
```

---

## Possible Errors

| HTTP | ErrorCode |
|------|-----------|
| 401 | UNAUTHORIZED |

---

# Error Codes

| ErrorCode | Description |
|-----------|-------------|
| ADVERTISEMENT_NOT_FOUND | Advertisement not found or unavailable. |
| UNAUTHORIZED | Authentication required. |
| ACCESS_DENIED | Access denied. |
| CANNOT_FAVORITE_OWN_ADVERTISEMENT | Users cannot favorite their own advertisements. |

---

# Implementation Notes

- Favorite is implemented as a toggle operation.
- A user can favorite an advertisement only once.
- A unique database constraint prevents duplicate favorites.
- Only ACTIVE advertisements can be favorited.
- Users cannot favorite their own advertisements.
- Deleted advertisements are excluded from favorite lists.
- Favorite advertisements are ordered by favorite creation time (newest first).
- Favorite list responses reuse `AdvertisementSummaryResponse`.
- Authentication is required for all Favorite APIs.
- All favorite-related business logic is implemented inside `FavoriteService`.