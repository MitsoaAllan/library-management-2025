CREATE TABLE book(
    book_id SERIAL PRIMARY KEY,
    title VARCHAR NOT NULL,
    topic VARCHAR NOT NULL,
    release_date DATE NOT NULL,
    page_numbers INT NOT NULL
);