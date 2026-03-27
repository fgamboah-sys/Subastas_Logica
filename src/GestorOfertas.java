package com.mycompany.proyectoparte1;
import java.util.ArrayList;
import java.util.List;

public class GestorOfertas {

    private final List<Oferta> ofertas = new ArrayList<>();

    public String crearOferta(Subasta s, Usuario u, double precio) {

        if (!(u instanceof Coleccionista))
            return "Solo coleccionistas pueden ofertar";

        if (s.getCreador().equals(u))
            return "No puede ofertar en su propia subasta";

        if (precio < s.getPrecioMinimo())
            return "Precio menor al mínimo";

        Oferta o = new Oferta((Coleccionista) u, precio);
        s.getOfertas().add(o);
        ofertas.add(o);

        return "Oferta creada";
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }
}