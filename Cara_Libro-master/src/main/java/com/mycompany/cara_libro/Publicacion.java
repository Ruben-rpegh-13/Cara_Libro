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
 */
  
   /* Commit - subir archivo
      push   - llevar a cabo commit
      pull refrescar proyecto
    
      Proyecto-commit-remote-push SUBIR ARCHIVO
      Proyecto-commit-remote-pull BAJAR ARCHIVO
    */
            
public class Publicacion {

    public LocalDate data;
    public String texto;
    Scanner teclado = new Scanner(System.in);
    
    //metodo para crear una publicacion dentro de un perfil
    public Publicacion(Perfil autor,String texto) {
        
        texto =teclado.nextLine();
        System.out.println( /*Aqui iria la hora */);
        
    }
    //metodo para añadir me gusta a una publicacion 
   public void engadirMeGusta (Perfil perfil){
       int contador=0;
       
       System.out.println("Hay " + contador + "me gusta"); 
   }
    
    
}
