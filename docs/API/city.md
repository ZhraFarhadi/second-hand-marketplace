# City API

---

# Overview

The City module provides geographical information used during advertisement creation and search.

Cities are organized under provinces.

Users first retrieve the list of provinces, then select a province to retrieve its cities.

This feature includes:

- Get Provinces
- Get Cities By Province

---

# Architecture

```
Client
   │
   │ Get Provinces / Get Cities
   ▼
CityController
   │
   ▼
CityService
   │
   ▼
ProvinceRepository
CityRepository
   │
   ▼
PostgreSQL
```

---

# City Flow

## Get Provinces

```
Client
    │
GET /api/cities/provinces
    │
    ▼
Load Provinces
    │
Sort By Name
    │
Return Province List
```

---

## Get Cities

```
Client
    │
GET /api/cities/provinces/{provinceId}/cities
    │
    ▼
Validate Province
    │
Load Cities
    │
Sort By Name
    │
Return City List
```

---

# Business Rules

- Authentication is **NOT required**.
- Provinces are always returned alphabetically.
- Cities are always returned alphabetically.
- Cities belong to exactly one province.
- A province must exist before its cities can be retrieved.
- These APIs are intended for advertisement creation, search filters, and location selection.

---

# API Endpoints

---

# Get Provinces

Returns all provinces.

## Endpoint

```
GET /api/cities/provinces
```

Authentication

```
Not Required
```

---

## Success Response

```json
[
  {
    "id": 1,
    "name": "Tehran"
  },
  {
    "id": 2,
    "name": "Isfahan"
  }
]
```

---

# Get Cities By Province

Returns all cities that belong to the selected province.

## Endpoint

```
GET /api/cities/provinces/{provinceId}/cities
```

Authentication

```
Not Required
```

---

## Success Response

```json
[
  {
    "id": 10,
    "name": "Tehran"
  },
  {
    "id": 11,
    "name": "Shemiran"
  }
]
```

---

## Possible Errors

|HTTP|ErrorCode|
|----|----------|
|404|PROVINCE_NOT_FOUND|

---

# Error Codes

|ErrorCode|Description|
|----------|-----------|
|PROVINCE_NOT_FOUND|Province not found.|

---

# Implementation Notes

- Provinces are retrieved from `ProvinceRepository`.
- Cities are retrieved from `CityRepository`.
- Provinces are sorted alphabetically using `findAllByOrderByNameAsc()`.
- Cities are sorted alphabetically using `findAllByProvinceOrderByNameAsc()`.
- These APIs are publicly accessible.
- Business logic is isolated inside `CityService`.
- `CityMapper` and `ProvinceMapper` are responsible for mapping entities to DTOs.
- The frontend first loads provinces, then loads cities after the user selects a province.