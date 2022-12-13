
package com.mycompany.cara_libro;

import java.util.ArrayList;

/**
 *
 * @author VictorLandin & Ruben-rpegh-13
 */
class Perfil {
    
    public String nombre;
    public String apellidos;
    public String estado;
    ArrayList<Perfil> amigos;
    
    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getapellidos() {
        return apellidos;
    }

    public void setapellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Perfil(String nombre, String apellidos, String estado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.estado = estado;
        this.amigos= new ArrayList<>();
    }

    
      public void engadirAmigo (Perfil perfil){
         this.amigos.add(perfil);
      }
    
    
    
}
