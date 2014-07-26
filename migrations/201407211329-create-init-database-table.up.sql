CREATE TABLE users
(id BIGSERIAL PRIMARY KEY,
 first_name VARCHAR(30),
 last_name VARCHAR(30),
 email VARCHAR(30),
 admin BOOLEAN,
 last_login TIME,
 pass VARCHAR(100));


 CREATE TABLE tools
 (id BIGSERIAL PRIMARY KEY,
 users_id BIGINT REFERENCES users (id),
 tool_name VARCHAR(30),
 description VARCHAR(30),
 tags VARCHAR(30));
