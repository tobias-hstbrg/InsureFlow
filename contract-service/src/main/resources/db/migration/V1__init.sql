CREATE TABLE contract (
    contract_id         UUID            PRIMARY KEY NOT NULL,
    customer_id         UUID            NOT NULL,

    insurance_product   VARCHAR(100)    NOT NULL,
    status              VARCHAR(50)     NOT NULL,
    start_date          DATE            NOT NULL,
    end_date            DATE            NOT NULL,
    monthly_premium     NUMERIC (10, 2) NOT NULL,
    created_at          TIMESTAMP       NOT NULL
)

INSERT INTO contract (
                    contract_id,
                    customer_id,
                    insurance_product,
                    status,
                    start_date,
                    end_date,
                    monthly_premium,
                    created_at
)
VALUES(
    'b165dc75-e41f-4345-8f77-a42d1de3ed25',
    'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11',
    'HEALTH',
    'EXPIRED',
    '2015-08-23',
    '2025-08-23',
    '226.54',
    NOW()
)
(
    '8784cd26-4a9e-4024-af27-f7a992771d57',
    'b1ffcd00-1d1c-4ef8-bb6d-6bb9bd380a22',
    'LIFE',
    'ACTIVE',
    '2001-01-19',
    '2031-01-01',
    '48.62',
    NOW()
)
(
    '624d6e55-f4a1-4849-8667-795705a0a9fa',
    'c2aacd11-2e2d-4ef8-bb6d-6bb9bd380a33',
    'CAR',
    'PENDING',
    '2026-05-03',
    '2027-05-03',
    '66.72',
    NOW()
)

