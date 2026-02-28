CREATE TABLE contacts (
                          id BIGSERIAL PRIMARY KEY,
                          phone VARCHAR(50),
                          email VARCHAR(255),
                          address VARCHAR(500),
                          google_map_url VARCHAR(500),
                          updated_at TIMESTAMP NOT NULL
);

-- Добавим начальную запись
INSERT INTO contacts (phone, email, address, google_map_url, updated_at)
VALUES ('+996 123 456 789', 'info@corporate.com', 'г. Бишкек, ул. Примерная, 1', 'https://maps.google.com/?q=Бишкек', NOW());