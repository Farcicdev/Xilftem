CREATE TABLE users (
    id serial PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password varchar(100) NOT NULL
);