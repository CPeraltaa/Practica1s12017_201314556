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
public class ListaFichas {
    NodoFichas inicio;
    NodoFichas fin;
    
    public ListaFichas(){
        inicio =null;
        fin = null;
    }
    
    public void InsertarInicio_ls(char l, int p){
        NodoFichas nuevo = new NodoFichas(l, p, inicio);
        inicio = nuevo;
        if(fin==null){
            fin=inicio;           
        }
        System.out.println("Se ha agregado a la lista: ");
        System.out.println(nuevo.letra);                
    }
    
    public void InsertarFinal_ls(char l, int p){
        NodoFichas nuevo = new NodoFichas(l,p, null);
        if(inicio==null){
            fin=nuevo;
            inicio=fin;
        }else{
            fin.siguiente=nuevo;
            fin = nuevo;
        }
    }
    
    public void EliminarInicio(){
        inicio =inicio.siguiente;        
    }
        
    public char ExtraerInicio(){
        char letra = inicio.letra;
        inicio=inicio.siguiente;
        if(inicio==null){
            fin=null;
        }
        return letra;
    }
    
    public void Listar(){
        NodoFichas temp = inicio;
        while(temp!=null){
            System.out.println(temp.letra);
            temp = temp.siguiente;            
        }
    }
    
    public void graficar(){
                File f;
                FileWriter w;
                BufferedWriter bw;
                PrintWriter wr;
                String nombre = "listasimple.dot";
                
                try {
                f=new File(nombre);
                w=new FileWriter(f);
                bw=new BufferedWriter(w);
                wr=new PrintWriter(bw);
                                		
		wr.write("digraph ListaS{\n");
                wr.append("label= \"Lista simple\"\n");
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
        NodoFichas temp = inicio;        
        String texto,texto2;
        if(temp!=null){
            while(temp!=null){
            texto="nodo"+temp.letra+"[label=\"Letra: "+temp.letra+"\"];\n";
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
