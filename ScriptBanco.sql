SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `banco`;
USE `banco` ;

CREATE TABLE IF NOT EXISTS `banco`.`empleado` (
  `id_empleado` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `n_telefono` INT NULL,
  `nombre_subor` VARCHAR(45) NULL,
  `fecha_ingreso` VARCHAR(45) NULL,
  PRIMARY KEY (`id_empleado`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `banco`.`clientes` (
  `id_clientes` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `ciudad` VARCHAR(45) NULL,
  `empleado_id_empleado` INT NOT NULL,
  PRIMARY KEY (`id_clientes`, `empleado_id_empleado`),
  INDEX `fk_clientes_empleado1_idx` (`empleado_id_empleado` ASC) VISIBLE,
  CONSTRAINT `fk_clientes_empleado1`
    FOREIGN KEY (`empleado_id_empleado`)
    REFERENCES `banco`.`empleado` (`id_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `banco`.`sucursal` (
  `ciudad` VARCHAR(45) NOT NULL,
  `nombre_sucursal` VARCHAR(45) NOT NULL,
  `clientes_id_clientes` INT NOT NULL,
  PRIMARY KEY (`nombre_sucursal`, `clientes_id_clientes`),
  INDEX `fk_sucursal_clientes1_idx` (`clientes_id_clientes` ASC) VISIBLE,
  CONSTRAINT `fk_sucursal_clientes1`
    FOREIGN KEY (`clientes_id_clientes`)
    REFERENCES `banco`.`clientes` (`id_clientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `banco`.`cuenta` (
  `tipo_cuenta` VARCHAR(45) NOT NULL,
  `n_cuenta` INT NOT NULL,
  `clientes_id_clientes` INT NOT NULL,
  PRIMARY KEY (`n_cuenta`, `clientes_id_clientes`),
  INDEX `fk_cuenta_clientes1_idx` (`clientes_id_clientes` ASC) VISIBLE,
  CONSTRAINT `fk_cuenta_clientes1`
    FOREIGN KEY (`clientes_id_clientes`)
    REFERENCES `banco`.`clientes` (`id_clientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `banco`.`area` (
  `id_area` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`id_area`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `banco`.`jefe` (
  `id_jefe` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `area` VARCHAR(45) NULL,
  `area_id_area` INT NOT NULL,
  `empleado_id_empleado` INT NOT NULL,
  PRIMARY KEY (`id_jefe`, `area_id_area`, `empleado_id_empleado`),
  INDEX `fk_jefe_area1_idx` (`area_id_area` ASC) VISIBLE,
  INDEX `fk_jefe_empleado1_idx` (`empleado_id_empleado` ASC) VISIBLE,
  CONSTRAINT `fk_jefe_area1`
    FOREIGN KEY (`area_id_area`)
    REFERENCES `banco`.`area` (`id_area`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_jefe_empleado1`
    FOREIGN KEY (`empleado_id_empleado`)
    REFERENCES `banco`.`empleado` (`id_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
