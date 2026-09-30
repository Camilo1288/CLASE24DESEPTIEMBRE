/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.intrografos;
import java.util.*;
/**
 *
 * @author Usuario
 */
public class Grafo implements IGrafo{
  
    private Map<Integer, Nodo> nodos = new HashMap<>();
 
  
    public void agregarNodo(int valor) {
        if (!nodos.containsKey(valor)) {
            nodos.put(valor, new Nodo(valor));
        }
    }
 
    
    public void agregarArista(int origen, int destino) {
        if (nodos.containsKey(origen) && nodos.containsKey(destino)) {
            Nodo nodoOrigen = nodos.get(origen);
            Nodo nodoDestino = nodos.get(destino);
 
            nodoOrigen.agregarVecino(nodoDestino);
            nodoDestino.agregarVecino(nodoOrigen); 
        }
    }
 
    
    public void mostrarMatrizAdyacencia() {
        System.out.println("Matriz de Adyacencia:");
        List<Integer> claves = new ArrayList<>(nodos.keySet());
        Collections.sort(claves); // Ordenar nodos por valor
 
        
        System.out.print("   ");
        for (int i : claves) System.out.print(i + " ");
        System.out.println();
 
      
        for (int i : claves) {
            System.out.print(i + ": ");
            for (int j : claves) {
                Nodo nodoI = nodos.get(i);
                Nodo nodoJ = nodos.get(j);
                System.out.print(nodoI.getVecinos().contains(nodoJ) ? "1 " : "0 ");
            }
            System.out.println();
        }
    }
 
   
    public void mostrarListaAdyacencia() {
        System.out.println("Lista de Adyacencia:");
 
        for (Map.Entry<Integer, Nodo> entrada : nodos.entrySet()) {
            System.out.print(entrada.getKey() + ": ");
            List<INodo> vecinos = entrada.getValue().getVecinos();
 
            for (INodo vecino : vecinos) {
                System.out.print(vecino.getValor() + " ");
            }
            System.out.println();
        }
    }
 
   
    public void bfs(int inicio) {
        if (!nodos.containsKey(inicio)) return; // precondición
 
        Set<Integer> visitados = new HashSet<>();
        Queue<Nodo> cola = new LinkedList<>();
 
        Nodo nodoInicio = nodos.get(inicio);
        cola.add(nodoInicio);
        visitados.add(inicio);
 
        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            System.out.print(actual.getValor() + " ");
 
            for (INodo vecino : actual.getVecinos()) {
                if (!visitados.contains(vecino.getValor())) {
                    visitados.add(vecino.getValor());
                    cola.add((Nodo) vecino);
                }
            }
        }
        System.out.println();
    }
 
   
    public void dfs(int inicio) {
        if (!nodos.containsKey(inicio)) return; // precondición
 
        Set<Integer> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfsRec(nodos.get(inicio), visitados);
        System.out.println();
    }
 
    
    private void dfsRec(Nodo actual, Set<Integer> visitados) {
        visitados.add(actual.getValor());
        System.out.print(actual.getValor() + " ");
 
        List<INodo> vecinos = actual.getVecinos();
        for (int i = vecinos.size() - 1; i >= 0; i--) {
            INodo vecino = vecinos.get(i);
            if (!visitados.contains(vecino.getValor())) {
                dfsRec((Nodo) vecino, visitados);
            }
        }
    }
}
