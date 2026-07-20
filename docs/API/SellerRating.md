# Seller Rating API

This document describes all endpoints related to seller ratings.

---

# Base URL

```
/api/ratings
```

---

# Create Seller Rating

Creates a new rating for a seller after a successful purchase.

## Endpoint

```
POST /api/ratings/advertisements/{advertisementId}
```

## Authentication

Required (JWT)

---

## Request Body

```json
{
  "score": 5,
  "comment": "Very polite seller and exactly as described."
}
```

---

## Validation

| Field | Rule |
|--------|------|
| score | Required |
| score | Integer |
| score | Between 1 and 5 |
| comment | Optional |
| comment | Maximum 500 characters |

---

## Success Response

HTTP 200 OK

```json
{
  "id": 15,
  "score": 5,
  "comment": "Very polite seller and exactly as described.",
  "reviewer": {
    "id": 8,
    "fullName": "Ali Ahmadi",
    "username": "ali"
  },
  "createdAt": "2026-07-20T18:42:10",
  "advertisementId": 32
}
```

---

## Business Rules

- User must be authenticated.
- Advertisement must exist.
- Advertisement must not be deleted.
- Advertisement must be SOLD.
- Reviewer must be the buyer of the advertisement.
- Reviewer cannot rate himself.
- Buyer account must be ACTIVE.
- Seller account must be ACTIVE.
- Only one rating is allowed for each buyer and advertisement.
- After saving the rating:
    - seller.averageRating is recalculated.
    - seller.ratingCount is recalculated.

---

## Possible Errors

| HTTP Status | ErrorCode |
|-------------|-----------|
| 400 | ADVERTISEMENT_NOT_PURCHASED |
| 400 | BUYER_ACCOUNT_NOT_ACTIVE |
| 400 | SELLER_ACCOUNT_NOT_ACTIVE |
| 400 | CANNOT_RATE_YOURSELF |
| 409 | RATING_ALREADY_EXISTS |
| 404 | ADVERTISEMENT_NOT_FOUND |
| 401 | UNAUTHORIZED |

---

# Get Seller Ratings

Returns seller ratings with pagination.

## Endpoint

```
GET /api/ratings/seller/{sellerId}
```

## Authentication

Not Required

---

## Query Parameters

| Name | Required | Default |
|------|----------|---------|
| page | No | 0 |
| size | No | 20 |
| sort | No | createdAt,desc |

---

## Example

```
GET /api/ratings/seller/5?page=0&size=10
```

---

## Success Response

```json
{
  "content": [
    {
      "id": 15,
      "score": 5,
      "comment": "Excellent seller.",
      "reviewer": {
        "id": 8,
        "fullName": "Ali Ahmadi",
        "username": "ali"
      },
      "createdAt": "2026-07-20T18:42:10",
      "advertisementId": 32
    },
    {
      "id": 12,
      "score": 4,
      "comment": "Everything was fine.",
      "reviewer": {
        "id": 14,
        "fullName": "Sara Hosseini",
        "username": "sara"
      },
      "createdAt": "2026-07-19T11:30:15",
      "advertisementId": 18
    }
  ],
  "totalElements": 2,
  "totalPages": 1,
  "number": 0,
  "size": 10
}
```

---

## Business Rules

- Seller must exist.
- Seller account must be ACTIVE.
- Ratings are ordered by newest first.
- Supports pagination.

---

## Possible Errors

| HTTP Status | ErrorCode |
|-------------|-----------|
| 404 | USER_NOT_FOUND |
| 400 | SELLER_ACCOUNT_NOT_ACTIVE |

---

# Seller Profile API

This endpoint returns seller information along with rating statistics.

> Implemented in **UserController**

## Endpoint

```
GET /api/users/{sellerId}/profile
```

## Authentication

Not Required

---

## Success Response

```json
{
  "id": 5,
  "fullName": "Mohammad Ahmadi",
  "username": "mohammad",
  "averageRating": 4.8,
  "ratingCount": 27
}
```

---

## Business Rules

- Seller must exist.
- Seller account must be ACTIVE.
- Rating statistics are updated automatically after every new rating.

---

## Possible Errors

| HTTP Status | ErrorCode |
|-------------|-----------|
| 404 | USER_NOT_FOUND |
| 400 | SELLER_ACCOUNT_NOT_ACTIVE |