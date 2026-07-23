# Advertisement API

---

# Overview

The Advertisement module is the core feature of the marketplace.

It is responsible for:

- Creating advertisements
- Updating advertisements
- Soft deleting advertisements
- Viewing advertisement details
- Viewing advertisement list
- Viewing seller advertisements
- Marking advertisements as sold

Every advertisement belongs to:

- Seller
- Category
- City

Each advertisement may contain:

- Multiple Images
- Multiple Category Attributes

Advertisements are reviewed by administrators before becoming publicly visible.

---

# Architecture

```
Client
      │
      ▼
AdvertisementController
      │
      ▼
AdvertisementService
      │
      ├──────── AdvertisementRepository
      ├──────── CategoryRepository
      ├──────── CityRepository
      ├──────── CategoryAttributeRepository
      └──────── CurrentUserService
                │
                ▼
         SecurityContext
```

Business rules are implemented entirely inside

```
AdvertisementService
```

DTO validation is performed before entering the Service layer.

---

# Advertisement Lifecycle

```
Create Advertisement
        │
        ▼
     PENDING
        │
 ┌──────┴──────┐
 │             │
Approve      Reject
 │             │
 ▼             ▼
ACTIVE     REJECTED
 │
 │ Mark As Sold
 ▼
SOLD
```

Deleted advertisements are never physically removed.

Instead:

```
deletedAt != null
```

means the advertisement is considered deleted.

---

# Advertisement Visibility

Advertisement visibility depends on both authentication and advertisement status.

| Status | Guest | Owner | Others |
|---------|-------|-------|--------|
|ACTIVE|✅|✅|✅|
|PENDING|❌|✅|❌|
|REJECTED|❌|✅|❌|
|SOLD|❌|✅|❌|
|Deleted|❌|❌|❌|

Public users only have access to ACTIVE advertisements.

Owners can access all of their own advertisements except deleted ones.

---

# Authorization Rules

| Operation | Authentication Required |
|------------|------------------------|
|Create Advertisement|✅|
|Update Advertisement|✅|
|Delete Advertisement|✅|
|Mark As Sold|✅|
|Get Advertisement Details|❌|
|Get Advertisements|❌|
|Get My Advertisements|✅|

---

# Business Rules

## Create Advertisement

Requirements:

- User must be authenticated.
- Category must exist.
- City must exist.
- Exactly one primary image is required.
- Duplicate attributes are not allowed.
- Every required category attribute must be provided.
- Every attribute value must match its data type.

New advertisements are always created with

```
Status = PENDING
```

---

## Update Advertisement

Only the owner may update an advertisement.

Sold advertisements cannot be updated.

Major changes require administrator review.

Major changes include:

- Category
- City
- Images
- Attributes

If major changes exist:

```
Status = PENDING
```

Minor changes do not require review.

Examples:

- Title
- Description
- Price

---

## Delete Advertisement

Deletion uses Soft Delete.

```
deletedAt = LocalDateTime.now()
```

The advertisement remains in the database.

Sold advertisements cannot be deleted.

Only the owner may delete.

---

## Mark Advertisement As Sold

Requirements:

- Owner only.
- Advertisement must be ACTIVE.

Status changes:

```
ACTIVE
        │
        ▼
SOLD
```

---

## View Advertisement Details

Guests may only view ACTIVE advertisements.

Owners may additionally view:

- PENDING
- REJECTED
- SOLD

Deleted advertisements always return

```
ADVERTISEMENT_NOT_FOUND
```

---

## View Advertisement List

Only ACTIVE advertisements are returned.

Deleted advertisements are ignored.

Results are ordered by

```
CreatedAt DESC
```

Pagination is supported.

---

## View My Advertisements

Returns advertisements belonging to the authenticated user.

Deleted advertisements are excluded.

Results are ordered by newest first.

---

# Images

Each advertisement contains one or more images.

Business Rules:

- Exactly one Primary image.
- Images preserve display order.
- Images are completely replaced during update.

---

# Category Attributes

Each category defines its own attributes.

Example

Vehicle

- Brand
- Model
- Mileage
- Fuel Type

Laptop

- RAM
- CPU
- Storage

Each attribute has a data type.

Supported types:

- TEXT
- NUMBER
- BOOLEAN
- DATE

Validation is performed inside AdvertisementService.

---

# Soft Delete

Advertisements are never physically deleted.

Instead:

```
deletedAt
```

is set.

Queries always ignore deleted advertisements.

---

# Review Process

New advertisements

↓

PENDING

↓

Reviewed by Admin

↓

ACTIVE / REJECTED

When an ACTIVE advertisement receives major updates it returns to

```
PENDING
```

until reviewed again.

---

# API Endpoints

---

# Create Advertisement

Creates a new advertisement.

## Endpoint

```
POST /api/advertisements
```

Authentication

Required

---

## Request

```json
{
  "title": "iPhone 14",
  "description": "Excellent condition",
  "price": 65000000,
  "categoryId": 2,
  "cityId": 5,
  "images": [
    {
      "imageUrl": "...",
      "primary": true
    }
  ],
  "attributes": [
    {
      "categoryAttributeId": 10,
      "value": "256"
    }
  ]
}
```

---

## Response

```
200 OK
```

Returns AdvertisementDetailsResponse.

---

# Update Advertisement

```
PUT /api/advertisements/{id}
```

Authentication

Required

Returns updated advertisement.

---

# Delete Advertisement

```
DELETE /api/advertisements/{id}
```

Authentication

Required

Soft Delete.

Returns

```
204 No Content
```

---

# Mark Advertisement Sold

```
PATCH /api/advertisements/{id}/sold
```

Authentication

Required

Returns updated advertisement.

---

# Get Advertisement Details

```
GET /api/advertisements/{id}
```

Authentication

Optional.

Returns AdvertisementDetailsResponse.

---

# Get Advertisements

```
GET /api/advertisements
```

Authentication

Not Required.

Supports pagination.

Returns

```
Page<AdvertisementSummaryResponse>
```

---

# Get My Advertisements

```
GET /api/advertisements/my
```

Authentication

Required.

Returns

```
Page<MyAdvertisementSummaryResponse>
```

---

# Error Codes

| ErrorCode | Description |
|------------|-------------|
|ADVERTISEMENT_NOT_FOUND|Advertisement does not exist.|
|ADVERTISEMENT_NOT_OWNER|Current user is not the owner.|
|ADVERTISEMENT_NOT_ACTIVE|Advertisement is not active.|
|ADVERTISEMENT_CANNOT_BE_UPDATED|Sold advertisements cannot be updated.|
|ADVERTISEMENT_CANNOT_BE_DELETED|Sold advertisements cannot be deleted.|
|INVALID_PRIMARY_IMAGE|Exactly one primary image is required.|
|INVALID_ATTRIBUTE|Category attribute is invalid.|
|DUPLICATE_ATTRIBUTE|Duplicate category attribute.|
|INVALID_ATTRIBUTE_VALUE|Attribute value is invalid.|
|VALIDATION_ERROR|Required attribute is missing.|
|CATEGORY_NOT_FOUND|Category does not exist.|
|CITY_NOT_FOUND|City does not exist.|
|UNAUTHORIZED|Authentication required.|
|ACCESS_DENIED|User has no permission.|

---

# Repository Queries

The service relies primarily on:

- AdvertisementRepository
- CategoryRepository
- CityRepository
- CategoryAttributeRepository

Main queries:

- Find Advertisement By Id
- Find Active Advertisements
- Find Seller Advertisements
- Save Advertisement

---

# Implementation Notes

- Advertisement creation uses DTO → Entity mapping.
- Images are managed through AdvertisementImage.
- Attributes are managed through AdvertisementAttribute.
- Soft Delete is implemented using the `deletedAt` field.
- Deleted advertisements are excluded from all public queries.
- Major updates trigger a new review process.
- Public endpoints support anonymous access.
- Owner validation is performed inside AdvertisementService.
- Authentication is handled exclusively through `CurrentUserService`.
- Business validation is centralized in the Service layer.
- Errors are handled using `BusinessException` and `ErrorCode`.
- Pagination is implemented using Spring Data `Pageable`.