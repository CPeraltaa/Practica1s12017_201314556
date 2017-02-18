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
public class ListaJugadores {
    NodoJugadores ultimo;
    
    public ListaJugadores(){
        ultimo=null;
    }
    
    public boolean estaVacia(){
        return ultimo==null;
    }
    
    public ListaJugadores insertar(String name){
        NodoJugadores nuevo = new NodoJugadores(name);
        if(ultimo!=null){
            nuevo.siguiente=ultimo.siguiente;
            ultimo.siguiente=nuevo;            
        }
        ultimo=nuevo;
        return this;
    }
    
    public void mostrarLista(){
        NodoJugadores auxiliar=ultimo.siguiente;        
        do{
            System.out.println(auxiliar.nombre);
            auxiliar=auxiliar.siguiente;
        }while(auxiliar!=ultimo.siguiente);
    }
    
    public boolean eliminar(String name){
        NodoJugadores actual=ultimo;
        boolean encontrado=false;
        while(actual.siguiente!=ultimo && !encontrado){
            encontrado=(actual.siguiente.nombre.equals(name));
            if(!encontrado){
                actual=actual.siguiente;
            }
        }
        encontrado=(actual.siguiente.nombre.equals(name));
        if(encontrado){
            NodoJugadores auxiliar=actual.siguiente;
            if(ultimo==ultimo.siguiente){
                ultimo=null;
            }else{
                if(auxiliar==ultimo){
                    ultimo=actual;
                }
                actual.siguiente=auxiliar.siguiente;
            }
            auxiliar=null;
        }
        return encontrado==true;
    }
    
    public void graficar(){
                File f;
                FileWriter w;
                BufferedWriter bw;
                PrintWriter wr;
                String nombre = "listacircular.dot";
                
                try {
                f=new File(nombre);
                w=new FileWriter(f);
                bw=new BufferedWriter(w);
                wr=new PrintWriter(bw);
                                		
		wr.write("digraph ListaS{\n");
                wr.append("label= \"Lista circular\"\n");
                wr.append("\tnode [fontcolor=\"red\", height=0.5, color=\"black\"]\n");
                wr.append("\tedge [color=\"black\", dir=fordware]\n");
                auxLd(wr);                
		wr.append("\n}");
		wr.close();
                bw.close();
                    try {
                        ProcessBuilder pbuilder;
                        
                        pbuilder = new ProcessBuilder("dot","listacircular.dot", "-Tpng", "-o", "listacircular.png");                        
                        pbuilder.redirectErrorStream(true);
                        pbuilder.start();                        
                    } catch (Exception e) {
                    }		
            } catch (Exception e) {
            }                                
     }          
     
    public final void auxLd(PrintWriter wr){
        NodoJugadores temp = ultimo.siguiente;        
        String texto,texto2,texto3;
        if(temp!=null){                                                                               
            do{	
                texto="nodo"+temp.nombre+"[label=\"Palabra: "+temp.nombre+"\"];\n";
                wr.append(texto);
                texto2="nodo"+temp.nombre+"->nodo"+temp.siguiente.nombre+";\n";
                wr.append(texto2);					
		temp=temp.siguiente;
            }while(temp!=ultimo.siguiente);            
        }                
    }
}
