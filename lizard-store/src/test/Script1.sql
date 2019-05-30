--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `database`.`order_product_tb_dtl` DROP PRIMARY KEY;

ALTER TABLE `database`.`category_tb_master` DROP PRIMARY KEY;

ALTER TABLE `database`.`order_tb_master` DROP PRIMARY KEY;

ALTER TABLE `database`.`products_tb_master` DROP PRIMARY KEY;

ALTER TABLE `database`.`user_tb_master` DROP PRIMARY KEY;

ALTER TABLE `database`.`order_tb_master` DROP INDEX `database`.`user_id`;

ALTER TABLE `database`.`order_product_tb_dtl` DROP INDEX `database`.`product_id`;

ALTER TABLE `database`.`order_tb_master` DROP INDEX `database`.`product_id`;

ALTER TABLE `database`.`order_product_tb_dtl` DROP INDEX `database`.`order_id`;

DROP TABLE `database`.`products_tb_master`;

DROP TABLE `database`.`order_tb_master`;

DROP TABLE `database`.`category_tb_master`;

DROP TABLE `database`.`order_product_tb_dtl`;

DROP TABLE `database`.`user_tb_master`;

CREATE TABLE `database`.`products_tb_master` (
	`product_id` INT NOT NULL AUTO_INCREMENT,
	`product_name` VARCHAR(32),
	`product_price` FLOAT,
	`product_image` VARCHAR(128),
	`date_added` DATE,
	PRIMARY KEY (`product_id`)
);

CREATE TABLE `database`.`order_tb_master` (
	`order_id` INT NOT NULL AUTO_INCREMENT,
	`ordr_nmbr` VARCHAR(32),
	`ordr_prc` FLOAT,
	`product_id` INT,
	`user_id` INT,
	`date_added` DATE,
	PRIMARY KEY (`order_id`)
);

CREATE TABLE `database`.`category_tb_master` (
	`category_id` INT NOT NULL AUTO_INCREMENT,
	`category_name` VARCHAR(32),
	`date_added` DATE,
	PRIMARY KEY (`category_id`)
);

CREATE TABLE `database`.`order_product_tb_dtl` (
	`ordr_prdct_id` INT NOT NULL AUTO_INCREMENT,
	`product_price` FLOAT,
	`product_qty` INT,
	`product_id` INT,
	`order_id` INT,
	`date_added` DATE,
	PRIMARY KEY (`ordr_prdct_id`)
);

CREATE TABLE `database`.`user_tb_master` (
	`user_id` INT NOT NULL AUTO_INCREMENT,
	`user_name` VARCHAR(32),
	`user_email` VARCHAR(64),
	`user_password` VARCHAR(32),
	`user_role` INT NOT NULL,
	`date_added` DATE,
	PRIMARY KEY (`user_id`)
);

CREATE INDEX `user_id` ON `database`.`order_tb_master` (`user_id` ASC);

CREATE INDEX `product_id` ON `database`.`order_product_tb_dtl` (`product_id` ASC);

CREATE INDEX `product_id` ON `database`.`order_tb_master` (`product_id` ASC);

CREATE INDEX `order_id` ON `database`.`order_product_tb_dtl` (`order_id` ASC);

