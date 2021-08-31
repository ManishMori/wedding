-- Creating user table:

CREATE TABLE `weddingregistration`.`user` (
  `user_id` INT NOT NULL,
  `user_first_name` VARCHAR(45) NOT NULL,
  `user_last_name` VARCHAR(45) NOT NULL,
  `user_full_name` VARCHAR(100) NOT NULL,
  `user_email` VARCHAR(45) NOT NULL,
  `user_gender` VARCHAR(6) NOT NULL,
  `user_d_o_b` DATE NOT NULL,
  `user_marriage_date` DATE NULL,
  `user_document_aadhar` LONGBLOB NOT NULL,
  `user_document_marriage_certificate` LONGBLOB ,
  `user_document_mariage_picture` LONGBLOB NOT NULL,
  `user_certificate_id` VARCHAR(255) NULL,
  `partner_user_id` INT NULL,
  `is_documents_approved` TINYINT(1) NOT NULL DEFAULT 0,
  `is_contract_generated` TINYINT(1) NOT NULL DEFAULT 0,
  `is_user_active` TINYINT(1) NOT NULL DEFAULT 1,
  `password` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`user_id`));
  
 -- Adding index
ALTER TABLE `weddingregistration`.`user` 
ADD INDEX `FK_PARTNER_ID_idx` (`partner_user_id` ASC);

 
-- Adding FK

ALTER TABLE `weddingregistration`.`user` 
ADD CONSTRAINT `FK_PARTNER_ID`
  FOREIGN KEY (`partner_user_id`)
  REFERENCES `weddingregistration`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  
  -- create user_sequence table
  CREATE TABLE `user_sequence` (
  `next_val` bigint(20) DEFAULT NULL
);

INSERT INTO `user_sequence`
VALUES(1);