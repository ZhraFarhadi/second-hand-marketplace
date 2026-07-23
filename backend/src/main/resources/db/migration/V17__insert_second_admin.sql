-- ==========================================================
-- SECOND ADMIN USER
-- ==========================================================

INSERT INTO users
(
    full_name,
    username,
    email,
    phone_number,
    password,
    role,
    account_status,
    average_rating,
    rating_count,
    created_at,
    updated_at
)
SELECT
    'Second Administrator',
    'admin2',
    'admin2@secondhandd.local',
    '09121200001',
    '$2a$10$lXHZkmuzGLLfoAPkP/YK3eXkK8C529/74K//mTnfTkoKx9jCn7lT6',
    'ADMIN',
    'ACTIVE',
    0,
    0,
    NOW(),
    NOW()
    WHERE NOT EXISTS (
    SELECT 1
    FROM users
    WHERE username = 'admin2'
);