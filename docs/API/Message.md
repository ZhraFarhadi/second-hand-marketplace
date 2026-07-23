# Message API

This document describes all Message-related endpoints.

---

# Base URL

/api/messages

---

# Authentication

JWT authentication required.

Authorization: Bearer <token>

---

# 1. Send Message

Sends a message inside an existing conversation.

## Endpoint

POST /api/messages/{conversationId}

---

## Path Variable

| Name | Type |
|------|------|
|conversationId|Long|

---

## Request Body

```json
{
  "content": "Hello, is it still available?"
}
```

---

## Validation

| Field | Rule |
|--------|------|
|content|Required|
|content|Maximum 5000 characters|

---

## Response

200 OK

```json
{
  "id": 35,
  "senderId": 3,
  "content": "Hello, is it still available?",
  "createdAt": "2026-07-16T18:30:14",
  "mine": true
}
```

---

## Possible Errors

| Status | Error |
|---------|-------|
|404|CONVERSATION_NOT_FOUND|
|400|INVALID_MESSAGE_CONTENT|
|401|Unauthorized|

---

# Business Rules

- Only conversation participants can send messages.
- Empty messages are not allowed.
- Message content is trimmed before saving.
- Sending a message updates conversation lastMessageAt.
- Receiver unread count increases automatically.