package com.softtek.m2.repositorio;

import com.softtek.m2.modelo.Tarea;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * La clase TareaRepositorioImpl implementa la interfaz TareaRepositorio y proporciona un repositorio de tareas en memoria.
 */
public class TareaRepositorioImpl implements TareaRepositorio {

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
        return listaDeTareas.stream()
                .filter(t -> t.getId().equals(tareaId))
                .findFirst();
    }

    @Override
    public void modificarTarea(Tarea tarea) {
        for (int i = 0; i < listaDeTareas.size(); i++) {
            if (listaDeTareas.get(i).getId().equals(tarea.getId())) {
                listaDeTareas.set(i, tarea);
                return;
            }
        }
    }

    @Override
    public void eliminarTareaPorId(Integer tareaId) {
        listaDeTareas.removeIf(t -> t.getId().equals(tareaId));
    }
}
