#  Gestor de Puntos con Spring Boot y Google Maps

##  Descripción
Proyecto de **aplicación web con Spring Boot** que permite insertar, listar y eliminar puntos geográficos (latitud y longitud).  
Cada punto se almacena en una base de datos y puede visualizarse en un mapa interactivo mediante la **Google Maps JavaScript API**.

---

##  Funcionalidades principales
-  Insertar puntos con latitud y longitud.
-  Listar todos los puntos guardados en la base de datos.
-  Eliminar puntos de la lista.
-  Mostrar en el mapa las coordenadas del punto seleccionado mediante un marcador.

---

## 🔑 Configuración de la API de Google Maps

Para que el mapa funcione correctamente, cada usuario debe **reemplazar la clave de la API** en el archivo HTML de la aplicación:

```html
<script async src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY_HERE&callback=initMap"></script>
```

- **Crea tu propia API Key en Google Cloud Console**
- **Reemplaza YOUR_API_KEY_HERE con tu clave personal**
- **Guarda los cambios y ejecuta la aplicación**

---

##  Tecnologías utilizadas
- **Java 24**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **HTML / CSS / JavaScript**
- **Google Maps JavaScript API**
- **Docker & Docker Compose**

---

## 🗄️ Configuración de la base de datos
Edita el archivo `application.properties` con tus credenciales locales de MySQL (si no usas Docker):

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/puntosdb
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update 
```

## Ejecutar con Docker

```
docker-compose build
docker-compose up --build
```

---

## Autor

Josep Llopis – [GitHub](https://github.com/josepllopis)

---

## Licencia

MIT

