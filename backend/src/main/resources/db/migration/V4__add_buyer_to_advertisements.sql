ALTER TABLE advertisements
    ADD COLUMN buyer_id BIGINT;

ALTER TABLE advertisements
    ADD CONSTRAINT fk_advertisements_buyer
        FOREIGN KEY (buyer_id)
            REFERENCES users(id);