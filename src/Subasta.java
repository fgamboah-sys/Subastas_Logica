package com.mycompany.proyectoparte1;
import java.time.LocalDateTime;
import java.util.*;

public class Subasta {

    private LocalDateTime fechaVencimiento;
    private Usuario creador;
    private double precioMinimo;
    private List<Objeto> objetos;
    private List<Oferta> ofertas;

    public Subasta() {
        objetos = new ArrayList<>();
        ofertas = new ArrayList<>();
    }

    public Subasta(LocalDateTime fecha, Usuario creador, double precio) {
        this();
        this.fechaVencimiento = fecha;
        this.creador = creador;
        this.precioMinimo = precio;
    }

    public Usuario getCreador() { return creador; }
    public double getPrecioMinimo() { return precioMinimo; }
    public List<Objeto> getObjetos() { return objetos; }
    public List<Oferta> getOfertas() { return ofertas; }

    @Override
    public String toString() {
        return "Subasta de " + creador + " | mínimo: " + precioMinimo;
    }
}