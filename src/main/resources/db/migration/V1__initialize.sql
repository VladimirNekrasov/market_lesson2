SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id                    INT(11) NOT NULL AUTO_INCREMENT,
  username              VARCHAR(50) NOT NULL,
  password              CHAR(80) NOT NULL,
  first_name            VARCHAR(50) NOT NULL,
  last_name             VARCHAR(50) NOT NULL,
  email                 VARCHAR(50) NOT NULL,
  phone                 VARCHAR(15) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;





DROP TABLE IF EXISTS categories;

CREATE TABLE categories (
  id	                INT(11) NOT NULL AUTO_INCREMENT,
  title                 VARCHAR(255) NOT NULL,
  description           VARCHAR(5000),
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;











