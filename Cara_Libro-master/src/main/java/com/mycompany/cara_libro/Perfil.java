
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
    private ArrayList<Perfil> amigos;
    private ArrayList<Perfil> solicitud;

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

    public ArrayList<Perfil> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<Perfil> amigos) {
        this.amigos = amigos;
    }

    public ArrayList<Perfil> getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(ArrayList<Perfil> solicitud) {
        this.solicitud = solicitud;
    }

    
    
    Perfil(String nombre, String contraseña) {
        
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.estado = estado;
        this.amigos = new ArrayList<Perfil>();
        this.solicitud = new ArrayList <Perfil>();
        
       
    }
      public Perfil engadirAmigo (Perfil amigo){
          
          
        return null;
          
          
      }

    public void engadirSolicitudeDeAmistad(Perfil amigo) {
        
    }
    
    
    
}
