CREATE  TABLE users (
  username VARCHAR(45) NOT NULL PRIMARY KEY ,
  password VARCHAR(60) NOT NULL ,
  enabled TINYINT NOT NULL ) ;

CREATE TABLE user_roles (
  user_role_id INTEGER  IDENTITY  NOT NULL PRIMARY KEY,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  FOREIGN KEY (username) REFERENCES users (username));