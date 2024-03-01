INSERT INTO users(first_name, last_name, birthdate, email, password, is_blocked, role) VALUES ('Иван','Иванов','1990-01-01','ivanov@gmail.com','Qwerty123',false,'ADMIN');
INSERT INTO users(first_name, last_name, birthdate, email, password, is_blocked, role) VALUES ('Петр','Петров','1992-05-09','petrov@gmail.com','111Ytrewq',false,'MANAGER');
INSERT INTO users(first_name, last_name, birthdate, email, password, is_blocked, role) VALUES ('Елена','Еленова','1993-06-17','olenova@gmail.com','111',false,'GUEST');
INSERT INTO users(first_name, last_name, birthdate, email, password, is_blocked, role) VALUES ('Ольга','Ольшанская','1956-08-13','olshanska@gmail.com','111',false,'GUEST');
INSERT INTO users(first_name, last_name, birthdate, email, password, is_blocked, role) VALUES ('Василий','Васильев','1975-09-23','vasiliev@gmail.com','111',false,'GUEST');

INSERT INTO rooms(type_by_count_person, type_by_size, floor, price) VALUES ('SINGLE','STANDART',1,80);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price) VALUES ('SINGLE','STANDART',1,80);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price) VALUES ('SINGLE','STANDART',1,80);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price) VALUES ('TWIN','STANDART',1,150);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price) VALUES ('TRPL','FAMILY_ROOM',1,190);

INSERT INTO rooms(type_by_count_person, type_by_size, floor, price) VALUES ('SINGLE','STANDART',1,80);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price) VALUES ('SINGLE','SUPERIOR',1,100);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price) VALUES ('DOUBLE','STUDIO',1,150);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price) VALUES ('DOUBLE','STANDART',1,140);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price) VALUES ('DOUBLE','FAMILY_ROOM',1,140);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price) VALUES ('TRPL','DELUX',1,190);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price) VALUES ('TRPL','SUPERIOR',1,230);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price) VALUES ('TWIN','STUDIO',1,210);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price) VALUES ('QDPL','STANDART',1,220);
INSERT INTO rooms(type_by_count_person, type_by_size, floor, price) VALUES ('QDPL','FAMILY_ROOM',1,240);

INSERT INTO bookings(start_date, end_date, status_booking, book_date, type_by_food, room_id, user_id) VALUES ('2024-03-02','2024-03-05','NEW','2024-02-29','RO', 1, 3);
