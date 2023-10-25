package com.softtek.m2;
import com.softtek.m2.vista.TareaVistaImpl;
import com.softtek.m2.vista.TareaVista;

public class Main {
    public static void main(String[] args) {
        TareaVista vista = new TareaVistaImpl();
        vista.mostrarMenu();
    }
}