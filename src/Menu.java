package com.mycompany.proyectoparte1;

import java.time.LocalDate;
import java.util.*;

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private Sistema sistema = new Sistema();
    private Usuario logueado = null;

    public void iniciar() {

        if (!sistema.existeModerador()) {
            System.out.println("=== REGISTRO DE MODERADOR ===");

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Correo: ");
            String correo = sc.nextLine();

            System.out.print("Contrasena: ");
            String pass = sc.nextLine();

            sistema.registrarModerador(nombre, id, LocalDate.of(2000,1,1), pass, correo);
            System.out.println("Moderador creado\n");
        }

        int op;

        do {
            System.out.println("\n1. Registrar");
            System.out.println("2. Login");
            System.out.println("3. Crear subasta");
            System.out.println("4. Crear oferta");
            System.out.println("5. Ver datos");
            System.out.println("0. Salir");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {

                case 1:
                    registrarUsuario();
                    break;

                case 2:
                    login();
                    break;

                case 3:
                    crearSubasta();
                    break;

                case 4:
                    crearOferta();
                    break;

                case 5:
                    verDatos();
                    break;
            }

        } while (op != 0);
    }

    private void registrarUsuario() {
        System.out.println("1. Vendedor  2. Coleccionista");
        int tipo = Integer.parseInt(sc.nextLine());

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        System.out.print("Contrasena: ");
        String pass = sc.nextLine();

        System.out.print("Direccion: ");
        String dir = sc.nextLine();

        if (tipo == 1) {
            System.out.println(sistema.registrarVendedor(nombre, id, LocalDate.of(1995,1,1), pass, correo, dir));
        } else {
            System.out.println(sistema.registrarColeccionista(nombre, id, LocalDate.of(1998,1,1), pass, correo, dir));
        }
    }

    private void login() {
        System.out.print("Correo: ");
        String correo = sc.nextLine();

        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        logueado = sistema.login(correo, pass);

        if (logueado == null)
            System.out.println("Credenciales incorrectas");
        else
            System.out.println("Bienvenido " + logueado);
    }

    private void crearSubasta() {
        if (logueado == null) {
            System.out.println("Debe iniciar sesión");
            return;
        }

        List<Objeto> objs = new ArrayList<>();

        System.out.print("Nombre del objeto: ");
        String nombre = sc.nextLine();

        System.out.print("Descripción: ");
        String desc = sc.nextLine();

        Objeto o = new Objeto(nombre, desc, "nuevo", LocalDate.now());
        objs.add(o);

        System.out.print("Precio mínimo: ");
        double precio = Double.parseDouble(sc.nextLine());

        System.out.println(sistema.crearSubasta(logueado, precio, objs));
    }

    private void crearOferta() {
        if (logueado == null) {
            System.out.println("Debe iniciar sesión");
            return;
        }

        if (sistema.getSubastas().isEmpty()) {
            System.out.println("No hay subastas");
            return;
        }

        System.out.print("Precio de oferta: ");
        double precio = Double.parseDouble(sc.nextLine());

        Subasta s = sistema.getSubastas().get(0);

        System.out.println(sistema.crearOferta(s, logueado, precio));
    }

    private void verDatos() {
        System.out.println("\n--- USUARIOS ---");
        sistema.getUsuarios().forEach(u -> System.out.println(u));

        System.out.println("\n--- SUBASTAS ---");
        sistema.getSubastas().forEach(s -> System.out.println(s));

        System.out.println("\n--- OFERTAS ---");
        sistema.getOfertas().forEach(o -> System.out.println(o));
    }
}