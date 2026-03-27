package com.mycompany.proyectoparte1;
import java.time.*;
import java.util.Objects;

public class Objeto {

    private String nombre;
    private String descripcion;
    private String estado;
    private LocalDate fechaCompra;

    public Objeto() {}

    public Objeto(String nombre, String descripcion, String estado, LocalDate fechaCompra) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCompra = fechaCompra;
    }

    @Override
    public String toString() {
        return nombre + " (" + estado + ")";
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Objeto obj) && nombre.equals(obj.nombre);
    }
}