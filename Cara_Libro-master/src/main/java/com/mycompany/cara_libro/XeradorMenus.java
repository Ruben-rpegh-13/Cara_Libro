package com.mycompany.cara_libro;

import java.util.ArrayList;
import java.util.Collections;
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
                    + "2: Biografia" + '\n'
                    + "3: Lista de amigos: "
                    // en esta linea de abajo se muestra el numero de amigos y solicitudes
                    // pendientes, pero como no hay \n no salta de linea
                    + sesionActual.getAmigos().size() + " amigos, " + sesionActual.getSolicitud().size()
                    + " solicitudes pendientes" + '\n'
                    + "4: Mensajes directos" + '\n'
                    + "0: Cerrar Sesion");
            opciones = lector.nextLine();

            switch (opciones) {// Aqui se mostraran las opciones que tiene el menu principal
                case "1":
                    cambiarEstado(sesionActual);
                    break;
                case "2":
                    mostrarBiografia(sesionActual);
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
        boolean menuAtras = false;
        String opciones;
        do {
            System.out.println("Estado: " + sesionActual.getEstado() + '\n'
                    + "Publicaciones: " + '\n');
            // enseña las publicaciones
            for (int contPublicacion = 0; contPublicacion < sesionActual.getPublicaciones().size(); contPublicacion++) {
                System.out.println(sesionActual.getPublicaciones().get(contPublicacion));
            }
            System.out.println(("1: Publicar" + '\n'
                    + "0: Atras"););        
            opciones = lector.nextLine();

            switch (opciones) {
                case "1":
                    publicar(sesionActual);
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

    private void publicar(Perfil sesionActual) { // añade una publicacion a la biografia
        String publicacion;
        System.out.println("Escriba su publicacion o pulse enter para volver");
        publicacion = lector.nextLine();
        if (!publicacion.isEmpty()) { // si no esta vacio, añade la publicacion
            sesionActual.engadirPublicacion(publicacion);
        }
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

    public void mostrarMensajes(Perfil sesionActual) { // muestra los mensajes de los amigos, este metodo es muy largo,
                                                       // por eso esta comentado en varias partes
        limpiarPantalla();
        boolean menuAtras = false;
        int numMensaxes;
        int numMensaxesSinLeer;
        Perfil amigo;
        do {// chequea si hay mensajes y cuantos hay
            System.out.println("Usuario: " + sesionActual.getNombre());
            System.out.println("Mensajes: ");
            for (int contAmigos = 0; contAmigos < sesionActual.getAmigos().size(); contAmigos++) { // recorre la lista
                                                                                                   // de amigos
                amigo = sesionActual.getAmigos().get(contAmigos);
                numMensaxes = 0;
                numMensaxesSinLeer = 0;
                for (int contMensajes = 0; contMensajes < amigo.getMensaxes().size(); contMensajes++) {
                    if (amigo.getMensaxes().get(contMensajes).getRemitente() == sesionActual) {
                        numMensaxes++; // guarda el numero de mensajes de la sesion actual, añadiendo los mensajes que
                                       // el usuario ha enviado
                    }
                }
                for (int contMensajes = 0; contMensajes < sesionActual.getMensaxes().size(); contMensajes++) {
                    if (sesionActual.getMensaxes().get(contMensajes).getRemitente() == amigo) {
                        numMensaxes++; // guarda el numero de mensajes de la sesion actual, añadiendo los mensajes que
                                       // el usuario ha recibido
                    }
                }
                if (numMensaxes == 0) { // si no hay mensajes
                    System.out.println("Tu amigo [" + amigo.getNombre() + "] y tu no teneis chat");
                } else { // si hay mensajes
                    for (int contNoLeidos = 0; contNoLeidos < amigo.getMensaxes().size(); contNoLeidos++) {
                        if (!sesionActual.getMensaxes().isEmpty()) {
                            if (sesionActual.getMensaxes().get(contNoLeidos).getRemitente() == amigo) {
                                if (!sesionActual.getMensaxes().get(contNoLeidos).isLido()) {
                                    numMensaxesSinLeer++; // guarda el numero de mensajes sin leer
                                }
                            }
                        }
                    }
                    System.out.println("Tiene " + numMensaxes + " mensajes en el chat con [" + amigo.getNombre()
                            + "] de los cuales tienes: " + numMensaxesSinLeer + " sin leer");
                }
            }
            System.out.println(
                    "Escriba el nombre del amigo del que desea ver los mensajes o 0 para volver al menu anterior");
            String nombreAmigo = lector.nextLine();
            if (nombreAmigo.equals("0")) { // si es 0 vuelve al menu anterior
                menuAtras = true;
            } else {
                amigo = chat(nombreAmigo, sesionActual); // si no es 0 llama al metodo chat
                if (amigo == null) {
                    System.out.println("No es un nombre valido");
                } else {
                    do {
                        System.out.println("Escriba 1 para enviar mensaje o 0 para volver al menu anterior");
                        String volver = lector.nextLine();
                        switch (volver) {
                            case "1":
                                escribirMensaje(sesionActual, amigo);
                                break;
                            case "0":
                                menuAtras = true;
                                break;
                            default:
                                break;
                        }
                    } while (!menuAtras);

                }
            }
            limpiarPantalla();
        } while (!menuAtras);

    }

    private Perfil chat(String nombreAmigo, Perfil sesionActual) { // muestra los mensajes de un amigo a ti y tuyos a
                                                                   // ese amigo
        limpiarPantalla();
        Perfil amigo = null;
        boolean menuAtras = false;
        do {
            int idMensaje = 0;
            ArrayList<Mensaxe> chatTemp = new ArrayList<Mensaxe>();
            for (int contAmigos = 0; contAmigos < sesionActual.getAmigos().size(); contAmigos++) {
                if (sesionActual.getAmigos().get(contAmigos).getNombre().equals(nombreAmigo)) {
                    amigo = sesionActual.getAmigos().get(contAmigos);
                }
            }
            if (amigo != null) {
                for (int contMensajes = 0; contMensajes < amigo.getMensaxes().size(); contMensajes++) { // recorre la
                                                                                                        // lista
                                                                                                        // de
                                                                                                        // mensajes del
                                                                                                        // amigo
                    if (amigo.getMensaxes().get(contMensajes).getRemitente() == sesionActual) {
                        chatTemp.add(amigo.getMensaxes().get(contMensajes));
                    }
                }
                for (int contMensajes = 0; contMensajes < sesionActual.getMensaxes().size(); contMensajes++) { // recorre
                                                                                                               // la
                                                                                                               // lista
                                                                                                               // de
                                                                                                               // mensajes
                                                                                                               // de
                                                                                                               // la
                                                                                                               // sesion
                                                                                                               // actual
                    if (sesionActual.getMensaxes().get(contMensajes).getRemitente() == amigo) {
                        chatTemp.add(sesionActual.getMensaxes().get(contMensajes));
                    }
                }

                if (chatTemp.isEmpty()) {
                    System.out.println("Tu amigo [" + amigo.getNombre() + "] y tu no teneis chat");
                } else {
                    Collections.sort(chatTemp, (o1, o2) -> o1.getData().compareTo(o2.getData())); // ordena los mensajes
                                                                                                  // por fecha tuve que
                                                                                                  // buscar en internet

                    for (int contMensajes = 0; contMensajes < chatTemp.size(); contMensajes++) { // muestra los mensajes
                        idMensaje++;
                        if (chatTemp.get(contMensajes).getRemitente() == sesionActual) {
                            System.out.println("Tu: " + chatTemp.get(contMensajes).getTexto());
                            System.out.println(chatTemp.get(contMensajes).getData());
                            System.out.println("ID: " + idMensaje);
                        } else {
                            System.out.println(amigo.getNombre() + ": " + chatTemp.get(contMensajes).getTexto());
                            System.out.println(chatTemp.get(contMensajes).getData());
                            System.out.println("ID: " + idMensaje);
                            if (!chatTemp.get(contMensajes).isLido()) { // si el mensaje no esta leido lo marca como
                                                                        // leido
                                marcarMesaxeComoLido(chatTemp.get(contMensajes));
                            }
                        }

                    }

                    System.out.println("Desea borrar un mensaje? (s/n)");
                    String borrar = lector.nextLine();
                    if (borrar.equals("s")) {
                        System.out.println("Escriba el ID del mensaje que desea borrar");
                        int id = lector.nextInt();
                        if (id > 0 && id <= chatTemp.size()) {
                            if (chatTemp.get(id - 1).getRemitente() == sesionActual) {
                                eliminarMensaje(amigo, chatTemp.get(id - 1));
                            } else {
                                System.out.println("No puedes borrar mensajes de tu amigo");
                            }
                        } else {
                            System.out.println("No es un ID valido");
                        }
                    }
                    System.out.println("Desea volver al menu anterior? (s/n)");
                    String volver = lector.nextLine();
                    if (volver.equals("s")) {
                        menuAtras = true;
                    }
                }
            }
        } while (!menuAtras);
        return amigo;
    }

    private void eliminarMensaje(Perfil amigo, Mensaxe mensaje) {
        amigo.eliminarMensaxe(mensaje);
    }

    private void marcarMesaxeComoLido(Mensaxe mensaxe) { // marca el mensaje como leido
        mensaxe.setLido(true);
    }

    private void escribirMensaje(Perfil remitente, Perfil destinatario) { // escribe un mensaje
        boolean menuAtras = false;
        String texto;
        do {
            System.out.println("Usuario: " + remitente.getNombre());
            System.out.println("Escriba el texto del mensaje para " + destinatario.getNombre()
                    + " o 0 para volver al menu anterior");
            texto = lector.nextLine();
            if (texto.equals("0")) {
                menuAtras = true;
            } else {
                Mensaxe mensaxe = new Mensaxe(texto, remitente);
                destinatario.engadirMensaxePrivada(mensaxe);
            }
            limpiarPantalla();
        } while (!menuAtras);
    }

    public void pecharSesion() { // cierra la sesion
        sesionActual = null;
    }

    private void crearPerfil() { // crea un perfil

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

    private void iniciarSesion() { // inicia sesion

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

    // muesta tus amigos y sus estados o te redirije a enviar solicitud, este metodo
    // es muy largo y por eso esta comentado en varias partes
    private void listaAmigos(Perfil sesionActual) {
        boolean menuAtras = false;
        String opciones;

        do {
            if (sesionActual.getAmigos().isEmpty()) { // si no tienes amigos te da la opcion de añadir uno
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
            } else { // si tienes amigos te muestra la lista de amigos y sus estados
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
            if (nombreSolicitud.equals("0")) { // si es 0 te redirije al menu anterior
                menuAtras = true;
            } else { // si no es 0 te muestra el perfil seleccionado
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

    private void ascii(int opcion) { // este metodo es para poner ascii art en el menu
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
            System.out.println(" ");
            switch (comando) {
                case "salir":
                    System.out.println("Saliendo...");
                    System.out.println("Presiona enter para continuar");
                    break;
                case "ayuda": // Este comando muestra los comandos disponibles
                    System.out.println("Comandos disponibles(no usar varios a la vez): " + '\n' +
                            "salir: cierra la consola" + '\n' +
                            "perfiles: crea varios perfiles" + '\n' +
                            "solicitudes: crea varios perfiles y manda solicitud de varios a uno" + '\n' +
                            "amigos: crea varios perfiles ya amigos" + '\n' +
                            "admin: muestra los perfiles con su contraseña, solicitudes y amigos" + '\n' +
                            "ayuda: muestra los comandos disponibles");
                    System.out.println(" ");
                    System.out.println("Presiona enter para continuar");

                    break;
                case "perfiles": // Este comando crea varios perfiles
                    System.out.println("Introduce el numero de perfiles a crear");
                    int numero = lector.nextInt();
                    for (int i = 0; i < numero; i++) {
                        String nombre = "usuario" + i;
                        String contraseña = "llave" + i;
                        Perfil perfil = new Perfil(nombre, contraseña);
                        CaraLibroBD.engadirPerfil(perfil);
                    }
                    System.out.println(" ");
                    break;
                case "solicitudes": // Este comando crea varios perfiles y manda solicitud de varios a uno
                    System.out.println("Introduce el numero de perfiles a crear");
                    int numero2 = lector.nextInt();
                    for (int i = 0; i < numero2; i++) {
                        String nombre = "usuario" + i;
                        String contraseña = "llave" + i;
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
                    System.out.println(" ");
                    break;
                case "amigos": // Este comando crea varios perfiles ya amigos
                    System.out.println("Introduce el numero de perfiles a crear");
                    int numero3 = lector.nextInt();
                    for (int i = 0; i < numero3; i++) {
                        String nombre = "usuario" + i;
                        String contraseña = "llave" + i; // llave en vez de contraseña por problemas que no he podido
                                                         // solucionar
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
                    System.out.println(" ");
                    break;
                case "admin":
                    admin();
                    System.out.println("Presiona enter para continuar");
                    System.out.println(" ");
                    break;
                default:
                    System.out.println("Comando no reconocido");
                    System.out.println("Presiona enter para continuar");
                    break;
            }

            lector.nextLine();

        } while (!comando.equals("salir"));
    }

    public void admin() { // Este metodo es para debuggear, muestra los perfiles con su contraseña,
                          // solicitudes y amigos
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