
CREATE USER 'libDbUser_mvc'@'localhost' IDENTIFIED BY 'spring';
GRANT ALL PRIVILEGES ON cs548_springmvc_librarydb.* TO 'libDbUser_mvc'@'localhost' WITH GRANT OPTION;
SHOW GRANTS FOR 'libDbUser_mvc'@'localhost';



CREATE SCHEMA IF NOT EXISTS `cs548_springmvc_librarydb` ;
USE `cs548_springmvc_librarydb` ;
DROP TABLE IF EXISTS `cs548_springmvc_librarydb`.`student`;


CREATE TABLE `cs548_springmvc_librarydb`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `lastName` VARCHAR(45) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `age` SMALLINT NULL,
  `gender` TINYINT NOT NULL,
  PRIMARY KEY (`id`));
  
  
  CREATE TABLE `cs548_springmvc_librarydb`.`book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `author` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));
 
  
