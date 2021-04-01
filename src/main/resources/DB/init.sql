CREATE TABLE users (
                       username varchar(15),
                       password varchar(100),
                       enabled smallint check (users.enabled < 2),
                       PRIMARY KEY (username)
) ;

CREATE TABLE authorities (
                             username varchar(15),
                             authority varchar(25),
                             FOREIGN KEY (username) references users(username)
) ;

INSERT INTO users (username, password, enabled)
VALUES
('artem', '{noop}artem', 1),
('andrey', '{noop}andrey', 1),
('vlad', '{noop}vlad', 1);

INSERT INTO authorities (username, authority)
VALUES
('artem', 'ROLE_USER'),
('andrey', 'ROLE_MANAGER'),
('vlad', 'ROLE_MANAGER'),
('vlad', 'ROLE_OWNER');

update users set password = '{bcrypt}$2y$12$SZ0UZmcdK..jTgRyapIsxe7hZ3e9JkFmrudOXW6zkd.27WXRa2LIa' where username = 'vlad';
update users set password = '{bcrypt}$2y$12$UAoBZuUjkhoDVFpjzfTcT.SzOfPHz1maSf0lwTmeELAYDTxtArRSq' where username = 'andrey';
update users set password = '{bcrypt}$2y$12$mBsIYmYhLC.czFYUf44R0ubI.jvB6QTHfswpYgtpFPsmrrlUJVN5e ' where username = 'artem';