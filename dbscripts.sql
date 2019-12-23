-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema stock
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema stock
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `stock` DEFAULT CHARACTER SET utf8 ;
USE `stock` ;

-- -----------------------------------------------------
-- Table `stock`.`sector`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock`.`sector` (
  `sec_id` INT(11) NOT NULL AUTO_INCREMENT,
  `sec_brief` VARCHAR(255) NOT NULL,
  `sec_name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`sec_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock`.`company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock`.`company` (
  `co_id` INT(11) NOT NULL AUTO_INCREMENT,
  `co_board_of_directors` VARCHAR(255) NULL DEFAULT NULL,
  `co_brief` VARCHAR(255) NULL DEFAULT NULL,
  `co_ceo` VARCHAR(255) NULL DEFAULT NULL,
  `co_check_se` BIT(1) NULL DEFAULT NULL,
  `co_company_code` BIGINT(20) NULL DEFAULT NULL,
  `co_name` VARCHAR(255) NULL DEFAULT NULL,
  `co_turn_over` BIGINT(20) NULL DEFAULT NULL,
  `sec_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`co_id`),
  INDEX `FKi9fwri4u1f7yhplj9s23hp2yx` (`sec_id` ASC),
  CONSTRAINT `FKi9fwri4u1f7yhplj9s23hp2yx`
    FOREIGN KEY (`sec_id`)
    REFERENCES `stock`.`sector` (`sec_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock`.`stock_exchange`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock`.`stock_exchange` (
  `se_id` INT(11) NOT NULL AUTO_INCREMENT,
  `se_address` VARCHAR(255) NULL DEFAULT NULL,
  `se_brief` VARCHAR(255) NULL DEFAULT NULL,
  `se_remarks` VARCHAR(255) NULL DEFAULT NULL,
  `se_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`se_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock`.`company_stock_exchange`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock`.`company_stock_exchange` (
  `cs_co_id` INT(11) NOT NULL,
  `cs_se_id` INT(11) NOT NULL,
  PRIMARY KEY (`cs_co_id`, `cs_se_id`),
  INDEX `FKgw2wbyifiw6s6ygawrd8pftcd` (`cs_se_id` ASC),
  CONSTRAINT `FK4hlbxxpj2xvt59kc81hu585a`
    FOREIGN KEY (`cs_co_id`)
    REFERENCES `stock`.`company` (`co_id`),
  CONSTRAINT `FKgw2wbyifiw6s6ygawrd8pftcd`
    FOREIGN KEY (`cs_se_id`)
    REFERENCES `stock`.`stock_exchange` (`se_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock`.`confirmation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock`.`confirmation` (
  `co_id` INT(11) NOT NULL AUTO_INCREMENT,
  `co_token` VARCHAR(255) NULL DEFAULT NULL,
  `co_user_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`co_id`))
ENGINE = MyISAM
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock`.`ipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock`.`ipo` (
  `ipo_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ipo_date_time` DATETIME NOT NULL,
  `ipo_price` DOUBLE NOT NULL,
  `ipo_remarks` VARCHAR(255) NOT NULL,
  `ipo_total_share` DOUBLE NOT NULL,
  `co_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ipo_id`),
  INDEX `FK2bv5yf1iy95bmuml04msawcc` (`co_id` ASC),
  CONSTRAINT `FK2bv5yf1iy95bmuml04msawcc`
    FOREIGN KEY (`co_id`)
    REFERENCES `stock`.`company` (`co_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock`.`role` (
  `ro_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ro_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`ro_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock`.`stock_price`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock`.`stock_price` (
  `sp_id` INT(11) NOT NULL AUTO_INCREMENT,
  `sp_company_code` BIGINT(20) NULL DEFAULT NULL,
  `sp_current_price` BIGINT(20) NULL DEFAULT NULL,
  `sp_date` DATETIME NULL DEFAULT NULL,
  `sp_stock_exchange_name` VARCHAR(255) NULL DEFAULT NULL,
  `sp_time` TIME NULL DEFAULT NULL,
  PRIMARY KEY (`sp_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock`.`user` (
  `us_id` INT(11) NOT NULL AUTO_INCREMENT,
  `us_confirm_status` BIT(1) NULL DEFAULT NULL,
  `us_email` VARCHAR(255) NULL DEFAULT NULL,
  `us_mobile_no` BIGINT(20) NULL DEFAULT NULL,
  `us_password` VARCHAR(255) NULL DEFAULT NULL,
  `us_raw_password` VARCHAR(255) NULL DEFAULT NULL,
  `us_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock`.`user_role` (
  `ur_us_id` INT(11) NOT NULL,
  `ur_ro_id` INT(11) NOT NULL,
  PRIMARY KEY (`ur_us_id`, `ur_ro_id`),
  INDEX `FKjia4161ecu6h4p0egc2oc04lt` (`ur_ro_id` ASC),
  CONSTRAINT `FK1t65ha4bv531fmav53vlu66fg`
    FOREIGN KEY (`ur_us_id`)
    REFERENCES `stock`.`user` (`us_id`),
  CONSTRAINT `FKjia4161ecu6h4p0egc2oc04lt`
    FOREIGN KEY (`ur_ro_id`)
    REFERENCES `stock`.`role` (`ro_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `stock`.`role`
(`ro_id`,
`ro_name`)
VALUES
(1,"ADMIN"),(2,"USER");

SELECT * FROM stock.role;


INSERT INTO `stock`.`company`
(
`co_board_of_directors`,
`co_brief`,
`co_ceo`,
`co_check_se`,
`co_name`,
`co_turn_over`,
`sec_id`,
`co_company_code`)
VALUES
(
"Archana",
"Good Profit",
"Mukesh Ambani",
1,
"Reliance",
12345,
1,
500112);

SELECT * FROM stock.company;

INSERT INTO `stock`.`sector` (`sec_brief`,`sec_name`) values ("Iron and Steel","Iron and Steel"),("Pharmaceuticals","Pharmaceuticals"),("HealthCare","HealthCare");

select * from stock.sector;

INSERT INTO `stock`.`company_stock_exchange`
(`cs_co_id`,
`cs_se_id`)
VALUES
(1,
1),(1,2);

SELECT * FROM stock.company_stock_exchange;

INSERT INTO `stock`.`stock_exchange`
(`se_name`,
`se_brief`,
`se_address`,
`se_remarks`
)
VALUES
("BSE","Bombay Stock Exchange","Dalal Street, Mumbai","Good Service"),
("NSE","National Stock Exchange","Delhi","Good");

SELECT * FROM stock.stock_exchange;


