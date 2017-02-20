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
public class ColaFichas {
    NodoColaFichas inicio,fin;
    int tamaño;
    
    public ColaFichas(){
        inicio=fin=null;
        tamaño=0;
    }
    
    public boolean estaVacia(){
        return inicio==null;
    }
    
    public void insertar(char letra, int punteo){
        NodoColaFichas nuevo = new NodoColaFichas(letra, punteo);
        if(estaVacia()){
            inicio=nuevo;
        }else{
            fin.siguiente=nuevo;
        }
        fin=nuevo;
        tamaño++;
    }
    
    public char pop(){
        char aux = inicio.letra;
        inicio=inicio.siguiente;
        tamaño--;
        return aux;
    }
    
    public char inicioCola(){
        return inicio.letra;
    }
    
    public int tamañoCola(){
        return tamaño;
    }
    
    public void graficar(){
                File f;
                FileWriter w;
                BufferedWriter bw;
                PrintWriter wr;
                String nombre = "cola.dot";
                
                try {
                f=new File(nombre);
                w=new FileWriter(f);
                bw=new BufferedWriter(w);
                wr=new PrintWriter(bw);
                                		
		wr.write("digraph ListaS{\n");
                wr.append("label= \"Cola\"\n");
                wr.append("\tnode [fontcolor=\"red\", height=0.5, color=\"black\"]\n");
                wr.append("\tedge [color=\"black\", dir=fordware]\n");
                auxLd(wr);                
		wr.append("\n}");
		wr.close();
                bw.close();
                    try {
                        ProcessBuilder pbuilder;
                        
                        pbuilder = new ProcessBuilder("dot","listasimple.dot", "-Tpng", "-o", "listasimple.png");                        
                        pbuilder.redirectErrorStream(true);
                        pbuilder.start();                        
                    } catch (Exception e) {
                    }		
            } catch (Exception e) {
            }                                
     }          
     
    public final void auxLd(PrintWriter wr){
        NodoColaFichas temp = inicio;        
        String texto,texto2;
        if(temp!=null){
            while(temp!=null){
            texto="nodo"+temp.letra+"[label=\"Letra: "+temp.letra+ "\\n Puntos: " + temp.punteo + "\"];\n";
            wr.append(texto);                                           
            
            if(temp.siguiente!=null)
				{
                                    texto2="nodo"+temp.letra+"->nodo"+temp.siguiente.letra+";\n";
                                    wr.append(texto2);					
				}
            temp=temp.siguiente;            
        }
        }        
    }
}
