# Foro Hub Challenge - Back End
Este proyecto fue desarrollado para el programa educativo de Oracle ONE en la plataforma de Alura para el curso de Java y Spring Framework G7 - ONE, donde se reforzaron los conocimientos sobre el lenguaje de programación Java, se aprendió sobre Spring Framework, persistencia de datos, consultas con Spring Data JPA, desarrollo de una API REST, Spring Security (JWT, autenticación y autorización), documentación de APIs y bases para el testing de una aplicación. El proyecto desarrollado se encarga ofrecer información sobre los tópicos creados mediante peticiones HTTP GET, permitir la creación de nuevos tópicos mediante peticiones HTTP POST, permitir la actualización de tópicos mediante peticiones HTTP PUT y, finalmente, permite eliminar tópicos mediantes peticiones HTTP DELETE. Además, el proyecto utiliza JWT para autenticar y autorizar las solicitudes HTTP expuestas por la API.
## Descripción del desafío
### Funciones disponibles
1. Iniciar sesión
2. Crear un nuevo tópico
3. Mostrar todos los tópicos creados
4. Mostrar un tópico específico
5. Actualizar un tópico
6. Eliminar un tópico
### Funciones extra
1. Documentación: se implementó Springdoc Swagger para documentar la API desarrollada. Swagger es una herramienta que ofrece una interfaz amigable y accesible, así como una forma de documentación automática generada simultáneamente con el desarrollo de la API.
## Prerrequisitos y recomendaciones
Antes de usar el proyecto y debido a que no está pensado para un usuario final determinado, se debe tener instalado como mínimo la versión 21 de JDK (Java Development Kit), algún IDE o herramienta de desarrollo y algún sistema gestor de bases de datos (SGBD). Se recomienda usar el IDE IntelliJ IDEA (IDE usado para desarrollar este proyecto) y el gestor de bases de datos MySQL (gestor utilizado para este proyecto). En caso de no usar MySQL, se deberá instalar el driver correspondiente y realizar los cambios respectivos.
## Instrucciones de uso
Para hacer uso de este proyecto se debe seguir los siguientes pasos:
1. Clonar o descargar el repositorio del proyecto
2. Descomprimir el archivo descargado (en caso de haber descargado el repositorio)
3. Abrir el proyecto en un IDE (Entorno de Desarrollo Integrado) o herramienta de desarrollo
4. Configurar las variables de entorno con los nombres de acuerdo con los definidos en el archivo "application.properties" y asignar los respectivos valores de cada variable para una correcta conexión con la base de datos
5. Se debe crear al menos un usuario en la base de datos para la autenticación y generación de JWT para la autorización de las peticiones HTTP en los demás endpoints
## Notas
Para conocer los endpoints disponibles y lo necesario para hacer uso de ellos existen dos formas:
1. Documentación de la API con Swagger UI se encuentra en la URL "http://server:port/swagger-ui/index.html"
2. Documentación de la API en formato JSON se encuentra en la URL "http://server:port/v3/api-docs"
## Autor
Santiago Jair Torres Rivera
