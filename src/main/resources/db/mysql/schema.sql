--DROP DATABASE if EXISTS changhongmyblog;

CREATE DATABASE if not exists changhongmyblog
CHARACTER SET utf8
COLLATE utf8_general_ci;
USE changhongmyblog;

--DROP TABLE if EXISTS message;
CREATE TABLE if not exists message (
  id bigint(20) NOT NULL 
--  AUTO_INCREMENT
  ,
  name varchar(255) NOT NULL,
   message varchar(255) NOT NULL,
  time datetime NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci
ROW_FORMAT = DYNAMIC;

CREATE TABLE types (
  id int NOT NULL PRIMARY KEY ,
  name varchar(255) NOT NULL
);

--DROP TABLE if EXISTS blog;

CREATE TABLE if not exists blog (
  id bigint(20) NOT NULL 
--  AUTO_INCREMENT
  ,
  title varchar(255) NOT NULL,
  types varchar(255) NOT NULL,
   image varchar(50) NOT NULL,
  data text NOT NULL,
   datanohtml text NOT NULL,
  createtime datetime NOT NULL,
  updatetime datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  complete tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci
ROW_FORMAT = DYNAMIC;
USE changhongmyblog;

--DROP TABLE if EXISTS image;

CREATE TABLE if not exists image (
  id bigint(20) NOT NULL 
--  AUTO_INCREMENT
  ,
  url varchar(255) DEFAULT NULL,
  data blob DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci
ROW_FORMAT = DYNAMIC;
USE changhongmyblog;

--DROP TABLE if EXISTS user;

CREATE TABLE if not exists user (
  id bigint(20) NOT NULL 
--  AUTO_INCREMENT
  ,
  name varchar(50) binary CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  password varchar(255) NOT NULL,
  imageurl varchar(255) DEFAULT NULL,
  logintime datetime NOT NULL,
  email varchar(50) DEFAULT NULL,
  tel varchar(255) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX name (name)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = '4'
ROW_FORMAT = DYNAMIC;
