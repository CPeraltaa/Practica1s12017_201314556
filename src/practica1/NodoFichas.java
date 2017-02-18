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
public class NodoFichas {
    char letra;
    int puntos;
    NodoFichas siguiente;
    
    public NodoFichas(char l, int p, NodoFichas nodo) {
        letra=l;
        puntos=p;
        siguiente=nodo;
    }           
}
