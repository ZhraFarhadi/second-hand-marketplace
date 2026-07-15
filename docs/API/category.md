# Category API

---

# Overview

The Category module manages the hierarchical structure of categories and their attributes.

Categories are organized as a tree structure. Users navigate from root categories to leaf categories when creating or browsing advertisements.

Category attributes can only be defined for **leaf categories**.

---

# Access Rules

## Public APIs

- GET /api/categories
- GET /api/categories/{categoryId}
- GET /api/categories/{categoryId}/children
- GET /api/categories/{categoryId}/breadcrumb
- GET /api/categories/{categoryId}/attributes

## Admin APIs

- POST /api/categories
- PUT /api/categories/{categoryId}
- DELETE /api/categories/{categoryId}

- POST /api/categories/{categoryId}/attributes
- PUT /api/categories/{categoryId}/attributes/{attributeId}
- DELETE /api/categories/{categoryId}/attributes/{attributeId}

# Business Rules

- Category names are unique (case-insensitive).
- Root categories are returned alphabetically.
- Child categories are returned alphabetically.
- Only direct children are returned by the API.
- A category cannot be its own parent.
- Circular category hierarchies are not allowed.
- Categories with child categories cannot be deleted.
- Categories used by advertisements cannot be deleted.
- Attributes can only be created for leaf categories.
- Attribute names are unique within the same category (case-insensitive).
- Attributes used by advertisements cannot be deleted.
- - A category cannot contain both child categories and attributes.
- Category and attribute names are compared case-insensitively.
- Leading and trailing spaces are ignored before validation.
- Parent categories never own attributes; attributes belong only to leaf categories.

---

# Category Navigation

The frontend loads categories level by level.

1. Load root categories.
2. User selects a category.
3. Backend returns only direct child categories.
4. Repeat until a leaf category is reached.
5. The frontend may use the breadcrumb endpoint to navigate back to any previous level.
6. Leaf categories expose their attributes.

# API Endpoints

## Categories

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/categories` | Create a new category |
| PUT | `/api/categories/{categoryId}` | Update category |
| DELETE | `/api/categories/{categoryId}` | Delete category |
| GET | `/api/categories` | Get root categories |
| GET | `/api/categories/{categoryId}` | Get category details |
| GET | `/api/categories/{categoryId}/children` | Get direct child categories |
| GET | `/api/categories/{categoryId}/breadcrumb` | Get category navigation path |

---

## Category Attributes

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/categories/{categoryId}/attributes` | Create category attribute |
| GET | `/api/categories/{categoryId}/attributes` | Get category attributes |
| PUT | `/api/categories/{categoryId}/attributes/{attributeId}` | Update category attribute |
| DELETE | `/api/categories/{categoryId}/attributes/{attributeId}` | Delete category attribute |

---

# Error Codes

| ErrorCode | Description |
|-----------|-------------|
| CATEGORY_NOT_FOUND | Category not found |
| CATEGORY_NAME_ALREADY_EXISTS | Category name already exists |
| CATEGORY_HAS_CHILDREN | Category has child categories |
| CATEGORY_HAS_ADVERTISEMENTS | Category is used by advertisements |
| INVALID_CATEGORY_HIERARCHY | Invalid category hierarchy |
| CATEGORY_IS_NOT_LEAF | Attributes can only be created for leaf categories |
| CATEGORY_ATTRIBUTE_NOT_FOUND | Category attribute not found |
| CATEGORY_ATTRIBUTE_ALREADY_EXISTS | Attribute already exists in this category |
| CATEGORY_ATTRIBUTE_IN_USE | Attribute is used by advertisements |
| INVALID_CATEGORY_ATTRIBUTE_NAME | Invalid category attribute name |

Hierarchy validation prevents:

- A category from becoming its own parent.
- Circular category hierarchies.
---

# Implementation Notes

- Categories are stored as a parent-child hierarchy.
- Only root categories are returned by `GET /api/categories`.
- Child categories are loaded on demand using `GET /api/categories/{categoryId}/children`.
- Breadcrumb navigation is supported through `GET /api/categories/{categoryId}/breadcrumb`.
- Attributes are available only for leaf categories.
- Category and attribute names are normalized before validation.
- Business validation is implemented in the Service layer.
- Exception handling is centralized using `BusinessException` and `ErrorCode`.
- - Categories are loaded lazily level by level; the backend never returns the entire category tree in a single request.
- Breadcrumb data is provided to support backward navigation in the category hierarchy.
- Categories and attributes are returned in alphabetical order.
- Duplicate category and attribute names are checked case-insensitively.
- Only leaf categories may define attributes.
- Category attributes are scoped to their own category and are not inherited by parent or child categories.