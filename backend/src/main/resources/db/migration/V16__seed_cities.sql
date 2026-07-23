-- ==========================================================
-- CITIES - PART 1
-- Provinces:
-- ALB Alborz
-- ARD Ardabil
-- AZE East Azerbaijan
-- BHR Bushehr
-- CHB Chaharmahal and Bakhtiari
-- ==========================================================

-- Alborz
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Karaj', p.id, 'ALB-KRJ', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ALB'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ALB-KRJ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Fardis', p.id, 'ALB-FRD', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ALB'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ALB-FRD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Nazarabad', p.id, 'ALB-NZR', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ALB'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ALB-NZR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Hashtgerd', p.id, 'ALB-HSG', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ALB'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ALB-HSG');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Mahdasht', p.id, 'ALB-MHD', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ALB'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ALB-MHD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Mohammadshahr', p.id, 'ALB-MMS', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ALB'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ALB-MMS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Savojbolagh', p.id, 'ALB-SVB', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ALB'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ALB-SVB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Taleqan', p.id, 'ALB-TLQ', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ALB'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ALB-TLQ');

-- Ardabil
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Ardabil', p.id, 'ARD-ARD', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ARD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ARD-ARD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Parsabad', p.id, 'ARD-PRS', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ARD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ARD-PRS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Meshginshahr', p.id, 'ARD-MSH', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ARD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ARD-MSH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Khalkhal', p.id, 'ARD-KHL', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ARD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ARD-KHL');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Germi', p.id, 'ARD-GRM', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ARD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ARD-GRM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Namin', p.id, 'ARD-NMN', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ARD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ARD-NMN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bileh Savar', p.id, 'ARD-BSV', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ARD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ARD-BSV');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Sareyn', p.id, 'ARD-SRN', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ARD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ARD-SRN');

-- East Azerbaijan
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Tabriz', p.id, 'AZE-TBZ', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'AZE'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'AZE-TBZ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Maragheh', p.id, 'AZE-MRG', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'AZE'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'AZE-MRG');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Marand', p.id, 'AZE-MRD', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'AZE'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'AZE-MRD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Mianeh', p.id, 'AZE-MIH', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'AZE'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'AZE-MIH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Ahar', p.id, 'AZE-AHR', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'AZE'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'AZE-AHR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bonab', p.id, 'AZE-BNB', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'AZE'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'AZE-BNB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Sarab', p.id, 'AZE-SRB', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'AZE'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'AZE-SRB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Azarshahr', p.id, 'AZE-AZS', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'AZE'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'AZE-AZS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Shabestar', p.id, 'AZE-SHB', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'AZE'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'AZE-SHB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Varzaqan', p.id, 'AZE-VRZ', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'AZE'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'AZE-VRZ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Jolfa', p.id, 'AZE-JLF', 11, NOW(), NOW()
FROM provinces p
WHERE p.code = 'AZE'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'AZE-JLF');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Osku', p.id, 'AZE-OSK', 12, NOW(), NOW()
FROM provinces p
WHERE p.code = 'AZE'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'AZE-OSK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Hashtrood', p.id, 'AZE-HSR', 13, NOW(), NOW()
FROM provinces p
WHERE p.code = 'AZE'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'AZE-HSR');

-- Bushehr
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bushehr', p.id, 'BHR-BHR', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'BHR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'BHR-BHR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Borazjan', p.id, 'BHR-BRZ', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'BHR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'BHR-BRZ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bandar Kangan', p.id, 'BHR-KNG', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'BHR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'BHR-KNG');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bandar Genaveh', p.id, 'BHR-GNV', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'BHR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'BHR-GNV');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Khormoj', p.id, 'BHR-KHR', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'BHR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'BHR-KHR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Ahram', p.id, 'BHR-AHM', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'BHR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'BHR-AHM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Jam', p.id, 'BHR-JAM', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'BHR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'BHR-JAM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Dayyer', p.id, 'BHR-DYR', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'BHR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'BHR-DYR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Deylam', p.id, 'BHR-DLM', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'BHR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'BHR-DLM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Asaluyeh', p.id, 'BHR-ASL', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'BHR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'BHR-ASL');

-- Chaharmahal and Bakhtiari
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Shahrekord', p.id, 'CHB-SHK', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'CHB'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'CHB-SHK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Borujen', p.id, 'CHB-BRJ', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'CHB'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'CHB-BRJ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Lordegan', p.id, 'CHB-LRD', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'CHB'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'CHB-LRD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Farrokhshahr', p.id, 'CHB-FRK', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'CHB'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'CHB-FRK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Farsan', p.id, 'CHB-FRS', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'CHB'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'CHB-FRS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Koohrang', p.id, 'CHB-KHR', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'CHB'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'CHB-KHR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Ben', p.id, 'CHB-BEN', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'CHB'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'CHB-BEN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Saman', p.id, 'CHB-SMN', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'CHB'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'CHB-SMN');




-- ==========================================================
-- CITIES - PART 2
-- Provinces:
-- FRS Fars
-- GIL Gilan
-- GLS Golestan
-- HMD Hamadan
-- HRM Hormozgan
-- ==========================================================

-- Fars
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Shiraz', p.id, 'FRS-SHZ', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'FRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'FRS-SHZ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Marvdasht', p.id, 'FRS-MVD', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'FRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'FRS-MVD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Jahrom', p.id, 'FRS-JHR', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'FRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'FRS-JHR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Fasa', p.id, 'FRS-FSA', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'FRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'FRS-FSA');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Kazeroon', p.id, 'FRS-KZR', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'FRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'FRS-KZR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Lar', p.id, 'FRS-LAR', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'FRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'FRS-LAR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Darab', p.id, 'FRS-DRB', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'FRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'FRS-DRB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Eghlid', p.id, 'FRS-EGL', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'FRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'FRS-EGL');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Firuzabad', p.id, 'FRS-FRB', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'FRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'FRS-FRB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Estahban', p.id, 'FRS-EST', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'FRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'FRS-EST');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Neyriz', p.id, 'FRS-NYR', 11, NOW(), NOW()
FROM provinces p
WHERE p.code = 'FRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'FRS-NYR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Abadeh', p.id, 'FRS-ABD', 12, NOW(), NOW()
FROM provinces p
WHERE p.code = 'FRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'FRS-ABD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Sepidan', p.id, 'FRS-SPD', 13, NOW(), NOW()
FROM provinces p
WHERE p.code = 'FRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'FRS-SPD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Kavar', p.id, 'FRS-KVR', 14, NOW(), NOW()
FROM provinces p
WHERE p.code = 'FRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'FRS-KVR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Lamerd', p.id, 'FRS-LMD', 15, NOW(), NOW()
FROM provinces p
WHERE p.code = 'FRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'FRS-LMD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Gerash', p.id, 'FRS-GRS', 16, NOW(), NOW()
FROM provinces p
WHERE p.code = 'FRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'FRS-GRS');

-- Gilan
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Rasht', p.id, 'GIL-RAS', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GIL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GIL-RAS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bandar Anzali', p.id, 'GIL-ANZ', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GIL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GIL-ANZ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Lahijan', p.id, 'GIL-LHJ', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GIL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GIL-LHJ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Langarud', p.id, 'GIL-LGR', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GIL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GIL-LGR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Astara', p.id, 'GIL-AST', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GIL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GIL-AST');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Rudsar', p.id, 'GIL-RDS', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GIL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GIL-RDS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Talesh', p.id, 'GIL-TLS', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GIL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GIL-TLS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Fuman', p.id, 'GIL-FUM', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GIL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GIL-FUM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Somesara', p.id, 'GIL-SOM', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GIL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GIL-SOM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Amlash', p.id, 'GIL-AML', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GIL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GIL-AML');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Shaft', p.id, 'GIL-SHF', 11, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GIL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GIL-SHF');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Astaneh-ye Ashrafiyeh', p.id, 'GIL-ASY', 12, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GIL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GIL-ASY');


INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Rezvanshahr', p.id, 'GIL-RZH', 13, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GIL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GIL-RZH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Masal', p.id, 'GIL-MSL', 14, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GIL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GIL-MSL');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Rudbar', p.id, 'GIL-RDB', 15, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GIL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GIL-RDB');

-- Golestan
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Gorgan', p.id, 'GLS-GOR', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GLS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GLS-GOR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Gonbad-e Kavus', p.id, 'GLS-GKB', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GLS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GLS-GKB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Aliabad Katoul', p.id, 'GLS-ALK', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GLS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GLS-ALK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bandar Torkaman', p.id, 'GLS-BTR', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GLS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GLS-BTR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Aq Qala', p.id, 'GLS-AQQ', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GLS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GLS-AQQ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Azadshahr', p.id, 'GLS-AZD', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GLS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GLS-AZD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Minudasht', p.id, 'GLS-MIN', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GLS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GLS-MIN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Kordkuy', p.id, 'GLS-KDK', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GLS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GLS-KDK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bandar Gaz', p.id, 'GLS-BGA', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GLS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GLS-BGA');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Kalaleh', p.id, 'GLS-KLL', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GLS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GLS-KLL');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Galikesh', p.id, 'GLS-GLK', 11, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GLS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GLS-GLK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Ramian', p.id, 'GLS-RMN', 12, NOW(), NOW()
FROM provinces p
WHERE p.code = 'GLS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'GLS-RMN');

-- Hamadan
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Hamadan', p.id, 'HMD-HMD', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HMD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HMD-HMD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Malayer', p.id, 'HMD-MLY', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HMD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HMD-MLY');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Nahavand', p.id, 'HMD-NHV', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HMD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HMD-NHV');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Tuyserkan', p.id, 'HMD-TUY', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HMD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HMD-TUY');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Asadabad', p.id, 'HMD-ASD', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HMD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HMD-ASD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bahar', p.id, 'HMD-BHR', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HMD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HMD-BHR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Razan', p.id, 'HMD-RZN', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HMD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HMD-RZN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Kabudarahang', p.id, 'HMD-KBD', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HMD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HMD-KBD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Famenin', p.id, 'HMD-FMN', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HMD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HMD-FMN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Lalejin', p.id, 'HMD-LLJ', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HMD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HMD-LLJ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Samen', p.id, 'HMD-SMN', 11, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HMD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HMD-SMN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Maryanaj', p.id, 'HMD-MRJ', 12, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HMD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HMD-MRJ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Jokar', p.id, 'HMD-JKR', 13, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HMD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HMD-JKR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Sarkan', p.id, 'HMD-SKN', 14, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HMD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HMD-SKN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Gian', p.id, 'HMD-GIN', 15, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HMD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HMD-GIN');

-- Hormozgan
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bandar Abbas', p.id, 'HRM-BAB', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HRM-BAB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Qeshm', p.id, 'HRM-QSH', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HRM-QSH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bandar Lengeh', p.id, 'HRM-BLN', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HRM-BLN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Minab', p.id, 'HRM-MIN', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HRM-MIN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bandar Khamir', p.id, 'HRM-BKH', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HRM-BKH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Jask', p.id, 'HRM-JSK', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HRM-JSK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Rudan', p.id, 'HRM-RUD', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HRM-RUD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Hajiabad', p.id, 'HRM-HJB', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HRM-HJB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Parsian', p.id, 'HRM-PRS', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HRM-PRS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Kish', p.id, 'HRM-KSH', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HRM-KSH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bastak', p.id, 'HRM-BST', 11, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HRM-BST');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bandar Charak', p.id, 'HRM-BCH', 12, NOW(), NOW()
FROM provinces p
WHERE p.code = 'HRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'HRM-BCH');


-- ==========================================================
-- CITIES - PART 3
-- Provinces:
-- ILM Ilam
-- ISF Isfahan
-- KER Kerman
-- KRD Kurdistan
-- KRM Kermanshah
-- ==========================================================

-- Ilam
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Ilam', p.id, 'ILM-ILM', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ILM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ILM-ILM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Dehloran', p.id, 'ILM-DHL', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ILM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ILM-DHL');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Abdanan', p.id, 'ILM-ABD', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ILM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ILM-ABD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Ivan', p.id, 'ILM-IVN', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ILM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ILM-IVN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Darreh Shahr', p.id, 'ILM-DRS', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ILM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ILM-DRS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Mehran', p.id, 'ILM-MHR', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ILM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ILM-MHR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Arakvaz', p.id, 'ILM-ARK', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ILM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ILM-ARK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Sarableh', p.id, 'ILM-SRB', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ILM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ILM-SRB');

-- Isfahan
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Isfahan', p.id, 'ISF-ISF', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ISF'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ISF-ISF');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Kashan', p.id, 'ISF-KSH', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ISF'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ISF-KSH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Najafabad', p.id, 'ISF-NJF', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ISF'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ISF-NJF');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Khomeinishahr', p.id, 'ISF-KHM', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ISF'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ISF-KHM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Shahin Shahr', p.id, 'ISF-SHS', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ISF'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ISF-SHS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Mobarakeh', p.id, 'ISF-MBR', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ISF'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ISF-MBR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Falavarjan', p.id, 'ISF-FLV', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ISF'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ISF-FLV');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Golpayegan', p.id, 'ISF-GLP', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ISF'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ISF-GLP');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Nain', p.id, 'ISF-NAN', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ISF'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ISF-NAN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Aran va Bidgol', p.id, 'ISF-AVB', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ISF'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ISF-AVB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Semirom', p.id, 'ISF-SMR', 11, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ISF'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ISF-SMR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Fooladshahr', p.id, 'ISF-FLD', 12, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ISF'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ISF-FLD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Dorcheh', p.id, 'ISF-DRC', 13, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ISF'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ISF-DRC');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Borkhar', p.id, 'ISF-BKR', 14, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ISF'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ISF-BKR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Khansar', p.id, 'ISF-KHN', 15, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ISF'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ISF-KHN');

-- Kerman
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Kerman', p.id, 'KER-KER', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KER'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KER-KER');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Sirjan', p.id, 'KER-SRJ', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KER'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KER-SRJ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Rafsanjan', p.id, 'KER-RFS', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KER'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KER-RFS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Jiroft', p.id, 'KER-JIR', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KER'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KER-JIR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bam', p.id, 'KER-BAM', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KER'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KER-BAM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Zarand', p.id, 'KER-ZRD', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KER'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KER-ZRD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Baft', p.id, 'KER-BFT', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KER'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KER-BFT');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Shahr-e Babak', p.id, 'KER-SBK', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KER'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KER-SBK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Kahnuj', p.id, 'KER-KHJ', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KER'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KER-KHJ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Ravar', p.id, 'KER-RVR', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KER'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KER-RVR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Anbarabad', p.id, 'KER-ANB', 11, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KER'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KER-ANB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Kouhbanan', p.id, 'KER-KBN', 12, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KER'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KER-KBN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Manujan', p.id, 'KER-MNJ', 13, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KER'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KER-MNJ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Rudbar-e Jonub', p.id, 'KER-RBJ', 14, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KER'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KER-RBJ');



-- Kurdistan
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Sanandaj', p.id, 'KRD-SNJ', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRD-SNJ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Saqqez', p.id, 'KRD-SQZ', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRD-SQZ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Marivan', p.id, 'KRD-MRV', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRD-MRV');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Baneh', p.id, 'KRD-BNH', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRD-BNH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Qorveh', p.id, 'KRD-QRV', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRD-QRV');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bijar', p.id, 'KRD-BJR', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRD-BJR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Kamyaran', p.id, 'KRD-KMY', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRD-KMY');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Divandarreh', p.id, 'KRD-DVD', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRD-DVD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Dehgolan', p.id, 'KRD-DHG', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRD-DHG');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Sarvabad', p.id, 'KRD-SRV', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRD-SRV');

-- Kermanshah
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Kermanshah', p.id, 'KRM-KRM', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRM-KRM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Eslamabad-e Gharb', p.id, 'KRM-ESL', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRM-ESL');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Javanrud', p.id, 'KRM-JVR', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRM-JVR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Paveh', p.id, 'KRM-PVH', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRM-PVH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Kangavar', p.id, 'KRM-KNG', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRM-KNG');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Sahneh', p.id, 'KRM-SHN', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRM-SHN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Harsin', p.id, 'KRM-HRS', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRM-HRS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Sonqor', p.id, 'KRM-SNQ', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRM-SNQ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Sarpol-e Zahab', p.id, 'KRM-SPZ', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRM-SPZ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Qasr-e Shirin', p.id, 'KRM-QSH', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRM-QSH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Gilan-e Gharb', p.id, 'KRM-GLG', 11, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRM-GLG');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Dalahoo', p.id, 'KRM-DLH', 12, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KRM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KRM-DLH');


-- ==========================================================
-- CITIES - PART 4
-- Provinces:
-- KZT Khuzestan
-- KOH Kohgiluyeh and Boyer-Ahmad
-- LRS Lorestan
-- MKZ Markazi
-- MZN Mazandaran
-- ==========================================================

-- Khuzestan
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Ahvaz', p.id, 'KZT-AHV', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KZT'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KZT-AHV');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Abadan', p.id, 'KZT-ABD', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KZT'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KZT-ABD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Khorramshahr', p.id, 'KZT-KHS', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KZT'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KZT-KHS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Dezful', p.id, 'KZT-DEZ', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KZT'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KZT-DEZ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Andimeshk', p.id, 'KZT-AND', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KZT'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KZT-AND');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Masjed Soleyman', p.id, 'KZT-MSJ', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KZT'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KZT-MSJ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Behbahan', p.id, 'KZT-BHB', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KZT'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KZT-BHB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Mahshahr', p.id, 'KZT-MHS', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KZT'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KZT-MHS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Shushtar', p.id, 'KZT-SHT', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KZT'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KZT-SHT');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Izeh', p.id, 'KZT-IZE', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KZT'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KZT-IZE');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Shush', p.id, 'KZT-SHS', 11, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KZT'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KZT-SHS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Ramhormoz', p.id, 'KZT-RMH', 12, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KZT'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KZT-RMH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Susangerd', p.id, 'KZT-SUS', 13, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KZT'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KZT-SUS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Omidiyeh', p.id, 'KZT-OMD', 14, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KZT'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KZT-OMD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bagh-e Malek', p.id, 'KZT-BGM', 15, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KZT'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KZT-BGM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bandar Imam Khomeini', p.id, 'KZT-BIK', 16, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KZT'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KZT-BIK');

-- Kohgiluyeh and Boyer-Ahmad
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Yasuj', p.id, 'KOH-YSJ', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KOH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KOH-YSJ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Dogonbadan', p.id, 'KOH-DGN', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KOH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KOH-DGN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Dehdasht', p.id, 'KOH-DHD', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KOH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KOH-DHD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Sisakht', p.id, 'KOH-SSK', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KOH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KOH-SSK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Likak', p.id, 'KOH-LIK', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KOH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KOH-LIK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Charam', p.id, 'KOH-CHR', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KOH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KOH-CHR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Basht', p.id, 'KOH-BSH', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KOH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KOH-BSH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Margoon', p.id, 'KOH-MRG', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'KOH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'KOH-MRG');

-- Lorestan
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Khorramabad', p.id, 'LRS-KHB', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'LRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'LRS-KHB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Borujerd', p.id, 'LRS-BRJ', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'LRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'LRS-BRJ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Dorud', p.id, 'LRS-DRD', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'LRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'LRS-DRD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Kuhdasht', p.id, 'LRS-KHD', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'LRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'LRS-KHD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Aligudarz', p.id, 'LRS-ALG', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'LRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'LRS-ALG');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Azna', p.id, 'LRS-AZN', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'LRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'LRS-AZN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Nurabad', p.id, 'LRS-NRB', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'LRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'LRS-NRB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Pol-e Dokhtar', p.id, 'LRS-PLD', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'LRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'LRS-PLD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Aleshtar', p.id, 'LRS-ALS', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'LRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'LRS-ALS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Rumeshkan', p.id, 'LRS-RMS', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'LRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'LRS-RMS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Sarab-e Dowreh', p.id, 'LRS-SBD', 11, NOW(), NOW()
FROM provinces p
WHERE p.code = 'LRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'LRS-SBD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Shoolabad', p.id, 'LRS-SHB', 12, NOW(), NOW()
FROM provinces p
WHERE p.code = 'LRS'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'LRS-SHB');

-- Markazi
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Arak', p.id, 'MKZ-ARK', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MKZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MKZ-ARK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Saveh', p.id, 'MKZ-SAV', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MKZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MKZ-SAV');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Khomein', p.id, 'MKZ-KHM', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MKZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MKZ-KHM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Mahallat', p.id, 'MKZ-MHL', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MKZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MKZ-MHL');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Delijan', p.id, 'MKZ-DLJ', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MKZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MKZ-DLJ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Tafresh', p.id, 'MKZ-TFR', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MKZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MKZ-TFR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Ashtian', p.id, 'MKZ-ASN', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MKZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MKZ-ASN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Zarandieh', p.id, 'MKZ-ZRN', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MKZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MKZ-ZRN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Komijan', p.id, 'MKZ-KMJ', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MKZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MKZ-KMJ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Shazand', p.id, 'MKZ-SHZ', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MKZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MKZ-SHZ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Farahan', p.id, 'MKZ-FRH', 11, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MKZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MKZ-FRH');

-- Mazandaran
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Sari', p.id, 'MZN-SAR', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-SAR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Babol', p.id, 'MZN-BBL', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-BBL');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Amol', p.id, 'MZN-AML', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-AML');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Qaemshahr', p.id, 'MZN-QMS', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-QMS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Nowshahr', p.id, 'MZN-NWS', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-NWS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Chalus', p.id, 'MZN-CHL', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-CHL');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Tonekabon', p.id, 'MZN-TNK', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-TNK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Ramsar', p.id, 'MZN-RMS', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-RMS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Babolsar', p.id, 'MZN-BSR', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-BSR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Neka', p.id, 'MZN-NEK', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-NEK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Behshahr', p.id, 'MZN-BHS', 11, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-BHS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Mahmudabad', p.id, 'MZN-MHB', 12, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-MHB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Fereydunkenar', p.id, 'MZN-FRK', 13, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-FRK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Juybar', p.id, 'MZN-JBR', 14, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-JBR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Nur', p.id, 'MZN-NUR', 15, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-NUR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Kelardasht', p.id, 'MZN-KLD', 16, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-KLD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Abbasabad', p.id, 'MZN-ABS', 17, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-ABS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Pol Sefid', p.id, 'MZN-PSF', 18, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-PSF');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Galoogah', p.id, 'MZN-GLG', 19, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-GLG');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Kiakola', p.id, 'MZN-KIA', 20, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-KIA');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Royan', p.id, 'MZN-RYN', 21, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-RYN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Salmanshahr', p.id, 'MZN-SLH', 22, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-SLH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Marzanabad', p.id, 'MZN-MRZ', 23, NOW(), NOW()
FROM provinces p
WHERE p.code = 'MZN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'MZN-MRZ');


-- ==========================================================
-- CITIES - PART 5
-- Provinces:
-- NKH North Khorasan
-- QAZ Qazvin
-- QOM Qom
-- RKH Razavi Khorasan
-- SMN Semnan
-- ==========================================================

-- North Khorasan
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bojnord', p.id, 'NKH-BJD', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'NKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'NKH-BJD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Shirvan', p.id, 'NKH-SHV', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'NKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'NKH-SHV');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Esfarayen', p.id, 'NKH-ESF', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'NKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'NKH-ESF');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Jajrom', p.id, 'NKH-JAJ', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'NKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'NKH-JAJ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'فاروج', p.id, 'NKH-FAR', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'NKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'NKH-FAR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Ashkhaneh', p.id, 'NKH-ASH', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'NKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'NKH-ASH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'راز', p.id, 'NKH-RAZ', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'NKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'NKH-RAZ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'گرمه', p.id, 'NKH-GRM', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'NKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'NKH-GRM');

-- Qazvin
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Qazvin', p.id, 'QAZ-QAZ', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'QAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'QAZ-QAZ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Takestan', p.id, 'QAZ-TAK', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'QAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'QAZ-TAK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Abyek', p.id, 'QAZ-ABY', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'QAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'QAZ-ABY');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Alvand', p.id, 'QAZ-ALV', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'QAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'QAZ-ALV');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Buin Zahra', p.id, 'QAZ-BZH', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'QAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'QAZ-BZH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Mohammadiyeh', p.id, 'QAZ-MHD', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'QAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'QAZ-MHD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Eqbaliyeh', p.id, 'QAZ-EQB', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'QAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'QAZ-EQB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Avaj', p.id, 'QAZ-AVJ', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'QAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'QAZ-AVJ');

-- Qom
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Qom', p.id, 'QOM-QOM', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'QOM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'QOM-QOM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Jafariyeh', p.id, 'QOM-JAF', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'QOM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'QOM-JAF');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Kahak', p.id, 'QOM-KHK', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'QOM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'QOM-KHK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Salafchegan', p.id, 'QOM-SLF', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'QOM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'QOM-SLF');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Qanavat', p.id, 'QOM-QNV', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'QOM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'QOM-QNV');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Dastjerd', p.id, 'QOM-DSJ', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'QOM'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'QOM-DSJ');

-- Razavi Khorasan
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Mashhad', p.id, 'RKH-MHD', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'RKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'RKH-MHD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Neyshabur', p.id, 'RKH-NEY', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'RKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'RKH-NEY');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Sabzevar', p.id, 'RKH-SBZ', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'RKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'RKH-SBZ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Torbat-e Heydarieh', p.id, 'RKH-THY', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'RKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'RKH-THY');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Kashmar', p.id, 'RKH-KSH', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'RKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'RKH-KSH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Torbat-e Jam', p.id, 'RKH-TJM', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'RKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'RKH-TJM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Chenaran', p.id, 'RKH-CHN', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'RKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'RKH-CHN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Sarakhs', p.id, 'RKH-SRK', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'RKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'RKH-SRK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Quchan', p.id, 'RKH-QCH', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'RKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'RKH-QCH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Gonabad', p.id, 'RKH-GNB', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'RKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'RKH-GNB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Khaf', p.id, 'RKH-KHF', 11, NOW(), NOW()
FROM provinces p
WHERE p.code = 'RKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'RKH-KHF');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Dargaz', p.id, 'RKH-DRG', 12, NOW(), NOW()
FROM provinces p
WHERE p.code = 'RKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'RKH-DRG');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Taybad', p.id, 'RKH-TBD', 13, NOW(), NOW()
FROM provinces p
WHERE p.code = 'RKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'RKH-TBD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Fariman', p.id, 'RKH-FRM', 14, NOW(), NOW()
FROM provinces p
WHERE p.code = 'RKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'RKH-FRM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bardaskan', p.id, 'RKH-BDK', 15, NOW(), NOW()
FROM provinces p
WHERE p.code = 'RKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'RKH-BDK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Kalat', p.id, 'RKH-KLT', 16, NOW(), NOW()
FROM provinces p
WHERE p.code = 'RKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'RKH-KLT');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Roshtkhar', p.id, 'RKH-RSK', 17, NOW(), NOW()
FROM provinces p
WHERE p.code = 'RKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'RKH-RSK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Joghatai', p.id, 'RKH-JGT', 18, NOW(), NOW()
FROM provinces p
WHERE p.code = 'RKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'RKH-JGT');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Khalilabad', p.id, 'RKH-KLB', 19, NOW(), NOW()
FROM provinces p
WHERE p.code = 'RKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'RKH-KLB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'طرقبه', p.id, 'RKH-TRQ', 20, NOW(), NOW()
FROM provinces p
WHERE p.code = 'RKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'RKH-TRQ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Shandiz', p.id, 'RKH-SHD', 21, NOW(), NOW()
FROM provinces p
WHERE p.code = 'RKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'RKH-SHD');

-- Semnan
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Semnan', p.id, 'SMN-SMN', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SMN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SMN-SMN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Shahroud', p.id, 'SMN-SHR', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SMN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SMN-SHR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Damghan', p.id, 'SMN-DMG', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SMN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SMN-DMG');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Garmsar', p.id, 'SMN-GRM', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SMN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SMN-GRM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Mahdishahr', p.id, 'SMN-MHD', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SMN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SMN-MHD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Meyami', p.id, 'SMN-MYM', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SMN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SMN-MYM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Aradan', p.id, 'SMN-ARD', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SMN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SMN-ARD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Sorkheh', p.id, 'SMN-SRK', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SMN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SMN-SRK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Ivanaki', p.id, 'SMN-IVN', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SMN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SMN-IVN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bastam', p.id, 'SMN-BSM', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SMN'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SMN-BSM');


-- ==========================================================
-- CITIES - PART 6
-- Provinces:
-- SBL Sistan and Baluchestan
-- SKH South Khorasan
-- THR Tehran
-- WAZ West Azerbaijan
-- YZD Yazd
-- ZNJ Zanjan
-- ==========================================================

-- Sistan and Baluchestan
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Zahedan', p.id, 'SBL-ZAH', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SBL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SBL-ZAH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Zabol', p.id, 'SBL-ZBL', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SBL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SBL-ZBL');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Chabahar', p.id, 'SBL-CHB', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SBL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SBL-CHB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Iranshahr', p.id, 'SBL-IRS', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SBL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SBL-IRS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Khash', p.id, 'SBL-KHS', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SBL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SBL-KHS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Saravan', p.id, 'SBL-SRV', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SBL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SBL-SRV');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Nikshahr', p.id, 'SBL-NIK', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SBL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SBL-NIK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Konarak', p.id, 'SBL-KNR', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SBL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SBL-KNR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Sarbaz', p.id, 'SBL-SBZ', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SBL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SBL-SBZ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Mirjaveh', p.id, 'SBL-MRJ', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SBL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SBL-MRJ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Rask', p.id, 'SBL-RSK', 11, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SBL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SBL-RSK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bampur', p.id, 'SBL-BMP', 12, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SBL'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SBL-BMP');

-- South Khorasan
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Birjand', p.id, 'SKH-BIR', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SKH-BIR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Qaen', p.id, 'SKH-QAE', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SKH-QAE');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Ferdows', p.id, 'SKH-FRD', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SKH-FRD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Tabas', p.id, 'SKH-TBS', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SKH-TBS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Nehbandan', p.id, 'SKH-NHB', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SKH-NHB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Sarbisheh', p.id, 'SKH-SBH', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SKH-SBH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Boshruyeh', p.id, 'SKH-BSH', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SKH-BSH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Khusf', p.id, 'SKH-KHF', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SKH-KHF');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Sarayan', p.id, 'SKH-SRY', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SKH-SRY');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Eslamieh', p.id, 'SKH-ESL', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'SKH'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'SKH-ESL');

-- Tehran
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Tehran', p.id, 'THR-THR', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'THR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'THR-THR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Shahriar', p.id, 'THR-SHR', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'THR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'THR-SHR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Islamshahr', p.id, 'THR-ISL', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'THR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'THR-ISL');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Rey', p.id, 'THR-REY', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'THR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'THR-REY');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Shemiranat', p.id, 'THR-SHM', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'THR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'THR-SHM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Varamin', p.id, 'THR-VRM', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'THR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'THR-VRM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Pakdasht', p.id, 'THR-PAK', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'THR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'THR-PAK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Qods', p.id, 'THR-QDS', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'THR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'THR-QDS');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Robat Karim', p.id, 'THR-RBK', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'THR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'THR-RBK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Firuzkuh', p.id, 'THR-FRZ', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'THR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'THR-FRZ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Damavand', p.id, 'THR-DMV', 11, NOW(), NOW()
FROM provinces p
WHERE p.code = 'THR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'THR-DMV');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Pishva', p.id, 'THR-PSH', 12, NOW(), NOW()
FROM provinces p
WHERE p.code = 'THR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'THR-PSH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Eslamshahr', p.id, 'THR-ESH', 13, NOW(), NOW()
FROM provinces p
WHERE p.code = 'THR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'THR-ESH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Andisheh', p.id, 'THR-AND', 14, NOW(), NOW()
FROM provinces p
WHERE p.code = 'THR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'THR-AND');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Parand', p.id, 'THR-PRD', 15, NOW(), NOW()
FROM provinces p
WHERE p.code = 'THR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'THR-PRD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Baqershahr', p.id, 'THR-BQR', 16, NOW(), NOW()
FROM provinces p
WHERE p.code = 'THR'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'THR-BQR');

-- West Azerbaijan
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Urmia', p.id, 'WAZ-URM', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'WAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'WAZ-URM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Khoy', p.id, 'WAZ-KHY', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'WAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'WAZ-KHY');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Mahabad', p.id, 'WAZ-MHB', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'WAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'WAZ-MHB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Miandoab', p.id, 'WAZ-MND', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'WAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'WAZ-MND');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bukan', p.id, 'WAZ-BKN', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'WAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'WAZ-BKN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Salmas', p.id, 'WAZ-SLM', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'WAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'WAZ-SLM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Naqadeh', p.id, 'WAZ-NQD', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'WAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'WAZ-NQD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Piranshahr', p.id, 'WAZ-PIR', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'WAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'WAZ-PIR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Maku', p.id, 'WAZ-MAK', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'WAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'WAZ-MAK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Sardasht', p.id, 'WAZ-SRD', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'WAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'WAZ-SRD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Oshnavieh', p.id, 'WAZ-OSH', 11, NOW(), NOW()
FROM provinces p
WHERE p.code = 'WAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'WAZ-OSH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Takab', p.id, 'WAZ-TKB', 12, NOW(), NOW()
FROM provinces p
WHERE p.code = 'WAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'WAZ-TKB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Chaldoran', p.id, 'WAZ-CHD', 13, NOW(), NOW()
FROM provinces p
WHERE p.code = 'WAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'WAZ-CHD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Showt', p.id, 'WAZ-SHW', 14, NOW(), NOW()
FROM provinces p
WHERE p.code = 'WAZ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'WAZ-SHW');

-- Yazd
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Yazd', p.id, 'YZD-YZD', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'YZD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'YZD-YZD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Meybod', p.id, 'YZD-MYB', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'YZD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'YZD-MYB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Ardakan', p.id, 'YZD-ARD', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'YZD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'YZD-ARD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Taft', p.id, 'YZD-TFT', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'YZD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'YZD-TFT');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Bafq', p.id, 'YZD-BFQ', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'YZD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'YZD-BFQ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Mehriz', p.id, 'YZD-MHR', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'YZD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'YZD-MHR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Abarkuh', p.id, 'YZD-ABK', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'YZD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'YZD-ABK');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Ashkezar', p.id, 'YZD-ASH', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'YZD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'YZD-ASH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Herat', p.id, 'YZD-HRT', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'YZD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'YZD-HRT');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Baharstan', p.id, 'YZD-BHS', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'YZD'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'YZD-BHS');

-- Zanjan
INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Zanjan', p.id, 'ZNJ-ZNJ', 1, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ZNJ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ZNJ-ZNJ');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Abhar', p.id, 'ZNJ-ABH', 2, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ZNJ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ZNJ-ABH');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Khodabandeh', p.id, 'ZNJ-KHB', 3, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ZNJ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ZNJ-KHB');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Khorramdareh', p.id, 'ZNJ-KHD', 4, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ZNJ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ZNJ-KHD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Tarom', p.id, 'ZNJ-TRM', 5, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ZNJ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ZNJ-TRM');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Mahneshan', p.id, 'ZNJ-MHN', 6, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ZNJ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ZNJ-MHN');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Ijrud', p.id, 'ZNJ-IJR', 7, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ZNJ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ZNJ-IJR');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Soltaniyeh', p.id, 'ZNJ-SLT', 8, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ZNJ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ZNJ-SLT');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Qeydar', p.id, 'ZNJ-QYD', 9, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ZNJ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ZNJ-QYD');

INSERT INTO cities (name, province_id, code, display_order, created_at, updated_at)
SELECT 'Hidaj', p.id, 'ZNJ-HDJ', 10, NOW(), NOW()
FROM provinces p
WHERE p.code = 'ZNJ'
  AND NOT EXISTS (SELECT 1 FROM cities c WHERE c.code = 'ZNJ-HDJ');


