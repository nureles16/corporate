CREATE TABLE banner (
                        id BIGSERIAL PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        subtitle VARCHAR(255),
                        image_url VARCHAR(500),
                        button_text VARCHAR(255),
                        button_link VARCHAR(500),
                        is_active BOOLEAN NOT NULL,
                        created_at TIMESTAMP NOT NULL,
                        updated_at TIMESTAMP NOT NULL
);