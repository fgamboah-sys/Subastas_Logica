package com.mycompany.proyectoparte1;

import java.time.LocalDate;

public class Vendedor extends Usuario {

    private double puntuacion;
    private String direccion;

    public Vendedor() {}

    public Vendedor(String n, String id, LocalDate f, String p, String c, double punt, String dir) {
        super(n,id,f,p,c);
        this.puntuacion = punt;
        this.direccion = dir;
    }
}