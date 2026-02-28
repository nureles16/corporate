CREATE TABLE portfolio (
                           id BIGSERIAL PRIMARY KEY,
                           title VARCHAR(255) NOT NULL,
                           description VARCHAR(500),
                           image_url VARCHAR(255),
                           project_url VARCHAR(255),
                           created_at TIMESTAMP NOT NULL,
                           is_published BOOLEAN NOT NULL DEFAULT FALSE
);