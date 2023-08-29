INSERT INTO countries (id, name) VALUES (1, 'Argentina');
INSERT INTO countries (id, name) VALUES (2, 'Brasil');
INSERT INTO countries (id, name) VALUES (3, 'Chile');
INSERT INTO countries (id, name) VALUES (57, 'España');

INSERT INTO cities (id, name, country_code) VALUES (1, 'Buenos Aires', 1);
INSERT INTO cities (id, name, country_code) VALUES (2, 'Rio de Janeiro', 2);
INSERT INTO cities (id, name, country_code) VALUES (3, 'Santiago de Chile', 3);
INSERT INTO cities (id, name, country_code) VALUES (4, 'Madrid', 57);

INSERT INTO users (id, name, email, password, created, is_active ) VALUES (1000, 'Carlos Janulik', 'jancaan@gmail.com', 'pass1234', NOW(), true);

INSERT INTO phones (id, number, city_code, user_id) VALUES (10001, '1234567', 1, 1000);
INSERT INTO phones (id, number, city_code, user_id) VALUES (10002, '7654321', 3, 1000);
INSERT INTO phones (id, number, city_code, user_id) VALUES (10003, '+3412112', 1, 57);


