INSERT INTO roles (id, name) VALUES
                                 (1, 'ROLE_ADMIN'),
                                 (2, 'ROLE_USER');

INSERT INTO users (id, username, password, enabled)
VALUES (1, 'admin', '$2a$10$7QJ8YwG8XH0P3rF9kYdRrOD5eH4N8Yc6uLrX2v1ZtqK9jA7WqzF3O', true);

INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1);

INSERT INTO news (id, title, description, content, image_url, created_at, updated_at, is_published)
VALUES
    (1, 'Company Launch', 'We launched our new website',
     'Full content about launch...',
     'https://example.com/image1.jpg',
     NOW(), NOW(), true);

INSERT INTO portfolio (id, title, description, image_url, project_url, created_at, is_published)
VALUES
    (1, 'E-commerce Platform',
     'Online store project',
     'https://example.com/portfolio1.jpg',
     'https://project.com',
     NOW(), true);

INSERT INTO services (id, title, description, icon_url, price, is_published)
VALUES
    (1, 'Web Development',
     'Full-stack web development service',
     'https://example.com/icon.png',
     1500.00,
     true);

INSERT INTO about (id, content, updated_at)
VALUES
    (1, 'We are a modern IT company...', NOW());

INSERT INTO contacts (id, phone, email, address, google_map_url, updated_at)
VALUES
    (1, '+996 700 123 456',
     'info@company.com',
     'Bishkek, Kyrgyzstan',
     'https://maps.google.com',
     NOW());

INSERT INTO banner (id, title, subtitle, image_url, button_text, button_link, is_active, created_at, updated_at)
VALUES
    (1,
     'Welcome to Our Company',
     'We build modern software',
     'https://example.com/banner.jpg',
     'Learn More',
     '/about',
     true,
     NOW(),
     NOW());

