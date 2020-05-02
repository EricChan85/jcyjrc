DROP TABLE IF EXISTS yjrc.person;
CREATE TABLE yjrc.person(
   ID int(10) NOT NULL AUTO_INCREMENT,  
   USERNAME varchar(30) NOT NULL,
   PASSWORD varchar(60) NOT NULL,
    name nvarchar(30) DEFAULT NULL ,
    gender nvarchar(5) DEFAULT NULL ,
    date_of_birth DATE DEFAULT NULL ,
    nationality nvarchar(10) DEFAULT NULL ,
    native_place nvarchar(30) DEFAULT NULL ,
    birth_place nvarchar(30) DEFAULT NULL ,
    political_status nvarchar(10) DEFAULT NULL ,
    education nvarchar(20) DEFAULT NULL ,
    health_condition nvarchar(20) DEFAULT NULL ,
    date_of_joining_the_party DATE DEFAULT NULL ,
    date_of_starting_to_work DATE DEFAULT NULL ,
    date_of_entering DATE DEFAULT NULL ,
    number_of_id_card varchar(20) DEFAULT NULL ,
    phone varchar(20) DEFAULT NULL ,
    institution nvarchar(50) DEFAULT NULL,
    position nvarchar(50) DEFAULT NULL ,
    professional_technical_position nvarchar(100) DEFAULT NULL ,
    photo varchar(20) DEFAULT NULL ,
    address nvarchar(100) DEFAULT NULL ,
    education_experience nvarchar(1000) DEFAULT NULL ,
    work_experience nvarchar(1000) DEFAULT NULL ,
    honors nvarchar(1000) DEFAULT NULL ,
    skills_and_interests nvarchar(1000) DEFAULT NULL ,
   ROLE varchar(45) NOT NULL,
   PRIMARY KEY ( ID )
);

insert into yjrc.person (name, username, password, phone, role) values 
('小明', 'xiaoming', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_ADMIN'),
('李雷', 'lilei', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('老王', 'laowang', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_STAFF');

insert into yjrc.person (name, username, password, phone, role) values 
('李雷1', 'lilei1', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷2', 'lilei2', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷3', 'lilei3', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷4', 'lilei4', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷5', 'lilei5', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷6', 'lilei6', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷7', 'lilei7', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷8', 'lilei8', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷9', 'lilei9', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷10', 'lilei10', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷11', 'lilei11', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷12', 'lilei12', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷13', 'lilei13', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷14', 'lilei14', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷15', 'lilei15', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷16', 'lilei16', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷17', 'lilei17', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷18', 'lilei18', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷19', 'lilei19', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷20', 'lilei20', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷21', 'lilei21', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷22', 'lilei22', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷23', 'lilei23', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷24', 'lilei24', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷25', 'lilei25', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷26', 'lilei26', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷27', 'lilei27', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷28', 'lilei28', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷29', 'lilei29', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷30', 'lilei30', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷31', 'lilei31', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷32', 'lilei32', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷33', 'lilei33', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷34', 'lilei34', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷35', 'lilei35', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷36', 'lilei36', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷37', 'lilei37', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷38', 'lilei38', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷39', 'lilei39', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷40', 'lilei40', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷41', 'lilei41', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷42', 'lilei42', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷43', 'lilei43', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷44', 'lilei44', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷45', 'lilei45', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷46', 'lilei46', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷47', 'lilei47', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷48', 'lilei48', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷49', 'lilei49', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷50', 'lilei50', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷51', 'lilei51', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷52', 'lilei52', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷53', 'lilei53', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷54', 'lilei54', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷55', 'lilei55', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷56', 'lilei56', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷57', 'lilei57', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷58', 'lilei58', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷59', 'lilei59', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷60', 'lilei60', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷61', 'lilei61', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷62', 'lilei62', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷63', 'lilei63', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷64', 'lilei64', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷65', 'lilei65', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷66', 'lilei66', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷67', 'lilei67', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷68', 'lilei68', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷69', 'lilei69', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷70', 'lilei70', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷71', 'lilei71', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER'),
('李雷72', 'lilei72', '$2a$11$jFhURK78qYIgycjltn4Rce62z6LzUwOi9ktYnUDkLm5jfxuJQMzhS', '13689451185', 'ROLE_USER');


DROP TABLE IF EXISTS yjrc.enums;
CREATE TABLE yjrc.enums(
   ID int(10) NOT NULL AUTO_INCREMENT,  
   ENUM_TYPE varchar(45) NOT NULL,
   ENUM_NAME nvarchar(45) NOT NULL,
   ENUM_VALUE INT NOT NULL,
   PRIMARY KEY ( ID )
);

INSERT INTO yjrc.enums (enum_type, enum_name, enum_value) values 
("nationality","汉族",1),
("nationality","蒙古族",2),
("nationality","回族",3),
("nationality","藏族",4),
("nationality","维吾尔族",5),
("nationality","苗族",6),
("nationality","彝族",7),
("nationality","壮族",8),
("nationality","布依族",9),
("nationality","朝鲜族",10),
("nationality","满族",11),
("nationality","侗族",12),
("nationality","瑶族",13),
("nationality","白族",14),
("nationality","土家族",15),
("nationality","哈尼族",16),
("nationality","哈萨克族",17),
("nationality","傣族",18),
("nationality","黎族",19),
("nationality","傈僳族",20),
("nationality","佤族",21),
("nationality","畲族",22),
("nationality","高山族",23),
("nationality","拉祜族",24),
("nationality","水族",25),
("nationality","东乡族",26),
("nationality","纳西族",27),
("nationality","景颇族",28),
("nationality","柯尔克孜族",29),
("nationality","土族",30),
("nationality","达斡尔族",31),
("nationality","仫佬族",32),
("nationality","羌族",33),
("nationality","布朗族",34),
("nationality","撒拉族",35),
("nationality","毛南族",36),
("nationality","仡佬族",37),
("nationality","锡伯族",38),
("nationality","阿昌族",39),
("nationality","普米族",40),
("nationality","塔吉克族",41),
("nationality","怒族",42),
("nationality","乌孜别克族",43),
("nationality","俄罗斯族",44),
("nationality","鄂温克族",45),
("nationality","德昂族",46),
("nationality","保安族",47),
("nationality","裕固族",48),
("nationality","京族",49),
("nationality","塔塔尔族",50),
("nationality","独龙族",51),
("nationality","鄂伦春族",52),
("nationality","赫哲族",53),
("nationality","门巴族",54),
("nationality","珞巴族",55),
("nationality","基诺族",56);

INSERT INTO yjrc.enums (enum_type, enum_name, enum_value) values 
("politicaStatus","中共党员",1),
("politicaStatus","中共预备党员",2),
("politicaStatus","共青团员",3),
("politicaStatus","民革党员",4),
("politicaStatus","民盟盟员",5),
("politicaStatus","民建会员",6),
("politicaStatus","民进会员",7),
("politicaStatus","农工党党员",8),
("politicaStatus","致公党党员",9),
("politicaStatus","九三学社社员",10),
("politicaStatus","台盟盟员",11),
("politicaStatus","无党派人士",12),
("politicaStatus","群众",13);

INSERT INTO yjrc.enums (enum_type, enum_name, enum_value) values 
("repairStatus","已提交",1),
("repairStatus","已处理",2),
("repairStatus","已评价",3);

INSERT INTO yjrc.enums (enum_type, enum_name, enum_value) values 
("activityStatus","已发布",1),
("activityStatus","未发布",2);

DROP TABLE IF EXISTS yjrc.education_experiences;
CREATE TABLE yjrc.education_experiences(
   ID int(10) NOT NULL AUTO_INCREMENT,  
   PERSON_ID int(10) NOT NULL,
   START_DATE DATE DEFAULT NULL ,
   END_DATE DATE DEFAULT NULL ,
   DETAILS varchar(200) NOT NULL,
   PRIMARY KEY ( ID )
);

DROP TABLE IF EXISTS yjrc.work_experience;
CREATE TABLE yjrc.work_experience(
   ID int(10) NOT NULL AUTO_INCREMENT,  
   PERSON_ID int(10) NOT NULL,
   START_DATE DATE DEFAULT NULL ,
   END_DATE DATE DEFAULT NULL ,
   DETAILS varchar(200) NOT NULL,
   PRIMARY KEY ( ID )
);

DROP TABLE IF EXISTS yjrc.repair;
CREATE TABLE yjrc.repair(
   ID int(10) NOT NULL AUTO_INCREMENT,  
   PERSON_ID int(10) NOT NULL,
   ADDRESS NVARCHAR(200) NOT NULL,
   PHONE VARCHAR(20) NOT NULL,
   DETAILS NVARCHAR(200) NOT NULL,
   START_TIME DATETIME DEFAULT NULL ,
   END_TIME DATETIME DEFAULT NULL ,
   CREATE_TIME DATETIME NOT NULL,   
   REPAIRMAN_ID INT(10) DEFAULT NULL,   
   REPAIR_DESCRIPTION NVARCHAR(300) DEFAULT NULL, 
   REPAIR_TIME DATETIME DEFAULT NULL,  
   EVALUATION NVARCHAR(300) DEFAULT NULL,
   EVALUATION_TIME DATETIME DEFAULT NULL,
   STATUS INT(10) NOT NULL,
   PRIMARY KEY ( ID )
);

DROP TABLE IF EXISTS yjrc.activity;
CREATE TABLE yjrc.activity(
   ID int(10) NOT NULL AUTO_INCREMENT,  
   TITLE NVARCHAR(200) NOT NULL,
   SKETCH NVARCHAR(1000) NOT NULL,
   DETAIL TEXT NOT NULL,
   CREATE_TIME DATETIME NOT NULL,   
   CREATOR_ID INT(10) DEFAULT NULL,   
   STATUS INT(10) NOT NULL,
   PRIMARY KEY ( ID )
);



//******************************************************************************************************** 

DROP TABLE IF EXISTS yjrc.person_roles;
CREATE TABLE yjrc.person_roles(
   ID int(10) NOT NULL AUTO_INCREMENT,  
   USERNAME varchar(45) NOT NULL,
   ROLE varchar(45) NOT NULL,
   PRIMARY KEY ( ID ),
   UNIQUE KEY uni_username_role (role,username),
   KEY fk_username_idx (username),
   CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES person (username)
);

INSERT INTO user_roles (username, role)
VALUES ('xiaoming', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('lilei', 'ROLE_USER');