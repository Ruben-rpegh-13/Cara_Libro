
package com.mycompany.cara_libro;

/**
 *
 * @author VictorLandin & Ruben-rpegh-13
 */
class Perfil {
    
    public String nombre;
    public String apellidos;
    public String estado;

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

    
    
    Perfil(String nombre, String contraseña) {
        
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.estado = estado;
        this.amigos = new ArrayList<>();
        this.solicitud = new ArrayList <>();
        
       
    }
      public Perfil engadirAmigo (Perfil){
          
          
      }
    
    
    
}
