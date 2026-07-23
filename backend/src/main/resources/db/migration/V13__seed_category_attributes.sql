-- ==========================================================
-- DIGITAL GOODS
-- ==========================================================

-------------------------------------------------------------
-- Phones & Tablets
-------------------------------------------------------------

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Brand','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Phones & Tablets'
  AND NOT EXISTS(
    SELECT 1
    FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Brand'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Model','TEXT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Phones & Tablets'
  AND NOT EXISTS(
    SELECT 1
    FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Model'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Storage','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Phones & Tablets'
  AND NOT EXISTS(
    SELECT 1
    FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Storage'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'RAM','NUMBER',false,NOW(),NOW()
FROM categories c
WHERE c.name='Phones & Tablets'
  AND NOT EXISTS(
    SELECT 1
    FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='RAM'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Color','SELECT',false,NOW(),NOW()
FROM categories c
WHERE c.name='Phones & Tablets'
  AND NOT EXISTS(
    SELECT 1
    FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Color'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Phones & Tablets'
  AND NOT EXISTS(
    SELECT 1
    FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Warranty','BOOLEAN',false,NOW(),NOW()
FROM categories c
WHERE c.name='Phones & Tablets'
  AND NOT EXISTS(
    SELECT 1
    FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Warranty'
);

-------------------------------------------------------------
-- Computers
-------------------------------------------------------------

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Brand','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Computers'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Brand'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Model','TEXT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Computers'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Model'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'CPU','TEXT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Computers'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='CPU'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'RAM','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Computers'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='RAM'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Storage','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Computers'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Storage'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'GPU','TEXT',false,NOW(),NOW()
FROM categories c
WHERE c.name='Computers'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='GPU'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Screen Size','NUMBER',false,NOW(),NOW()
FROM categories c
WHERE c.name='Computers'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Screen Size'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Computers'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition'
);

-------------------------------------------------------------
-- Gaming
-------------------------------------------------------------

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Platform','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Gaming'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Platform'
);


INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Brand','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Gaming'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Brand'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Model','TEXT',false,NOW(),NOW()
FROM categories c
WHERE c.name='Gaming'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Model'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Gaming'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition'
);


-- ==========================================================
-- Cameras
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Brand','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Cameras'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Brand'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Model','TEXT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Cameras'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Model'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Sensor Type','SELECT',false,NOW(),NOW()
FROM categories c
WHERE c.name='Cameras'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Sensor Type'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Cameras'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition'
);

-------------------------------------------------------------
-- Electronics & Accessories
-------------------------------------------------------------

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Type','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Electronics & Accessories'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Type'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Brand','SELECT',false,NOW(),NOW()
FROM categories c
WHERE c.name='Electronics & Accessories'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Brand'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Electronics & Accessories'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition'
);

-- ==========================================================
-- VEHICLES
-- ==========================================================

-------------------------------------------------------------
-- Cars
-------------------------------------------------------------

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Brand','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Cars'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Brand'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Model','TEXT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Cars'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Model'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Year','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Cars'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Year'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Mileage','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Cars'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Mileage'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Fuel Type','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Cars'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Fuel Type'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Transmission','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Cars'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Transmission'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Color','SELECT',false,NOW(),NOW()
FROM categories c
WHERE c.name='Cars'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Color'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Cars'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition'
);

-------------------------------------------------------------
-- Motorcycles
-------------------------------------------------------------

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Brand','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Motorcycles'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Brand'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Model','TEXT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Motorcycles'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Model'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Engine Volume','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Motorcycles'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Engine Volume'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Year','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Motorcycles'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Year'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Motorcycles'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition'
);

-- ==========================================================
-- Heavy Vehicles
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Type','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Heavy Vehicles'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Type'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Brand','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Heavy Vehicles'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Brand'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Model','TEXT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Heavy Vehicles'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Model'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Year','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Heavy Vehicles'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Year'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Mileage','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Heavy Vehicles'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Mileage'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Heavy Vehicles'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition'
);

-- ==========================================================
-- Parts & Accessories
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Category','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Parts & Accessories'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Category'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Brand','SELECT',false,NOW(),NOW()
FROM categories c
WHERE c.name='Parts & Accessories'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Brand'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Compatible With','TEXT',false,NOW(),NOW()
FROM categories c
WHERE c.name='Parts & Accessories'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Compatible With'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Parts & Accessories'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition'
);


-- ==========================================================
-- REAL ESTATE
-- ==========================================================

-------------------------------------------------------------
-- Apartment
-------------------------------------------------------------

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Transaction Type','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Apartment'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Transaction Type'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Area','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Apartment'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Area'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Bedrooms','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Apartment'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Bedrooms'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Bathrooms','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Apartment'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Bathrooms'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Floor','NUMBER',false,NOW(),NOW()
FROM categories c
WHERE c.name='Apartment'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Floor'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Parking','BOOLEAN',false,NOW(),NOW()
FROM categories c
WHERE c.name='Apartment'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Parking'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Storage Room','BOOLEAN',false,NOW(),NOW()
FROM categories c
WHERE c.name='Apartment'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Storage Room'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Elevator','BOOLEAN',false,NOW(),NOW()
FROM categories c
WHERE c.name='Apartment'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Elevator'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Year Built','NUMBER',false,NOW(),NOW()
FROM categories c
WHERE c.name='Apartment'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Year Built'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Furnished','BOOLEAN',false,NOW(),NOW()
FROM categories c
WHERE c.name='Apartment'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Furnished'
);

-------------------------------------------------------------
-- Villa
-------------------------------------------------------------

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Transaction Type','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Villa'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Transaction Type'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Area','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Villa'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Area'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Bedrooms','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Villa'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Bedrooms'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Bathrooms','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Villa'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Bathrooms'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Parking','BOOLEAN',false,NOW(),NOW()
FROM categories c
WHERE c.name='Villa'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Parking'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Storage Room','BOOLEAN',false,NOW(),NOW()
FROM categories c
WHERE c.name='Villa'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Storage Room'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Year Built','NUMBER',false,NOW(),NOW()
FROM categories c
WHERE c.name='Villa'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Year Built'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Furnished','BOOLEAN',false,NOW(),NOW()
FROM categories c
WHERE c.name='Villa'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Furnished'
);

-------------------------------------------------------------
-- House
-------------------------------------------------------------

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Transaction Type','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='House'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Transaction Type'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Area','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='House'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Area'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Bedrooms','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='House'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Bedrooms'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Bathrooms','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='House'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Bathrooms'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Parking','BOOLEAN',false,NOW(),NOW()
FROM categories c
WHERE c.name='House'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Parking'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Storage Room','BOOLEAN',false,NOW(),NOW()
FROM categories c
WHERE c.name='House'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Storage Room'
);

-------------------------------------------------------------
-- Residential Complex
-------------------------------------------------------------

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Transaction Type','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Residential Complex'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Transaction Type'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Area','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Residential Complex'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Area'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Bedrooms','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Residential Complex'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Bedrooms'
);

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Bathrooms','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Residential Complex'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Bathrooms'
);

-- ==========================================================
-- Office
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Transaction Type','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Office'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Transaction Type');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Area','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Office'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Area');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Floor','NUMBER',false,NOW(),NOW()
FROM categories c
WHERE c.name='Office'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Floor');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Parking','BOOLEAN',false,NOW(),NOW()
FROM categories c
WHERE c.name='Office'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Parking');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Elevator','BOOLEAN',false,NOW(),NOW()
FROM categories c
WHERE c.name='Office'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Elevator');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Year Built','NUMBER',false,NOW(),NOW()
FROM categories c
WHERE c.name='Office'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Year Built');


-- ==========================================================
-- Shop
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Transaction Type','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Shop'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Transaction Type');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Area','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Shop'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Area');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Floor','NUMBER',false,NOW(),NOW()
FROM categories c
WHERE c.name='Shop'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Floor');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Parking','BOOLEAN',false,NOW(),NOW()
FROM categories c
WHERE c.name='Shop'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Parking');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Year Built','NUMBER',false,NOW(),NOW()
FROM categories c
WHERE c.name='Shop'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Year Built');

-- ==========================================================
-- Warehouse
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Transaction Type','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Warehouse'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Transaction Type');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Area','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Warehouse'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Area');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Ceiling Height','NUMBER',false,NOW(),NOW()
FROM categories c
WHERE c.name='Warehouse'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Ceiling Height');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Parking','BOOLEAN',false,NOW(),NOW()
FROM categories c
WHERE c.name='Warehouse'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Parking');


-- ==========================================================
-- Industrial Unit
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Transaction Type','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Industrial Unit'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Transaction Type');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Area','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Industrial Unit'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Area');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Electric Power','NUMBER',false,NOW(),NOW()
FROM categories c
WHERE c.name='Industrial Unit'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Electric Power');

-- ==========================================================
-- Residential Land
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Transaction Type','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Residential Land'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Transaction Type');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Area','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Residential Land'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Area');




-- ==========================================================
-- Commercial Land
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Transaction Type','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Commercial Land'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Transaction Type');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Area','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Commercial Land'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Area');



-- ==========================================================
-- Agricultural Land
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Transaction Type','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Agricultural Land'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Transaction Type');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Area','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Agricultural Land'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Area');



-- ==========================================================
-- Kitchen Appliances
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Brand','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Kitchen Appliances'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Brand');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Model','TEXT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Kitchen Appliances'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Model');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Kitchen Appliances'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Warranty','BOOLEAN',false,NOW(),NOW()
FROM categories c
WHERE c.name='Kitchen Appliances'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Warranty');

-- ==========================================================
-- Cooling & Heating
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Brand','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Cooling & Heating'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Brand');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Model','TEXT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Cooling & Heating'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Model');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Cooling & Heating'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Capacity','NUMBER',false,NOW(),NOW()
FROM categories c
WHERE c.name='Cooling & Heating'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Capacity');

-- ==========================================================
-- Laundry Appliances
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Brand','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Laundry Appliances'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Brand');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Model','TEXT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Laundry Appliances'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Model');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Laundry Appliances'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition');

-- ==========================================================
-- Vacuum Cleaners
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Brand','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Vacuum Cleaners'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Brand');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Model','TEXT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Vacuum Cleaners'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Model');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Vacuum Cleaners'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition');

-- ==========================================================
-- Living Room
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Category','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Living Room'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Category');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Material','SELECT',false,NOW(),NOW()
FROM categories c
WHERE c.name='Living Room'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Material');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Living Room'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition');

-- ==========================================================
-- Bedroom
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Category','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Bedroom'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Category');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Material','SELECT',false,NOW(),NOW()
FROM categories c
WHERE c.name='Bedroom'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Material');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Bedroom'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition');

-- ==========================================================
-- Office Furniture
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Category','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Office Furniture'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Category');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Material','SELECT',false,NOW(),NOW()
FROM categories c
WHERE c.name='Office Furniture'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Material');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Office Furniture'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition');

-- ==========================================================
-- Home Decoration
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Category','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Home Decoration'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Category');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Material','SELECT',false,NOW(),NOW()
FROM categories c
WHERE c.name='Home Decoration'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Material');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Home Decoration'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition');

-- ==========================================================
-- Women Clothing
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Brand','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Women Clothing'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Brand');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Size','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Women Clothing'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Size');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Color','SELECT',false,NOW(),NOW()
FROM categories c
WHERE c.name='Women Clothing'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Color');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Women Clothing'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition');

-- ==========================================================
-- Men Clothing
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Brand','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Men Clothing'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Brand');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Size','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Men Clothing'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Size');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Color','SELECT',false,NOW(),NOW()
FROM categories c
WHERE c.name='Men Clothing'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Color');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Men Clothing'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition');

-- ==========================================================
-- Shoes
-- ==========================================================



INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Size','NUMBER',true,NOW(),NOW()
FROM categories c
WHERE c.name='Shoes'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Size');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Color','SELECT',false,NOW(),NOW()
FROM categories c
WHERE c.name='Shoes'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Color');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Shoes'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition');

-- ==========================================================
-- Bags & Accessories
-- ==========================================================


INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Brand','SELECT',false,NOW(),NOW()
FROM categories c
WHERE c.name='Bags & Accessories'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Brand');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Bags & Accessories'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition');

-- ==========================================================
-- Fitness Equipment
-- ==========================================================


INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Brand','SELECT',false,NOW(),NOW()
FROM categories c
WHERE c.name='Fitness Equipment'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Brand');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Fitness Equipment'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition');

-- ==========================================================
-- Bicycles
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Brand','SELECT',false,NOW(),NOW()
FROM categories c
WHERE c.name='Bicycles'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Brand');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Frame Size','NUMBER',false,NOW(),NOW()
FROM categories c
WHERE c.name='Bicycles'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Frame Size');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Bicycles'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition');

-- ==========================================================
-- Camping & Travel
-- ==========================================================



INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Camping & Travel'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition');

-- ==========================================================
-- Musical Instruments
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Instrument Type','TEXT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Musical Instruments'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Instrument Type');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Brand','SELECT',false,NOW(),NOW()
FROM categories c
WHERE c.name='Musical Instruments'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Brand');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Condition','SELECT',true,NOW(),NOW()
FROM categories c
WHERE c.name='Musical Instruments'
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Condition');

-- ==========================================================
-- Services
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Service Type','TEXT',true,NOW(),NOW()
FROM categories c
WHERE c.name IN
      ('Home Services','Education','Beauty','Repair Services')
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Service Type');

-- ==========================================================
-- Jobs
-- ==========================================================

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Salary','NUMBER',false,NOW(),NOW()
FROM categories c
WHERE c.parent_id=(SELECT id FROM categories WHERE name='Jobs')
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Salary');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Experience Level','TEXT',false,NOW(),NOW()
FROM categories c
WHERE c.parent_id=(SELECT id FROM categories WHERE name='Jobs')
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Experience Level');

-- ==========================================================
-- Pets
-- ==========================================================



INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Gender','TEXT',false,NOW(),NOW()
FROM categories c
WHERE c.parent_id=(SELECT id FROM categories WHERE name='Pets')
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Gender');

INSERT INTO category_attributes
(category_id,name,data_type,required,created_at,updated_at)
SELECT c.id,'Age','NUMBER',false,NOW(),NOW()
FROM categories c
WHERE c.parent_id=(SELECT id FROM categories WHERE name='Pets')
  AND NOT EXISTS(
    SELECT 1 FROM category_attributes ca
    WHERE ca.category_id=c.id
      AND ca.name='Age');
