CREATE TABLE users
(id BIGSERIAL PRIMARY KEY,
 email VARCHAR(30),
 last_login TIME,
 pass VARCHAR(100));


 CREATE TABLE list_item
 (id BIGSERIAL PRIMARY KEY,
 users_id BIGINT REFERENCES users (id),
 name VARCHAR(30),
 description VARCHAR(30),
 tags VARCHAR(30));
