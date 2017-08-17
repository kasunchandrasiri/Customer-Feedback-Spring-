INSERT INTO users(username,password,enabled)
VALUES ('admin','$2a$10$c2Z0m3V7.Uo8Ad4B5zZvu.nfGF4Fy7TvsVb40vmz6r3qvyZr19zgm', 1);


INSERT INTO user_roles (username, role)
VALUES ('admin', 'ROLE_ADMIN');