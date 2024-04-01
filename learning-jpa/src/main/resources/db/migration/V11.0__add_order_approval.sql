CREATE TABLE order_approval(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    approved_by VARCHAR(50),
    create_at TIMESTAMP,
    last_modified_date TIMESTAMP
);

ALTER TABLE order_header
    ADD COLUMN order_approval_id BIGINT;

ALTER TABLE order_header
    ADD CONSTRAINT order_approval_fk
        FOREIGN KEY (order_approval_id) REFERENCES order_approval(id);