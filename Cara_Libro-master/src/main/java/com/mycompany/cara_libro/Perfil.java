
package com.mycompany.cara_libro;

import java.util.ArrayList;

/**
 *
 * @author VictorLandin & Ruben-rpegh-13
 */
class Perfil {
    
    public String nombre;
    public String contraseña;
    public String estado;
    private ArrayList<Perfil> amigos;
    private ArrayList<Perfil> solicitud;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String apellidos) {
        this.contraseña = apellidos;
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
        this.contraseña = contraseña;
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