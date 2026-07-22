# Admin API Documentation

## Overview

This document describes all administrator endpoints available in the SecondHand Marketplace backend.

All endpoints in this document require an authenticated user with the **ADMIN** role.

Base URL

```
/api/admin
```

Authentication

```
Authorization: Bearer <JWT_TOKEN>
```

Only users with role:

```
ROLE_ADMIN
```

can access these endpoints.

---

# Dashboard

## Get Dashboard Statistics

```
GET /api/admin/dashboard
```

Returns overall marketplace statistics.

### Response

```json
{
  "totalUsers": 125,
  "blockedUsers": 3,
  "totalAdvertisements": 520,
  "pendingAdvertisements": 11,
  "activeAdvertisements": 490,
  "soldAdvertisements": 19,
  "totalCategories": 18,
  "totalCities": 482,
  "totalProvinces": 31,
  "totalRatings": 77,
  "totalConversations": 153
}
```

---

# User Management

## Get Users

```
GET /api/admin/users
```

Returns paginated list of users ordered by creation date.

---

## Get User Details

```
GET /api/admin/users/{userId}
```

Returns complete information about a user.

---

## Block User

```
PUT /api/admin/users/{userId}/block
```

Blocks a user account.

### Response

```
204 No Content
```

---

## Unblock User

```
PUT /api/admin/users/{userId}/unblock
```

Activates a blocked user.

### Response

```
204 No Content
```

---

# Advertisement Review

## Get Pending Advertisements

```
GET /api/admin/reviews/pending
```

Returns advertisements waiting for approval.

---

## Get Review Details

```
GET /api/admin/reviews/{reviewId}
```

Returns review information.

---

## Approve Advertisement

```
PUT /api/admin/reviews/{reviewId}/approve
```

Approves advertisement and changes advertisement status.

---

## Reject Advertisement

```
PUT /api/admin/reviews/{reviewId}/reject
```

Rejects advertisement.

### Request

```json
{
    "reason": "Duplicate advertisement."
}
```

---

# Category Management

Base Path

```
/api/admin/categories
```

---

## Get Categories

```
GET /
```

Returns root categories.

---

## Get Category Details

```
GET /{categoryId}
```

Returns category information together with its attributes.

---

## Create Category

```
POST /
```

### Request

```json
{
    "name": "Electronics",
    "parentId": null
}
```

---

## Update Category

```
PUT /{categoryId}
```

### Request

```json
{
    "name": "Mobile Phones",
    "parentId": 2
}
```

---

## Delete Category

```
DELETE /{categoryId}
```

Deletes a category if business rules allow.

---

## Get Children

```
GET /{categoryId}/children
```

Returns child categories.

---

## Get Breadcrumb

```
GET /{categoryId}/breadcrumb
```

Returns category hierarchy.

---

# Category Attribute Management

Base Path

```
/api/admin/categories/{categoryId}/attributes
```

---

## Get Attributes

```
GET /
```

Returns category attributes.

---

## Create Attribute

```
POST /
```

### Request

```json
{
    "name": "Color",
    "dataType": "TEXT",
    "required": true
}
```

---

## Update Attribute

```
PUT /{attributeId}
```

### Request

```json
{
    "name": "Memory",
    "dataType": "NUMBER",
    "required": true
}
```

---

## Delete Attribute

```
DELETE /{attributeId}
```

Deletes a category attribute.

---

# Security

Every endpoint inside

```
/api/admin/**
```

requires

```
ROLE_ADMIN
```

Requests from normal users return

```
403 Forbidden
```

---

# Business Rules

## User Management

- Administrator accounts cannot be registered through the public registration API.
- Users can be blocked or unblocked only by administrators.

---

## Advertisement Review

- Newly created advertisements are placed in **PENDING** status.
- Only administrators can approve or reject advertisements.
- Rejected advertisements require a rejection reason.

---

## Category Management

- Category names must be unique.
- Parent categories cannot contain attributes.
- Only leaf categories may contain attributes.
- Categories containing advertisements cannot be deleted.
- Categories with child categories cannot be deleted.

---

## Category Attribute Management

- Attribute names must be unique within the same category.
- Attributes cannot be deleted if advertisements are already using them.
- Only leaf categories may contain attributes.

---

# Error Responses

Typical responses

```
400 Bad Request
```

Validation error.

```
401 Unauthorized
```

Missing or invalid JWT.

```
403 Forbidden
```

Authenticated user is not ADMIN.

```
404 Not Found
```

Requested resource does not exist.

```
409 Conflict
```

Business rule violation.

```
500 Internal Server Error
```

Unexpected server error.