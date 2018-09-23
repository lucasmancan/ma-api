-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`categorias` (
  `id` INT NOT NULL,
  `nome` VARCHAR(255) NULL,
  `administra` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`instituicoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`instituicoes` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `registro_governo` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cursos` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `instituicao_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cursos_instituicao1_idx` (`instituicao_id` ASC) VISIBLE,
  CONSTRAINT `fk_cursos_instituicao1`
    FOREIGN KEY (`instituicao_id`)
    REFERENCES `mydb`.`instituicoes` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`pessoas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pessoas` (
  `id` INT NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `data_inclusao` DATE NOT NULL,
  `data_alteracao` DATE NULL,
  `email_principal` VARCHAR(45) NOT NULL,
  `rg` VARCHAR(20) NULL,
  `cpf` VARCHAR(11) NULL,
  `telefone_principal` INT NULL,
  `registro_instituicao` VARCHAR(45) NULL,
  `cursos_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pessoas_cursos1_idx` (`cursos_id` ASC) VISIBLE,
  CONSTRAINT `fk_pessoas_cursos1`
    FOREIGN KEY (`cursos_id`)
    REFERENCES `mydb`.`cursos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuarios` (
  `data_inclusao` DATE NOT NULL,
  `data_alteracao` DATE NOT NULL,
  `categorias_id` INT NOT NULL,
  `senha` VARCHAR(45) NULL,
  `id` INT NOT NULL,
  `instituicao_id` INT NOT NULL,
  `pessoas_id` INT NOT NULL,
  INDEX `fk_usuarios_categorias1_idx` (`categorias_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  INDEX `fk_usuarios_instituicao1_idx` (`instituicao_id` ASC) VISIBLE,
  INDEX `fk_usuarios_pessoas1_idx` (`pessoas_id` ASC) VISIBLE,
  CONSTRAINT `fk_usuarios_categorias1`
    FOREIGN KEY (`categorias_id`)
    REFERENCES `mydb`.`categorias` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_instituicao1`
    FOREIGN KEY (`instituicao_id`)
    REFERENCES `mydb`.`instituicoes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_pessoas1`
    FOREIGN KEY (`pessoas_id`)
    REFERENCES `mydb`.`pessoas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`emails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`emails` (
  `id` INT NOT NULL,
  `email` VARCHAR(45) NULL,
  `pessoas_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_emails_pessoas1_idx` (`pessoas_id` ASC) VISIBLE,
  CONSTRAINT `fk_emails_pessoas1`
    FOREIGN KEY (`pessoas_id`)
    REFERENCES `mydb`.`pessoas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`telefones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`telefones` (
  `id` INT NOT NULL,
  `telefone` VARCHAR(20) NULL,
  `pessoas_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_telefones_pessoas1_idx` (`pessoas_id` ASC) VISIBLE,
  CONSTRAINT `fk_telefones_pessoas1`
    FOREIGN KEY (`pessoas_id`)
    REFERENCES `mydb`.`pessoas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`atividades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`atividades` (
  `id` INT NOT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  `local` VARCHAR(255) NOT NULL,
  `data_inclusao` TIMESTAMP NOT NULL,
  `aprovada` TINYINT NOT NULL DEFAULT 0,
  `hora_inicio` DATE NOT NULL,
  `hora_fim` DATE NOT NULL,
  `relatorio` TEXT NOT NULL,
  `total_horas` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`atividades_has_usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`atividades_has_usuarios` (
  `atividades_id` INT NOT NULL,
  `usuarios_id` INT NOT NULL,
  PRIMARY KEY (`atividades_id`, `usuarios_id`),
  INDEX `fk_atividades_has_usuarios_usuarios1_idx` (`usuarios_id` ASC) VISIBLE,
  INDEX `fk_atividades_has_usuarios_atividades1_idx` (`atividades_id` ASC) VISIBLE,
  CONSTRAINT `fk_atividades_has_usuarios_atividades1`
    FOREIGN KEY (`atividades_id`)
    REFERENCES `mydb`.`atividades` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_atividades_has_usuarios_usuarios1`
    FOREIGN KEY (`usuarios_id`)
    REFERENCES `mydb`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
