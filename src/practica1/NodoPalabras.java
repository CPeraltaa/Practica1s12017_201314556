/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author Carlos
 */
public class NodoPalabras {
    private String palabra;
    NodoPalabras siguiente;

    public NodoPalabras(String p, NodoPalabras nodo){
        palabra=p;
        siguiente=nodo;
    }
            
    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public NodoPalabras getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPalabras siguiente) {
        this.siguiente = siguiente;
    }
    
}
