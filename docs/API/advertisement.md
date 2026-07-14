# Advertisement API

---

# Overview

The Advertisement API is responsible for managing marketplace advertisements.

Every advertisement belongs to exactly one seller and must be approved by an administrator before becoming publicly visible.

Advertisements use **Soft Delete**, therefore deleted advertisements are never physically removed from the database.

---

# Advertisement Status

| Status | Description |
|---------|-------------|
| PENDING | Waiting for administrator review |
| ACTIVE | Visible to all users |
| REJECTED | Rejected by administrator |
| SOLD | Marked as sold by seller |

---

# Create Advertisement

## Endpoint

POST /advertisements

## Authentication

Required

## Description

Creates a new advertisement.

The authenticated user automatically becomes the seller.

The advertisement is always created with **PENDING** status.

---

## Request Body

```json
{
  "title": "...",
  "description": "...",
  "price": 100000,
  "categoryId": 1,
  "cityId": 10,
  "images": [],
  "attributes": []
}
```

---

## Response

AdvertisementDetailsResponse

---

## Success

201 Created

---

## Possible Errors

400 Bad Request

401 Unauthorized

404 Category Not Found

404 City Not Found

---

## Business Rules

- Seller is determined from the authenticated user.
- Exactly one image must be primary.
- Required category attributes must be provided.
- Attribute values must match their data type.
- Advertisement status is always PENDING after creation.

---

# Update Advertisement

---

## Endpoint

PUT /advertisements/{advertisementId}

---

## Authentication

Required

---

## Description

Updates an existing advertisement.

Only the advertisement owner can update it.

---

## Success

200 OK

---

## Possible Errors

400 Bad Request

401 Unauthorized

403 Forbidden

404 Advertisement Not Found

---

## Business Rules

Updating the following fields keeps the advertisement ACTIVE:

- title
- description
- price

Updating any of the following fields requires administrator review again:

- category
- city
- images
- attributes

In this case the advertisement status becomes PENDING.

Sold advertisements cannot be updated.

---

# Delete Advertisement

---

## Endpoint

DELETE /advertisements/{advertisementId}

---

## Authentication

Required

---

## Description

Soft deletes an advertisement.

The advertisement is hidden from the system but remains stored in the database.

---

## Success

204 No Content

---

## Possible Errors

401 Unauthorized

403 Forbidden

404 Advertisement Not Found

---

# Mark Advertisement as Sold

---

## Endpoint

PATCH /advertisements/{advertisementId}/sold

---

## Authentication

Required

---

## Description

Marks an ACTIVE advertisement as SOLD.

---

## Success

200 OK

---

## Possible Errors

400 Advertisement is not active

401 Unauthorized

403 Forbidden

404 Advertisement Not Found

---

## Business Rules

Only ACTIVE advertisements can be marked as SOLD.

Only the owner can perform this operation.

---

# Get Advertisement Details

---

## Endpoint

GET /advertisements/{advertisementId}

---

## Authentication

Optional

---

## Description

Returns complete information about an advertisement.

---

## Success

200 OK

---

## Business Rules

Anonymous users can view only ACTIVE advertisements.

Owners can view all of their own advertisements except deleted ones.

Deleted advertisements are never returned.

---

# Get Advertisements

---

## Endpoint

GET /advertisements

---

## Authentication

Not Required

---

## Description

Returns a paginated list of ACTIVE advertisements.

---

## Query Parameters

page

size

sort

---

## Success

200 OK

---

# Get My Advertisements

---

## Endpoint

GET /advertisements/my

---

## Authentication

Required

---

## Description

Returns all advertisements created by the authenticated user.

---

## Query Parameters

page

size

sort

---

## Success

200 OK

---

# Global Business Rules

- Soft Delete is used for advertisement removal.
- Deleted advertisements are never visible.
- Every advertisement belongs to exactly one seller.
- Every advertisement belongs to one category.
- Every advertisement belongs to one city.
- Every advertisement must contain exactly one primary image.
- Required category attributes must always be provided.
- Attribute values must match the defined data type.
- Only the owner can update or delete an advertisement.
- Only ACTIVE advertisements are visible to anonymous users.
- Owners can always view their own advertisements.
- Creating an advertisement always sets its status to PENDING.
- Updating category, city, images or attributes changes the status to PENDING.
- Updating title, description or price does not change the status.
- SOLD advertisements cannot be updated.