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
import java.util.Random;

/**
 *
 * @author Carlos
 */
public class ListaJugadores {
    NodoJugadores ultimo;
    ColaFichas cola = new ColaFichas();    
    int bandera =0;
    public ListaJugadores(){
        ultimo=null;        
    }
    
    public boolean estaVacia(){
        return ultimo==null;
    }
    
    public void revolver(){
        if (bandera == 0){
            cola.llenarRandom();                                   
            try {
                Thread.sleep(4000);
            } catch (Exception e) {
            }
            for (int i = 0; i<95; i++){
                //Random aleatorio = new Random(); 
               // int numero = aleatorio.nextInt(2)+1;
                int j;
                char a;
                //switch(numero){
                   // case 1:
                   if(cola.lt.fin!=null){
                        a=cola.lt.ExtraerFinal();
                        j=cola.retornaValor(a);
                        cola.insertar(a, j);
                   }
                      //  break;
                   // case 2:
                   if (cola.lt.inicio!=null){
                        a = cola.lt.ExtraerInicio();
                        j=cola.retornaValor(a);
                        cola.insertar(a, j);
                       // break;
                   }
               // } 
            }
            cola.graficar();
            bandera++;
        }else{
            System.out.println("Ya se ha llenado la cola de fichas aleatoriamente");
        }
    }            
    
    public ListaJugadores insertar(String name){
        NodoJugadores nuevo = new NodoJugadores(name);        
        for (int i = 0; i<7; i++){
            int temp;
            char temp2;
            temp2 = cola.pop();
            temp = cola.retornaValor(temp2);
            nuevo.fichas.InsertarFinal_ls(temp2,temp);            
        }
        
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
        String texto,texto2, texto3, texto4, texto5;
        if(temp!=null){                                                                               
            do{	
                texto="nodo"+temp.hashCode()+"[label=\"Jugador: "+temp.nombre+"\"];\n";
                wr.append(texto);
                texto2="nodo"+temp.hashCode()+"->nodo"+temp.siguiente.hashCode()+";\n";
                wr.append(texto2);
                
                    NodoFichas temp2 = temp.fichas.inicio;
                    texto5="nodo"+temp.hashCode()+"->nodo"+temp2.hashCode()+";\n";
                    wr.append(texto5);
                if(temp2 != null){
                    
                    while (temp2 != null) {
                    texto3 = "nodo" + temp2.hashCode() + "[label=\"Letra: " + temp2.letra + "\\n Puntos: " + temp2.puntos + "\"];\n";
                    wr.append(texto3);
                         
                    if (temp2.siguiente != null) {
                        texto4 = "nodo" + temp2.hashCode() + "->nodo" + temp2.siguiente.hashCode() + ";\n";
                        wr.append(texto4);
                    }
                        temp2 = temp2.siguiente;
                        
                   }
                }
		temp=temp.siguiente;
                 
            }while(temp!=ultimo.siguiente);
           
        }                
    }
}
