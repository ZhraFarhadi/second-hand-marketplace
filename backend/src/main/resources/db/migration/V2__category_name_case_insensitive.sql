CREATE UNIQUE INDEX IF NOT EXISTS uk_categories_name_lower
    ON categories (LOWER(name));
