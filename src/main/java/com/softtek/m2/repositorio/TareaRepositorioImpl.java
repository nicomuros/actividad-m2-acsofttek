package com.softtek.m2.repositorio;

import com.softtek.m2.modelo.Tarea;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * La clase TareaRepositorioImpl implementa la interfaz TareaRepositorio y proporciona un repositorio de tareas en memoria.
 */
public class TareaRepositorioImpl implements TareaRepositorio {

    // Lista de tareas, que servirá como repositorio sin persistencia de datos para la ejecución de la aplicación.
    private static final List<Tarea> listaDeTareas = new ArrayList<>();

    public TareaRepositorioImpl(){}

    @Override
    public void agregarTarea(Tarea tarea) {
        listaDeTareas.add(tarea);
    }

    @Override
    public List<Tarea> seleccionarTodasLasTareas() {
        return listaDeTareas;
    }

    @Override
    public Boolean existeTareaPorId(Integer tareaId) {
        return listaDeTareas.stream().anyMatch(t -> t.getId().equals(tareaId));
    }

    @Override
    public Optional<Tarea> seleccionarTareaPorId(Integer tareaId) {

        // Se recorre la lista. Se filtra aquellas que coincidan con el ID, y se devuelve la primera (y única)
        return listaDeTareas.stream()
                .filter(t -> t.getId().equals(tareaId))
                .findFirst();
    }

    @Override
    public void modificarTarea(Tarea tarea) {

        // Se recorre la lista
        for (int i = 0; i < listaDeTareas.size(); i++) {

            // Se busca la tarea que coincida con el id proporcionado
            if (listaDeTareas.get(i).getId().equals(tarea.getId())) {

                // Se actualiza la tarea
                listaDeTareas.set(i, tarea);

                // Se rompe el ciclo
                return;
            }
        }
    }

    @Override
    public void eliminarTareaPorId(Integer tareaId) {

        // Se recorre la lista, y se elimina aquella que coincida con el id
        listaDeTareas.removeIf(t -> t.getId().equals(tareaId));
    }
}
