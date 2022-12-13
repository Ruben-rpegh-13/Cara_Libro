package com.mycompany.cara_libro;

import java.util.Scanner;

/**
 *
 * @author VictorLandin & Ruben-rpegh-13
 */
public class XeradorMenus { //muchas cosas estan comentadas debido a probar distintos metodos

    //Atributos (se añadiran segun haga falta) 
    CaraLibroBD datos;
    Perfil sesionActual;
    Scanner lector = new Scanner(System.in);

    public XeradorMenus() {

    }

    //P representa el nombre del objeto perfil, puede cambiar luego
    //Estos son los menus
    public void mostrarMenuInicial() { //este menu mostrará las opciones de registrarse e iniciar sesion
        String opciones;
        boolean menuAtras = false;

        do {
            ascii(1);

            //  pongo \n para saltar de linea
            System.out.println("1: Registrarse" + '\n'
                    + "2: iniciar sesion" + '\n'
                    + "0: Cerrar");
            opciones = lector.nextLine();

            switch (opciones) {//
                case "1":
                    crearPerfil();
                    break;
                case "2":
                    iniciarSesion();
                    break;
                case "0":
                    menuAtras = true;
                    break;
                default:
                    break;
            }
            limpiarPantalla();
        } while (!menuAtras);
    }

    public void mostrarMenuPrincipal(Perfil sesionActual) {
        boolean menuAtras = false;
        String opciones;
        do {

            //  pongo \n para saltar de linea
            System.out.println("Usuario: " + sesionActual.getnombre() + '\n'
                    + "1: Estado" + '\n'
                    + "2: Biografia(no implementado)" + '\n'
                    + "3: Lista de amigos" + '\n'
                    + "0: Cerrar Sesion");
            opciones = lector.nextLine();

            switch (opciones) {//
                case "1":
                    cambiarEstado(sesionActual);
                    break;
                case "2":
                    //mostrarBiografia(sesionActual);
                    break;
                case "3":
                    mostrarListaAmigos(sesionActual);
                    break;
                case "0":
                    pecharSesion();
                    menuAtras = true;
                    break;
                default:
                    break;
            }
            limpiarPantalla();
        } while (!menuAtras);
    }

    /*
    public void mostrarBiografia(Perfil sesionActual) { 
        String opciones;
        if (sesionActual.getBiografia()== null) {
            System.out.println("Escribe su biografia");
            sesionActual.setBiografia(lector.nextLine());
        } else {
            System.out.println(sesionActual.getBiografia());
            System.out.println("1: Cambiar biografia" + '\n'
                    + "0: Cerrar" + '\n');
            opciones = lector.nextLine();

            switch (opciones) {
                case "1":
                    sesionActual.setBiografia(lector.nextLine());
                    break;
                default:
                    break;
            }
        }
    }*/
    public void mostrarSolicitudesDeAmizade(Perfil sesionActual) {

    }

    public void mostrarListaAmigos(Perfil sesionActual) {
        boolean menuAtras = false;
        String opciones;
        String nombreAmigo;
        Perfil amigo;
        do {
            if (sesionActual.amigos.size == 0) {
                System.out.println("Parece que aun no tienes amigos, quieres añadir uno?" + '\n'
                        + "1: Añadir amigo" + '\n'
                        + "0: Atras");
                opciones = lector.nextLine();
                switch (opciones) {
                    case "1":
                        System.out.println("nombre de su amigo");
                        nombreAmigo = lector.nextLine();
                        amigo = CaraLibroBD.buscarPerfil(nombreAmigo);
                        if (amigo == null) {
                            System.out.println("Lo siento, tu amigo no existe");
                        } else {
                            sesionActual.engadirSolicitudeDeAmistad(amigo);
                            System.out.println("Solicitud enviada");
                        }
                        break;
                    case "0":
                        menuAtras = true;
                        break;
                    default:
                        break;
                }
            } else {

            }
            limpiarPantalla();
        } while (!menuAtras);
    }

    public void mostrarMensajes(Perfil sesionActual) {

    }

    public void pecharSesion() {
        sesionActual = null;
    }

    private void crearPerfil() {

        boolean atras = false;
        boolean correcto = false;
        String nombre;
        String contraseña;

        do {
            ascii(2);
            System.out.println("Inserte 0 y enter para ir al menu anterior" + '\n' + "O inserte nombre");
            nombre = lector.nextLine();
            if ("0".equals(nombre)) {//compara nombre porque si es igual a 1 vuelve al menu anterior en vez de aceptarlo como usuario
                atras = true;
            } else {
                System.out.println("Contraseña");
                contraseña = lector.nextLine();
                if (this.datos.obterPerfil(nombre) != null) {//esta comparacion sirve para no tener  problemas con varios usuarios llamados igual
                    System.out.println("Ese usuario ya esta en uso");
                } else {
                    CaraLibroBD.engadirPerfil(new Perfil(nombre, contraseña));
                    correcto = true;
                }
            }

        } while (!correcto && !atras); //servirta para cuando haya que hacer la opcion de poner la contraseña dos veces
    }

    private void iniciarSesion() {

        boolean atras = false;
        boolean correcto = false;
        String nombre;
        String contraseña;

        do {
            ascii(3);
            System.out.println("Inserte 0 y enter para ir al menu anterior" + '\n' + "O inserte nombre");
            nombre = lector.nextLine();
            if ("0".equals(nombre)) { //compara nombre porque si es igual a 1 vuelve al menu anterior en vez de aceptarlo como usuario
                atras = true;
            } else {
                System.out.println("Contraseña");
                contraseña = lector.nextLine();
            }//añadir codigo para verificar contraseña y nombre + iniciar sesion

        } while (!atras && !correcto);
        if (correcto) {
            mostrarMenuPrincipal(sesionActual);
        }
    }

    private void cambiarEstado(Perfil sesionActual) {
        String opciones;
        if (sesionActual.getEstado() == null) {
            System.out.println("Inserte Su primer estado");
            sesionActual.setEstado(lector.nextLine());
        } else {
            System.out.println(sesionActual.getEstado());
            System.out.println("1: Cambiar estado" + '\n'
                    + "0: Cerrar" + '\n');
            opciones = lector.nextLine();

            switch (opciones) {
                case "1":
                    sesionActual.setEstado(lector.nextLine());
                    break;
                default:
                    break;
            }
        }
    }

    private void limpiarPantalla() {//este metodo limpia la pantalla llenando 100 lineas
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    private void ascii(int opcion) {
        switch (opcion) {
            case 1 ->
                System.out.println("""
                                                                                                                          
                                                                                        ,,   ,,                           
                                     .g8\"""bgd                            `7MMF'        db  *MM                           
                                   .dP'     `M                              MM               MM                           
                                   dM'       `  ,6"Yb.  `7Mb,od8  ,6"Yb.    MM        `7MM   MM,dMMb.  `7Mb,od8  ,pW"Wq.  
                                   MM          8)   MM    MM' "' 8)   MM    MM          MM   MM    `Mb   MM' "' 6W'   `Wb 
                                   MM.          ,pm9MM    MM      ,pm9MM    MM      ,   MM   MM     M8   MM     8M     M8 
                                   `Mb.     ,' 8M   MM    MM     8M   MM    MM     ,M   MM   MM.   ,M9   MM     YA.   ,A9 
                                     `"bmmmd'  `Moo9^Yo..JMML.   `Moo9^Yo..JMMmmmmMMM .JMML. P^YbmdP'  .JMML.    `Ybmd9'  
                                                                                                                          """);
            case 2 ->
                System.out.println("""
                                     ___                _        _                                 
                                    | _ \\  ___   __ _  (_)  ___ | |_   _ _   __ _   _ _   ___  ___ 
                                    |   / / -_) / _` | | | (_-< |  _| | '_| / _` | | '_| (_-< / -_)
                                    |_|_\\ \\___| \\__, | |_| /__/  \\__| |_|   \\__,_| |_|   /__/ \\___|
                                                |___/                                              """);
            case 3 ->
                System.out.println("""
                                     ___          _        _                  ___              _              
                                    |_ _|  _ _   (_)  __  (_)  __ _   _ _    / __|  ___   ___ (_)  ___   _ _  
                                     | |  | ' \\  | | / _| | | / _` | | '_|   \\__ \\ / -_) (_-< | | / _ \\ | ' \\ 
                                    |___| |_||_| |_| \\__| |_| \\__,_| |_|     |___/ \\___| /__/ |_| \\___/ |_||_|""");

        }
    }
}
