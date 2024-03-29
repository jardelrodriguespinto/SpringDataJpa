CREATE TABLE customer(
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
     name VARCHAR(255),
     address_address VARCHAR(30),
     address_city VARCHAR(30),
     address_state VARCHAR(30),
     address_zip_code VARCHAR(30),
     phone VARCHAR(50),
     email VARCHAR(255),
     order_header_id BIGINT,
     created_at TIMESTAMP,
     last_modified_date TIMESTAMP,
     CONSTRAINT pc_product_order_header_id_pk FOREIGN KEY(order_header_id) REFERENCES order_header(id)
);

ALTER TABLE order_header ADD COLUMN customer_id BIGINT;

ALTER TABLE order_header ADD CONSTRAINT order_header_customer_fk FOREIGN KEY(customer_id) REFERENCES customer(id);
