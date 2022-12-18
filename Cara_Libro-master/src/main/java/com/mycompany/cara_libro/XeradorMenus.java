package com.mycompany.cara_libro;

import java.util.Scanner;

/**
 *
 * @author VictorLandin & Ruben-rpegh-13
 */
public class XeradorMenus { //muchas cosas estan comentadas debido a probar distintos metodos

    //Atributos (se añadiran mas si llegan a ser necesarios) 
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
            System.out.println("Usuario: " + sesionActual.getNombre() + '\n'
                    + "1: Estado" + '\n'
                    + "2: Biografia(no implementado)" + '\n'
                    + "3: Lista de amigos" + '\n'
                    + "0: Cerrar Sesion");
            opciones = lector.nextLine();

            switch (opciones) {// Aqui se mostraran las opciones que tiene el menu principal
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

    // enseña tanto el estado escrito por la persona como la lista de publicaciones
    public void mostrarBiografia(Perfil sesionActual) {
        String opciones;

    }

    //muestra las solicitudes y te deja aceptarlas
    public void mostrarSolicitudesDeAmizade(Perfil sesionActual) {
        boolean menuAtras = false;
        String nombreSolicitud;

        do {
            // en caso de no tener solicitudes
            if (sesionActual.getSolicitud().isEmpty()) {
                System.out.println("Parece que aun no tienes solicitudes de amistad, pulse enter para volver");
                lector.nextLine();
                menuAtras = true;
                //Si hay solicitudes,las enseña y te deja escoger una o salir del menu
            } else {
                for (int cont = 0; cont < sesionActual.getSolicitud().size(); cont++) {
                    System.out.println(sesionActual.getSolicitud().get(cont));
                }
                System.out.println("Escriba el nombre de la solicitud que desea ver o 0 para volver al menu anterior");
                //Te muestra el perfil seleccionado
                nombreSolicitud = lector.nextLine();
                if (nombreSolicitud.equals("0")) {
                    menuAtras = true;
                } else {
                    for (int cont = 0; cont < sesionActual.getSolicitud().size(); cont++) {
                        if (sesionActual.getSolicitud().get(cont).equals(nombreSolicitud)) {
                            System.out.println(sesionActual.getSolicitud());
                            if (CaraLibroBD.buscarPerfil(nombreSolicitud).getEstado() == null) {
                                System.out.println("\t" + "Sin estado");
                            } else {
                                System.out.println("\t" + CaraLibroBD.buscarPerfil(nombreSolicitud).getEstado());
                            }
                        }
                        //aceptas o rechazas la solicitud
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("Quiere añadir a esta persona?");
                        String opciones;
                        opciones = lector.nextLine();
                         System.out.println( "SI" + '\n' 
                                           + "No" + '\n'
                                           + "Atrás");
                        switch (opciones) {
                            case "S":
                                break;
                            case "N":
                                break;
                            case "A":
                                break;
                            default:
                                break;

                        }

                    }
                    System.out.println("No es un nombre valido");
                }
            }
        } while (!menuAtras);
        limpiarPantalla();
    }

    //muestra la lista de amigos
    public void mostrarListaAmigos(Perfil sesionActual) {
        boolean menuAtras = false;
        String opciones;
        do {

            //  muestra las opciones que dispone el menu
            System.out.println("Usuario: " + sesionActual.getNombre() + '\n'
                    + "1: Lista de amigos: " + sesionActual.getAmigos().size() + " amigos" + '\n'
                    + "2: Solicitudes de amistad: " + sesionActual.getSolicitud().size() + " pendientes" + '\n'
                    + "3: Enviar solicitud" + '\n'
                    + "0: Menu anterior");
            opciones = lector.nextLine();

            switch (opciones) {//
                case "1":
                    listaAmigos(sesionActual);
                    break;
                case "2":
                    mostrarSolicitudesDeAmizade(sesionActual);
                    break;
                case "3":
                    prepararSolicitudAmistad(sesionActual);
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

    public void mostrarMensajes(Perfil sesionActual) {

    }
    //Saldrias de la sesion con ese perfil

    public void pecharSesion() {
        sesionActual = null;
    }

    //
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
                if (CaraLibroBD.buscarPerfil(nombre) != null) {//esta comparacion sirve para no tener  problemas con varios usuarios llamados igual
                    System.out.println("Ese usuario ya esta en uso");
                } else {
                    System.out.println("Contraseña");
                    contraseña = lector.nextLine();
                    CaraLibroBD.engadirPerfil(new Perfil(nombre, contraseña));
                    correcto = true;
                }
            }
            limpiarPantalla();
        } while (!correcto && !atras); //servirta para cuando haya que hacer la opcion de poner la contraseña dos veces
    }
    //Entrarias a la sesion de ese perfil

    private void iniciarSesion() {

        boolean atras = false;
        boolean correcto = false;
        String nombre;
        String contraseña;

        do {
            ascii(3);
            System.out.println("Inserte 0 y enter para ir al menu anterior" + '\n' + "O inserte nombre");
            nombre = lector.nextLine();
            //compara nombre porque si es igual a 1 vuelve al menu anterior en vez de aceptarlo como usuario
            if ("0".equals(nombre)) {
                atras = true;
            } else {
                System.out.println("Contraseña");
                contraseña = lector.nextLine();
                sesionActual = CaraLibroBD.obterPerfil(nombre, contraseña);
                if (sesionActual != null) {
                    correcto = true;
                }
            }
            limpiarPantalla();
        } while (!atras && !correcto);
        if (correcto) {
            mostrarMenuPrincipal(sesionActual);
        }
    }
    //Muestra el menu para cambiar de estado o para escribir uno si no hay ninguno

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

    //muesta tus amigos y sus estados o te redirije a enviar solicitud
    private void listaAmigos(Perfil sesionActual) {
        boolean menuAtras = false;
        String opciones;

        do {
            if (sesionActual.getAmigos().isEmpty()) {
                System.out.println("Parece que aun no tienes amigos, quieres añadir uno?" + '\n'
                        + "1: Añadir amigo" + '\n'
                        + "0: Atras");
                opciones = lector.nextLine();
                switch (opciones) {
                    case "1":
                        prepararSolicitudAmistad(sesionActual);
                        break;
                    case "0":
                        menuAtras = true;
                        break;
                    default:
                        break;
                }
            } else {
                for (int cont = 0; cont < sesionActual.getAmigos().size(); cont++) {
                    System.out.println(sesionActual.getAmigos().get(cont).getNombre());
                    if (sesionActual.getAmigos().get(cont).getEstado() == null) {
                        System.out.println("\t" + "Sin estado");
                    } else {
                        System.out.println("\t" + sesionActual.getAmigos().get(cont).getEstado());
                    }
                }
            }
            limpiarPantalla();
        } while (!menuAtras);

    }
    //revisa que el usuario sea valido de varias maneras y luego envia la solicitud

    private void prepararSolicitudAmistad(Perfil sesionActual) {
        String nombreAmigo;
        Perfil amigo;
        boolean menuAtras = false;
        boolean enviado = false;
        do {
            limpiarPantalla();
            //Aqui verifica que el nombre existe y que no es el nombre del usuario actual
            System.out.println("Inserte nombre de su amigo");
            nombreAmigo = lector.nextLine();
            amigo = CaraLibroBD.buscarPerfil(nombreAmigo);
            if (amigo == null) {
                System.out.println("Lo siento, tu amigo no existe");
            } else if (sesionActual.getAmigos().contains(amigo)) {
                System.out.println("Esta persona ya es tu amiga");
            } else if (sesionActual.nombre.equals(nombreAmigo)) {
                System.out.println("No puedes ser tu propio amigo");
            } else if (sesionActual.getSolicitud().contains(nombreAmigo)) {
                System.out.println("Ya tienes una solicitud de esta persona, ¿quiere añadirla como amigo?" + '\n'
                        + "0: no" + '\n'
                        + "1: si");
                if (lector.nextLine().equals("1")) {
                    sesionActual.engadirAmigo(amigo);
                }
            } else if (CaraLibroBD.buscarPerfil(nombreAmigo).getSolicitud().contains(sesionActual.getNombre())) {
                //Se comprueba si la persona a la que envias una solicitud ya tiene una solicitud tuya
                System.out.println("Ya enviaste una solicitud");
            } else {
                sesionActual.engadirSolicitudeDeAmistad(amigo);
                System.out.println("Solicitud enviada");
                enviado = true;
            }
            if (!enviado) {
                System.out.println("Reintentar?" + '\n'
                        + "0: Atras" + '\n'
                        + "1: Reintentar");
                if ("0".equals(lector.nextLine())) {
                    menuAtras = true;
                }
            }
        } while (!enviado && !menuAtras);
    }
    //este metodo vacia la pantalla

    private void limpiarPantalla() {
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
