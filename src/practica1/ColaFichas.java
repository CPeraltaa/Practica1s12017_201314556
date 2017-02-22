/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
public class ColaFichas {

    NodoColaFichas inicio, fin;
    int tamaño;
    ListaTemporal lt = new ListaTemporal();    

    public ColaFichas() {
        inicio = fin = null;
        tamaño = 0;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public void insertar(char letra, int punteo) {
        NodoColaFichas nuevo = new NodoColaFichas(letra, punteo);
        if (estaVacia()) {
            inicio = nuevo;
        } else {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
        tamaño++;
    }

    public char pop() {
        char aux = inicio.letra;
        inicio = inicio.siguiente;
        tamaño--;
        return aux;
    }

    public char inicioCola() {
        return inicio.letra;
    }

    public int tamañoCola() {
        return tamaño;
    }

    public void graficar() {
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
        String nombre = "cola.dot";

        try {
            f = new File(nombre);
            w = new FileWriter(f);
            bw = new BufferedWriter(w);
            wr = new PrintWriter(bw);

            wr.write("digraph ListaS{\n");
            wr.append("label= \"Cola de fichas\"\n");
            wr.append("\tnode [fontcolor=\"red\", height=0.5, color=\"black\"]\n");
            wr.append("\tedge [color=\"black\", dir=fordware]\n");
            auxLd(wr);
            wr.append("\n}");
            wr.close();
            bw.close();
            try {
                ProcessBuilder pbuilder;

                pbuilder = new ProcessBuilder("dot", "cola.dot", "-Tpng", "-o", "cola.png");
                pbuilder.redirectErrorStream(true);
                pbuilder.start();
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
    }

    public final void auxLd(PrintWriter wr) {
        NodoColaFichas temp = inicio;
        String texto, texto2;
        if (temp != null) {
            while (temp != null) {
                texto = "nodo" + temp.hashCode() + "[label=\"Letra: " + temp.letra + "\\n Puntos: " + temp.punteo + "\"];\n";
                wr.append(texto);

                if (temp.siguiente != null) {
                    texto2 = "nodo" + temp.hashCode() + "->nodo" + temp.siguiente.hashCode() + ";\n";
                    wr.append(texto2);
                }
                temp = temp.siguiente;
            }
        }
    }

    public void llenarRandom() {
        
            for (int i = 0; i<12;i++){
                lt.insertarFinal('a');
                lt.insertarFinal('e');
            }            
            
            for (int i = 0; i<9; i++){            
                lt.insertarFinal('o');
            }
            
            for (int i= 0; i<6;i++){            
                lt.insertarFinal('i');
                lt.insertarFinal('s');
            }           

            for(int i = 0; i<5; i++){
                lt.insertarFinal('n');
                lt.insertarFinal('r');
                lt.insertarFinal('u');
                lt.insertarFinal('d');
            }

            for (int i=0; i<4; i++){
                lt.insertarFinal('l');
                lt.insertarFinal('t');
                lt.insertarFinal('c');
            }            
                      

            for(int i= 0; i<2; i++){
                lt.insertarFinal('g');
                lt.insertarFinal('b');
                lt.insertarFinal('m');
                lt.insertarFinal('p'); 
                lt.insertarFinal('h');
            }                      
                                  
            for(int i = 0; i<1; i++){
                lt.insertarFinal('f');
                lt.insertarFinal('v');
                lt.insertarFinal('y');
                lt.insertarFinal('q');
                lt.insertarFinal('j');
                lt.insertarFinal('ñ');
                lt.insertarFinal('x');
                lt.insertarFinal('z');
            }
           lt.graficar();
        JOptionPane.showMessageDialog(null, "Fichas insertadas en la lista");
    }

   
    public int retornaValor(char l) {
        switch (l) {
            case 'a':
                return 1;
            case 'e':
                return 1;
            case 'o':
                return 1;
            case 'i':
                return 1;
            case 's':
                return 1;
            case 'n':
                return 1;
            case 'l':
                return 1;
            case 'r':
                return 1;
            case 'u':
                return 1;
            case 't':
                return 1;
            case 'd':
                return 2;
            case 'g':
                return 2;
            case 'c':
                return 3;
            case 'b':
                return 3;
            case 'm':
                return 3;
            case 'p':
                return 3;
            case 'h':
                return 4;
            case 'f':
                return 4;
            case 'v':
                return 4;
            case 'y':
                return 4;
            case 'q':
                return 5;
            case 'j':
                return 8;
            case 'ñ':
                return 8;
            case 'x':
                return 8;
            case 'z':
                return 10;
            default:
                return 0;
        }

    }
}
