ALTER TABLE users ADD COLUMN IF NOT EXISTS full_name VARCHAR(255);


UPDATE users
SET full_name = CONCAT(
        COALESCE(first_name, ''),
        CASE
            WHEN first_name IS NOT NULL AND last_name IS NOT NULL THEN ' '
            ELSE ''
            END,
        COALESCE(last_name, '')
                );

ALTER TABLE users DROP COLUMN first_name;
ALTER TABLE users DROP COLUMN last_name;
