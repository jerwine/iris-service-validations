use irises;

CREATE TABLE IF NOT EXISTS iris (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    species varchar(256) NOT NULL,
    sepal_length DECIMAL(20,2) NOT NULL,
    sepal_width DECIMAL(20,2) NOT NULL,
    petal_length DECIMAL(20,2) NOT NULL,
    petal_width DECIMAL(20,2) NOT NULL
)