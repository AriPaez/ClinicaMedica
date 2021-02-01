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


--sobre turno de paciente
GO
ALTER PROCEDURE sobreTurno(@dniDelPaciente VARCHAR(8) ,@nuevaFecha DATE,
@nuevaHoraInicio TIME,@nuevaHoraFin TIME)
AS 
 IF NOT EXISTS (SELECT dniPaciente FROM Turno WHERE dniPaciente=@dniDelPaciente)
 BEGIN
	 PRINT('¡dniPaciente no encontrado en la BASE DE DATOS!')
	 RETURN
 END
 BEGIN 
	UPDATE Turno
	   SET [fecha]=@nuevaFecha, 
		  [horaInicio]=@nuevaHoraInicio,
		  [horaFin]=@nuevaHoraFin
	 WHERE dniPaciente=@dniDelPaciente 
 END
 GO
 ----sobre turno de paciente con try catch
ALTER PROCEDURE sobreTurno(@dniDelPaciente VARCHAR(8) ,@nuevaFecha DATE,
@nuevaHoraInicio TIME,@nuevaHoraFin TIME)
AS 
BEGIN TRY  
IF EXISTS (SELECT dniPaciente FROM Turno WHERE dniPaciente=@dniDelPaciente)
  BEGIN
  UPDATE Turno
	   SET [fecha]=@nuevaFecha, 
		  [horaInicio]=@nuevaHoraInicio,
		  [horaFin]=@nuevaHoraFin
	 WHERE dniPaciente=@dniDelPaciente 
	END
END TRY  
BEGIN CATCH  
	 
  PRINT('¡dniPaciente no encontrado en la BASE DE DATOS!')    
END CATCH

exec sobreTurno '654','24-9-1996','08:00:00.0000000','08:00:00.0000000'

---sobre turno de paciente con transacion

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

exec sobreTurno '654','24-9-1996','08:00:00.0000000','08:00:00.0000000'

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

 select*
 from Administrador

