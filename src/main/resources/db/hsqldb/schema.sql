
CREATE TABLE message (
  id int NOT NULL PRIMARY KEY ,
  name varchar(255) NOT NULL,
   message varchar(255) NOT NULL,
  time datetime NOT NULL
);

CREATE TABLE blog (
  id int NOT NULL PRIMARY KEY,
  title varchar(50) NOT NULL,
  image varchar(50) NOT NULL,
  data VARCHAR(2014) NOT NULL,
  createtime datetime NOT NULL,
  updatetime datetime NOT NULL,
  complete tinyint NOT NULL 
 
);


CREATE TABLE image (
  id int NOT NULL PRIMARY KEY,
  url varchar(255),
  data blob
);


CREATE TABLE user (
  id int NOT NULL PRIMARY KEY,
  name varchar(50)  NOT NULL,
  password varchar(255) NOT NULL,
  imageurl varchar(255) DEFAULT NULL,
  logintime datetime NOT NULL,
  email varchar(50),
  tel varchar(255)
--  UNIQUE INDEX name (name)
);
