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
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {        
        ListaPalabras lp = new ListaPalabras();
        lp.InsertarFinal_ls("Hola");
        lp.InsertarFinal_ls("Jotadas");
        lp.graficar();
        
        ListaJugadores lj = new ListaJugadores();
        lj.insertar("Jorge");
        lj.insertar("carlos");
        lj.insertar("andrea");
        lj.insertar("mady");
        lj.graficar();
    }
    
}
