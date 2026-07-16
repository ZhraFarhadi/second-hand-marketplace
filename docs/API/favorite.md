# Favorite API

---

# Overview

The Favorite module allows authenticated users to save advertisements for later viewing.

Favorites are implemented as a **toggle operation**, meaning the same endpoint is used to both add and remove an advertisement from the user's favorites.

This feature includes:

- Add Advertisement to Favorites
- Remove Advertisement from Favorites
- Get Favorite Advertisements
- Get Favorites Count

---

# Architecture

```
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

```
Client
    │
POST /api/favorites/{advertisementId}
    │
    ▼
Authenticate User
    │
Load Advertisement
    │
Check Advertisement Status
    │
Check Existing Favorite
    │
 ┌───────────────┐
 │ Exists ?      │
 └──────┬────────┘
        │
   Yes  │  No
        │
 Delete Favorite
        │
        ▼
  Favorite Removed
```

or

```
Client
    │
POST /api/favorites/{advertisementId}
    │
    ▼
Authenticate User
    │
Load Advertisement
    │
Create Favorite
    │
Save
    │
Favorite Added
```

---

## Get Favorites

```
Client
    │
GET /api/favorites
    │
    ▼
Authenticate User
    │
Load Favorites
    │
Sort By CreatedAt DESC
    │
Return Advertisement List
```

---

## Get Favorites Count

```
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

A user can add only **ACTIVE** advertisements to favorites.

A user cannot favorite:

- PENDING advertisements
- SOLD advertisements
- Deleted advertisements

Adding the same advertisement twice removes it from favorites.

Favorites are displayed from newest to oldest.

Only the owner of the favorites can access them.

---

# API Endpoints

---

# Toggle Favorite

Adds or removes an advertisement from favorites.

## Endpoint

```
POST /api/favorites/{advertisementId}
```

Authentication:

```
Required
```

---

## Success Response

When added

```
204 No Content
```

When removed

```
204 No Content
```

---

## Possible Errors

| HTTP | ErrorCode |
|------|-----------|
|401|UNAUTHORIZED|
|404|ADVERTISEMENT_NOT_FOUND|

---

# Get Favorite Advertisements

Returns the authenticated user's favorite advertisements.

## Endpoint

```
GET /api/favorites
```

Authentication:

```
Required
```

---

## Success Response

```json
[
  {
    "id": 5,
    "advertisement": {
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
      }
    }
  }
]
```

---

## Possible Errors

|HTTP|ErrorCode|
|----|----------|
|401|UNAUTHORIZED|

---

# Get Favorites Count

Returns the total number of favorite advertisements.

## Endpoint

```
GET /api/favorites/count
```

Authentication:

```
Required
```

---

## Success Response

```json
{
    "count": 12
}
```

---

## Possible Errors

|HTTP|ErrorCode|
|----|----------|
|401|UNAUTHORIZED|

---

# Error Codes

|ErrorCode|Description|
|----------|-----------|
|ADVERTISEMENT_NOT_FOUND|Advertisement not found or unavailable.|
|UNAUTHORIZED|Authentication required.|
|ACCESS_DENIED|Access denied.|

---

# Implementation Notes

- Favorite is implemented as a toggle operation.
- Each user can favorite an advertisement only once.
- A unique database constraint prevents duplicate favorites.
- Only ACTIVE advertisements can be added to favorites.
- Deleted advertisements are excluded from favorite lists.
- Favorite advertisements are ordered by creation date (newest first).
- Favorite responses reuse `AdvertisementSummaryResponse`.
- Authentication is required for all Favorite APIs.
- Favorite business logic is isolated inside `FavoriteService`.