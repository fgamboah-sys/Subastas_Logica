package com.mycompany.proyectoparte1;
public class Oferta {

    private Coleccionista oferente;
    private double precio;

    public Oferta() {}

    public Oferta(Coleccionista oferente, double precio) {
        this.oferente = oferente;
        this.precio = precio;
    }

    public Coleccionista getOferente() { return oferente; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return oferente + " ofertó: " + precio;
    }
}