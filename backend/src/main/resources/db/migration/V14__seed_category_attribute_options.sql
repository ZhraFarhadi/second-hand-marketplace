-- =========================================================
-- PART 1/3
-- Digital Goods + Vehicles + Real Estate + Home Appliances + Furniture & Home
-- Fail-Fast Validation + Idempotent Seed
-- =========================================================



DO $$
DECLARE
missing_count INTEGER;
BEGIN
WITH seed(category_name, attribute_name) AS (
    VALUES
        -- Digital Goods
        ('Phones & Tablets', 'Brand'),
        ('Phones & Tablets', 'Color'),
        ('Phones & Tablets', 'Condition'),

        ('Computers', 'Brand'),
        ('Computers', 'Condition'),

        ('Gaming', 'Platform'),
        ('Gaming', 'Brand'),
        ('Gaming', 'Condition'),

        ('Cameras', 'Brand'),
        ('Cameras', 'Sensor Type'),
        ('Cameras', 'Condition'),


        ('Electronics & Accessories', 'Type'),
        ('Electronics & Accessories', 'Brand'),
        ('Electronics & Accessories', 'Condition'),

        -- Vehicles
        ('Cars', 'Brand'),
        ('Cars', 'Fuel Type'),
        ('Cars', 'Transmission'),
        ('Cars', 'Color'),
        ('Cars', 'Condition'),

        ('Motorcycles', 'Brand'),
        ('Motorcycles', 'Condition'),

        ('Heavy Vehicles', 'Type'),
        ('Heavy Vehicles', 'Brand'),
        ('Heavy Vehicles', 'Condition'),

        ('Parts & Accessories', 'Category'),
        ('Parts & Accessories', 'Brand'),
        ('Parts & Accessories', 'Condition'),

        -- Real Estate
        ('Apartment', 'Transaction Type'),
        ('Villa', 'Transaction Type'),
        ('House', 'Transaction Type'),
        ('Residential Complex', 'Transaction Type'),
        ('Office', 'Transaction Type'),
        ('Shop', 'Transaction Type'),
        ('Warehouse', 'Transaction Type'),
        ('Industrial Unit', 'Transaction Type'),
        ('Residential Land', 'Transaction Type'),
        ('Commercial Land', 'Transaction Type'),
        ('Agricultural Land', 'Transaction Type'),

        -- Home Appliances
        ('Kitchen Appliances', 'Brand'),
        ('Kitchen Appliances', 'Condition'),

        ('Cooling & Heating', 'Brand'),
        ('Cooling & Heating', 'Condition'),

        ('Laundry Appliances', 'Brand'),
        ('Laundry Appliances', 'Condition'),

        ('Vacuum Cleaners', 'Brand'),
        ('Vacuum Cleaners', 'Condition'),

        -- Furniture & Home
        ('Living Room', 'Category'),
        ('Living Room', 'Material'),
        ('Living Room', 'Condition'),

        ('Bedroom', 'Category'),
        ('Bedroom', 'Material'),
        ('Bedroom', 'Condition'),

        ('Office Furniture', 'Category'),
        ('Office Furniture', 'Material'),
        ('Office Furniture', 'Condition'),

        ('Home Decoration', 'Category'),
        ('Home Decoration', 'Material'),
        ('Home Decoration', 'Condition')


)
SELECT COUNT(*)
INTO missing_count
FROM seed s
         LEFT JOIN categories c
                   ON c.name = s.category_name
         LEFT JOIN category_attributes ca
                   ON ca.category_id = c.id
                       AND ca.name = s.attribute_name
WHERE ca.id IS NULL;

IF missing_count > 0 THEN
        RAISE EXCEPTION 'Fail-Fast: % missing or invalid SELECT mappings found in Part 1/3.', missing_count;
END IF;
END $$;

WITH option_seed(category_name, attribute_name, option_value, display_order) AS (
    VALUES
        -- =========================
        -- Phones & Tablets
        -- =========================
        ('Phones & Tablets', 'Brand', 'Apple', 1),
        ('Phones & Tablets', 'Brand', 'Samsung', 2),
        ('Phones & Tablets', 'Brand', 'Xiaomi', 3),
        ('Phones & Tablets', 'Brand', 'Huawei', 4),
        ('Phones & Tablets', 'Brand', 'Honor', 5),
        ('Phones & Tablets', 'Brand', 'Google', 6),
        ('Phones & Tablets', 'Brand', 'Nokia', 7),
        ('Phones & Tablets', 'Brand', 'OnePlus', 8),
        ('Phones & Tablets', 'Brand', 'Motorola', 9),
        ('Phones & Tablets', 'Brand', 'Sony', 10),
        ('Phones & Tablets', 'Brand', 'Oppo', 11),
        ('Phones & Tablets', 'Brand', 'Vivo', 12),
        ('Phones & Tablets', 'Brand', 'Realme', 13),
        ('Phones & Tablets', 'Brand', 'Asus', 14),
        ('Phones & Tablets', 'Brand', 'Lenovo', 15),
        ('Phones & Tablets', 'Brand', 'Microsoft', 16),
        ('Phones & Tablets', 'Brand', 'Other', 17),

        ('Phones & Tablets', 'Color', 'Black', 1),
        ('Phones & Tablets', 'Color', 'White', 2),
        ('Phones & Tablets', 'Color', 'Silver', 3),
        ('Phones & Tablets', 'Color', 'Gray', 4),
        ('Phones & Tablets', 'Color', 'Gold', 5),
        ('Phones & Tablets', 'Color', 'Rose Gold', 6),
        ('Phones & Tablets', 'Color', 'Blue', 7),
        ('Phones & Tablets', 'Color', 'Green', 8),
        ('Phones & Tablets', 'Color', 'Red', 9),
        ('Phones & Tablets', 'Color', 'Purple', 10),
        ('Phones & Tablets', 'Color', 'Yellow', 11),
        ('Phones & Tablets', 'Color', 'Other', 12),

        ('Phones & Tablets', 'Condition', 'New', 1),
        ('Phones & Tablets', 'Condition', 'Like New', 2),
        ('Phones & Tablets', 'Condition', 'Good', 3),
        ('Phones & Tablets', 'Condition', 'Fair', 4),
        ('Phones & Tablets', 'Condition', 'For Parts or Not Working', 5),

        -- =========================
        -- Computers
        -- =========================
        ('Computers', 'Brand', 'Apple', 1),
        ('Computers', 'Brand', 'Dell', 2),
        ('Computers', 'Brand', 'HP', 3),
        ('Computers', 'Brand', 'Lenovo', 4),
        ('Computers', 'Brand', 'Asus', 5),
        ('Computers', 'Brand', 'Acer', 6),
        ('Computers', 'Brand', 'Microsoft', 7),
        ('Computers', 'Brand', 'MSI', 8),
        ('Computers', 'Brand', 'Samsung', 9),
        ('Computers', 'Brand', 'Huawei', 10),
        ('Computers', 'Brand', 'Razer', 11),
        ('Computers', 'Brand', 'Alienware', 12),
        ('Computers', 'Brand', 'Gigabyte', 13),
        ('Computers', 'Brand', 'Toshiba', 14),
        ('Computers', 'Brand', 'Other', 15),

        ('Computers', 'Condition', 'New', 1),
        ('Computers', 'Condition', 'Like New', 2),
        ('Computers', 'Condition', 'Good', 3),
        ('Computers', 'Condition', 'Fair', 4),
        ('Computers', 'Condition', 'For Parts or Not Working', 5),

        -- =========================
        -- Gaming
        -- =========================
        ('Gaming', 'Platform', 'PlayStation 5', 1),
        ('Gaming', 'Platform', 'PlayStation 4', 2),
        ('Gaming', 'Platform', 'PlayStation 3', 3),
        ('Gaming', 'Platform', 'Xbox Series X/S', 4),
        ('Gaming', 'Platform', 'Xbox One', 5),
        ('Gaming', 'Platform', 'Xbox 360', 6),
        ('Gaming', 'Platform', 'Nintendo Switch', 7),
        ('Gaming', 'Platform', 'Nintendo Wii', 8),
        ('Gaming', 'Platform', 'PC', 9),
        ('Gaming', 'Platform', 'Steam Deck', 10),
        ('Gaming', 'Platform', 'Mobile', 11),
        ('Gaming', 'Platform', 'Other', 12),

        ('Gaming', 'Brand', 'Sony', 1),
        ('Gaming', 'Brand', 'Microsoft', 2),
        ('Gaming', 'Brand', 'Nintendo', 3),
        ('Gaming', 'Brand', 'Valve', 4),
        ('Gaming', 'Brand', 'Razer', 5),
        ('Gaming', 'Brand', 'Logitech', 6),
        ('Gaming', 'Brand', 'Corsair', 7),
        ('Gaming', 'Brand', 'SteelSeries', 8),
        ('Gaming', 'Brand', 'HyperX', 9),
        ('Gaming', 'Brand', 'Asus', 10),
        ('Gaming', 'Brand', 'MSI', 11),
        ('Gaming', 'Brand', 'Other', 12),

        ('Gaming', 'Condition', 'New', 1),
        ('Gaming', 'Condition', 'Like New', 2),
        ('Gaming', 'Condition', 'Good', 3),
        ('Gaming', 'Condition', 'Fair', 4),
        ('Gaming', 'Condition', 'For Parts or Not Working', 5),

        -- =========================
        -- Cameras
        -- =========================

        -- =========================
-- Cameras
-- =========================
        ('Cameras', 'Brand', 'Canon', 1),
        ('Cameras', 'Brand', 'Nikon', 2),
        ('Cameras', 'Brand', 'Sony', 3),
        ('Cameras', 'Brand', 'Fujifilm', 4),
        ('Cameras', 'Brand', 'Panasonic', 5),
        ('Cameras', 'Brand', 'Olympus', 6),
        ('Cameras', 'Brand', 'Leica', 7),
        ('Cameras', 'Brand', 'Pentax', 8),
        ('Cameras', 'Brand', 'GoPro', 9),
        ('Cameras', 'Brand', 'DJI', 10),
        ('Cameras', 'Brand', 'Kodak', 11),
        ('Cameras', 'Brand', 'Other', 12),

        ('Cameras', 'Sensor Type', 'Full Frame', 1),
        ('Cameras', 'Sensor Type', 'APS-C', 2),
        ('Cameras', 'Sensor Type', 'Micro Four Thirds', 3),
        ('Cameras', 'Sensor Type', 'Medium Format', 4),
        ('Cameras', 'Sensor Type', '1-Inch', 5),
        ('Cameras', 'Sensor Type', 'Compact Sensor', 6),
        ('Cameras', 'Sensor Type', 'Other', 7),

        ('Cameras', 'Condition', 'New', 1),
        ('Cameras', 'Condition', 'Like New', 2),
        ('Cameras', 'Condition', 'Good', 3),
        ('Cameras', 'Condition', 'Fair', 4),
        ('Cameras', 'Condition', 'For Parts or Not Working', 5),


        -- =========================
        -- Electronics & Accessories
        -- =========================
        ('Electronics & Accessories', 'Type', 'Headphones & Earphones', 1),
        ('Electronics & Accessories', 'Type', 'Speakers', 2),
        ('Electronics & Accessories', 'Type', 'Smart Watches', 3),
        ('Electronics & Accessories', 'Type', 'Chargers & Adapters', 4),
        ('Electronics & Accessories', 'Type', 'Cables', 5),
        ('Electronics & Accessories', 'Type', 'Power Banks', 6),
        ('Electronics & Accessories', 'Type', 'Storage Devices', 7),
        ('Electronics & Accessories', 'Type', 'Computer Accessories', 8),
        ('Electronics & Accessories', 'Type', 'Phone Accessories', 9),
        ('Electronics & Accessories', 'Type', 'Networking Equipment', 10),
        ('Electronics & Accessories', 'Type', 'TV & Video Accessories', 11),
        ('Electronics & Accessories', 'Type', 'Other', 12),


        ('Electronics & Accessories', 'Brand', 'Apple', 1),
        ('Electronics & Accessories', 'Brand', 'Samsung', 2),
        ('Electronics & Accessories', 'Brand', 'Sony', 3),
        ('Electronics & Accessories', 'Brand', 'LG', 4),
        ('Electronics & Accessories', 'Brand', 'Xiaomi', 5),
        ('Electronics & Accessories', 'Brand', 'Huawei', 6),
        ('Electronics & Accessories', 'Brand', 'Anker', 7),
        ('Electronics & Accessories', 'Brand', 'JBL', 8),
        ('Electronics & Accessories', 'Brand', 'Bose', 9),
        ('Electronics & Accessories', 'Brand', 'Logitech', 10),
        ('Electronics & Accessories', 'Brand', 'Razer', 11),
        ('Electronics & Accessories', 'Brand', 'Baseus', 12),
        ('Electronics & Accessories', 'Brand', 'Other', 13),

        ('Electronics & Accessories', 'Condition', 'New', 1),
        ('Electronics & Accessories', 'Condition', 'Like New', 2),
        ('Electronics & Accessories', 'Condition', 'Good', 3),
        ('Electronics & Accessories', 'Condition', 'Fair', 4),
        ('Electronics & Accessories', 'Condition', 'For Parts or Not Working', 5),

        -- =========================
        -- Cars
        -- =========================
        ('Cars', 'Brand', 'Toyota', 1),
        ('Cars', 'Brand', 'Honda', 2),
        ('Cars', 'Brand', 'Nissan', 3),
        ('Cars', 'Brand', 'Hyundai', 4),
        ('Cars', 'Brand', 'Kia', 5),
        ('Cars', 'Brand', 'Ford', 6),
        ('Cars', 'Brand', 'Chevrolet', 7),
        ('Cars', 'Brand', 'Volkswagen', 8),
        ('Cars', 'Brand', 'BMW', 9),
        ('Cars', 'Brand', 'Mercedes-Benz', 10),
        ('Cars', 'Brand', 'Audi', 11),
        ('Cars', 'Brand', 'Lexus', 12),
        ('Cars', 'Brand', 'Mazda', 13),
        ('Cars', 'Brand', 'Mitsubishi', 14),
        ('Cars', 'Brand', 'Renault', 15),
        ('Cars', 'Brand', 'Peugeot', 16),
        ('Cars', 'Brand', 'Volvo', 17),
        ('Cars', 'Brand', 'Jeep', 18),
        ('Cars', 'Brand', 'Land Rover', 19),
        ('Cars', 'Brand', 'Porsche', 20),
        ('Cars', 'Brand', 'Tesla', 21),
        ('Cars', 'Brand', 'Fiat', 22),
        ('Cars', 'Brand', 'Suzuki', 23),
        ('Cars', 'Brand', 'Subaru', 24),
        ('Cars', 'Brand', 'Other', 25),

        ('Cars', 'Fuel Type', 'Gasoline', 1),
        ('Cars', 'Fuel Type', 'Diesel', 2),
        ('Cars', 'Fuel Type', 'Hybrid', 3),
        ('Cars', 'Fuel Type', 'Plug-in Hybrid', 4),
        ('Cars', 'Fuel Type', 'Electric', 5),
        ('Cars', 'Fuel Type', 'LPG', 6),
        ('Cars', 'Fuel Type', 'CNG', 7),
        ('Cars', 'Fuel Type', 'Other', 8),

        ('Cars', 'Transmission', 'Automatic', 1),
        ('Cars', 'Transmission', 'Manual', 2),
        ('Cars', 'Transmission', 'CVT', 3),
        ('Cars', 'Transmission', 'Semi-Automatic', 4),

        ('Cars', 'Color', 'Black', 1),
        ('Cars', 'Color', 'White', 2),
        ('Cars', 'Color', 'Silver', 3),
        ('Cars', 'Color', 'Gray', 4),
        ('Cars', 'Color', 'Blue', 5),
        ('Cars', 'Color', 'Red', 6),
        ('Cars', 'Color', 'Green', 7),
        ('Cars', 'Color', 'Brown', 8),
        ('Cars', 'Color', 'Beige', 9),
        ('Cars', 'Color', 'Gold', 10),
        ('Cars', 'Color', 'Orange', 11),
        ('Cars', 'Color', 'Yellow', 12),
        ('Cars', 'Color', 'Other', 13),

        ('Cars', 'Condition', 'New', 1),
        ('Cars', 'Condition', 'Used - Excellent', 2),
        ('Cars', 'Condition', 'Used - Good', 3),
        ('Cars', 'Condition', 'Used - Fair', 4),
        ('Cars', 'Condition', 'Damaged', 5),
        ('Cars', 'Condition', 'For Parts', 6),

        -- =========================
        -- Motorcycles
        -- =========================
        ('Motorcycles', 'Brand', 'Honda', 1),
        ('Motorcycles', 'Brand', 'Yamaha', 2),
        ('Motorcycles', 'Brand', 'Suzuki', 3),
        ('Motorcycles', 'Brand', 'Kawasaki', 4),
        ('Motorcycles', 'Brand', 'BMW', 5),
        ('Motorcycles', 'Brand', 'Ducati', 6),
        ('Motorcycles', 'Brand', 'KTM', 7),
        ('Motorcycles', 'Brand', 'Harley-Davidson', 8),
        ('Motorcycles', 'Brand', 'Triumph', 9),
        ('Motorcycles', 'Brand', 'Vespa', 10),
        ('Motorcycles', 'Brand', 'Aprilia', 11),
        ('Motorcycles', 'Brand', 'Royal Enfield', 12),
        ('Motorcycles', 'Brand', 'Other', 13),

        ('Motorcycles', 'Condition', 'New', 1),
        ('Motorcycles', 'Condition', 'Used - Excellent', 2),
        ('Motorcycles', 'Condition', 'Used - Good', 3),
        ('Motorcycles', 'Condition', 'Used - Fair', 4),
        ('Motorcycles', 'Condition', 'Damaged', 5),
        ('Motorcycles', 'Condition', 'For Parts', 6),

        -- =========================
        -- Heavy Vehicles
        -- =========================
        ('Heavy Vehicles', 'Type', 'Truck', 1),
        ('Heavy Vehicles', 'Type', 'Pickup Truck', 2),
        ('Heavy Vehicles', 'Type', 'Van', 3),
        ('Heavy Vehicles', 'Type', 'Bus', 4),
        ('Heavy Vehicles', 'Type', 'Minibus', 5),
        ('Heavy Vehicles', 'Type', 'Trailer', 6),
        ('Heavy Vehicles', 'Type', 'Tractor', 7),
        ('Heavy Vehicles', 'Type', 'Construction Vehicle', 8),
        ('Heavy Vehicles', 'Type', 'Agricultural Vehicle', 9),
        ('Heavy Vehicles', 'Type', 'Other', 10),

        ('Heavy Vehicles', 'Brand', 'Mercedes-Benz', 1),
        ('Heavy Vehicles', 'Brand', 'Volvo', 2),
        ('Heavy Vehicles', 'Brand', 'Scania', 3),
        ('Heavy Vehicles', 'Brand', 'MAN', 4),
        ('Heavy Vehicles', 'Brand', 'DAF', 5),
        ('Heavy Vehicles', 'Brand', 'Iveco', 6),
        ('Heavy Vehicles', 'Brand', 'Isuzu', 7),
        ('Heavy Vehicles', 'Brand', 'Hino', 8),
        ('Heavy Vehicles', 'Brand', 'Mitsubishi Fuso', 9),
        ('Heavy Vehicles', 'Brand', 'Ford', 10),
        ('Heavy Vehicles', 'Brand', 'Renault Trucks', 11),
        ('Heavy Vehicles', 'Brand', 'Caterpillar', 12),
        ('Heavy Vehicles', 'Brand', 'Other', 13),

        ('Heavy Vehicles', 'Condition', 'New', 1),
        ('Heavy Vehicles', 'Condition', 'Used - Excellent', 2),
        ('Heavy Vehicles', 'Condition', 'Used - Good', 3),
        ('Heavy Vehicles', 'Condition', 'Used - Fair', 4),
        ('Heavy Vehicles', 'Condition', 'Damaged', 5),
        ('Heavy Vehicles', 'Condition', 'For Parts', 6),

        -- =========================
        -- Parts & Accessories
        -- =========================
        ('Parts & Accessories', 'Category', 'Engine Parts', 1),
        ('Parts & Accessories', 'Category', 'Body Parts', 2),
        ('Parts & Accessories', 'Category', 'Electrical Parts', 3),
        ('Parts & Accessories', 'Category', 'Suspension & Steering', 4),
        ('Parts & Accessories', 'Category', 'Brakes', 5),
        ('Parts & Accessories', 'Category', 'Wheels & Tires', 6),
        ('Parts & Accessories', 'Category', 'Interior Accessories', 7),
        ('Parts & Accessories', 'Category', 'Exterior Accessories', 8),
        ('Parts & Accessories', 'Category', 'Audio & Navigation', 9),
        ('Parts & Accessories', 'Category', 'Motorcycle Parts', 10),
        ('Parts & Accessories', 'Category', 'Heavy Vehicle Parts', 11),
        ('Parts & Accessories', 'Category', 'Other', 12),

        ('Parts & Accessories', 'Brand', 'Bosch', 1),
        ('Parts & Accessories', 'Brand', 'Denso', 2),
        ('Parts & Accessories', 'Brand', 'NGK', 3),
        ('Parts & Accessories', 'Brand', 'Brembo', 4),
        ('Parts & Accessories', 'Brand', 'Michelin', 5),
        ('Parts & Accessories', 'Brand', 'Bridgestone', 6),
        ('Parts & Accessories', 'Brand', 'Continental', 7),
        ('Parts & Accessories', 'Brand', 'Goodyear', 8),
        ('Parts & Accessories', 'Brand', 'Castrol', 9),
        ('Parts & Accessories', 'Brand', 'Mobil', 10),
        ('Parts & Accessories', 'Brand', 'Toyota', 11),
        ('Parts & Accessories', 'Brand', 'Honda', 12),
        ('Parts & Accessories', 'Brand', 'Hyundai', 13),
        ('Parts & Accessories', 'Brand', 'Kia', 14),
        ('Parts & Accessories', 'Brand', 'Ford', 15),
        ('Parts & Accessories', 'Brand', 'BMW', 16),
        ('Parts & Accessories', 'Brand', 'Mercedes-Benz', 17),
        ('Parts & Accessories', 'Brand', 'Generic', 18),
        ('Parts & Accessories', 'Brand', 'Other', 19),

        ('Parts & Accessories', 'Condition', 'New', 1),
        ('Parts & Accessories', 'Condition', 'Like New', 2),
        ('Parts & Accessories', 'Condition', 'Used - Good', 3),
        ('Parts & Accessories', 'Condition', 'Used - Fair', 4),
        ('Parts & Accessories', 'Condition', 'Refurbished', 5),
        ('Parts & Accessories', 'Condition', 'For Parts', 6),

        -- =========================
        -- Real Estate
        -- =========================
        ('Apartment', 'Transaction Type', 'For Sale', 1),
        ('Apartment', 'Transaction Type', 'For Rent', 2),
        ('Apartment', 'Transaction Type', 'Mortgage', 3),
        ('Apartment', 'Transaction Type', 'Short-Term Rent', 4),

        ('Villa', 'Transaction Type', 'For Sale', 1),
        ('Villa', 'Transaction Type', 'For Rent', 2),
        ('Villa', 'Transaction Type', 'Mortgage', 3),
        ('Villa', 'Transaction Type', 'Short-Term Rent', 4),

        ('House', 'Transaction Type', 'For Sale', 1),
        ('House', 'Transaction Type', 'For Rent', 2),
        ('House', 'Transaction Type', 'Mortgage', 3),
        ('House', 'Transaction Type', 'Short-Term Rent', 4),

        ('Residential Complex', 'Transaction Type', 'For Sale', 1),
        ('Residential Complex', 'Transaction Type', 'For Rent', 2),
        ('Residential Complex', 'Transaction Type', 'Mortgage', 3),
        ('Residential Complex', 'Transaction Type', 'Short-Term Rent', 4),

        ('Office', 'Transaction Type', 'For Sale', 1),
        ('Office', 'Transaction Type', 'For Rent', 2),
        ('Office', 'Transaction Type', 'Mortgage', 3),
        ('Office', 'Transaction Type', 'Short-Term Rent', 4),

        ('Shop', 'Transaction Type', 'For Sale', 1),
        ('Shop', 'Transaction Type', 'For Rent', 2),
        ('Shop', 'Transaction Type', 'Mortgage', 3),
        ('Shop', 'Transaction Type', 'Short-Term Rent', 4),

        ('Warehouse', 'Transaction Type', 'For Sale', 1),
        ('Warehouse', 'Transaction Type', 'For Rent', 2),
        ('Warehouse', 'Transaction Type', 'Mortgage', 3),

        ('Industrial Unit', 'Transaction Type', 'For Sale', 1),
        ('Industrial Unit', 'Transaction Type', 'For Rent', 2),
        ('Industrial Unit', 'Transaction Type', 'Mortgage', 3),

        ('Residential Land', 'Transaction Type', 'For Sale', 1),
        ('Residential Land', 'Transaction Type', 'For Rent', 2),
        ('Residential Land', 'Transaction Type', 'Mortgage', 3),

        ('Commercial Land', 'Transaction Type', 'For Sale', 1),
        ('Commercial Land', 'Transaction Type', 'For Rent', 2),
        ('Commercial Land', 'Transaction Type', 'Mortgage', 3),

        ('Agricultural Land', 'Transaction Type', 'For Sale', 1),
        ('Agricultural Land', 'Transaction Type', 'For Rent', 2),
        ('Agricultural Land', 'Transaction Type', 'Mortgage', 3),

        -- =========================
        -- Home Appliances
        -- =========================
        ('Kitchen Appliances', 'Brand', 'Samsung', 1),
        ('Kitchen Appliances', 'Brand', 'LG', 2),
        ('Kitchen Appliances', 'Brand', 'Bosch', 3),
        ('Kitchen Appliances', 'Brand', 'Philips', 4),
        ('Kitchen Appliances', 'Brand', 'Panasonic', 5),
        ('Kitchen Appliances', 'Brand', 'Tefal', 6),
        ('Kitchen Appliances', 'Brand', 'Moulinex', 7),
        ('Kitchen Appliances', 'Brand', 'Kenwood', 8),
        ('Kitchen Appliances', 'Brand', 'Beko', 9),
        ('Kitchen Appliances', 'Brand', 'Daewoo', 10),
        ('Kitchen Appliances', 'Brand', 'Other', 11),




        ('Kitchen Appliances', 'Condition', 'New', 1),
        ('Kitchen Appliances', 'Condition', 'Like New', 2),
        ('Kitchen Appliances', 'Condition', 'Good', 3),
        ('Kitchen Appliances', 'Condition', 'Fair', 4),
        ('Kitchen Appliances', 'Condition', 'For Parts or Not Working', 5),

        ('Cooling & Heating', 'Brand', 'Samsung', 1),
        ('Cooling & Heating', 'Brand', 'LG', 2),
        ('Cooling & Heating', 'Brand', 'Bosch', 3),
        ('Cooling & Heating', 'Brand', 'Panasonic', 4),
        ('Cooling & Heating', 'Brand', 'Daikin', 5),
        ('Cooling & Heating', 'Brand', 'Gree', 6),
        ('Cooling & Heating', 'Brand', 'Midea', 7),
        ('Cooling & Heating', 'Brand', 'Carrier', 8),
        ('Cooling & Heating', 'Brand', 'Beko', 9),
        ('Cooling & Heating', 'Brand', 'Other', 10),



        ('Cooling & Heating', 'Condition', 'New', 1),
        ('Cooling & Heating', 'Condition', 'Like New', 2),
        ('Cooling & Heating', 'Condition', 'Good', 3),
        ('Cooling & Heating', 'Condition', 'Fair', 4),
        ('Cooling & Heating', 'Condition', 'For Parts or Not Working', 5),

        ('Laundry Appliances', 'Brand', 'Samsung', 1),
        ('Laundry Appliances', 'Brand', 'LG', 2),
        ('Laundry Appliances', 'Brand', 'Bosch', 3),
        ('Laundry Appliances', 'Brand', 'Beko', 4),
        ('Laundry Appliances', 'Brand', 'Whirlpool', 5),
        ('Laundry Appliances', 'Brand', 'Electrolux', 6),
        ('Laundry Appliances', 'Brand', 'Daewoo', 7),
        ('Laundry Appliances', 'Brand', 'Panasonic', 8),
        ('Laundry Appliances', 'Brand', 'Other', 9),



        ('Laundry Appliances', 'Condition', 'New', 1),
        ('Laundry Appliances', 'Condition', 'Like New', 2),
        ('Laundry Appliances', 'Condition', 'Good', 3),
        ('Laundry Appliances', 'Condition', 'Fair', 4),
        ('Laundry Appliances', 'Condition', 'For Parts or Not Working', 5),

        ('Vacuum Cleaners', 'Brand', 'Dyson', 1),
        ('Vacuum Cleaners', 'Brand', 'Philips', 2),
        ('Vacuum Cleaners', 'Brand', 'Bosch', 3),
        ('Vacuum Cleaners', 'Brand', 'Samsung', 4),
        ('Vacuum Cleaners', 'Brand', 'LG', 5),
        ('Vacuum Cleaners', 'Brand', 'Panasonic', 6),
        ('Vacuum Cleaners', 'Brand', 'Bissell', 7),
        ('Vacuum Cleaners', 'Brand', 'Tefal', 8),
        ('Vacuum Cleaners', 'Brand', 'Other', 9),



        ('Vacuum Cleaners', 'Condition', 'New', 1),
        ('Vacuum Cleaners', 'Condition', 'Like New', 2),
        ('Vacuum Cleaners', 'Condition', 'Good', 3),
        ('Vacuum Cleaners', 'Condition', 'Fair', 4),
        ('Vacuum Cleaners', 'Condition', 'For Parts or Not Working', 5),

        -- =========================
        -- Furniture & Home
        -- =========================

        -- =========================
-- Furniture & Home
-- =========================

-- =========================
-- Living Room
-- =========================
        ('Living Room', 'Category', 'Sofa', 1),
        ('Living Room', 'Category', 'Armchair', 2),
        ('Living Room', 'Category', 'Coffee Table', 3),
        ('Living Room', 'Category', 'TV Stand', 4),
        ('Living Room', 'Category', 'Side Table', 5),
        ('Living Room', 'Category', 'Bookshelf', 6),
        ('Living Room', 'Category', 'Cabinet', 7),
        ('Living Room', 'Category', 'Other', 8),

        ('Living Room', 'Material', 'Wood', 1),
        ('Living Room', 'Material', 'MDF', 2),
        ('Living Room', 'Material', 'Metal', 3),
        ('Living Room', 'Material', 'Glass', 4),
        ('Living Room', 'Material', 'Plastic', 5),
        ('Living Room', 'Material', 'Leather', 6),
        ('Living Room', 'Material', 'Fabric', 7),
        ('Living Room', 'Material', 'Velvet', 8),
        ('Living Room', 'Material', 'Rattan', 9),
        ('Living Room', 'Material', 'Other', 10),

        ('Living Room', 'Condition', 'New', 1),
        ('Living Room', 'Condition', 'Like New', 2),
        ('Living Room', 'Condition', 'Good', 3),
        ('Living Room', 'Condition', 'Fair', 4),
        ('Living Room', 'Condition', 'Needs Repair', 5),

-- =========================
-- Bedroom
-- =========================
        ('Bedroom', 'Category', 'Bed', 1),
        ('Bedroom', 'Category', 'Mattress', 2),
        ('Bedroom', 'Category', 'Wardrobe', 3),
        ('Bedroom', 'Category', 'Dresser', 4),
        ('Bedroom', 'Category', 'Nightstand', 5),
        ('Bedroom', 'Category', 'Vanity Table', 6),
        ('Bedroom', 'Category', 'Bedroom Set', 7),
        ('Bedroom', 'Category', 'Other', 8),

        ('Bedroom', 'Material', 'Wood', 1),
        ('Bedroom', 'Material', 'MDF', 2),
        ('Bedroom', 'Material', 'Metal', 3),
        ('Bedroom', 'Material', 'Glass', 4),
        ('Bedroom', 'Material', 'Plastic', 5),
        ('Bedroom', 'Material', 'Leather', 6),
        ('Bedroom', 'Material', 'Fabric', 7),
        ('Bedroom', 'Material', 'Velvet', 8),
        ('Bedroom', 'Material', 'Other', 9),

        ('Bedroom', 'Condition', 'New', 1),
        ('Bedroom', 'Condition', 'Like New', 2),
        ('Bedroom', 'Condition', 'Good', 3),
        ('Bedroom', 'Condition', 'Fair', 4),
        ('Bedroom', 'Condition', 'Needs Repair', 5),

-- =========================
-- Office Furniture
-- =========================
        ('Office Furniture', 'Category', 'Office Desk', 1),
        ('Office Furniture', 'Category', 'Office Chair', 2),
        ('Office Furniture', 'Category', 'Filing Cabinet', 3),
        ('Office Furniture', 'Category', 'Bookshelf', 4),
        ('Office Furniture', 'Category', 'Conference Table', 5),
        ('Office Furniture', 'Category', 'Reception Desk', 6),
        ('Office Furniture', 'Category', 'Office Furniture Set', 7),
        ('Office Furniture', 'Category', 'Other', 8),

        ('Office Furniture', 'Material', 'Wood', 1),
        ('Office Furniture', 'Material', 'MDF', 2),
        ('Office Furniture', 'Material', 'Metal', 3),
        ('Office Furniture', 'Material', 'Glass', 4),
        ('Office Furniture', 'Material', 'Plastic', 5),
        ('Office Furniture', 'Material', 'Leather', 6),
        ('Office Furniture', 'Material', 'Fabric', 7),
        ('Office Furniture', 'Material', 'Mesh', 8),
        ('Office Furniture', 'Material', 'Other', 9),

        ('Office Furniture', 'Condition', 'New', 1),
        ('Office Furniture', 'Condition', 'Like New', 2),
        ('Office Furniture', 'Condition', 'Good', 3),
        ('Office Furniture', 'Condition', 'Fair', 4),
        ('Office Furniture', 'Condition', 'Needs Repair', 5),

-- =========================
-- Home Decoration
-- =========================
        ('Home Decoration', 'Category', 'Decorative Accessories', 1),
        ('Home Decoration', 'Category', 'Wall Art', 2),
        ('Home Decoration', 'Category', 'Lighting', 3),
        ('Home Decoration', 'Category', 'Curtains', 4),
        ('Home Decoration', 'Category', 'Carpets', 5),

        ('Home Decoration', 'Material', 'Wood', 1),
        ('Home Decoration', 'Material', 'Metal', 2),
        ('Home Decoration', 'Material', 'Glass', 3),
        ('Home Decoration', 'Material', 'Plastic', 4),
        ('Home Decoration', 'Material', 'Fabric', 5),

        ('Home Decoration', 'Condition', 'New', 1),
        ('Home Decoration', 'Condition', 'Like New', 2),
        ('Home Decoration', 'Condition', 'Good', 3),
        ('Home Decoration', 'Condition', 'Needs Repair', 4)



)
INSERT INTO category_attribute_options (category_attribute_id, value, display_order, created_at, updated_at)
SELECT ca.id, os.option_value, os.display_order, NOW(), NOW()
FROM option_seed os
         JOIN categories c
              ON c.name = os.category_name
         JOIN category_attributes ca
              ON ca.category_id = c.id
                  AND ca.name = os.attribute_name
    ON CONFLICT (category_attribute_id, value)
DO UPDATE SET
    display_order = EXCLUDED.display_order,
           updated_at = NOW();


-- =========================================================
-- PART 2/3
-- Fashion + Sports & Leisure
-- Fail-Fast Validation + Idempotent Seed
-- =========================================================

DO $$
DECLARE
missing_count INTEGER;
BEGIN
WITH seed(category_name, attribute_name) AS (
    VALUES
        -- Fashion
        ('Women Clothing', 'Brand'),
        ('Women Clothing', 'Size'),
        ('Women Clothing', 'Color'),
        ('Women Clothing', 'Condition'),

        ('Men Clothing', 'Brand'),
        ('Men Clothing', 'Size'),
        ('Men Clothing', 'Color'),
        ('Men Clothing', 'Condition'),

        ('Shoes', 'Color'),
        ('Shoes', 'Condition'),

        ('Bags & Accessories', 'Brand'),
        ('Bags & Accessories', 'Condition'),

        -- Sports & Leisure
        ('Fitness Equipment', 'Brand'),
        ('Fitness Equipment', 'Condition'),

        ('Bicycles', 'Brand'),
        ('Bicycles', 'Condition'),

        ('Camping & Travel', 'Condition'),

        ('Musical Instruments', 'Brand'),
        ('Musical Instruments', 'Condition')
)
SELECT COUNT(*)
INTO missing_count
FROM seed s
         LEFT JOIN categories c
                   ON c.name = s.category_name
         LEFT JOIN category_attributes ca
                   ON ca.category_id = c.id
                       AND ca.name = s.attribute_name
WHERE ca.id IS NULL;

IF missing_count > 0 THEN
        RAISE EXCEPTION 'Fail-Fast: % missing or invalid SELECT mappings found in Part 2/3.', missing_count;
END IF;
END $$;

WITH option_seed(category_name, attribute_name, option_value, display_order) AS (
    VALUES
        -- =========================
        -- Women Clothing
        -- =========================
        ('Women Clothing', 'Brand', 'Zara', 1),
        ('Women Clothing', 'Brand', 'H&M', 2),
        ('Women Clothing', 'Brand', 'Mango', 3),
        ('Women Clothing', 'Brand', 'Nike', 4),
        ('Women Clothing', 'Brand', 'Adidas', 5),
        ('Women Clothing', 'Brand', 'Puma', 6),
        ('Women Clothing', 'Brand', 'Levi''s', 7),
        ('Women Clothing', 'Brand', 'Gucci', 8),
        ('Women Clothing', 'Brand', 'Chanel', 9),
        ('Women Clothing', 'Brand', 'Dior', 10),
        ('Women Clothing', 'Brand', 'Other', 11),

        ('Women Clothing', 'Size', 'XXS', 1),
        ('Women Clothing', 'Size', 'XS', 2),
        ('Women Clothing', 'Size', 'S', 3),
        ('Women Clothing', 'Size', 'M', 4),
        ('Women Clothing', 'Size', 'L', 5),
        ('Women Clothing', 'Size', 'XL', 6),
        ('Women Clothing', 'Size', 'XXL', 7),
        ('Women Clothing', 'Size', 'Free Size', 8),

        ('Women Clothing', 'Color', 'Black', 1),
        ('Women Clothing', 'Color', 'White', 2),
        ('Women Clothing', 'Color', 'Gray', 3),
        ('Women Clothing', 'Color', 'Blue', 4),
        ('Women Clothing', 'Color', 'Red', 5),
        ('Women Clothing', 'Color', 'Green', 6),
        ('Women Clothing', 'Color', 'Pink', 7),
        ('Women Clothing', 'Color', 'Purple', 8),
        ('Women Clothing', 'Color', 'Brown', 9),
        ('Women Clothing', 'Color', 'Beige', 10),
        ('Women Clothing', 'Color', 'Yellow', 11),
        ('Women Clothing', 'Color', 'Orange', 12),
        ('Women Clothing', 'Color', 'Other', 13),


        ('Women Clothing', 'Condition', 'New', 1),
        ('Women Clothing', 'Condition', 'Like New', 2),
        ('Women Clothing', 'Condition', 'Good', 3),
        ('Women Clothing', 'Condition', 'Fair', 4),

        -- =========================
        -- Men Clothing
        -- =========================
        ('Men Clothing', 'Brand', 'Zara', 1),
        ('Men Clothing', 'Brand', 'H&M', 2),
        ('Men Clothing', 'Brand', 'Nike', 3),
        ('Men Clothing', 'Brand', 'Adidas', 4),
        ('Men Clothing', 'Brand', 'Puma', 5),
        ('Men Clothing', 'Brand', 'Levi''s', 6),
        ('Men Clothing', 'Brand', 'Tommy Hilfiger', 7),
        ('Men Clothing', 'Brand', 'Lacoste', 8),
        ('Men Clothing', 'Brand', 'Gucci', 9),
        ('Men Clothing', 'Brand', 'Other', 10),

        ('Men Clothing', 'Size', 'XS', 1),
        ('Men Clothing', 'Size', 'S', 2),
        ('Men Clothing', 'Size', 'M', 3),
        ('Men Clothing', 'Size', 'L', 4),
        ('Men Clothing', 'Size', 'XL', 5),
        ('Men Clothing', 'Size', 'XXL', 6),
        ('Men Clothing', 'Size', '3XL', 7),

        ('Men Clothing', 'Color', 'Black', 1),
        ('Men Clothing', 'Color', 'White', 2),
        ('Men Clothing', 'Color', 'Gray', 3),
        ('Men Clothing', 'Color', 'Blue', 4),
        ('Men Clothing', 'Color', 'Red', 5),
        ('Men Clothing', 'Color', 'Green', 6),
        ('Men Clothing', 'Color', 'Brown', 7),
        ('Men Clothing', 'Color', 'Beige', 8),
        ('Men Clothing', 'Color', 'Yellow', 9),
        ('Men Clothing', 'Color', 'Other', 10),


        ('Men Clothing', 'Condition', 'New', 1),
        ('Men Clothing', 'Condition', 'Like New', 2),
        ('Men Clothing', 'Condition', 'Good', 3),
        ('Men Clothing', 'Condition', 'Fair', 4),

        -- =========================
        -- Shoes
        -- =========================
        ('Shoes', 'Color', 'Black', 1),
        ('Shoes', 'Color', 'White', 2),
        ('Shoes', 'Color', 'Gray', 3),
        ('Shoes', 'Color', 'Blue', 4),
        ('Shoes', 'Color', 'Red', 5),
        ('Shoes', 'Color', 'Brown', 6),
        ('Shoes', 'Color', 'Beige', 7),
        ('Shoes', 'Color', 'Pink', 8),
        ('Shoes', 'Color', 'Green', 9),
        ('Shoes', 'Color', 'Other', 10),

        ('Shoes', 'Condition', 'New', 1),
        ('Shoes', 'Condition', 'Like New', 2),
        ('Shoes', 'Condition', 'Good', 3),
        ('Shoes', 'Condition', 'Fair', 4),

        -- =========================
        -- Bags & Accessories
        -- =========================
        ('Bags & Accessories', 'Brand', 'Zara', 1),
        ('Bags & Accessories', 'Brand', 'H&M', 2),
        ('Bags & Accessories', 'Brand', 'Michael Kors', 3),
        ('Bags & Accessories', 'Brand', 'Coach', 4),
        ('Bags & Accessories', 'Brand', 'Gucci', 5),
        ('Bags & Accessories', 'Brand', 'Louis Vuitton', 6),
        ('Bags & Accessories', 'Brand', 'Prada', 7),
        ('Bags & Accessories', 'Brand', 'Chanel', 8),
        ('Bags & Accessories', 'Brand', 'Dior', 9),
        ('Bags & Accessories', 'Brand', 'Other', 10),

        ('Bags & Accessories', 'Condition', 'New', 1),
        ('Bags & Accessories', 'Condition', 'Like New', 2),
        ('Bags & Accessories', 'Condition', 'Good', 3),
        ('Bags & Accessories', 'Condition', 'Fair', 4),

        -- =========================
        -- Fitness Equipment
        -- =========================
        ('Fitness Equipment', 'Brand', 'Nike', 1),
        ('Fitness Equipment', 'Brand', 'Adidas', 2),
        ('Fitness Equipment', 'Brand', 'Reebok', 3),
        ('Fitness Equipment', 'Brand', 'Bowflex', 4),
        ('Fitness Equipment', 'Brand', 'NordicTrack', 5),
        ('Fitness Equipment', 'Brand', 'Life Fitness', 6),
        ('Fitness Equipment', 'Brand', 'Technogym', 7),
        ('Fitness Equipment', 'Brand', 'Other', 8),

        ('Fitness Equipment', 'Condition', 'New', 1),
        ('Fitness Equipment', 'Condition', 'Like New', 2),
        ('Fitness Equipment', 'Condition', 'Good', 3),
        ('Fitness Equipment', 'Condition', 'Fair', 4),

        -- =========================
        -- Bicycles
        -- =========================
        ('Bicycles', 'Brand', 'Giant', 1),
        ('Bicycles', 'Brand', 'Trek', 2),
        ('Bicycles', 'Brand', 'Specialized', 3),
        ('Bicycles', 'Brand', 'Cannondale', 4),
        ('Bicycles', 'Brand', 'Scott', 5),
        ('Bicycles', 'Brand', 'Merida', 6),
        ('Bicycles', 'Brand', 'Bianchi', 7),
        ('Bicycles', 'Brand', 'Other', 8),

        ('Bicycles', 'Condition', 'New', 1),
        ('Bicycles', 'Condition', 'Like New', 2),
        ('Bicycles', 'Condition', 'Good', 3),
        ('Bicycles', 'Condition', 'Fair', 4),

        -- =========================
        -- Camping & Travel
        -- =========================
        ('Camping & Travel', 'Condition', 'New', 1),
        ('Camping & Travel', 'Condition', 'Like New', 2),
        ('Camping & Travel', 'Condition', 'Good', 3),
        ('Camping & Travel', 'Condition', 'Fair', 4),

        -- =========================
        -- Musical Instruments
        -- =========================
        ('Musical Instruments', 'Brand', 'Yamaha', 1),
        ('Musical Instruments', 'Brand', 'Roland', 2),
        ('Musical Instruments', 'Brand', 'Casio', 3),
        ('Musical Instruments', 'Brand', 'Fender', 4),
        ('Musical Instruments', 'Brand', 'Gibson', 5),
        ('Musical Instruments', 'Brand', 'Ibanez', 6),
        ('Musical Instruments', 'Brand', 'Korg', 7),
        ('Musical Instruments', 'Brand', 'Pearl', 8),
        ('Musical Instruments', 'Brand', 'Other', 9),

        ('Musical Instruments', 'Condition', 'New', 1),
        ('Musical Instruments', 'Condition', 'Like New', 2),
        ('Musical Instruments', 'Condition', 'Good', 3),
        ('Musical Instruments', 'Condition', 'Fair', 4)
)
INSERT INTO category_attribute_options (category_attribute_id, value, display_order, created_at, updated_at)
SELECT ca.id, os.option_value, os.display_order, NOW(), NOW()
FROM option_seed os
         JOIN categories c
              ON c.name = os.category_name
         JOIN category_attributes ca
              ON ca.category_id = c.id
                  AND ca.name = os.attribute_name
    ON CONFLICT (category_attribute_id, value)
DO UPDATE SET
    display_order = EXCLUDED.display_order,
           updated_at = NOW();



