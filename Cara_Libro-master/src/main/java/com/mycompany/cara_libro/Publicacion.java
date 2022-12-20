/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cara_libro;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author VictorLandin & Ruben-rpegh-13
 */
public class Publicacion {

    public LocalDate data;
    public String texto;
    public int meGusta;
    public int numComentario;
    private ArrayList<Comentario> comentario = new ArrayList<Comentario>();
    private ArrayList<Perfil> perfilLike = new ArrayList<Perfil>();
    public boolean lido;

    public ArrayList<Comentario> getComentario() {
        return comentario;
    }

    public void setComentario(ArrayList<Comentario> comentario) {
        this.comentario = comentario;
    }

    public ArrayList<Perfil> getPerfilLike() {
        return perfilLike;
    }

    public void setPerfilLike(ArrayList<Perfil> perfilLike) {
        this.perfilLike = perfilLike;
    }

    // Permite publicar unha publicacion e muestra a hora da publicacion
    public Publicacion(Perfil autor, String texto) {

        this.texto = texto;
        this.data = LocalDate.now();
        this.meGusta = 0;
        this.numComentario = 0;
    }

    public void mostrar() {
        mostrarTexto();
        mostrarmeGusta();
        mostrarData();
        mostrarComentarios();
    }

    // Permite dar like a una publicacion
    public void darLike(Perfil autor) {
        if (perfilLike.contains(autor)) {
            meGusta--;
        } else {
            meGusta++;
            perfilLike.add(autor);
        }
    }

    // Permite ver cuanto comentarios tiene una publicacion
    public void comentar() {

        numComentario++;
    }

    // Permite mostrar el numero de meGusta de una publicacion
    public void mostrarmeGusta() {

        System.out.println("meGusta: " + meGusta);
    }

    // Permite mostrar el numero de comentarios de una publicacion
    public void mostrarComentarios() {

        System.out.println("Comentarios: ");
        for (Comentario comentario : comentario) {
            System.out.println(comentario.texto);
            System.out.println(comentario.data);
            System.out.println(comentario.getAutor().getNombre());
        }
    }

    // Permite mostrar el texto de una publicacion
    public void mostrarTexto() {

        System.out.println(texto);
    }

    // Permite mostrar la fecha de una publicacion
    public void mostrarData() {

        System.out.println(data);
    }

    public void engadirComentario(Comentario comentario) {
        this.comentario.add(comentario);
    }
}
