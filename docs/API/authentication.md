# Authentication API

---

# Overview

The Authentication module is responsible for user registration and login.

Authentication is based on **JWT (JSON Web Token)** and **Spring Security**.

After a successful login, the server generates a JWT token which must be included in all protected API requests.

This feature includes:

- User Registration
- User Login
- JWT Authentication
- Spring Security Authorization
- Password Encryption
- Current Authenticated User Resolution

---

# Architecture

```
Client
   │
   │ Login / Register
   ▼
AuthenticationController
   │
   ▼
AuthenticationService
   │
   ▼
UserRepository
   │
   ▼
PostgreSQL
```

For authenticated requests:

```
Client
      │
Authorization: Bearer JWT
      │
      ▼
JwtAuthenticationFilter
      │
      ▼
JwtService
      │
      ▼
SecurityContext
      │
      ▼
CurrentUserService
      │
      ▼
Business Services
```

---

# Authentication Flow

## Registration

```
Client
    │
POST /api/auth/register
    │
    ▼
Validate DTO
    │
Check duplicate username
    │
Check duplicate email
    │
Check duplicate phone number
    │
Encode password
    │
Create User
    │
Save
```

---

## Login

```
Client
    │
POST /api/auth/login
    │
    ▼
Find User
    │
Check Account Status
    │
Check Password
    │
Generate JWT
    │
Return Token
```

---

# JWT Authentication Flow

For every protected request:

```
Authorization Header
        │
Bearer eyJhb...
        │
        ▼
JwtAuthenticationFilter
        │
Extract Token
        │
Validate Token
        │
Extract Username
        │
Load User
        │
Create Authentication
        │
Store in SecurityContext
```

Business services retrieve the authenticated user through:

```
CurrentUserService.getCurrentUser()
```

or

```
CurrentUserService.getCurrentUserOrNull()
```

---

# Security Rules

## Public APIs

Authentication is **NOT required**.

| Endpoint |
|-----------|
|POST /api/auth/register|
|POST /api/auth/login|
|GET /api/advertisements|
|GET /api/advertisements/{id}|
|GET /api/categories/**|
|GET /api/cities/**|
|GET /ping|

---

## Protected APIs

Authentication is required.

Examples:

- Create Advertisement
- Update Advertisement
- Delete Advertisement
- Mark Advertisement Sold
- My Advertisements
- User Profile
- Favorites
- Conversations
- Ratings

---

## Admin APIs

Accessible only by users with

```
ROLE_ADMIN
```

---

# Password Security

Passwords are never stored in plain text.

BCrypt is used for hashing passwords.

```
Password
      │
BCryptPasswordEncoder
      │
Hashed Password
      │
Database
```

During login:

```
Raw Password
      │
matches()
      │
Stored BCrypt Password
```

---

# Business Rules

## Registration

A user can register only if:

- Username is unique.
- Email is unique.
- Phone number is unique.
- Request passes DTO validation.

New users receive:

```
Role = USER
AccountStatus = ACTIVE
```

Password is encrypted before saving.

---

## Login

User can login only if:

- Username exists.
- Password is correct.
- AccountStatus is ACTIVE.

Blocked users cannot login.

---

# Current User Resolution

Business services never access SecurityContext directly.

Instead they use:

```
CurrentUserService
```

Methods:

```
getCurrentUser()
```

Returns authenticated user.

Throws:

```
UNAUTHORIZED
```

if user is not logged in.

---

```
getCurrentUserOrNull()
```

Returns:

- current user

or

- null

Used by public APIs where authentication is optional.

Example:

Advertisement Details

Guest:

- can see ACTIVE advertisements

Owner:

- can see his own PENDING advertisements

---

# API Endpoints

---

# Register

Creates a new account.

## Endpoint

```
POST /api/auth/register
```

Authentication:

```
Not Required
```

---

## Request

```json
{
  "fullName": "John Doe",
  "username": "johndoe",
  "email": "john@example.com",
  "phoneNumber": "09123456789",
  "password": "password123"
}
```

---

## Success Response

```
204 No Content
```

---

## Possible Errors

|HTTP|ErrorCode|
|----|----------|
|400|VALIDATION_ERROR|
|409|USERNAME_ALREADY_EXISTS|
|409|EMAIL_ALREADY_EXISTS|
|409|PHONE_NUMBER_ALREADY_EXISTS|

---

# Login

Authenticates user.

## Endpoint

```
POST /api/auth/login
```

Authentication:

```
Not Required
```

---

## Request

```json
{
  "username":"johndoe",
  "password":"password123"
}
```

---

## Success Response

```json
{
  "token":"eyJhbGciOiJIUzI1NiJ9...",
  "id":1,
  "fullName":"John Doe",
  "username":"johndoe",
  "role":"USER"
}
```

---

## Possible Errors

|HTTP|ErrorCode|
|----|----------|
|401|INVALID_CREDENTIALS|
|403|USER_BLOCKED|

---

# Error Codes

|ErrorCode|Description|
|----------|-----------|
|USERNAME_ALREADY_EXISTS|Username already exists.|
|EMAIL_ALREADY_EXISTS|Email already exists.|
|PHONE_NUMBER_ALREADY_EXISTS|Phone number already exists.|
|INVALID_CREDENTIALS|Username or password is incorrect.|
|USER_BLOCKED|User account has been blocked.|
|UNAUTHORIZED|Authentication required.|
|ACCESS_DENIED|Access denied.|
|VALIDATION_ERROR|DTO validation failed.|

---

# Implementation Notes

- Spring Security is configured as Stateless.
- JWT is used for authentication.
- Session authentication is disabled.
- HTTP Basic authentication is disabled.
- Form Login is disabled.
- Passwords are encrypted using BCrypt.
- JWT contains the username as the subject.
- Business services access authenticated users only through CurrentUserService.
- Duplicate username, email, and phone number are checked inside AuthenticationService.
- Authentication logic is completely separated from business features.
- Exception handling is centralized using BusinessException and ErrorCode.