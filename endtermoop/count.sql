CREATE TABLE IF NOT EXISTS NoButtonClicks (
    id INT PRIMARY KEY AUTO_INCREMENT,
    count INT NOT NULL
);
CREATE DATABASE IF NOT EXISTS base;

USE base;

CREATE TABLE IF NOT EXISTS preferences (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(255),
    city VARCHAR(255),
    venue VARCHAR(255),
    datetime DATETIME,
    dresscode VARCHAR(255)
);
