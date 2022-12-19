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
  public class Publicacion {
	
	public LocalDate data;
	public String texto;
	public int meGusta;
	public String comentario;
	public boolean lido;
	Scanner teclado = new Scanner(System.in);
	
	//Permite publicar unha publicacion e muestra a hora da publicacion
	public Publicacion(String texto){
		
		texto =teclado.nextLine();
		mostrarTexto();
		mostrarmeGusta();
		mostrarComentarios();
		mostrarData();
		mostrarLido();
	}
	
	//Permite dar like a una publicacion
	public void darLike(){
		
		meGusta++;
	}
	
	//Permite ver cuanto comentarios tiene una publicacion
	public void comentar(){
		
		comentario++;
	}
	
	//Permite mostrar el numero de meGusta de una publicacion
	public void mostrarmeGusta(){
		
		System.out.println("meGusta: "+meGusta);
	}
	
	//Permite mostrar el numero de comentarios de una publicacion
	public void mostrarComentarios(){
		
		System.out.println("Comentarios: "+comentario);
	}
	
	//Permite mostrar el texto de una publicacion
	public void mostrarTexto(){
		
		System.out.println(texto);
	}
	
	//Permite mostrar la fecha de una publicacion
	public void mostrarData(){
		
		System.out.println(data);
	}
	
	//Permite mostrar si una publicacion ha sido leida o no
	public void mostrarLido(){
		
		if (lido=true)
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("Lido");
	} 
   }
    
    
}
