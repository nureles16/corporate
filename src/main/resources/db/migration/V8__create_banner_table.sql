CREATE TABLE banner (
                        id BIGSERIAL PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        subtitle VARCHAR(500),
                        image_url VARCHAR(255),
                        button_text VARCHAR(255),
                        button_link VARCHAR(255),
                        is_active BOOLEAN NOT NULL DEFAULT FALSE,
                        created_at TIMESTAMP NOT NULL,
                        updated_at TIMESTAMP NOT NULL
);

-- Добавим начальный баннер
INSERT INTO banner (title, subtitle, image_url, button_text, button_link, is_active, created_at, updated_at)
VALUES ('Добро пожаловать!', 'Наш корпоративный сайт', '/images/banner.jpg', 'Узнать больше', '/about', TRUE, NOW(), NOW());