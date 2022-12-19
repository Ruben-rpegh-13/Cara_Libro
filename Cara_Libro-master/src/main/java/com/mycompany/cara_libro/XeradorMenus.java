package com.mycompany.cara_libro;

import java.util.Scanner;

/**
 *
 * @author VictorLandin & Ruben-rpegh-13
 */
public class XeradorMenus { // muchas cosas estan comentadas debido a probar distintos metodos

    // Atributos (se añadiran mas si llegan a ser necesarios)
    CaraLibroBD datos;
    Perfil sesionActual;
    Scanner lector = new Scanner(System.in);

    public XeradorMenus() {

    }

    // P representa el nombre del objeto perfil, puede cambiar luego
    // Estos son los menus
    public void mostrarMenuInicial() { // este menu mostrará las opciones de registrarse e iniciar sesion
        String opciones;
        boolean menuAtras = false;

        do {
            ascii(1);

            // pongo \n para saltar de linea
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
                case "comandos":
                    debug();
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

            // pongo \n para saltar de linea
            System.out.println("Usuario: " + sesionActual.getNombre() + '\n'
                    + "1: Estado" + '\n'
                    + "2: Biografia(no implementado)" + '\n'
                    + "3: Lista de amigos: "
                    // en esta linea de abajo se muestra el numero de amigos y solicitudes
                    // pendientes, pero como no hay \n no salta de linea
                    + sesionActual.getAmigos().size() + " amigos, " + sesionActual.getSolicitud().size()
                    + " solicitudes pendientes" + '\n'
                    + "4: mensajes directos" + '\n'
                    + "0: Cerrar Sesion");
            opciones = lector.nextLine();

            switch (opciones) {// Aqui se mostraran las opciones que tiene el menu principal
                case "1":
                    cambiarEstado(sesionActual);
                    break;
                case "2":
                    // mostrarBiografia(sesionActual);
                    break;
                case "3":
                    mostrarListaAmigos(sesionActual);
                    break;
                case "4":
                    mostrarMensajes(sesionActual);
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

    // muestra las solicitudes y te deja aceptarlas
    public void mostrarSolicitudesDeAmizade(Perfil sesionActual) {
        boolean menuAtras = false;
        String nombreSolicitud;
        Perfil perfilSolicitante;

        do {
            // en caso de no tener solicitudes
            if (sesionActual.getSolicitud().isEmpty()) {
                System.out.println("Parece que aun no tienes solicitudes de amistad, pulse enter para volver");
                lector.nextLine();
                menuAtras = true;
                // Si hay solicitudes,las enseña y te deja escoger una o salir del menu
            } else {
                for (int contSolicitud = 0; contSolicitud < sesionActual.getSolicitud().size(); contSolicitud++) {
                    System.out.println(sesionActual.getSolicitud().get(contSolicitud));
                }
                System.out.println("Escriba el nombre de la solicitud que desea ver o 0 para volver al menu anterior");
                // Te muestra el perfil seleccionado
                nombreSolicitud = lector.nextLine();
                if (nombreSolicitud.equals("0")) {
                    menuAtras = true;
                } else {
                    for (int contSolicitud = 0; contSolicitud < sesionActual.getSolicitud().size(); contSolicitud++) {
                        if (sesionActual.getSolicitud().get(contSolicitud).equals(nombreSolicitud)) {
                            perfilSolicitante = CaraLibroBD.buscarPerfil(nombreSolicitud);
                            if (perfilSolicitante.getEstado() == null) {
                                System.out.println("\t" + "Sin estado");
                            } else {
                                System.out.println("\t" + perfilSolicitante.getEstado());
                            }
                            System.out.println(" ");
                            // aceptas o rechazas la solicitud
                            System.out.println(" ");
                            System.out.println(" ");
                            System.out.println("Quiere añadir a esta persona?");
                            String opciones;
                            System.out.println("Si" + '\n'
                                    + "No" + '\n'
                                    + "Atrás");
                            opciones = lector.nextLine();
                            switch (opciones) {
                                case "Si":
                                    sesionActual.aceptarSolicitudeDeAmistad(perfilSolicitante);
                                    break;
                                case "No":
                                    sesionActual.rexeitarSolicitudeDeAmistad(perfilSolicitante);
                                    break;
                                case "A":
                                    menuAtras = true;
                                    break;
                                default:
                                    break;
                            }
                        } else {
                            System.out.println("No es un nombre valido");
                        }
                    }
                }
            }
        } while (!menuAtras);
        limpiarPantalla();
    }

    // muestra la lista de amigos
    public void mostrarListaAmigos(Perfil sesionActual) {
        boolean menuAtras = false;
        String opciones;
        do {

            // muestra las opciones que dispone el menu
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
        boolean menuAtras = false;
        int numMensaxes;
        Perfil amigo;
        do {// chequea si hay mensajes y cuantos hay

            for (int contAmigos = 0; contAmigos < sesionActual.getAmigos().size(); contAmigos++) {
                amigo = sesionActual.getAmigos().get(contAmigos);
                numMensaxes = 0;
                if (amigo.getMensaxes().isEmpty()) {
                    System.out.println(amigo.getNombre() + " no tiene mensajes");
                } else {
                    for (int contMensajes = 0; contMensajes < amigo.getMensaxes().size(); contMensajes++) {
                        if (amigo.getMensaxes().get(contMensajes).getRemitente().equals(sesionActual)) {
                            numMensaxes++;
                        }
                    }
                    if (numMensaxes == 0) {
                        System.out.println(amigo.getNombre() + " no tiene mensajes");
                    } else {
                        for (int contNoLeidos = 0; contNoLeidos < amigo.getMensaxes().size(); contNoLeidos++) {
                            if (amigo.getMensaxes().get(contNoLeidos).getRemitente().equals(sesionActual)) {
                                if (!amigo.getMensaxes().get(contNoLeidos).isLido()) {
                                    System.out.println(
                                            amigo.getNombre() + " tiene " + numMensaxes + " mensajes no leidos");
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(
                    "Escriba el nombre del amigo del que desea ver los mensajes o 0 para volver al menu anterior");
            String nombreAmigo = lector.nextLine();
            if (nombreAmigo.equals("0")) {
                menuAtras = true;
            } else {
                amigo = null;
                for (int contAmigos = 0; contAmigos < sesionActual.getAmigos().size(); contAmigos++) {
                    if (sesionActual.getAmigos().get(contAmigos).getNombre().equals(nombreAmigo)) {
                        amigo = sesionActual.getAmigos().get(contAmigos);
                        for (int contMensajes = 0; contMensajes < amigo.getMensaxes().size(); contMensajes++) {
                            if (amigo.getMensaxes().get(contMensajes).getRemitente().equals(sesionActual)) {
                                System.out.println(amigo.getMensaxes().get(contMensajes).getRemitente().getNombre()
                                        + ": " + amigo.getMensaxes().get(contMensajes).getTexto());
                                amigo.getMensaxes().get(contMensajes).setLido(true);
                            }
                        }
                    }
                }
                if (amigo == null) {
                    System.out.println("No es un nombre valido");
                }
            }
            limpiarPantalla();
        } while (!menuAtras);

    }

    // Saldrias de la sesion con ese perfil
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
            if ("0".equals(nombre)) {// compara nombre porque si es igual a 1 vuelve al menu anterior en vez de
                                     // aceptarlo como usuario
                atras = true;
            } else {
                if (CaraLibroBD.buscarPerfil(nombre) != null) {// esta comparacion sirve para no tener problemas con
                                                               // varios usuarios llamados igual
                    System.out.println("Ese usuario ya esta en uso");
                } else {
                    System.out.println("contraseña");
                    contraseña = lector.nextLine();
                    CaraLibroBD.engadirPerfil(new Perfil(nombre, contraseña));
                    correcto = true;
                }
            }
            limpiarPantalla();
        } while (!correcto && !atras); // serviria para cuando haya que hacer la opcion de poner la contraseña dos
                                       // veces
    }
    // Entrarias a la sesion de ese perfil

    private void iniciarSesion() {

        boolean atras = false;
        boolean correcto = false;
        String nombre;
        String contraseña;

        do {
            ascii(3);
            System.out.println("Inserte 0 y enter para ir al menu anterior" + '\n' + "O inserte nombre");
            nombre = lector.nextLine();
            // compara nombre porque si es igual a 1 vuelve al menu anterior en vez de
            // aceptarlo como usuario
            if ("0".equals(nombre)) {
                atras = true;
            } else {
                System.out.println("contraseña");
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
    // Muestra el menu para cambiar de estado o para escribir uno si no hay ninguno

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

    // muesta tus amigos y sus estados o te redirije a enviar solicitud
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
                for (int contAmigos = 0; contAmigos < sesionActual.getAmigos().size(); contAmigos++) {
                    System.out.println(sesionActual.getAmigos().get(contAmigos).getNombre());
                    if (sesionActual.getAmigos().get(contAmigos).getEstado() == null) {
                        System.out.println("\t" + "Sin estado");
                    } else {
                        System.out.println("\t" + sesionActual.getAmigos().get(contAmigos).getEstado());
                    }
                }

            }
            System.out.println("Escriba el nombre del amigo que desea ver o 0 para volver al menu anterior");
            // Te muestra el perfil seleccionado
            String nombreSolicitud = lector.nextLine();
            if (nombreSolicitud.equals("0")) {
                menuAtras = true;
            } else {
                for (int contAmigos = 0; contAmigos < sesionActual.getSolicitud().size(); contAmigos++) {
                    Perfil perfilAmigo = CaraLibroBD.buscarPerfil(nombreSolicitud);
                    if (sesionActual.getAmigos().get(contAmigos).equals(perfilAmigo)) {
                        // decides si entrar en la biografia o mensajes de tu amigo
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("Que desea hacer?");
                        System.out.println("1: Biografia(no implementado)" + '\n'
                                + "0: Atrás");
                        opciones = lector.nextLine();
                        switch (opciones) {
                            case "1":
                                // mostrarBiografia(perfilAmigo);
                                break;
                            case "0":
                                menuAtras = true;
                                break;
                            default:
                                break;
                        }
                    } else {
                        System.out.println("No es un nombre valido, o aun no es tu amigo");
                    }
                }
            }
            limpiarPantalla();
        } while (!menuAtras);

    }
    // revisa que el usuario sea valido de varias maneras y luego envia la solicitud

    private void prepararSolicitudAmistad(Perfil sesionActual) {
        String nombreAmigo;
        Perfil amigo;
        boolean menuAtras = false;
        boolean enviado = false;
        do {
            limpiarPantalla();
            // Aqui verifica que el nombre existe y que no es el nombre del usuario actual
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
                // Se comprueba si la persona a la que envias una solicitud ya tiene una
                // solicitud tuya
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
    // este metodo vacia la pantalla

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

    public void debug() { // Este metodo es para debuggear
        String comando;
        do {
            System.out.println("Introduce un comando " + '\n' + " comando ayuda para ayuda");
            comando = lector.nextLine();
            switch (comando) {
                case "salir":
                    System.out.println("Saliendo...");
                    break;
                case "ayuda":
                    System.out.println("Comandos disponibles(no usar varios a la vez): " + '\n' +
                            "salir: cierra la consola" + '\n' +
                            "perfiles: crea varios perfiles" + '\n' +
                            "solicitudes: crea varios perfiles y manda solicitud de varios a uno" + '\n' +
                            "amigos: crea varios perfiles ya amigos" + '\n' +
                            "lista: muestra los perfiles con su contraseña, solicitudes y amigos" + '\n' +
                            "ayuda: muestra los comandos disponibles");
                    break;
                case "perfiles":
                    System.out.println("Introduce el numero de perfiles a crear");
                    int numero = lector.nextInt();
                    for (int i = 0; i < numero; i++) {
                        String nombre = "usuario" + i;
                        String contraseña = "contraseña" + i;
                        Perfil perfil = new Perfil(nombre, contraseña);
                        CaraLibroBD.engadirPerfil(perfil);
                    }
                    break;
                case "solicitudes":
                    System.out.println("Introduce el numero de perfiles a crear");
                    int numero2 = lector.nextInt();
                    for (int i = 0; i < numero2; i++) {
                        String nombre = "usuario" + i;
                        String contraseña = "contraseña" + i;
                        Perfil perfil = new Perfil(nombre, contraseña);
                        CaraLibroBD.engadirPerfil(perfil);
                    }
                    for (int i = 1; i < numero2; i++) {
                        String nombre = "usuario" + i;
                        String nombre2 = "usuario0";
                        Perfil perfil = CaraLibroBD.buscarPerfil(nombre);
                        Perfil perfil2 = CaraLibroBD.buscarPerfil(nombre2);
                        perfil.engadirSolicitudeDeAmistad(perfil2);
                    }
                    break;
                case "amigos":
                    System.out.println("Introduce el numero de perfiles a crear");
                    int numero3 = lector.nextInt();
                    for (int i = 0; i < numero3; i++) {
                        String nombre = "usuario" + i;
                        String contraseña = "contraseña" + i;
                        Perfil perfil = new Perfil(nombre, contraseña);
                        CaraLibroBD.engadirPerfil(perfil);
                    }
                    for (int i = 0; i < numero3; i++) {
                        for (int j = 0; j < numero3; j++) {
                            if (i != j) {
                                String nombre = "usuario" + i;
                                String nombre2 = "usuario" + j;
                                Perfil perfil = CaraLibroBD.buscarPerfil(nombre);
                                Perfil perfil2 = CaraLibroBD.buscarPerfil(nombre2);
                                perfil.engadirAmigo(perfil2);
                            }
                        }
                    }
                    break;
                case "lista":
                    debugPro();
                    break;
                default:
                    System.out.println("Comando no reconocido");
                    break;
            }

        } while (!comando.equals("salir"));
    }

    public void debugPro() {
        for (Perfil perfil : CaraLibroBD.datos) {
            System.out.println("Nombre: " + perfil.getNombre());
            System.out.println("Contraseña: " + perfil.getContraseña());
            System.out.println("Solicitudes: ");
            for (String perfil1 : perfil.getSolicitud()) {
                System.out.println(perfil1);
            }
            System.out.println("Amigos: ");
            for (Perfil perfil1 : perfil.getAmigos()) {
                System.out.println(perfil1.getNombre());
            }
            System.out.println(" ");
        }
    }
}