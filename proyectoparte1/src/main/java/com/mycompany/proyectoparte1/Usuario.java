package com.mycompany.proyectoparte1;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Usuario {

    private String nombreCompleto;
    private String identificacion;
    private LocalDate fechaNacimiento;
    private String contrasena;
    private String correo;

    public Usuario() {}

    public Usuario(String nombreCompleto, String identificacion, LocalDate fechaNacimiento, String contrasena, String correo) {
        this.nombreCompleto = nombreCompleto;
        this.identificacion = identificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasena = contrasena;
        this.correo = correo;
    }

    public int calcularEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public String getCorreo() { return correo; }
    public String getContrasena() { return contrasena; }
    public String getIdentificacion() { return identificacion; }

    @Override
    public String toString() {
        return nombreCompleto + " - " + correo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario u = (Usuario) o;
        return identificacion.equals(u.identificacion);
    }
}