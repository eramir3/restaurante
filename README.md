# Restaurante
Restaurante la mejor cocina prueba conexa

# Caracteristicas del Proyecto
El proyecto fue creado bajo las siguientes caracteristicas:
  - Front-end: Thymeleaf y Ajax
  - Back-end: Java Spring Boot con manejo de dependencias
  - Bases de Datos: Postgresql
  - ORM: Hibernate
  - Arquitectura REST
  - Patron de diseño DAO y servicios
  - Maven

# Pasos para importar la aplicacion
1. Importarla en un IDE (ej. Eclipse) como un proyecto Maven
2. Crear base de datos con el nombre de restaurante
3. En el archivo application.properties indicar la ip y el puerto de conexion de la base de datos. Por defecto esta 

spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/restaurante

4. Correr la aplicacion como una Java Application en Eclipse. Esta se correra bajo la URL localhost:8080
5. Correr el archivo inserts.sql para ingresar la informacion de las entidades que hacen parte de la aplicacion (mesas, camareros, cocineros, etc.)
6. Interactuar con la aplicacion

# Pasos para desplegar la aplicacion
1. Se creo el archivo lamejorcocina.war
2. Se debe crear la base de datos y correr los scripts como se menciona en el paso anterior.
2. El archivo debe ser cargado en un servidor, por ejemplo tomcat y bajo la url localhost:8080/lamejorcocina/clientes/list comprobar que funcionamiento de la misma
3. En el archivo .war adjunto en el archivo application.properties se encuentra la linea 

spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/restaurante

Que indica la ip, el puerto y el nombre de la base de datos por defecto
4. La URL de la aplicacion es localhost:8080/lamejorcocina/clientes/list


# Uso de la aplicacion
La aplicacion cuenta con 4 menus: 
1. El primero es Registrar factura donde se puede registrar la factura relacionada a un cliente. Es necesario haber cargado los scripts del archivo inserts.sql para poder ver correctamente las listas de lo cocineros, camareros y mesas. Al crear una factura se crea un nuevo cliente por defecto.
2. El segundo menu es la creacion de clientes. Estos clientes no son necesarios para crear las facturas.
3. El tercer menu es el de consulta clientes, el cual muestra los clientes que han gastado mas de 100,000 pesos al realizar un pedido.
4. El cuarto menu es consulta camareros el cual muestra el total facturado de los camareros para el 2019. Para una correcta funcionalidad de esta consulta no se deben realizar facturas con fechas diferentes a las del año en curso.
