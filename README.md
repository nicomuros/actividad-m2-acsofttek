# Descripción

Este proyecto fue realizado como presentación de la **Actividad M2** de la **Academia Java + Springboot**, dictada por **Softtek** en conjunto con la **Universidad Siglo-XXI**. El objetivo del proyecto fue desarrollar una aplicación tipo Todo-List que impelemente un filtrado de datos, y luego desarrollar un diagrama de flujo de dicha aplicación.

# Instalación
## Dependencias
Para poder ejecutar el proyecto es necesario tener instaladas y configuradas las siguientes dependencias: 

* **[Maven 3.9+](https://maven.apache.org/download.cgi)** 
* **[JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)**
* **[Git](https://git-scm.com/downloads)**

Es importante tener configuradas las variables de entorno `JAVA_HOME` `MAVEN_HOME`, junto con sus `PATH` para ejecutar correctamente el empaquetado y la iniciación de la aplicación. 

## Instalación
Siga estos pasos para instalar la aplicación:

1. Clonar el repositorio desde GitHub al sistema local. Puedes hacerlo utilizando Git y ejecutando el siguiente comando en tu terminal:

`git clone https://github.com/nicomuros/actividad-m2-acsofttek.git`

2. Navegar al directorio de la aplicación:

`cd actividad-m2-acsofttek`

3. Utilizar Maven para compilar y construir la aplicación. Para ello, ejecutar el siguiente comando:

`mvn clean package`

Esto compilará el proyecto y creará un archivo JAR ejecutable en la carpeta "target".

4. Ejecuta la aplicación JAR con el siguiente comando, reemplazando "nombre-del-archivo.jar" con el nombre real del archivo JAR generado:

`java -jar nombre-del-archivo.jar`

La aplicación se ejecutará y podrás interactuar con ella a través de la línea de comandos.

## Arquitectura de la Aplicación

La aplicación sigue una arquitectura que divide la funcionalidad en diferentes capas con responsabilidades específicas. 
Las capas principales son:

1. **Capa de Presentación**
    - Ubicación: `com.softtek.m2.vista`
    - Intefaz: `TareaVista`
    - Descripción: La capa de presentación se encarga de la interfaz de usuario y la interacción directa con el usuario.
      Esta capa provee una interfaz de línea de comandos a través de la clase `TareaVistaImpl`, la cual permite a los 
      usuarios interactuar con la aplicación mediante un menú basado en texto en la consola. `TareaVistaImpl` muestra un 
      menú interactivo que presenta opciones para mostrar tareas, agregar tareas, modificar tareas, eliminar tareas y 
      salir de la aplicación.

    - Para realizar estas operaciones, `TareaVistaImpl` llama a métodos de la intefaz `TareaServicio` 
      correspondientes a cada opción del menú. Esto permite a los usuarios gestionar tareas sin 
      necesidad de conocer los detalles de implementación subyacentes. 


2. **Capa de Servicio**
    - Ubicación: `com.softtek.m2.servicio`
    - Intefaz: `TareaServicio`
    - Descripción: La capa de lógica de negocio contiene la lógica central de la aplicación. 
   Aquí se procesan y gestionan los datos. Interactúa con la capa de persistencia 
   de datos para realizar operaciones CRUD a partir de la interfaz `TareaServicioImpl`. También maneja excepciones y errores. 
  


3. **Capa de Persistencia de Datos (Repositorio)**
    - Ubicación: `com.softtek.m2.repositorio`
    - Intefaz: `TareaRepositorio`
    - Descripción: La capa de persistencia de datos se encarga de la gestión de datos y la interacción con el 
   almacenamiento. En este caso, `TareaRepositorioImpl` utiliza una lista en memoria para almacenar tareas, especificamente,
   almacena una lista de objetos `Tarea`. Proporciona métodos para agregar, consultar, 
   modificar y eliminar registros.


4. **Capa de Modelos**
    - Ubicación: `com.softtek.m2.modelo`
    - Descripción: La capa de modelos contiene la clase que representa el modelo de la aplicación. Aquí se encuentra el
    modelo `Tarea` que se encarga de representar el tipo de dato que la aplicación usa. 

## Diagramas
### Diagrama de clases
El siguiente diagrama muestra la relación que existe entre las distintas clases del proyecto, apoyandose en la arquitectura
de capas que se describió previamente:

![](https://github.com/nicomuros/actividad-m2-acsofttek/blob/main/diagramas/Diagrama%20de%20clases.png?raw=true)
### Diagrama de flujo
El siguiente diagrama muestra el proceso desde que el usuario ingresa a la aplicación, hasta que ingresa una tarea en el
repositorio.

![](https://github.com/nicomuros/actividad-m2-acsofttek/blob/main/diagramas/Diagrama%20de%20flujo%20(agregar%20tarea).png?raw=true)
