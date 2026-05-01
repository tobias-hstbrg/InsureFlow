CREATE TABLE address (
    id              UUID            PRIMARY KEY,
    customer_id     UUID            NOT NULL REFERENCES customer(insurance_id),
    streetname      VARCHAR(100)    NOT NULL,
    house_number    VARCHAR(15)     NOT NULL,
    postcode        VARCHAR(50)     NOT NULL,
    city            VARCHAR(100)    NOT NULL,
    country             VARCHAR(120)    NOT NULL,
    created_at      TIMESTAMP       NOT NULL
);