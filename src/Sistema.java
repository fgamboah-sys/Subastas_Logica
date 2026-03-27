package com.mycompany.proyectoparte1;
import java.time.*;
import java.util.*;

public class Sistema {

    private List<Usuario> usuarios = new ArrayList<>();
    private List<Subasta> subastas = new ArrayList<>();
    private List<Oferta> ofertas = new ArrayList<>();

    public boolean existeModerador() {
        return usuarios.stream().anyMatch(u -> u instanceof Moderador);
    }

    public String registrarModerador(String n, String id, LocalDate f, String p, String c) {
        if (existeModerador()) return "Ya existe moderador";
        if (Period.between(f, LocalDate.now()).getYears() < 18) return "Debe ser mayor de edad";
        usuarios.add(new Moderador(n,id,f,p,c));
        return "Moderador registrado";
    }

    public String registrarColeccionista(String n, String id, LocalDate f, String p, String c, String dir) {
        if (Period.between(f, LocalDate.now()).getYears() < 18) return "Debe ser mayor";
        usuarios.add(new Coleccionista(n,id,f,p,c,0,dir));
        return "Coleccionista registrado";
    }

    public String registrarVendedor(String n, String id, LocalDate f, String p, String c, String dir) {
        if (Period.between(f, LocalDate.now()).getYears() < 18) return "Debe ser mayor";
        usuarios.add(new Vendedor(n,id,f,p,c,0,dir));
        return "Vendedor registrado";
    }

    public Usuario login(String correo, String pass) {
        return usuarios.stream()
                .filter(u -> u.getCorreo().equals(correo) && u.getContrasena().equals(pass))
                .findFirst().orElse(null);
    }

    public String crearSubasta(Usuario creador, double precio, List<Objeto> objs) {
        if (creador instanceof Moderador) return "Moderador no puede crear";
        if (objs.isEmpty()) return "Debe tener objetos";

        Subasta s = new Subasta(LocalDateTime.now().plusDays(1), creador, precio);
        s.getObjetos().addAll(objs);
        subastas.add(s);
        return "Subasta creada";
    }

    public String crearOferta(Subasta s, Usuario u, double precio) {
        if (!(u instanceof Coleccionista)) return "Solo coleccionistas ofertan";
        if (s.getCreador().equals(u)) return "No puede ofertar en su subasta";
        if (precio < s.getPrecioMinimo()) return "Precio menor al mínimo";

        Oferta o = new Oferta((Coleccionista) u, precio);
        s.getOfertas().add(o);
        ofertas.add(o);
        return "Oferta creada";
    }

    public List<Usuario> getUsuarios() { return usuarios; }
    public List<Subasta> getSubastas() { return subastas; }
    public List<Oferta> getOfertas() { return ofertas; }
}