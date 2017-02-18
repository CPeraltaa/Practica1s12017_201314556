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
public class NodoJugadores {
    String nombre;
    NodoJugadores siguiente;
    
    public NodoJugadores(String name){
        nombre=name;
        siguiente=this;
    }            
}
