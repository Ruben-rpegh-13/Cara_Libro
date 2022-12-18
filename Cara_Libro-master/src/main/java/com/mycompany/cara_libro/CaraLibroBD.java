
package com.mycompany.cara_libro;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author VictorLandin & Ruben-rpegh-13
 */
class CaraLibroBD {

    private static ArrayList <Perfil> datos = new ArrayList();

    public CaraLibroBD() {
    }
    
    public static void engadirPerfil (Perfil novoPerfil){    
        datos.add(novoPerfil);
    }
    
    
    public static Perfil obterPerfil (String nombre, String contraseña) {
        Perfil devolver = null;
     
     for(int contador = 0; contador < datos.size() ; contador++){
        if(datos.get(contador).getNombre().equals(nombre) && datos.get(contador).getContraseña().equals(contraseña)){
            //verifica nombre Y contraseña
            devolver = datos.get(contador);
        }
     }
        
        return devolver;
    }
    
    public static Perfil buscarPerfil (String nombre){
     
     Perfil devolver = null;
     
     for(int contador = 0; contador < datos.size() ; contador++){
        if(datos.get(contador).getNombre().equals(nombre)){
            devolver = datos.get(contador);
        }
                     
                     
     }
        
        
        return devolver;
    }
    
}