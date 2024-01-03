INSERT INTO users (username, password) VALUES ('admin', '$2a$12$PlW5sEvscoTuJ7uvK2d/d.CouaSiiXPGsoKnBQF42sf..3XPswDfe');
INSERT INTO admins (name, surname, personnel_number, username, email, enabled, role) VALUES ('Administrator', 'Admin', 1, 'admin', 'admin@test.nl', TRUE, 'ROLE_ADMIN');

INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('maternityNurse', 'ROLE_MATERNITYNURSE');
INSERT INTO authorities (username, authority) VALUES ('client', 'ROLE_CLIENT');
INSERT INTO authorities (username, authority) VALUES ('midwife', 'ROLE_MIDWIFE');