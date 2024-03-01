INSERT INTO users(first_name, last_name, birthdate, email, password, is_blocked, role) VALUES ('Иван','Иванов','1990-01-01','ivanov@gmail.com','Qwerty123',false,'ADMIN');
INSERT INTO users(first_name, last_name, birthdate, email, password, is_blocked, role) VALUES ('Петр','Петров','1992-05-09','petrov@gmail.com','111Ytrewq',false,'MANAGER');
INSERT INTO users(first_name, last_name, birthdate, email, password, is_blocked, role) VALUES ('Елена','Еленова','1993-06-17','olenova@gmail.com','111',false,'GUEST');
INSERT INTO users(first_name, last_name, birthdate, email, password, is_blocked, role) VALUES ('Ольга','Ольшанская','1956-08-13','olshanska@gmail.com','111',false,'GUEST');
INSERT INTO users(first_name, last_name, birthdate, email, password, is_blocked, role) VALUES ('Василий','Васильев','1975-09-23','vasiliev@gmail.com','111',false,'GUEST');

INSERT INTO rooms(type_by_count_person, type_by_size, floor, price, is_available) VALUES ('SINGLE','STANDART',1,80,true);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price, is_available) VALUES ('SINGLE','STANDART',1,80,true);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price, is_available) VALUES ('SINGLE','STANDART',1,80,true);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price, is_available) VALUES ('TWIN','STANDART',1,150,true);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price, is_available) VALUES ('TRPL','FAMILY_ROOM',1,190,true);

INSERT INTO rooms(type_by_count_person, type_by_size, floor, price, is_available) VALUES ('SINGLE','STANDART',1,80,true);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price, is_available) VALUES ('SINGLE','SUPERIOR',1,100,true);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price, is_available) VALUES ('DOUBLE','STUDIO',1,150,true);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price, is_available) VALUES ('DOUBLE','STANDART',1,140,true);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price, is_available) VALUES ('DOUBLE','FAMILY_ROOM',1,140,true);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price, is_available) VALUES ('TRPL','DELUX',1,190,true);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price, is_available) VALUES ('TRPL','SUPERIOR',1,230,true);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price, is_available) VALUES ('TWIN','STUDIO',1,210,true);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price, is_available) VALUES ('QDPL','STANDART',1,220,true);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price, is_available) VALUES ('QDPL','FAMILY_ROOM',1,240,true);
