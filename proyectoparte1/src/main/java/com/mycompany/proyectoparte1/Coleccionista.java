package com.mycompany.proyectoparte1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Coleccionista extends Usuario {

    private double puntuacion;
    private String direccion;
    private List<Objeto> objetos;

    public Coleccionista() {
        objetos = new ArrayList<>();
    }

    public Coleccionista(String n, String id, LocalDate f, String p, String c, double punt, String dir) {
        super(n,id,f,p,c);
        this.puntuacion = punt;
        this.direccion = dir;
        this.objetos = new ArrayList<>();
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }
}