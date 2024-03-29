CREATE TABLE category(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(50),
    created_at TIMESTAMP,
    last_modified_date TIMESTAMP
);

CREATE TABLE product_category(
    product_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    PRIMARY KEY (product_id, category_id),
    CONSTRAINT pc_product_id_pk FOREIGN KEY (product_id) REFERENCES product(id),
    CONSTRAINT pc_category_id_pk FOREIGN KEY (category_id) REFERENCES category(id)
);

INSERT INTO product (name, description, status, created_at, last_modified_date)
VALUES ('PROD1', 'PRODUCT1', 'NEW', now(), now());

INSERT INTO product (name, description, status, created_at, last_modified_date)
VALUES ('PROD2','PRODUCT2', 'NEW', now(), now());

INSERT INTO product (name, description, status, created_at, last_modified_date)
VALUES ('PROD2','PRODUCT3', 'NEW', now(), now());

INSERT INTO product (name, description, status, created_at, last_modified_date)
VALUES ('PROD3', 'PRODUCT4', 'NEW', now(), now());

INSERT INTO product (name, description, status, created_at, last_modified_date)
VALUES ('PROD4', 'PRODUCT5', 'NEW', now(), now());

INSERT INTO category (description, created_at, last_modified_date)
VALUES ('CAT1', now(), now());

INSERT INTO category (description, created_at, last_modified_date)
VALUES ('CAT2', now(), now());

INSERT INTO product_category(product_id, category_id)
    SELECT p.id, c.id FROM product p, category c
        WHERE p.description = 'PRODUCT' AND c.description = 'CAT1';

INSERT INTO product_category(product_id, category_id)
    SELECT p.id, c.id FROM product p, category c
        WHERE p.description = 'PRODUCT2' AND c.description = 'CAT1';

INSERT INTO product_category(product_id, category_id)
    SELECT p.id, c.id FROM product p, category c
        WHERE p.description = 'PRODUCT1' AND c.description = 'CAT3';

INSERT INTO product_category(product_id, category_id)
    SELECT p.id, c.id FROM product p, category c
        WHERE p.description = 'PRODUCT4' AND c.description = 'CAT3';
