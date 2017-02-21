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
public class NodoTemporal {
    public NodoTemporal siguiente;
    public NodoTemporal anterior;
    public char letra;
    
    public NodoTemporal (char dat){
        this(dat,null,null);
    }

    public NodoTemporal(char dat, NodoTemporal sig, NodoTemporal ant){
        letra = dat;
        siguiente = sig;        
        anterior = ant;
        
        
    }           
}
