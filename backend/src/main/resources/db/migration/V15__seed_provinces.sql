-- ==========================================================
-- PROVINCES
-- ==========================================================

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Alborz', 'ALB', 1, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'ALB'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Ardabil', 'ARD', 2, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'ARD'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Bushehr', 'BUS', 3, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'BUS'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Chaharmahal and Bakhtiari', 'CHB', 4, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'CHB'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'East Azerbaijan', 'EAZ', 5, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'EAZ'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Fars', 'FRS', 6, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'FRS'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Gilan', 'GIL', 7, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'GIL'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Golestan', 'GOL', 8, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'GOL'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Hamadan', 'HAM', 9, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'HAM'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Hormozgan', 'HOR', 10, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'HOR'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Ilam', 'ILA', 11, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'ILA'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Isfahan', 'ISF', 12, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'ISF'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Kerman', 'KER', 13, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'KER'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Kermanshah', 'KSH', 14, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'KSH'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Khuzestan', 'KHU', 15, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'KHU'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Kohgiluyeh and Boyer-Ahmad', 'KBA', 16, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'KBA'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Kurdistan', 'KUR', 17, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'KUR'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Lorestan', 'LOR', 18, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'LOR'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Markazi', 'MRK', 19, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'MRK'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Mazandaran', 'MAZ', 20, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'MAZ'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'North Khorasan', 'NKH', 21, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'NKH'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Qazvin', 'QAZ', 22, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'QAZ'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Qom', 'QOM', 23, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'QOM'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Razavi Khorasan', 'RKH', 24, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'RKH'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Semnan', 'SEM', 25, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'SEM'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Sistan and Baluchestan', 'SIB', 26, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'SIB'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'South Khorasan', 'SKH', 27, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'SKH'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Tehran', 'TEH', 28, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'TEH'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'West Azerbaijan', 'WAZ', 29, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'WAZ'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Yazd', 'YAZ', 30, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'YAZ'
);

INSERT INTO provinces (name, code, display_order, created_at, updated_at)
SELECT 'Zanjan', 'ZAN', 31, NOW(), NOW()
    WHERE NOT EXISTS (
    SELECT 1 FROM provinces WHERE code = 'ZAN'
);
