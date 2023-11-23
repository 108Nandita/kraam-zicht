INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('maternityNurse', 'ROLE_MATERNITYNURSE');
INSERT INTO authorities (username, authority) VALUES ('client', 'ROLE_CLIENT');
INSERT INTO authorities (username, authority) VALUES ('midwife', 'ROLE_MIDWIFE');

INSERT INTO admins (name, surname, personnel_number, username, password, email, enabled, role) VALUES ('Administrator', 'Admin', 1, 'admin', '$2a$12$PlW5sEvscoTuJ7uvK2d/d.CouaSiiXPGsoKnBQF42sf..3XPswDfe', 'admin@test.nl', TRUE, 'ROLE_ADMIN');