CREATE TABLE author(
    author_id SERIAL PRIMARY KEY,
    author_name VARCHAR NOT NULL,
    sex VARCHAR NOT NULL,
    birth_date DATE NOT NULL
);