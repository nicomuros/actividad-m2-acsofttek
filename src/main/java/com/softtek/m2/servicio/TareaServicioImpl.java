package com.softtek.m2.servicio;

import com.softtek.m2.excepciones.DatosInvalidosException;
import com.softtek.m2.excepciones.RecursoNoEncontradoException;
import com.softtek.m2.modelo.Tarea;
import com.softtek.m2.repositorio.TareaRepositorio;
import com.softtek.m2.repositorio.TareaRepositorioImpl;

import java.util.List;

/**
 * La clase TareaServicioImpl implementa la interfaz TareaServicio y proporciona métodos para gestionar tareas.
 */
public class TareaServicioImpl implements TareaServicio{
    TareaRepositorio repositorio = new TareaRepositorioImpl();

    /**
     * Agrega una nueva tarea con la descripción especificada.
     *
     * @param descripcion La descripción de la tarea a agregar.
     * @throws DatosInvalidosException Si la descripción está vacía.
     */
    public void agregarTarea(String descripcion){
        if (descripcion.isEmpty()) throw new DatosInvalidosException("Debe proporcionar una descripcion.");

        Tarea nuevaTarea = new Tarea(descripcion);
        repositorio.agregarTarea(nuevaTarea);
    }

    /**
     * Obtiene una lista de todas las tareas activas.
     *
     * @return Lista de tareas activas.
     */
    public List<Tarea> obtenerTareas(){
        return repositorio.seleccionarTodasLasTareas();
    }

    /**
     * Obtiene una tarea por su ID.
     *
     * @param tareaId El ID de la tarea a obtener.
     * @return La tarea correspondiente al ID.
     * @throws RecursoNoEncontradoException Si no se encuentra una tarea con el ID especificado.
     */
    public Tarea obtenerTareaPorId(Integer tareaId){
        return repositorio.seleccionarTareaPorId(tareaId)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró una tarea con el id: " + tareaId));
    }

    /**
     * Modifica una tarea existente con una nueva descripción.
     *
     * @param descripcion La nueva descripción de la tarea.
     * @param tareaId El ID de la tarea a modificar.
     * @throws DatosInvalidosException Si la descripción está vacía.
     * @throws RecursoNoEncontradoException Si no se encuentra una tarea con el ID especificado.
     */
    public void modificarTarea(String descripcion, Integer tareaId){
        Tarea tarea = repositorio.seleccionarTareaPorId(tareaId)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró una tarea con el id: " + tareaId));

        boolean tareaActualizada = false;

        if (descripcion.isEmpty()) throw new DatosInvalidosException("Debe proporcionar una descripción");

        if (!tarea.getDescripcion().equals(descripcion)){
            tarea.setDescripcion(descripcion);
            tareaActualizada = true;
        }

        if (!tareaActualizada){
            throw new DatosInvalidosException("No se actualizó la tarea con id: " + tareaId + ", no hay diferencia en los datos");
        }

        repositorio.modificarTarea(tarea);
    }

    /**
     * Elimina una tarea por su ID.
     *
     * @param tareaId El ID de la tarea a eliminar.
     * @throws RecursoNoEncontradoException Si no se encuentra una tarea con el ID especificado.
     */
    public void eliminarTarea(Integer tareaId){
        if (!repositorio.existeTareaPorId(tareaId)) throw new RecursoNoEncontradoException("No se encontró una tarea con el id: " + tareaId);
        repositorio.eliminarTareaPorId(tareaId);
    }
}
