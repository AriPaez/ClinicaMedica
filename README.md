# Sistema Médico
#### Usuarios del Sistema
1. Administrador
2. Médicos

###### Acciones del Administrador
1. Crear cuenta de Administrador.
2. Login con dni y contraseña.
3. Realiza registro de pacientes.
4. Asignar turno a pacientes. Para ello, verifica la existencia de pacientes y
especialidades disponibles.
5. La clínica posee consultorios y laboratorios donde se realizan
los estudios y es por ello que el administrativo debería poder asignarle a los
distintos turnos el consultorio/laboratorio donde va a brindarse la atención,
fecha de inicio y hora de finalización, paciente y el médico que la brindará.
6. Asignar sobre turno al paciente.
7. Al administrativo se le muestra un mensaje de alerta de que al registrarse una cantidad determinada de inasistencias de algún
paciente, se genera automáticamente un evento para que pueda llamarlo.

###### Acciones del Médico

1. Crear cuenta de médico.
2. Login con dni y contraseña.
3. Registrar asistencia de paciente en su turno correspondiente.
4. Cargar estudios a pacientes. Los estudios no tienen asociados medicamentos a recetar. Los estudios son realizados en una única fecha, por lo que para acreditar la participación es necesaria solamente la asistencia en esa fecha y
hora.
5. Cargar recetas a pacientes. 
6. Los médicos poseen una sola especialidad.


###### Clínica Médica

1. La clínica médica posee área médicas.
2. Las áreas médicas poseen especialidades.
3. Las áreas médicas poseen un coordinador médico.
