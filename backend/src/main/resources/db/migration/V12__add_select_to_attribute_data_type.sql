-- =========================================================
-- V12__add_select_to_attribute_data_type.sql
-- =========================================================

BEGIN;

ALTER TABLE category_attributes
DROP CONSTRAINT IF EXISTS category_attributes_data_type_check;

ALTER TABLE category_attributes
    ADD CONSTRAINT category_attributes_data_type_check
        CHECK (
            data_type IN (
                          'TEXT',
                          'NUMBER',
                          'BOOLEAN',
                          'DATE',
                          'SELECT'
                )
            );

COMMIT;