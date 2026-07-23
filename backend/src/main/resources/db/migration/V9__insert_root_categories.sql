-- ==========================================================
-- ROOT CATEGORIES
-- ==========================================================

INSERT INTO categories (name, parent_id, display_order, created_at, updated_at)
SELECT 'Digital Goods', NULL, 1, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1
    FROM categories
    WHERE name = 'Digital Goods'
);

INSERT INTO categories (name, parent_id, display_order, created_at, updated_at)
SELECT 'Vehicles', NULL, 2, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1
    FROM categories
    WHERE name = 'Vehicles'
);

INSERT INTO categories (name, parent_id, display_order, created_at, updated_at)
SELECT 'Real Estate', NULL, 3, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1
    FROM categories
    WHERE name = 'Real Estate'
);

INSERT INTO categories (name, parent_id, display_order, created_at, updated_at)
SELECT 'Home Appliances', NULL, 4, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1
    FROM categories
    WHERE name = 'Home Appliances'
);

INSERT INTO categories (name, parent_id, display_order, created_at, updated_at)
SELECT 'Furniture & Home', NULL, 5, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1
    FROM categories
    WHERE name = 'Furniture & Home'
);

INSERT INTO categories (name, parent_id, display_order, created_at, updated_at)
SELECT 'Fashion', NULL, 6, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1
    FROM categories
    WHERE name = 'Fashion'
);

INSERT INTO categories (name, parent_id, display_order, created_at, updated_at)
SELECT 'Sports & Leisure', NULL, 7, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1
    FROM categories
    WHERE name = 'Sports & Leisure'
);

INSERT INTO categories (name, parent_id, display_order, created_at, updated_at)
SELECT 'Services', NULL, 8, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1
    FROM categories
    WHERE name = 'Services'
);

INSERT INTO categories (name, parent_id, display_order, created_at, updated_at)
SELECT 'Jobs', NULL, 9, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1
    FROM categories
    WHERE name = 'Jobs'
);

INSERT INTO categories (name, parent_id, display_order, created_at, updated_at)
SELECT 'Pets', NULL, 10, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1
    FROM categories
    WHERE name = 'Pets'
);