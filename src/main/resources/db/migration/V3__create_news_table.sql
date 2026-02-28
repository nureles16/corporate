CREATE TABLE news (
                      id BIGSERIAL PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      description VARCHAR(500),
                      content TEXT,
                      image_url VARCHAR(255),
                      created_at TIMESTAMP NOT NULL,
                      updated_at TIMESTAMP,
                      is_published BOOLEAN NOT NULL DEFAULT FALSE
);