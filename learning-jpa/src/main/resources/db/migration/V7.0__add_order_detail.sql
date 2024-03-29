CREATE TABLE order_line(
    id BIGINT AUTO_INCREMENT,
    quantity_ordered INT,
    order_header_id BIGINT,
    created_at TIMESTAMP,
    last_modified_date TIMESTAMP,
    CONSTRAINT order_header_pk FOREIGN KEY (order_header_id) REFERENCES order_header(id),
    PRIMARY KEY(id)
)engine=InnoDB;