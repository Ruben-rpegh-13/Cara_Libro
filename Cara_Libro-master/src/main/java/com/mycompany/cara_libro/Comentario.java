/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cara_libro;
import java.util.Date;

/**
 *
 * @author VictorLandin & Ruben-rpegh-13
 * 
 */
public class Comentario {
    
    public Date data;
    public String texto;
    private Perfil autor;

    public Perfil getAutor() {
        return autor;
    }

    public void setAutor(Perfil autor) {
        this.autor = autor;
    }

    //Permite comentar una publicacion y muestra la hora del comentario
    public Comentario(String texto){
        
        this.texto = texto;
        this.data = new Date();

    }

    //Esto es un comentario de practica

}
