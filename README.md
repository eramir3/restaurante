# Restaurante
Restaurante la mejor cocina prueba conexa

# Caracteristicas del Proyecto
El proyecto fue creado bajo las siguientes caracteristicas:
  - Front-end: Thymeleaf
  - Back-end: Java Spring Boot
  - Bases de Datos: Postgresql
  - ORM: Hibernate
  - Arquitectura REST
  - Patron DAO y servicios

# Pasos para importar la aplicacion
1. Importarla en un IDE i.e Eclipse
2. Crear base de datos con el nombre de restaurante
3. En el archivo application.properties indicar la ip y el puerto de conexion de la base de datos
4. Correr la aplicacion como una Java Application en Eclipse
5. Correr el archivo inserts.sql para ingresar informacion de los entidades que hace parte de la aplicacion (mesas, camareros, cocineros, etc.)
6. Interactuar con la aplicacion

# Pasos para desplegar la aplicacion
1. Se creo el archivo lamejorcocina.war
2. El archivo debe ser cargado en un servidor, por ejemplo tomcat y bajo la url localhost:8080/lamejorcocina/clientes/list comprobar que funcionamiento de la misma
3. En el archivo .war adjunto en el archivo application.properties se encuentra la linea 

spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/restaurante

Que indica la ip, el puerto y el nombre de la base de datos por defecto
