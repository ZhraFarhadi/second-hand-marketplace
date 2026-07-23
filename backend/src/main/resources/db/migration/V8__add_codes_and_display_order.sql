-- ===========================
-- CATEGORY
-- ===========================

ALTER TABLE categories
    ADD COLUMN IF NOT EXISTS display_order INTEGER NOT NULL DEFAULT 0;


-- ===========================
-- PROVINCE
-- ===========================

ALTER TABLE provinces
    ADD COLUMN IF NOT EXISTS code VARCHAR(10);

ALTER TABLE provinces
    ADD COLUMN IF NOT EXISTS display_order INTEGER NOT NULL DEFAULT 0;


UPDATE provinces
SET code = CONCAT('P', id)
WHERE code IS NULL;

ALTER TABLE provinces
    ALTER COLUMN code SET NOT NULL;


DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1
        FROM pg_constraint
        WHERE conname = 'uk_province_code'
    ) THEN
ALTER TABLE provinces
    ADD CONSTRAINT uk_province_code UNIQUE (code);
END IF;
END $$;



-- ===========================
-- CITY
-- ===========================

ALTER TABLE cities
    ADD COLUMN IF NOT EXISTS code VARCHAR(10);

ALTER TABLE cities
    ADD COLUMN IF NOT EXISTS display_order INTEGER NOT NULL DEFAULT 0;


UPDATE cities
SET code = CONCAT('C', id)
WHERE code IS NULL;


ALTER TABLE cities
    ALTER COLUMN code SET NOT NULL;


DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1
        FROM pg_constraint
        WHERE conname = 'uk_city_code'
    ) THEN
ALTER TABLE cities
    ADD CONSTRAINT uk_city_code UNIQUE (code);
END IF;
END $$;