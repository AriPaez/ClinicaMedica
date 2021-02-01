CREATE TABLE Medico
(
	dniMedico VARCHAR(8) PRIMARY KEY NOT NULL,
	primerNombre VARCHAR(20) NOT NULL,
	segundoNombre VARCHAR(20),
	apellido VARCHAR(20) NOT NULL,
	cargo VARCHAR(6) NOT NULL,
	consultorio INT NOT NULL,
	especialidad varchar(20) NOT NULL,
	contrasenia VARCHAR(20)  NOT NULL,
	  
)

CREATE TABLE AreaMedica
(
    idAreaMedica INT PRIMARY KEY NOT NULL,
	nombre VARCHAR(15),	
	dniMedico VARCHAR(8) NOT NULL
	FOREIGN KEY(dniMedico) REFERENCES Medico(dniMedico)
)

CREATE TABLE Administrador
(
	dniAdministrador VARCHAR(8) PRIMARY KEY NOT NULL,
	primerNombre VARCHAR(20) NOT NULL,
	segundoNombre VARCHAR(20) ,
	apellido VARCHAR(20) NOT NULL,
	cargo VARCHAR(30) NOT NULL,
	contrasenia VARCHAR(20)  NOT NULL,
)

CREATE TABLE Paciente
(
	dniPaciente VARCHAR(8) PRIMARY KEY NOT NULL,
	fechaDeNacimiento DATE  NOT NULL,
	primerNombre VARCHAR(20)  NOT NULL,
	segundoNombre VARCHAR(20),
	apellido VARCHAR(20)  NOT NULL,
	celular VARCHAR(10) NOT NULL,
	email VARCHAR(20),
	dniAdministrador VARCHAR(8)  NOT NULL,
	FOREIGN KEY(dniAdministrador) REFERENCES Administrador(dniAdministrador)
	 
)

CREATE TABLE Estudio
(
	idEstudio INT PRIMARY KEY NOT NULL,
	fechaConsulta DATE NOT NULL,
	peso FLOAT NOT NULL,
	talla FLOAT NOT NULL,
	motivoConsulta VARCHAR(40) NOT NULL,
	diagnostico VARCHAR(40) NOT NULL,
	dniMedico VARCHAR(8) NOT NULL

	FOREIGN KEY(dniMedico) REFERENCES Medico(dniMedico)
)

CREATE TABLE Receta
(
	idReceta INT PRIMARY KEY NOT NULL,
	medicamento VARCHAR(40) NOT NULL,
	instruccionesAlPaciente VARCHAR(40) NOT NULL,
	instruccionesALaFarmacia VARCHAR(50) NOT NULL,
	idEstudio INT NOT NULL,
	dniPaciente VARCHAR(8) NOT NULL,
	
	FOREIGN KEY(idEstudio) REFERENCES Estudio(idEstudio),
	FOREIGN KEY(dniPaciente) REFERENCES Paciente(dniPaciente)


)

CREATE TABLE Turno
(
	idTurno INT  PRIMARY KEY IDENTITY(1,1) NOT NULL,
	fecha DATE,
	horaInicio TIME,
	horaFin TIME,
	dniPaciente VARCHAR(8) NOT NULL,
	dniMedico VARCHAR(8) NOT NULL,
	FOREIGN KEY(dniPaciente) REFERENCES Paciente(dniPaciente), 
	FOREIGN KEY(dniMedico) REFERENCES Medico(dniMedico),
)

SET IDENTITY_INSERT Turno OFF
 