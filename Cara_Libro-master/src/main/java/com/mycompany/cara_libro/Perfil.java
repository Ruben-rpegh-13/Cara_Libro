
package com.mycompany.cara_libro;

import java.util.ArrayList;

/**
 *
 * @author VictorLandin & Ruben-rpegh-13
 */


class Perfil {
    
    //atributos del perfil
    
    public String nombre;
    public String contraseña;
    public String estado;
    private ArrayList<Perfil> amigos;
    private ArrayList<String> solicitud;

    //Getter  y Setter 
    
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

    public ArrayList<String> getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(ArrayList<String> solicitud) {
        this.solicitud = solicitud;
    }

    
    
    Perfil(String nombre, String contraseña) {
        
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.estado = estado;
        this.amigos = new ArrayList<Perfil>();
        this.solicitud = new ArrayList <String>();
        
       
    }
            //Este metodo sirve para una añadir un perfil a tu lista de amigos
      public Perfil engadirAmigo (Perfil amigo){
         
          //listaAmigos.get(amigo).add(this);
       
        return null;
          
          
      }
             //añade tu nombre a la lista de solicitudes de la otra persona
    public void engadirSolicitudeDeAmistad(Perfil perfilAmigo) {
        perfilAmigo.solicitud.add(nombre);
    }
            //acepta la solicitud, se añade como amigo en ambos perfiles y luego  elimina  la solicitud
    public void aceptarSolicitudeDeAmistad(Perfil perfilAmigo) { 
        amigos.add(perfilAmigo);
        CaraLibroBD.buscarPerfil(perfilAmigo.getNombre()).amigos.add(this);
        solicitud.remove(perfilAmigo.getNombre());
    }
            //elimina la solicitud de la lista de pendientes
    public void rexeitarSolicitudeDeAmistad(Perfil perfilAmigo) { 
        solicitud.remove(perfilAmigo.getNombre());
    }
    
}