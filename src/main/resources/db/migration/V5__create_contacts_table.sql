CREATE TABLE contacts (
                          id BIGSERIAL PRIMARY KEY,
                          phone VARCHAR(50),
                          email VARCHAR(255),
                          address VARCHAR(500),
                          google_map_url VARCHAR(500),
                          updated_at TIMESTAMP NOT NULL
);