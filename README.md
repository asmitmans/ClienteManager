# ClienteManager - Sistema de Gestión de Clientes

## Descripción del Proyecto
ClienteManager es una aplicación desarrollada en Java para la gestión de
clientes de la pastelería ficticia "Bon Bon Jovi". Este sistema permite
realizar operaciones CRUD sobre los clientes, así como la importación y
exportación de datos en formato CSV o TXT. El proyecto fue diseñado para
demostrar conocimientos en programación orientada a objetos, manejo de
archivos y pruebas unitarias con JUnit.


## Características
- **Listar clientes**: Muestra una lista de todos los clientes con su estado
  (Activo/Inactivo).
- **Agregar cliente**: Permite registrar nuevos clientes con sus datos.
- **Editar cliente**: Permite modificar datos o cambiar el estado de los
  clientes.
- **Cargar datos**: Importa información de clientes desde un archivo CSV.
- **Exportar datos**: Exporta la información de los clientes a un archivo CSV
  o TXT.
- **Menú interactivo**: Navegación por las distintas opciones a través de un
  menú en consola.


## Tecnologías Utilizadas
- **Java**: Lenguaje de programación utilizado para construir la lógica de la
  aplicación.
- **Git y GitHub**: Para el control de versiones y la colaboración en el código.
- **JUnit**: Herramienta de testing para pruebas unitarias.
- **Java Streams**: Utilizado para manejar colecciones de datos de manera
  eficiente.


## Instalación y Uso
1. Clona este repositorio:
   ```bash
   git clone https://github.com/asmitmans/ClienteManager.git
   ```
2. Importa el proyecto en Eclipse.
3. Ejecuta la clase Main para iniciar la aplicación.


## Estructura del Proyecto
- `src/main`: Contiene la clase `Main` para ejecutar el sistema.
- `src/modelo`: Contiene las clases que representan los modelos de datos, como 
  `Cliente`.
- `src/servicio`: Contiene la lógica de negocio para gestionar los clientes y 
  archivos.
- `src/vista`: Maneja la interacción con el usuario a través de un menú en 
  consola.

## Requisitos
- **Java 8+**: Para ejecutar el código.
- **Eclipse**: Para importar y gestionar el proyecto.


## Autor
Este proyecto fue desarrollado por [Agustin Smitmans](https://github.com/asmitmans) 
como parte de un desafío técnico en Java.


