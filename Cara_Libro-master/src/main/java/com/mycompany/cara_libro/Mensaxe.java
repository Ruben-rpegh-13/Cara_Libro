/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cara_libro;

import java.util.Date;

/**
 *
 * @author VictorLandin & Ruben-rpegh-13
 */
public class Mensaxe {

    public Date data;
    public String texto;
    public boolean lido;
    Perfil remitente;

    public Mensaxe(String texto, Perfil remitente) {
        this.texto = texto;
        this.data = new Date();
        this.lido = false;
        this.remitente = remitente;
    }

    //Getter y Setter

    public Perfil getRemitente() {
        return remitente;
    }

    public void setRemitente(Perfil remitente) {
        this.remitente = remitente;
    }

    public boolean isLido() {
        return lido;
    }

    public void setLido(boolean lido) {
        this.lido = lido;
    }

    public Date getData() {
        return data;
    }  

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setData(Date data) {
        this.data = data;
    }

    
}
