CREATE TABLE customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    contact VARCHAR(255) NOT NULL,
    industry VARCHAR(255) NOT NULL
);

CREATE TABLE project (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    department_name VARCHAR(255) NOT NULL,
    manager_name VARCHAR(255) NOT NULL,
    leader_name VARCHAR(255) NOT NULL,
    rank VARCHAR(2) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    category VARCHAR(32) NOT NULL,
    CONSTRAINT fk_project_customer FOREIGN KEY (customer_id) REFERENCES customer(id)
);
