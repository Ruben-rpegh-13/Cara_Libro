/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cara_libro;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author VictorLandin & Ruben-rpegh-13
 * 
 */
public class Comentario {
    
    public LocalDate data;
    public String texto;
    Scanner teclado = new Scanner(System.in);
    
    //Permite comentar una publicacion y muestra la hora del comentario
    public Comentario(String texto){        
        texto =teclado.nextLine();
        System.out.println(/*Aqui iria la hora */); 
    }
}
