package com.mycompany.proyectoparte1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GestorSubastas {

    private List<Subasta> subastas = new ArrayList<>();

    public String crearSubasta(Usuario creador, double precio, List<Objeto> objs) {

        if (creador instanceof Moderador)
            return "Moderador no puede crear subastas";

        if (objs == null || objs.isEmpty())
            return "Debe agregar objetos";

        Subasta s = new Subasta(LocalDateTime.now().plusDays(1), creador, precio);
        s.getObjetos().addAll(objs);

        subastas.add(s);
        return "Subasta creada";
    }

    public List<Subasta> getSubastas() {
        return subastas;
    }
}