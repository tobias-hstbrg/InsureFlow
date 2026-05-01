INSERT INTO customer (insurance_id, surname, forename, email_address, birthdate, created_at)
VALUES
    ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Mustermann', 'Max', 'max@insureflow.de', '1985-03-15', NOW()),
    ('b1ffcd00-1d1c-4ef8-bb6d-6bb9bd380a22', 'Schmidt', 'Anna', 'anna@insureflow.de', '1990-07-22', NOW()),
    ('c2aacd11-2e2d-4ef8-bb6d-6bb9bd380a33', 'Müller', 'Peter', 'peter@insureflow.de', '1978-11-30', NOW());

INSERT INTO address (id, customer_id, streetname, house_number, postcode, city, country, created_at)
VALUES
    ('d3bbde22-3f3e-4ef8-bb6d-6bb9bd380a44', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'Hauptstraße', '12', '10115', 'Berlin', 'Germany', NOW()),
    ('e4ccef33-4a4f-4ef8-bb6d-6bb9bd380a55', 'b1ffcd00-1d1c-4ef8-bb6d-6bb9bd380a22', 'Bahnhofstraße', '5', '80331', 'München', 'Germany', NOW()),
    ('f5ddfa44-5b5a-4ef8-bb6d-6bb9bd380a66', 'c2aacd11-2e2d-4ef8-bb6d-6bb9bd380a33', 'Gartenweg', '8a', '20095', 'Hamburg', 'Germany', NOW());