-- ==========================================================
-- REAL ESTATE
-- ==========================================================

INSERT INTO categories (name, parent_id, display_order, created_at, updated_at)
SELECT 'Residential',
       r.id,
       1,
       NOW(),
       NOW()
FROM categories r
WHERE r.name = 'Real Estate'
  AND NOT EXISTS (
    SELECT 1
    FROM categories c
    WHERE c.name = 'Residential'
      AND c.parent_id = r.id
);

INSERT INTO categories (name, parent_id, display_order, created_at, updated_at)
SELECT 'Commercial',
       r.id,
       2,
       NOW(),
       NOW()
FROM categories r
WHERE r.name = 'Real Estate'
  AND NOT EXISTS (
    SELECT 1
    FROM categories c
    WHERE c.name = 'Commercial'
      AND c.parent_id = r.id
);

INSERT INTO categories (name, parent_id, display_order, created_at, updated_at)
SELECT 'Land',
       r.id,
       3,
       NOW(),
       NOW()
FROM categories r
WHERE r.name = 'Real Estate'
  AND NOT EXISTS (
    SELECT 1
    FROM categories c
    WHERE c.name = 'Land'
      AND c.parent_id = r.id
);

-- ==========================================================
-- Residential
-- ==========================================================

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Apartment',
       r.id,
       1,
       NOW(),
       NOW()
FROM categories r
         JOIN categories p
              ON r.parent_id=p.id
WHERE r.name='Residential'
  AND p.name='Real Estate'
  AND NOT EXISTS(
    SELECT 1
    FROM categories c
    WHERE c.name='Apartment'
      AND c.parent_id=r.id
);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Villa',
       r.id,
       2,
       NOW(),
       NOW()
FROM categories r
         JOIN categories p
              ON r.parent_id=p.id
WHERE r.name='Residential'
  AND p.name='Real Estate'
  AND NOT EXISTS(
    SELECT 1
    FROM categories c
    WHERE c.name='Villa'
      AND c.parent_id=r.id
);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'House',
       r.id,
       3,
       NOW(),
       NOW()
FROM categories r
         JOIN categories p
              ON r.parent_id=p.id
WHERE r.name='Residential'
  AND p.name='Real Estate'
  AND NOT EXISTS(
    SELECT 1
    FROM categories c
    WHERE c.name='House'
      AND c.parent_id=r.id
);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Residential Complex',
       r.id,
       4,
       NOW(),
       NOW()
FROM categories r
         JOIN categories p
              ON r.parent_id=p.id
WHERE r.name='Residential'
  AND p.name='Real Estate'
  AND NOT EXISTS(
    SELECT 1
    FROM categories c
    WHERE c.name='Residential Complex'
      AND c.parent_id=r.id
);

-- ==========================================================
-- Commercial
-- ==========================================================

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Office',
       r.id,
       1,
       NOW(),
       NOW()
FROM categories r
         JOIN categories p
              ON r.parent_id=p.id
WHERE r.name='Commercial'
  AND p.name='Real Estate'
  AND NOT EXISTS(
    SELECT 1
    FROM categories c
    WHERE c.name='Office'
      AND c.parent_id=r.id
);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Shop',
       r.id,
       2,
       NOW(),
       NOW()
FROM categories r
         JOIN categories p
              ON r.parent_id=p.id
WHERE r.name='Commercial'
  AND p.name='Real Estate'
  AND NOT EXISTS(
    SELECT 1
    FROM categories c
    WHERE c.name='Shop'
      AND c.parent_id=r.id
);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Warehouse',
       r.id,
       3,
       NOW(),
       NOW()
FROM categories r
         JOIN categories p
              ON r.parent_id=p.id
WHERE r.name='Commercial'
  AND p.name='Real Estate'
  AND NOT EXISTS(
    SELECT 1
    FROM categories c
    WHERE c.name='Warehouse'
      AND c.parent_id=r.id
);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Industrial Unit',
       r.id,
       4,
       NOW(),
       NOW()
FROM categories r
         JOIN categories p
              ON r.parent_id=p.id
WHERE r.name='Commercial'
  AND p.name='Real Estate'
  AND NOT EXISTS(
    SELECT 1
    FROM categories c
    WHERE c.name='Industrial Unit'
      AND c.parent_id=r.id
);

-- ==========================================================
-- Land
-- ==========================================================

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Residential Land',
       r.id,
       1,
       NOW(),
       NOW()
FROM categories r
         JOIN categories p
              ON r.parent_id=p.id
WHERE r.name='Land'
  AND p.name='Real Estate'
  AND NOT EXISTS(
    SELECT 1
    FROM categories c
    WHERE c.name='Residential Land'
      AND c.parent_id=r.id
);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Commercial Land',
       r.id,
       2,
       NOW(),
       NOW()
FROM categories r
         JOIN categories p
              ON r.parent_id=p.id
WHERE r.name='Land'
  AND p.name='Real Estate'
  AND NOT EXISTS(
    SELECT 1
    FROM categories c
    WHERE c.name='Commercial Land'
      AND c.parent_id=r.id
);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Agricultural Land',
       r.id,
       3,
       NOW(),
       NOW()
FROM categories r
         JOIN categories p
              ON r.parent_id=p.id
WHERE r.name='Land'
  AND p.name='Real Estate'
  AND NOT EXISTS(
    SELECT 1
    FROM categories c
    WHERE c.name='Agricultural Land'
      AND c.parent_id=r.id
);

-- ==========================================================
-- VEHICLES
-- ==========================================================

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Cars',v.id,1,NOW(),NOW()
FROM categories v
WHERE v.name='Vehicles'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Cars'
      AND c.parent_id=v.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Motorcycles',v.id,2,NOW(),NOW()
FROM categories v
WHERE v.name='Vehicles'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Motorcycles'
      AND c.parent_id=v.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Heavy Vehicles',v.id,3,NOW(),NOW()
FROM categories v
WHERE v.name='Vehicles'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Heavy Vehicles'
      AND c.parent_id=v.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Parts & Accessories',v.id,4,NOW(),NOW()
FROM categories v
WHERE v.name='Vehicles'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Parts & Accessories'
      AND c.parent_id=v.id);

-- ==========================================================
-- DIGITAL GOODS
-- ==========================================================

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Phones & Tablets',d.id,1,NOW(),NOW()
FROM categories d
WHERE d.name='Digital Goods'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Phones & Tablets'
      AND c.parent_id=d.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Computers',d.id,2,NOW(),NOW()
FROM categories d
WHERE d.name='Digital Goods'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Computers'
      AND c.parent_id=d.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Gaming',d.id,3,NOW(),NOW()
FROM categories d
WHERE d.name='Digital Goods'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Gaming'
      AND c.parent_id=d.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Cameras',d.id,4,NOW(),NOW()
FROM categories d
WHERE d.name='Digital Goods'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Cameras'
      AND c.parent_id=d.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Electronics & Accessories',d.id,5,NOW(),NOW()
FROM categories d
WHERE d.name='Digital Goods'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Electronics & Accessories'
      AND c.parent_id=d.id);

-- ==========================================================
-- HOME APPLIANCES
-- ==========================================================

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Kitchen Appliances',h.id,1,NOW(),NOW()
FROM categories h
WHERE h.name='Home Appliances'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Kitchen Appliances'
      AND c.parent_id=h.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Cooling & Heating',h.id,2,NOW(),NOW()
FROM categories h
WHERE h.name='Home Appliances'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Cooling & Heating'
      AND c.parent_id=h.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Laundry Appliances',h.id,3,NOW(),NOW()
FROM categories h
WHERE h.name='Home Appliances'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Laundry Appliances'
      AND c.parent_id=h.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Vacuum Cleaners',h.id,4,NOW(),NOW()
FROM categories h
WHERE h.name='Home Appliances'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Vacuum Cleaners'
      AND c.parent_id=h.id);

-- ==========================================================
-- FURNITURE & HOME
-- ==========================================================

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Living Room',f.id,1,NOW(),NOW()
FROM categories f
WHERE f.name='Furniture & Home'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Living Room'
      AND c.parent_id=f.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Bedroom',f.id,2,NOW(),NOW()
FROM categories f
WHERE f.name='Furniture & Home'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Bedroom'
      AND c.parent_id=f.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Office Furniture',f.id,3,NOW(),NOW()
FROM categories f
WHERE f.name='Furniture & Home'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Office Furniture'
      AND c.parent_id=f.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Home Decoration',f.id,4,NOW(),NOW()
FROM categories f
WHERE f.name='Furniture & Home'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Home Decoration'
      AND c.parent_id=f.id);

-- ==========================================================
-- FASHION
-- ==========================================================

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Women Clothing',f.id,1,NOW(),NOW()
FROM categories f
WHERE f.name='Fashion'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Women Clothing'
      AND c.parent_id=f.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Men Clothing',f.id,2,NOW(),NOW()
FROM categories f
WHERE f.name='Fashion'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Men Clothing'
      AND c.parent_id=f.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Shoes',f.id,3,NOW(),NOW()
FROM categories f
WHERE f.name='Fashion'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Shoes'
      AND c.parent_id=f.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Bags & Accessories',f.id,4,NOW(),NOW()
FROM categories f
WHERE f.name='Fashion'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Bags & Accessories'
      AND c.parent_id=f.id);

-- ==========================================================
-- SPORTS & LEISURE
-- ==========================================================

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Fitness Equipment',s.id,1,NOW(),NOW()
FROM categories s
WHERE s.name='Sports & Leisure'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Fitness Equipment'
      AND c.parent_id=s.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Bicycles',s.id,2,NOW(),NOW()
FROM categories s
WHERE s.name='Sports & Leisure'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Bicycles'
      AND c.parent_id=s.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Camping & Travel',s.id,3,NOW(),NOW()
FROM categories s
WHERE s.name='Sports & Leisure'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Camping & Travel'
      AND c.parent_id=s.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Musical Instruments',s.id,4,NOW(),NOW()
FROM categories s
WHERE s.name='Sports & Leisure'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Musical Instruments'
      AND c.parent_id=s.id);

-- ==========================================================
-- SERVICES
-- ==========================================================

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Home Services',s.id,1,NOW(),NOW()
FROM categories s
WHERE s.name='Services'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Home Services'
      AND c.parent_id=s.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Education',s.id,2,NOW(),NOW()
FROM categories s
WHERE s.name='Services'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Education'
      AND c.parent_id=s.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Beauty',s.id,3,NOW(),NOW()
FROM categories s
WHERE s.name='Services'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Beauty'
      AND c.parent_id=s.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Repair Services',s.id,4,NOW(),NOW()
FROM categories s
WHERE s.name='Services'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Repair Services'
      AND c.parent_id=s.id);

-- ==========================================================
-- JOBS
-- ==========================================================

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Full-time',j.id,1,NOW(),NOW()
FROM categories j
WHERE j.name='Jobs'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Full-time'
      AND c.parent_id=j.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Part-time',j.id,2,NOW(),NOW()
FROM categories j
WHERE j.name='Jobs'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Part-time'
      AND c.parent_id=j.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Remote',j.id,3,NOW(),NOW()
FROM categories j
WHERE j.name='Jobs'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Remote'
      AND c.parent_id=j.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Internship',j.id,4,NOW(),NOW()
FROM categories j
WHERE j.name='Jobs'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Internship'
      AND c.parent_id=j.id);

-- ==========================================================
-- PETS
-- ==========================================================

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Dogs',p.id,1,NOW(),NOW()
FROM categories p
WHERE p.name='Pets'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Dogs'
      AND c.parent_id=p.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Cats',p.id,2,NOW(),NOW()
FROM categories p
WHERE p.name='Pets'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Cats'
      AND c.parent_id=p.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Birds',p.id,3,NOW(),NOW()
FROM categories p
WHERE p.name='Pets'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Birds'
      AND c.parent_id=p.id);

INSERT INTO categories (name,parent_id,display_order,created_at,updated_at)
SELECT 'Pet Supplies',p.id,4,NOW(),NOW()
FROM categories p
WHERE p.name='Pets'
  AND NOT EXISTS(
    SELECT 1 FROM categories c
    WHERE c.name='Pet Supplies'
      AND c.parent_id=p.id);