
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

    public class xeradorMenus {
        //this.datos = new CaraLibroBD;
    }

    //P representa el nombre del objeto perfil, puede cambiar luego
    //Estos son los menus
    public void mostrarMenuInicial() { //este menu mostrará las opciones de registrarse e iniciar sesion
        String opciones;
        boolean enSesion = false;
        Scanner lector = new Scanner(System.in);

        do {
            ascii(1);

            //  pongo \n para saltar de linea
            System.out.println("1: Registrarse" + '\n'
                    + "2: iniciar sesion");
            opciones = lector.nextLine();

            switch (opciones) {//
                case "1":
                    crearPerfil();
                    break;
                case "2":
                    iniciarSesion();
                    break;
                default:
                    break;
            }
            limpiarPantalla();
        } while (!enSesion);
    }

    
    public void mostrarMenuPrincipal(Perfil p) {

    }
    
    /* Aun no implementado
    public void mostrarBiografia(Perfil p) {

    }

    public void mostrarSolicitudesDeAmizade(Perfil p) {

    }
    public void mostrarListaAmigos(Perfil p) {

    }
    public void mostrarMensajes(Perfil p) {

    }
    
    //acaban los menus
    
    public void pecharSesion() {

    }
     */
    private void crearPerfil() {

        boolean atras = false;
        boolean correcto = false;
        Scanner lector = new Scanner(System.in);
        String nombre;
        String contraseña;

        do {
            ascii(2);
            System.out.println("Inserte 1 y enter para ir al menu anterior" + '\n' + "O inserte nombre");
            nombre = lector.nextLine();
            if ("1".equals(nombre)) {//compara nombre porque si es igual a 1 vuelve al menu anterior en vez de aceptarlo como usuario
                atras = true;
            } else {
                System.out.println("Contraseña");
                contraseña = lector.nextLine();
                if (this.datos.buscarPerfil(nombre)) {//esta comparacion sirve para no tener  problemas con varios usuarios llamados igual
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
        Scanner lector = new Scanner(System.in);
        String nombre;
        String contraseña;

        do {
            ascii(3);
            System.out.println("Inserte 1 y enter para ir al menu anterior" + '\n' + "O inserte nombre");
            nombre = lector.nextLine();
            if ("1".equals(nombre)) { //compara nombre porque si es igual a 1 vuelve al menu anterior en vez de aceptarlo como usuario
                atras = true;
            } else {
                System.out.println("Contraseña");
                contraseña = lector.nextLine();
            }
        } while (!atras && !correcto);
        if (correcto) {
            mostrarMenuPrincipal(Placeholder); //aun no se ha añadido la clase perfil
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
