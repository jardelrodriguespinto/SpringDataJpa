DROP TABLE IF EXISTS order_header;
DROP TABLE IF EXISTS hibernate_sequence;

CREATE TABLE order_header(
    id BIGINT AUTO_INCREMENT,
    customer_name VARCHAR(500),
    PRIMARY KEY(id)
)engine=InnoDB;

CREATE TABLE hibernate_sequence (
    next_val BIGINT
) engine=InnoDB;

INSERT INTO hibernate_sequence values (1);

INSERT INTO order_header(id, customer_name) VALUES(1, 'João');