# Conversation API

This document describes all Conversation-related endpoints.

---

# Base URL

/api/conversations

---

# Authentication

All Conversation APIs require JWT authentication.

Authorization: Bearer <token>

---

# 1. Start Conversation

Creates a new conversation with the advertisement owner.

If a conversation already exists, the existing conversation is returned.

## Endpoint

POST /api/conversations/start/{advertisementId}

---

## Path Variable

| Name | Type | Description |
|------|------|-------------|
| advertisementId | Long | Advertisement ID |

---

## Response

200 OK

```json
{
  "id": 15,
  "buyer": {
    "id": 3,
    "fullName": "Ali Ahmadi"
  },
  "seller": {
    "id": 8,
    "fullName": "Sara Hosseini"
  },
  "advertisement": {
    "id": 12,
    "title": "iPhone 14 Pro",
    "price": 65000000
  },
  "messages": {
    "content": []
  }
}
```

---

## Possible Errors

| Status | Error |
|---------|-------|
|404|ADVERTISEMENT_NOT_FOUND|
|400|ADVERTISEMENT_NOT_ACTIVE|
|400|CANNOT_START_CONVERSATION_WITH_SELF|

---

# 2. Get Conversation

Returns conversation details and paginated messages.

## Endpoint

GET /api/conversations/{conversationId}

---

## Query Parameters

| Name | Type | Default |
|------|------|----------|
|page|int|0|
|size|int|30|

---

## Response

200 OK

```json
{
  "id": 15,
  "buyer": {},
  "seller": {},
  "advertisement": {},
  "messages": {
    "content": [
      {
        "id": 10,
        "senderId": 3,
        "content": "Hello",
        "createdAt": "...",
        "mine": true
      }
    ]
  }
}
```

---

## Possible Errors

| Status | Error |
|---------|-------|
|404|CONVERSATION_NOT_FOUND|

---

# 3. Get My Conversations

Returns conversations ordered by latest activity.

## Endpoint

GET /api/conversations

---

## Query Parameters

| Name | Type | Default |
|------|------|----------|
|page|int|0|
|size|int|20|

---

## Response

200 OK

```json
{
  "content": [
    {
      "id": 15,
      "advertisementId": 12,
      "advertisementTitle": "iPhone 14 Pro",
      "advertisementPrimaryImage": "...",
      "otherUser": {},
      "lastMessage": "Is it available?",
      "hasUnreadMessages": true,
      "unreadCount": 2,
      "lastMessageTime": "2026-07-16T18:20:11"
    }
  ]
}
```

---

## Possible Errors

| Status | Error |
|---------|-------|
|401|Unauthorized|

---

# Business Rules

- Only buyer and seller can access a conversation.
- Starting a conversation twice returns the existing conversation.
- Seller cannot start a conversation with their own advertisement.
- Only ACTIVE advertisements accept new conversations.
- Messages are automatically marked as read when opened.
- Conversations are ordered by latest message.