CREATE SCHEMA fightclub_db ;

CREATE TABLE fightclub_db.user (
id integer NOT NULL AUTO_INCREMENT,
birthDate date NOT NULL,
emailAddress varchar(255) NOT NULL,
firstName varchar(255) NOT NULL,
lastName varchar(255) NOT NULL,
password varchar(255) NOT NULL,
userName varchar(20) NOT NULL,
gender varchar(10) NOT NULL,
phoneNumber mediumtext NOT NULL,
country varchar(30) NOT NULL,
city varchar(30) NOT NULL,
address varchar(30) NOT NULL,
zipcode integer NOT NULL,
image mediumblob NOT NULL,
PRIMARY KEY (id)
);

ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1

INSERT INTO fightclub_db.user
(id,birthDate,emailAddress,firstName,lastName,password,userName,gender,phoneNumber,country,city,address,zipcode,image)
VALUES(1,'1958-11-27','456@qwd.com','toth','bela','$2a$12$anYtbjb4BNmUrDo.QPIGzOQKPaX2xt8m8J/ueUlrp1NybiAJq/9Nm','456','MALE','+36125486592','magyarorszag','budapest','kossuth utca 5',1234,'aqwd'),
(2,'1982-01-17','reka@qwd.com','kiss','reka','$2a$12$MB0iSZWzk0BE.9y4AxmUuOhbSqOl0wwXq68iDewP/oBYY3JlXaV1i','reka','FEMALE','+36524859635','magyarorszag','budapest','andrassy ut 7',1584,'aqwd'),
(3,'1992-08-19','petike@qwd.com','szabo','peter','$2a$12$qdk3KWYhac9e2MBmZU2B8.VbxBt1ugy93HOdmjEVpLzQ/GHMHeZhK','petike','MALE','+36125489374','magyarorszag','gyula','petofi ut 1',2548,'aqwd'),
(4,'1975-11-02','zsolti@qwd.com','veres','zsolt','$2a$12$LcG5Yzpu0/e5GJSWMLD4s.rvZ8Uxs4tRmaZbTewtY8L/p7mxyE8oW','zsolti','MALE','+36254856953','magyarorszag','nyiregyhaza','rakoczi ut 1',7584,'aqwd'),
(5,'1998-10-04','liza@qwd.com','szabo','ilona','$2a$12$EKKOEItco2AgUCF1U966xOfksIMJP29eV1qowToxr6O6GMwyJLQp.','liza','FEMALE','+36125485695','magyarorszag','miskolc','corvin utca 157',3535,'aqwd'),
(6,'1978-03-04','miki@qwd.com','fekete','miklos','$2a$12$mJ.e8w817S6v362KRkUnn.VhlV9wrS4rNMo9goRRFsUmsLybT..li','miki','MALE','+36985485325','magyarorszag','miskolc','corvin utca 15',3535,'aqwd'),
(7,'1986-12-12','luke@qwd.com','kovacs','lajos','$2a$12$E4YDkRxlMAd2CMY8SAziuubHmhHeadJfIkFWLN2D7h3GWXdQ/lXOq','luke','MALE','+36125485695','magyarorszag','szeged','szegedi koz 6',7856,'aqwd'),
(8,'1997-05-21','pisti@qwd.com','olah','istvan','$2a$12$2bDEL2hgDOkEF2E846/KIu24BeDC3jBfpJQJnrWJNmrpi2/UleU5O','psiti','MALE','+36854695357','magyarorszag','lyukobanya','homok utca 87',1212,'aqwd'),
(9,'1965-08-05','papi@qwd.com','magyar','bela','$2a$12$kIhqCpOsqXgDLlTZj5BSp.x75GXKyLP5OI6yUnpz.LtSvkO2nMvdC','papi','MALE','+36458653259','magyarorszag','budapest','beke ter 5',1552,'aqwd'),
(10,'1978-12-06','szilveszter@qwd.com','toth','szilveszter','$2a$12$mi349u3iLVrqdVhnTXG/v.AhMqWxfx3yJrxfYp0Ly3n05PdFv80mK','szilveszter','MALE','+36120645789','magyarorszag','budapest','szabadsag ter 57',1558,'aqwd');



CREATE TABLE fightclub_db."user"
(
id serial NOT NULL,
birthDate date NOT NULL,
emailAddress varchar(255) NOT NULL,
firstName varchar(255) NOT NULL,
lastName varchar(255) NOT NULL,
password varchar(255) NOT NULL,
userName varchar(20) NOT NULL,
gender varchar(10) NOT NULL,
phoneNumber text NOT NULL,
country varchar(30) NOT NULL,
city varchar(30) NOT NULL,
address varchar(30) NOT NULL,
zipcode integer NOT NULL,
image mediumblob NOT NULL,
PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
)
;
