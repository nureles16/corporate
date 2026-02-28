CREATE TABLE about (
                       id BIGSERIAL PRIMARY KEY,
                       content TEXT,
                       updated_at TIMESTAMP NOT NULL
);

-- Добавим начальную запись
INSERT INTO about (content, updated_at)
VALUES ('Добро пожаловать на наш корпоративный сайт!', NOW());