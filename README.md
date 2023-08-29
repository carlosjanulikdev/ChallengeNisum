# ChallengeNisum

### Evaluación: JAVA

Desarrolle una aplicación que exponga una API RESTful de creación de usuarios. <br/>
Todos los endpoints deben aceptar y retornar solamente JSON, inclusive al para los mensajes de error.
Todos los mensajes deben seguir el formato: <br/>

```json
{"mensaje": "mensaje de error"}
```
<br/>

### Registro
<ul>
<li>Ese endpoint deberá recibir un usuario con los campos "nombre", "correo", "contraseña",
más un listado de objetos "teléfono", respetando el siguiente formato:<br/>

```json
{
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.org",
    "password": "hunter2",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        }
    ]
}
```
</li>
<li> Responder el código de status HTTP adecuado</li>
<li> En caso de éxito, retorne el usuario y los siguientes campos:
○ id: id del usuario (puede ser lo que se genera por el banco de datos, pero sería
más deseable un UUID)<br/>
○ created: fecha de creación del usuario<br/>
○ modified: fecha de la última actualización de usuario<br/>
○ last_login: del último ingreso (en caso de nuevo usuario, va a coincidir con la fecha de creación)<br/>
○ token: token de acceso de la API (puede ser UUID o JWT)<br/>
○ isactive: Indica si el usuario sigue habilitado dentro del sistema.
</li>
<li> Si caso el correo conste en la base de datos, deberá retornar un error "El correo ya registrado".</li>
<li> El correo debe seguir una expresión regular para validar que formato sea el correcto.(aaaaaaa@dominio.cl)</li>
<li> La clave debe seguir una expresión regular para validar que formato sea el correcto. (El
valor de la expresión regular debe ser configurable) </li>
<li> El token deberá ser persistido junto con el usuario</li>
</ul>

### Requisitos
<ul>
<li> Plazo: 2 días, si tienes algún inconveniente con el tiempo comunicate con nosotros</li>
<li> Banco de datos en memoria. Ejemplo: HSQLDB o H2.</li>
<li> Proceso de build vía Gradle o Maven.</li>
<li> Persistencia con JPA. Ejemplo: EclipseLink, Hibernate u OpenJPA.</li>
<li> Framework SpringBoot.</li>
<li> Java 8+</li>
<li> Entrega en un repositorio público (github o bitbucket) con el código fuente y script de creación de BD.</li>
<li> Readme explicando cómo probarlo.</li>
<li> Diagrama de la solución.</li>
</ul>

### Requisitos opcionales
<ul>
<li> JWT como token </li>
<li> Pruebas unitarias </li>
<li> Swagger</li>
</ul>

<hr/>

#### Configuración de entorno local
<ul>
<li> Clonar el proyecto: $ git clone https://github.com/carlosjanulikdev/ChallengeNisum.git</li>
<li> Ir al directorio del proyecto clonado ($ cd ChallengeNisum)</li>
<li> Correr el proyecto: $ mvn spring-boot:run o levantar graficamente desde un IDE mediante run sobre la clase: com.challenge.nisum.NisumApplication. Está configurado para que levante en el puerto 5000.</li>
<li> La documentación de la API se encuentra en Swagger (se podrá testear desde allí si se desea): http://localhost:5000/swagger-ui/index.html</li>
<li> El diagrama de la solución se encuentra en "resources/ModelChallengeNisum.jpg"</li>
</ul>

