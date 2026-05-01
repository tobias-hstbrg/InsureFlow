CREATE TABLE customer (
    insurance_id         UUID         PRIMARY KEY,
    forename VARCHAR(100) NOT NULL,
    surname  VARCHAR(100) NOT NULL,
    email_address      VARCHAR(255) NOT NULL UNIQUE,
    birthdate       TIMESTAMP NOT NULL,
    created_at TIMESTAMP    NOT NULL
);