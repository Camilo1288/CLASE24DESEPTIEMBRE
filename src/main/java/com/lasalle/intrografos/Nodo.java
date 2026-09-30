/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.intrografos;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Usuario
 */
public class Nodo implements INodo{
    private int valor; 
    private List<INodo> vecinos; 
 
    // Constructor
    public Nodo(int valor) {
        this.valor = valor;
        this.vecinos = new ArrayList<>(); 
    }
 
    public int getValor() {
        return valor;
    }
 
    public void setValor(int valor) {
        this.valor = valor;
    }
 
    
    public void agregarVecino(INodo vecino) {
        if (!vecinos.contains(vecino)) {
            vecinos.add(vecino);
        }
    }
 
    public List<INodo> getVecinos() {
        return vecinos;
    }
}
