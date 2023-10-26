package com.softtek.m2.vista;

import com.softtek.m2.modelo.Tarea;
import com.softtek.m2.servicio.TareaServicio;
import com.softtek.m2.servicio.TareaServicioImpl;

import java.util.Scanner;

/**
 * La clase TareaVistaImpl proporciona una interfaz de línea de comandos para interactuar con el sistema de gestión de tareas.
 * Permite al usuario realizar operaciones como ver tareas, agregar tareas, modificar tareas y eliminar tareas.
 */
public class TareaVistaImpl implements TareaVista{

    // Dependencias
    Scanner entrada = new Scanner(System.in);
    TareaServicio servicio = new TareaServicioImpl();

    /**
     * Muestra el menú principal de la aplicación y gestiona la interacción del usuario.
     * Además, agrega una primer tarea
     */
    public void mostrarMenu(){

        System.out.println("\n\n~~ TODO List ~~");
        servicio.agregarTarea("Primer tarea"); // Primer tarea

        boolean continuar = true; // Variable de control de flujo
        do {
            System.out.print("""
                    \nMenú:
                    1: Mostrar tareas.
                    2: Agregar una tarea.
                    3: Modificar una tarea.
                    4: Eliminar una tarea.
                    0: Salir.
                    Elija una opción:""");

            // Se captura el input del usuario
            String userInputOpcion = entrada.nextLine();

            // Se decide que camino seguir acore a la elección del usuario
            switch (userInputOpcion) {
                case "1":
                    mostrarTareas();
                    break;
                case "2":
                    agregarTarea();
                    break;
                case "3":
                    modificarTarea();
                    break;
                case "4":
                    eliminarTarea();
                    break;

                    // Se cierra el programa
                case "0":
                    System.out.println("Muchas gracias por usar la aplicación! \nAutor: Nicolás Muros");
                    continuar = false;
                    break;

                    // Cuando se ingresa un dato no válido como opción, se muestra un mensaje de error
                default:
                    System.out.println("\nERROR: Ingrese una opción correcta.");
            }
        } while (continuar);
    }

    /**
     * Muestra la lista de tareas activas en la consola.
     */
    private void mostrarTareas(){
        System.out.println("\nTareas activas:");

        // Solicitud al servicio de la lista de tareas. Se recorre y se muestran en consola
        servicio.obtenerTareas()
                .forEach((t) -> System.out.println(
                        "ID: " + t.getId() + ", Descripción: " + t.getDescripcion() + "."));
    }

    /**
     * Permite al usuario agregar una nueva tarea a través de la consola.
     * Se manejan excepciones en caso de errores.
     */
    private void agregarTarea(){
        System.out.print("\nIngrese la descripción de la nueva tarea: ");
        try {

            // Se captura la descripción
            String descripcion = entrada.nextLine();

            // Se envía la descripción al servicio para que cargue la tarea en el repositorio
            servicio.agregarTarea(descripcion);
        } catch (Exception e){
            mostrarError(e);
        }
    }

    /**
     * Permite al usuario modificar una tarea existente a través de la consola.
     * Se manejan excepciones en caso de errores.
     */
    private void modificarTarea(){
        System.out.println("\nIngrese el ID de la tarea que quiere modificar");
        try {
            // Captura del ID
            Integer tareaId = Integer.parseInt(entrada.nextLine());

            // Se recupera la tarea original
            Tarea tarea = servicio.obtenerTareaPorId(tareaId);

            // Se muestra al usuario la tarea original
            System.out.println("Tarea a modificar: ID: " +
                    tarea.getId() + ", Descripción: " + tarea.getDescripcion() + ".");

            // Captura de la nueva descripción
            System.out.print("Ingrese la nueva descripción: ");
            String descripcion = entrada.nextLine();

            // Se solicita al servicio modificar la tarea
            servicio.modificarTarea(descripcion, tareaId);

            // Se recupera la tarea ya modificada y se muestra en pantalla
            Tarea tareaActualizada = servicio.obtenerTareaPorId(tareaId);
            System.out.println("Tarea modificada exitosamente: ID: " +
                    tareaActualizada.getId() + ", Descripción: " + tareaActualizada.getDescripcion() + ".");
        } catch (Exception e){
            mostrarError(e);
        }
    }

    /**
     * Permite al usuario eliminar una tarea a través de la consola.
     * Se manejan excepciones en caso de errores.
     */
    private void eliminarTarea(){
        System.out.println("\nIngrese el ID de la tarea que quiere eliminar: ");
        try {

            // Se captura el id de la tarea que se desea eliminar
            Integer tareaId = Integer.parseInt(entrada.nextLine());

            // Solicitud al servicio por los datos de la tarea
            Tarea tarea = servicio.obtenerTareaPorId(tareaId);
            System.out.println("Tarea a eliminar: ID: " + tarea.getId() + ", Descripción: " + tarea.getDescripcion() + ".");

            // Solicitud al servicio de eliminar la tarea
            servicio.eliminarTarea(tareaId);
            System.out.println("Tarea eliminada exitosamente.");
        } catch (Exception e){
            mostrarError(e);
        }
    }

    /**
     * Muestra un mensaje de error en la consola.
     *
     * @param error La excepción que ha ocurrido.
     */
    private void mostrarError(Exception error){
        System.out.println("\nERROR: " + error.getMessage());
    }
}
