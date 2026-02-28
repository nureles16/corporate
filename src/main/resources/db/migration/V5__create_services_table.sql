CREATE TABLE services (
                          id BIGSERIAL PRIMARY KEY,
                          title VARCHAR(255) NOT NULL,
                          description VARCHAR(500),
                          icon_url VARCHAR(255),
                          price NUMERIC(10,2),
                          is_published BOOLEAN NOT NULL DEFAULT FALSE,
                          created_at TIMESTAMP NOT NULL
);