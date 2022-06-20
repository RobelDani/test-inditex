# test-inditex

Prueba para inditex

## Precondiciones

Como primer paso necesitas instalar Java JDK 11 o 8, Apache Maven 3.3.9 o superior y GIT.

Crear una carpeta en la ubicación deseada, como consejo, crear en "C:/Proyectos".

Pulsar la tecla shift + botón derecho del ratón dentro de la carpeta creada haga clic para abrir una consola de
comandos "Open command windows here".
Escriba en la consola el siguiente comando:

* git clone https://github.com/RobelDani/test-inditex.git

Después de descargar el proyecto

Abra el proyecto en IDE (preferiblemente Intellij IDEA) y seleccione el proyecto descargado "test-inditex".

Ejecute el siguiente comando para compilar el proyecto.

```bash
mvn clean install
```

# Arrancar proyecto

Para ejecutar la API, se debe ejecutar el siguiente comando en el directorio 'engine' dentro del proyecto:

* mvn spring-boot:run

O ejecute Class Application.class en su servidor IDE o copie engine-[versión].jar en su servidor Tomcat

# Consultar BBDD

Se ha creado una base de datos en memoria con H2 y para poder consultar dicha bbdd basta con poner en su navegador http:
//[serverIp]:8080/h2-console con los datos siguientes:

    Saved Settings: Generic H2 (Embedded)
    Setting Name: Generic H2 (Embedded)

    Driver Class: org.h2.Driver
    JDBC URL: jdbc:h2:mem:testdb
    User Name: sa
    Password:

# Ejemplo de prueba con Postman

Servicio de prueba Sequra URL Servicio: http://[serverIp]:8080/api/prices

El único campo obligatorio es "dateApplication".

Request

    {
        "dateApplication": "2020-06-14T10:00:00",
        "brandId": 1,
        "productId": 35455
    }

Response

    {
        "brandRS": {
            "productId": 35455,
            "brandId": 1,
            "fareApplied": 3,
            "startDate": "2020-06-15T00:00:00",
            "endDate": "2020-06-15T11:00:00",
            "totalPrice": 30.50,
            "currency": "EUR"
        }
    }

# Autor

Roberto Daniel Blanco Parra - Trabajo inicial