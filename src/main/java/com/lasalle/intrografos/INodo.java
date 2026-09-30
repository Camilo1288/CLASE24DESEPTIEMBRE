/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lasalle.intrografos;
import java.util.List;
/**
 *
 * @author Usuario
 */
public interface INodo {
    
    int getValor(); 
    void setValor(int valor); 
    void agregarVecino(INodo vecino); 
    List<INodo> getVecinos(); 

}
