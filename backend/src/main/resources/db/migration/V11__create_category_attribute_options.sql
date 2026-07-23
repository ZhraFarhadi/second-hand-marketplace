CREATE TABLE IF NOT EXISTS category_attribute_options
(
    id BIGSERIAL PRIMARY KEY,

    category_attribute_id BIGINT NOT NULL,

    value VARCHAR(100) NOT NULL,

    display_order INTEGER NOT NULL DEFAULT 0,

    created_at TIMESTAMP NOT NULL,

    updated_at TIMESTAMP NOT NULL,

    deleted_at TIMESTAMP NULL,

    CONSTRAINT fk_category_attribute_option_attribute
    FOREIGN KEY (category_attribute_id)
    REFERENCES category_attributes (id)
    ON DELETE CASCADE,

    CONSTRAINT uk_category_attribute_option
    UNIQUE (category_attribute_id, value)
    );

CREATE INDEX IF NOT EXISTS idx_category_attribute_option_attribute
    ON category_attribute_options (category_attribute_id);

CREATE INDEX IF NOT EXISTS idx_category_attribute_option_order
    ON category_attribute_options (category_attribute_id, display_order);
