/*create database simute;*/
use simute;

create table Usuario(
		Cedula varchar(30) NOT NULL PRIMARY KEY, 
		Nombre varchar(40), 
		Apellido1 varchar(40), 
		Apellido2 varchar(40), 
		Celular int, 
		Correo varchar(40), 
		Contra varchar(8),
		TipoUsuario int
) ENGINE = InnoDB;

create table Poblacion(
		NumeroTelefono varchar(30) NOT NULL PRIMARY KEY, 
		Provincia int NOT NULL,
		Canton int NOT NULL, 
		Distrito int NOT NULL
) ENGINE = InnoDB;

create table SolicitudMuestra(
		id_SolicitudMuestra int NOT NULL AUTO_INCREMENT PRIMARY KEY,
		NombreMuestra varchar(50),
		Cantidad int,
		FechaCreacion date,
		FechaInicio date
	
) ENGINE = InnoDB;

create table Muestra(
		id_Muestra int NOT NULL AUTO_INCREMENT PRIMARY KEY,
		Intento int NOT NULL,
		Estado int NOT NULL,
		FechaInicio date,
		FechaCierre date,
		CedulaUsuario varchar(30),
		id_SMuestra int,
		NumTelMuestra int,
		CONSTRAINT FK_SolicitudMuestra FOREIGN KEY (id_SMuestra) REFERENCES SolicitudMuestra (id_SolicitudMuestra),
		CONSTRAINT FK_Poblacion FOREIGN KEY (NumTelMuestra) REFERENCES Poblacion (id_Poblacion),
		CONSTRAINT FK_UsuarioM FOREIGN KEY (CedulaUsuario) REFERENCES Usuario (Cedula)
		ON DELETE CASCADE
		ON UPDATE RESTRICT
) ENGINE = InnoDB;
