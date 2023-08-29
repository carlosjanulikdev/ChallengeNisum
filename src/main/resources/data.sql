INSERT INTO countries (id, name) VALUES (1, 'Argentina');
INSERT INTO countries (id, name) VALUES (2, 'Brasil');
INSERT INTO countries (id, name) VALUES (3, 'Chile');

INSERT INTO cities (id, name) VALUES (1, 'Buenos Aires');
INSERT INTO cities (id, name) VALUES (2, 'Rio de Janeiro');
INSERT INTO cities (id, name) VALUES (3, 'Santiago de Chile');

INSERT INTO users (id, name, email, password, created, is_active ) VALUES (1000, 'Carlos Janulik', 'jancaan@gmail.com', 'pass1234', NOW(), true);

INSERT INTO phones (id, number, city_code, country_code, user_id) VALUES (10001, '1234567', 1, 1, 1000);
INSERT INTO phones (id, number, city_code, country_code, user_id) VALUES (10002, '7654321', 3, 3, 1000);


