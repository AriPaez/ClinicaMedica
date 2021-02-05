--Permite registrar a un medico.
GO
CREATE PROCEDURE registrarMedico(@dni varchar(8),@pNombre varchar(20),@sNombre varchar(20),
@ape varchar(20),@cargo varchar(10),@consultrio int,
@especialidad varchar(30),@pass varchar(20))
AS
INSERT INTO Medico
           ([dniMedico]
           ,[primerNombre]
           ,[segundoNombre]
           ,[apellido]
           ,[cargo]
           ,[consultorio]
           ,[especialidad]
           ,[contrasenia])
     VALUES(@dni,@pNombre ,@sNombre ,
	@ape ,@cargo ,@consultrio,
	@especialidad ,@pass )
GO

 
--Regista a un administrador.
GO
CREATE PROCEDURE registrarAdministrador(@dni varchar(8),@pNombre varchar(20),@sNombre varchar(20),
@ape varchar(20),@c varchar(30),@pass varchar(20))
AS
INSERT INTO [dbo].[Administrador]
           ([dniAdministrador]
           ,[primerNombre]
           ,[segundoNombre]
           ,[apellido]
           ,[cargo]
           ,[contrasenia])
     VALUES(@dni,@pNombre,@sNombre,@ape,@c,@pass)
GO


--Registro de paciente
GO
CREATE PROCEDURE registrarPaciente(@dniPaciente VARCHAR(8),
	@fechaDeNacimiento DATE  ,
	@primerNombre VARCHAR(20)  ,
	@segundoNombre VARCHAR(20),
	@apellido VARCHAR(20)  ,
	@celular VARCHAR(10) ,
	@email VARCHAR(20),
	@dniAdministrador VARCHAR(8)  )
AS
INSERT INTO [dbo].[Paciente]
           ([dniPaciente]
           ,[fechaDeNacimiento]
           ,[primerNombre]
           ,[segundoNombre]
           ,[apellido]
           ,[celular]
           ,[email]
           ,[dniAdministrador])
     VALUES
		(@dniPaciente,
		@fechaDeNacimiento ,
		@primerNombre,
		@segundoNombre ,
		@apellido ,
		@celular,
		@email,
		@dniAdministrador )
GO

--Retorno de horariosInico de turnos que dispone un medico.
GO
CREATE FUNCTION horarioInicioTurnosReservados(@dniMedico int,@fechaIngreso date)
RETURNS TABLE
AS
RETURN(
	 SELECT horaInicio
	 FROM turno
	 WHERE  dniMedico=@dniMedico and fecha=@fechaIngreso
	 ) 
GO

--Retorno de horariosInico de turnos que dispone un medico(escalar). 

CREATE FUNCTION horarioInicioTurnosReservados(@dniMedico int,@fechaIngreso date) 
RETURNS date   
AS   
-- Returns the stock level for the product.  
BEGIN  
    DECLARE @hI date;  
    SELECT @hI = horaInicio   
    FROM Turno p   
    WHERE dniMedico =@dniMedico AND fecha= @fechaIngreso  
    RETURN @hI
END; 
 
 --horarioInicioTurnosReservados
GO
CREATE PROCEDURE horarioInicioTurnosReservados(@dniMedico int,@fechaIngreso date) 
AS
	 SELECT horaInicio
	 FROM turno
	 WHERE  dniMedico=@dniMedico and fecha=@fechaIngreso
GO
 
 EXEC horarioInicioTurnosReservados '94712223','2021-01-18'
--asignar turno a un paciente
 
CREATE PROCEDURE asignarTurno(@fecha DATE
           ,@horaInicio TIME
           ,@horaFin TIME
           ,@dniPaciente VARCHAR(8)
           ,@dniMedico VARCHAR(8))
AS
INSERT INTO [dbo].[Turno]
           ([fecha]
           ,[horaInicio]
           ,[horaFin]
           ,[dniPaciente]
           ,[dniMedico])
     VALUES
           (@fecha
		   ,@horaInicio 
           ,@horaFin 
           ,@dniPaciente 
           ,@dniMedico )
GO


--SE BUSCA PACIENTE
CREATE FUNCTION busquedaPaciente(@dniPaciente varchar(8)) 
RETURNS BIT
AS
BEGIN
    RETURN (CASE WHEN EXISTS(
        SELECT 1   
        FROM Paciente   
        WHERE dniPaciente=@dniPaciente)
		THEN 1 ELSE 0 END );
END;
GO
 
---sobre turno de paciente con TRANSACTION

ALTER PROCEDURE sobreTurno(@dniDelPaciente VARCHAR(8) ,@nuevaFecha DATE,
@nuevaHoraInicio TIME,@nuevaHoraFin TIME)
AS 
IF NOT EXISTS (SELECT dniPaciente FROM Turno WHERE dniPaciente = @dniDelPaciente)
 BEGIN
	RAISERROR('¡DNI no encontrado en la BBDD!',14,1) --dni no encontrado.
	RETURN
 END
 BEGIN TRANSACTION
 UPDATE Turno
	   SET [fecha]=@nuevaFecha, 
		  [horaInicio]=@nuevaHoraInicio,
		  [horaFin]=@nuevaHoraFin
	 WHERE dniPaciente=@dniDelPaciente 
COMMIT TRANSACTION
GO

EXEC sobreTurno '654','24-9-1996','08:00:00.0000000','08:00:00.0000000'

---sobre turno de paciente sin transaccion

ALTER PROCEDURE sobreTurno(@dniDelPaciente VARCHAR(8) ,@nuevaFecha DATE,
@nuevaHoraInicio TIME,@nuevaHoraFin TIME)
AS 
IF NOT EXISTS (SELECT dniPaciente FROM Turno WHERE dniPaciente = @dniDelPaciente)
 BEGIN
	RAISERROR('¡DNI no encontrado en la BBDD!',14,1) --dni no encontrado.
	RETURN
 END
 UPDATE Turno
	   SET [fecha]=@nuevaFecha, 
		  [horaInicio]=@nuevaHoraInicio,
		  [horaFin]=@nuevaHoraFin
	 WHERE dniPaciente=@dniDelPaciente 
GO

EXEC sobreTurno '654','24-9-1996','08:00:00.0000000','08:00:00.0000000'

---sobre turno de paciente con THOROW

ALTER PROCEDURE sobreTurno(@dniDelPaciente VARCHAR(8) ,@nuevaFecha DATE,
@nuevaHoraInicio TIME,@nuevaHoraFin TIME)
AS 
IF EXISTS (SELECT dniPaciente FROM Turno WHERE dniPaciente = @dniDelPaciente)
 UPDATE Turno
	   SET [fecha]=@nuevaFecha, 
		  [horaInicio]=@nuevaHoraInicio,
		  [horaFin]=@nuevaHoraFin
	 WHERE dniPaciente=@dniDelPaciente 
ELSE
	THROW 50000,'¡DNI no encontrado en la BBDD!',0;
GO

EXEC sobreTurno '654','24-9-1996','08:00:00.0000000','08:00:00.0000000'

--se obtiene el turno de un paciente mediante su dni correspondiente.

 CREATE PROCEDURE obtenerTurnoDePaciente(@dniDelPaciente VARCHAR(8))
 AS
 BEGIN
 --CONVERT(varchar,horaInicio,108) as [HH:MM:SS]
 SELECT idTurno,fecha,CONVERT(VARCHAR(5), horaInicio, 108) AS horarioInicio
 ,CONVERT(VARCHAR(5), horaFin, 108) AS horarioFin,dniPaciente,dniMedico
 FROM Turno
 WHERE dniPaciente=@dniDelPaciente
 END
 --ejecucion del procedimiento.
 exec obtenerTurnoDePaciente '34326587'
 

 --busqueda de existencia de paciente e 
 --ingreso de asistencia de paciente al turno.
 -- en el parametro asistencia desde java recibe un tipo de valor
 --booleano.
 --tambien realiza carga de estudio y receta.
 ALTER PROCEDURE registrarPlanillaPaciente(@dniPaciente VARCHAR(8),@dniMedico VARCHAR(8),
 @asistencia BIT,@talla FLOAT,@peso FLOAT,@motivoConsulta VARCHAR(80),
 @diagnostico VARCHAR(40),@medicamento VARCHAR(40),@instruccionesAlPaciente VARCHAR(80),
 @instruccionesALaFarmacia VARCHAR(80))
 AS
 BEGIN TRY
 IF NOT EXISTS (SELECT dniPaciente FROM Turno WHERE dniPaciente=@dniPaciente)
  
	RAISERROR('No existe el DNI del paciente ingresado. Intente con otro',14,1)
  
	--ingreso de asistencia del paciente en la tabla turno.
	UPDATE [dbo].[turno]
    SET asistencia=@asistencia   
	WHERE  dniPaciente=@dniPaciente
	--CARGA ESTUDIO
	INSERT INTO [dbo].[Estudio]
           ([fechaConsulta]
           ,[peso]
           ,[talla]
           ,[motivoConsulta]
           ,[diagnostico]
           ,[dniMedico])
     VALUES
           ( 
            GETDATE()--fecha actual.
           ,@peso
           ,@talla 
           ,@motivoConsulta 
           ,@diagnostico
           ,@dniMedico)
	----CARGA RECETA
		INSERT INTO [dbo].[Receta]
				   ([medicamento]
				   ,[instruccionesAlPaciente]
				   ,[instruccionesALaFarmacia]
				   ,[idEstudio]
				   ,[dniPaciente])
			 VALUES
				   ( 
					@medicamento 
				   ,@instruccionesAlPaciente 
				   ,@instruccionesALaFarmacia 
				   ,(SELECT MAX(idEstudio)  FROM Estudio)--se incrusta el ultimo idEstudio regitrado.
				   ,@dniPaciente )
END TRY  
BEGIN CATCH  
		SELECT  ERROR_MESSAGE() AS [Mensaje de Error]; 
END CATCH
GO
 
EXEC registrarPlanillaPaciente '34326587','','','','','','','','',''
 
 
--registrar asistencia de paciente a turno.

ALTER PROCEDURE registrarAsistenciaATurno(@dniPaciente VARCHAR(8),@asistencia BIT)
AS
BEGIN TRY
IF NOT EXISTS (SELECT dniPaciente FROM turno WHERE dniPaciente=@dniPaciente)
BEGIN
	RAISERROR('El paciente ingresado no existe en la BBDD',14,1)
END
ELSE
BEGIN
	UPDATE [dbo].[turno]
	   SET [asistencia] =@asistencia
	 WHERE dniPaciente=@dniPaciente
END
END TRY
BEGIN CATCH  
		DECLARE @ErrorMessage NVARCHAR(100);
		SELECT  @ErrorMessage = ERROR_MESSAGE()

		RAISERROR ( @ErrorMessage,14,1); 
END CATCH

EXEC registrarAsistenciaATurno '123123123','0'

--registrarPlanillaPaciente
ALTER PROCEDURE registrarPlanillaPaciente(@dniPaciente VARCHAR(8),@dniMedico VARCHAR(8),
 @talla FLOAT,@peso FLOAT,@motivoConsulta VARCHAR(80),
 @diagnostico VARCHAR(40),@medicamento VARCHAR(40),@instruccionesAlPaciente VARCHAR(80),
 @instruccionesALaFarmacia VARCHAR(80))
 AS
 BEGIN TRY   
	--CARGA ESTUDIO
	INSERT INTO [dbo].[Estudio]
           ([fechaConsulta]
           ,[peso]
           ,[talla]
           ,[motivoConsulta]
           ,[diagnostico]
           ,[dniMedico])
     VALUES
           ( 
            GETDATE()--fecha actual.
           ,@peso
           ,@talla 
           ,@motivoConsulta 
           ,@diagnostico
           ,@dniMedico)
	----CARGA RECETA
		INSERT INTO [dbo].[Receta]
				   ([medicamento]
				   ,[instruccionesAlPaciente]
				   ,[instruccionesALaFarmacia]
				   ,[idEstudio]
				   ,[dniPaciente])
			 VALUES
				   ( 
					@medicamento 
				   ,@instruccionesAlPaciente 
				   ,@instruccionesALaFarmacia 
				   ,(SELECT MAX(idEstudio)  FROM Estudio)--se incrusta el ultimo idEstudio regitrado.
				   ,@dniPaciente )
END TRY  
BEGIN CATCH  
		DECLARE @mensajeDeError VARCHAR(150);
		SET @mensajeDeError = ERROR_MESSAGE()
		raiserror(@mensajeDeError,14,1)
END CATCH  
GO

EXEC registrarPlanillaPaciente '34326587','','','','','','','','',''

--Procedimiento que filtra el estudio y receta de un paciente.
CREATE PROCEDURE filtrarEstudioYReceta(@dniPaciente VARCHAR(8))
AS
BEGIN TRY
IF NOT EXISTS (SELECT dniPaciente FROM turno WHERE dniPaciente=@dniPaciente)
BEGIN
	RAISERROR('El paciente ingresado no existe en la BBDD',14,1)
END
ELSE
BEGIN
	SELECT fechaConsulta AS [Fecha Estudio],peso,talla,motivoConsulta,diagnostico,
	medicamento,instruccionesAlPaciente,instruccionesALaFarmacia,dniPaciente
	FROM Estudio AS est INNER JOIN Receta AS res ON(res.idEstudio=est.idEstudio)
	WHERE res.dniPaciente=@dniPaciente
END
END TRY
BEGIN CATCH
		DECLARE @ErrorMessage NVARCHAR(100);
		SELECT  @ErrorMessage = ERROR_MESSAGE()
		RAISERROR ( @ErrorMessage,14,1);
END CATCH
 
EXEC filtrarEstudioYReceta '34345456'

--Procedimiento que muestra el estudio y receta de un paciente.
ALTER PROCEDURE mostrarEstudioYReceta
AS
BEGIN TRY
BEGIN
	SELECT fechaConsulta AS [Fecha Estudio],peso,talla,motivoConsulta,diagnostico,
	medicamento,instruccionesAlPaciente,instruccionesALaFarmacia,dniPaciente
	FROM Estudio AS est INNER JOIN Receta AS res ON(res.idEstudio=est.idEstudio)
END
END TRY
BEGIN CATCH
	    DECLARE @ErrorMessage  VARCHAR(100);
		SELECT  @ErrorMessage = ERROR_MESSAGE()
		RAISERROR ( @ErrorMessage,14,1);
END CATCH
 
 
EXEC mostrarEstudioYReceta 


--Notificaciones de inasistencias a turno de pacientes.Se filtra
--solo los paciente que hayan falta >=4 veces.
GO
ALTER PROCEDURE notificaciones
AS
SELECT dniPaciente,COUNT(*) AS Inasistencias
FROM turno
WHERE asistencia IS NULL
GROUP BY dniPaciente 
HAVING COUNT(*)>=4
GO

EXEC notificaciones

--Mostrar pacientes con inasistencias. Si no existe ninguna
--persona con inasistencias >=4, se lanza un error.
 ALTER PROCEDURE mostararPacientesAusentes
 AS
 BEGIN TRY
	  DECLARE @maximoValor INT
	  SELECT TOP 1 @maximoValor=COUNT(*)  
	  FROM turno
	  WHERE asistencia IS NULL
	  GROUP BY dniPaciente 
	  ORDER BY COUNT(asistencia)  asc;
	  IF(@maximoValor)<4
		 RAISERROR('NO EXISTE PACIENTES CON INASISTENCIAS',14,1)
	  ELSE 
		  SELECT dniPaciente,COUNT(*) Inasistencias 
		  FROM turno
		  WHERE asistencia IS NULL
		  GROUP BY dniPaciente 
		  HAVING COUNT(*)>=4
 END TRY
 BEGIN CATCH
	DECLARE @mensajeDeError VARCHAR(100)
	SET @mensajeDeError=ERROR_MESSAGE()
	RAISERROR(@mensajeDeError,14,1)
 END CATCH
 
EXEC mostararPacientesAusentes
 
  


 
