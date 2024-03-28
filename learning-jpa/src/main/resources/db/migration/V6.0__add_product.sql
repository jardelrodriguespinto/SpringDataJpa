DROP TABLE IF EXISTS product;

CREATE TABLE product(
        id BIGINT AUTO_INCREMENT,
        name VARCHAR(255),
        description VARCHAR(255),
        status VARCHAR(50),
        primary key (id)
)engine=InnoDB;