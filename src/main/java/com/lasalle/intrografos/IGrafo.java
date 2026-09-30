/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lasalle.intrografos;

/**
 *
 * @author Usuario
 */
public interface IGrafo {
    
    void agregarNodo(int valor); 
    void agregarArista(int origen, int destino); 
 
    void mostrarMatrizAdyacencia(); 
    void mostrarListaAdyacencia(); 
 
    void bfs(int inicio); 
    void dfs(int inicio); 
}
