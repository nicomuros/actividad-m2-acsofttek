package com.softtek.m2;
import com.softtek.m2.vista.TareaVistaImpl;
import com.softtek.m2.vista.TareaVista;

public class Main {
    public static void main(String[] args) {

        // Instancia de la capa de vista
        TareaVista vista = new TareaVistaImpl();

        // Se inicia la interfaz al mostrar el menú
        vista.mostrarMenu();
    }
}