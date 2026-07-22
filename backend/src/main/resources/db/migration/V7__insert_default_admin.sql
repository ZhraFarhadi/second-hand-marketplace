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
    'System Administrator',
    'admin',
    'admin@secondhand.local',
    '09120000000',
    '$2a$10$IH0MtyQBTmNNcqigfiGtOOWx/GAWYGSPsI/2UYfwogcXcHPW0vdne',
    'ADMIN',
    'ACTIVE',
    0,
    0,
    NOW(),
    NOW()
    WHERE NOT EXISTS
(
    SELECT 1
    FROM users
    WHERE username = 'admin'
);