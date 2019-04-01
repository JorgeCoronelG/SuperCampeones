/**
 * Author:  Jorge Coronel González
 * Created: 28/03/2019
 */

CREATE DATABASE PROYECTO_II;
USE PROYECTO_II;

CREATE TABLE USUARIO(
    idUs int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombreUs varchar(50),
    passUs varchar(32),
    estatus TINYINT(1)
);

INSERT INTO USUARIO VALUES(null, 'admin', md5('admin'), 1);

CREATE TABLE EQUIPO(
    idEq int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombreEq varchar(120),
    pgEq int DEFAULT 0,
    ppEq int DEFAULT 0,
    peEq int DEFAULT 0,
    gaEq int DEFAULT 0,
    geEq int DEFAULT 0,
    difEq int DEFAULT 0,
    puntosEq int DEFAULT 0
);
--pgEq = Partidos ganados
--ppEq = Partidos perdidos
--peEq = Partidos empatados
--gaEq = Goles a favor
--geEq = Goles en contra
--difEq = Diferencia de goles

INSERT INTO EQUIPO VALUES(null, 'América',0,0,0,0,0,0,0);
INSERT INTO EQUIPO VALUES(null, 'Chivas',0,0,0,0,0,0,0);

CREATE TABLE PARTIDO(
    idPtd int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    arbitroPtd varchar(120),
    jorPtd int
);

INSERT INTO PARTIDO VALUES(null, 'El Gen', 1);

CREATE TABLE PARTIDO_EQUIPO(
    idPtd int NOT NULL,
    idEq int NOT NULL,
    golesEq int,
    FOREIGN KEY(idPtd) REFERENCES PARTIDO(idPtd),
    FOREIGN KEY(idEq) REFERENCES EQUIPO(idEq)
);

INSERT INTO PARTIDO_EQUIPO VALUES(1,1,2);
INSERT INTO PARTIDO_EQUIPO VALUES(1,2,0);