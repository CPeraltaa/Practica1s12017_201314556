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

/**
 *
 * @author Carlos
 */
public class ListaTemporal {

    public NodoTemporal inicio;
    public NodoTemporal fin;

    public ListaTemporal() {
        inicio = fin = null;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public void insertarInicio(char dato) {
        if (!estaVacia()) {
            inicio = new NodoTemporal(dato, inicio, null);
            inicio.siguiente.anterior = inicio;
        } else {
            inicio = fin = new NodoTemporal(dato);
        }
    }

    public void insertarFinal(char dato) {
        if (!estaVacia()) {
            fin = new NodoTemporal(dato, null, fin);
            fin.anterior.siguiente = fin;
        } else {
            inicio = fin = new NodoTemporal(dato);
        }
    }

    public char ExtraerInicio() {
        char dato = inicio.letra;        
        if (inicio == fin) {
            inicio=fin=null;
        } else {
            inicio = inicio.siguiente;
            inicio.anterior=null;
        }
        System.out.println("extraido inicio");
        return dato;
        
    }

    public char ExtraerFinal() {
        char dato = fin.letra;        
        if (inicio == fin) {
            inicio=fin=null;
        } else {
            fin = fin.anterior;
            fin.siguiente=null;
        }
        System.out.println("extraido fin");
        return dato;
    }

    public void graficar() {
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
        String nombre = "listadoble.dot";

        try {
            f = new File(nombre);
            w = new FileWriter(f);
            bw = new BufferedWriter(w);
            wr = new PrintWriter(bw);

            wr.write("digraph ListaS{\n");
            wr.append("label= \"Lista doble\"\n");
            wr.append("\tnode [fontcolor=\"red\", height=0.5, color=\"black\"]\n");
            wr.append("\tedge [color=\"black\", dir=fordware]\n");
            auxLd(wr);
            wr.append("\n}");
            wr.close();
            bw.close();
            try {
                ProcessBuilder pbuilder;

                pbuilder = new ProcessBuilder("dot", "listadoble.dot", "-Tpng", "-o", "listadoble.png");
                pbuilder.redirectErrorStream(true);
                pbuilder.start();
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
    }

    public final void auxLd(PrintWriter wr) {
        NodoTemporal temp = inicio;
        String texto, texto2;
        if (temp != null) {
            while (temp != null) {
                texto = "nodo" + temp.letra + "[label=\"Letra: " + temp.letra + "\"];\n";
                wr.append(texto);

                if (temp.siguiente != null) {
                    texto2 = "nodo" + temp.letra + "->nodo" + temp.siguiente.letra + ";\n";
                    wr.append(texto2);
                }
                temp = temp.siguiente;
            }
        }
    }
}
