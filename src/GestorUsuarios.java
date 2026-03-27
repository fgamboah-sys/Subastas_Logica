package com.mycompany.proyectoparte1;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class GestorUsuarios {

    private List<Usuario> usuarios = new ArrayList<>();

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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}