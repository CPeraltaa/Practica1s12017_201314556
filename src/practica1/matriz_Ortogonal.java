package practica1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class matriz_Ortogonal
{
	public cabeceras c;
	public Laterales l;

	public matriz_Ortogonal()
	{
		c = new cabeceras();
		l = new Laterales();
	}
	public final boolean existe(int x, int y)
	{
		Nodo_Lateral nodoCol = l.primero;
		if (nodoCol == null)
		{
			return false;
		}
		else
		{
			while (nodoCol != null)
			{
				Nodo_Ortogonal nodoRow = nodoCol.Fila.primero;
				while (nodoRow != null)
				{
					if ((nodoRow.x == x && (nodoRow.y == y)))
					{
						return true;
					}
					nodoRow = nodoRow.derecha;
				}
				nodoCol = nodoCol.siguiente;
			}
		}
		return false;

	}
	
	public  void modificar(int x, int y, char let, int punt)
	{
		if (existe(x, y))
		{
			Nodo_Lateral nodoCol = l.primero;
			while (nodoCol != null)
			{
				Nodo_Ortogonal nodoRow = nodoCol.Fila.primero;
				while (nodoRow != null)
				{
					if ((nodoRow.x == x && (nodoRow.y == y)))
					{
						
						nodoRow.letra = let;
						nodoRow.puntos = punt;
					}					
					nodoRow = nodoRow.derecha;
				}
				nodoCol = nodoCol.siguiente;
			}
		}
		else
		{			
			insertar(x, y, let, punt);			
		}
	}
	public void insertar(int x, int y, char let, int punt)
	{
		if (!existe(x, y))
		{
			Nodo_Ortogonal insercion;
			insercion = new Nodo_Ortogonal(x, y, let, punt);
			if (c.existe(x) == false)
			{
				c.insertar(new Nodo_Cabecera(x));
			}
			if (l.existe(y) == false)
			{
				l.insertar(new Nodo_Lateral(y));
			}
			Nodo_Cabecera cTemporal;
			Nodo_Lateral lTemporal;
			cTemporal = c.busqueda(x);
			lTemporal = l.busqueda(y);
			cTemporal.Columna.insertar(insercion);
			lTemporal.Fila.insertar(insercion);

		}
		else
		{
		   System.out.println("Ruta ya insertada");
		}
	}
        
	public void crearHeader(int xy)
	{
		if (c.existe(xy) == false)
		{
			c.insertar(new Nodo_Cabecera(xy));
		}
		if (l.existe(xy) == false)
		{
			l.insertar(new Nodo_Lateral(xy));
		}
		Nodo_Cabecera cTemporal;
		Nodo_Lateral lTemporal;
		cTemporal = c.busqueda(xy);
		lTemporal = l.busqueda(xy);
	}	

	public void graficarMatriz()
	{

		String conexionHeadColumID = "NODOM";
		String conexionHeadColumDI = "";
		String headColum = "{\nrank=min;\nNODOM[label=\"Rutas de vuelo\"];\n";
		String conexionesVerticalesID = "";
		String conexionesVerticalesDI = "";
		String bloqueConexVert = "";
		Nodo_Lateral nodoTemp1 = l.primero;
		while (nodoTemp1 != null)
		{
			headColum = headColum + "NODOC" + nodoTemp1.y + "[label=\"Posicion: " + nodoTemp1.y +  "\",rankdir=LR];\n";
			conexionHeadColumID = conexionHeadColumID + " -> NODOC" + nodoTemp1.y;
			if (nodoTemp1.siguiente != null)
			{
				conexionHeadColumDI = " -> NODOC" + nodoTemp1.y + conexionHeadColumDI;
			}
			conexionesVerticalesID = "NODOC" + nodoTemp1.y;
			conexionesVerticalesDI = "NODOC" + nodoTemp1.y;
			Nodo_Ortogonal nodoTemp2 = nodoTemp1.Fila.primero;
			while (nodoTemp2 != null)
			{
				conexionesVerticalesID = conexionesVerticalesID + " -> NODO" + nodoTemp2.x + nodoTemp1.y;
				conexionesVerticalesDI = "NODO" + nodoTemp2.x + nodoTemp1.y + " -> " + conexionesVerticalesDI;
				nodoTemp2 = nodoTemp2.derecha;
			}
			conexionesVerticalesID = conexionesVerticalesID + ";\n";
			conexionesVerticalesDI = conexionesVerticalesDI + ";\n";
			bloqueConexVert = bloqueConexVert + conexionesVerticalesID + conexionesVerticalesDI;
			conexionesVerticalesID = "";
			conexionesVerticalesDI = "";
			nodoTemp1 = nodoTemp1.siguiente;
		}


		Nodo_Cabecera nodoFila = c.primero;
		if (nodoFila != null)
		{

			String headFila = "";
			String conexioHeadFila = "";
			String headFilaAnterior = "NODOM";
			String nodoAnterior = "";
			String etiquetaRank = "\n{\nrank=same;\n";
			String bloqueRank = "";
			String conexionesHoriz = "";
			String bloqueConexHoriz = "";
			boolean esPrimeraFila = true;
			while (nodoFila != null)
			{

				if (esPrimeraFila)
				{
					conexioHeadFila = headFilaAnterior + " -> NODOF" + nodoFila.x + "\n";
					headFilaAnterior = "NODOF" + nodoFila.x;
					esPrimeraFila = false;
				}
				else
				{
					conexioHeadFila = conexioHeadFila + headFilaAnterior + " -> NODOF" + nodoFila.x + "[rankdir=UD];\n";
					conexioHeadFila = conexioHeadFila + "NODOF" + nodoFila.x + " -> " + headFilaAnterior + "\n";
					headFilaAnterior = "NODOF" + nodoFila.x;
				}



				if (nodoFila.siguiente == null)
				{
					etiquetaRank = "\n{\nrank=max;\n";
				}
				nodoAnterior = "NODOF" + nodoFila.x;
				headFila = etiquetaRank + "NODOF" + nodoFila.x + "[label=\"Posicion: " + nodoFila.x + "\"];\n";
				Nodo_Ortogonal nodoColum = nodoFila.Columna.primero;
				while (nodoColum != null)
				{
					headFila = headFila + "NODO" + nodoFila.x + nodoColum.y + "[label=\"Letra: " + nodoColum.letra + "\\nPunteo letra: " + nodoColum.puntos + "\"];\n";

					conexionesHoriz = conexionesHoriz + nodoAnterior + " -> " + "NODO" + nodoFila.x + nodoColum.y + "[constraint=false];\n";
					conexionesHoriz = conexionesHoriz + "NODO" + nodoFila.x + nodoColum.y + " -> " + nodoAnterior + "[constraint=false];\n";
					nodoAnterior = "NODO" + nodoFila.x + nodoColum.y;

					nodoColum = nodoColum.abajo;
				}
				bloqueConexHoriz = bloqueConexHoriz + conexionesHoriz + "\n";
				conexionesHoriz = "";
				nodoAnterior = "";
				bloqueRank = bloqueRank + headFila + "}\n";
				headFila = "";
				nodoFila = nodoFila.siguiente;
			}
			headColum = headColum + "}\n";
                File f;
                FileWriter w;
                BufferedWriter bw;
                PrintWriter wr;
                String nombre = "matriz.dot";
                                               
                        try {
                        f=new File(nombre);
                        w=new FileWriter(f);
                        bw=new BufferedWriter(w);
                        wr=new PrintWriter(bw);
                        
                        wr.write("digraph Mat_Orto{\n" + System.lineSeparator());
				wr.write("rankdir=UD;\n" + System.lineSeparator());
				wr.write("node[shape = box ]\n" + System.lineSeparator());
				wr.write(headColum + System.lineSeparator());
				wr.write(bloqueRank + System.lineSeparator());
				wr.write(conexionHeadColumID + conexionHeadColumDI + System.lineSeparator());
				wr.write("\n" + conexioHeadFila + System.lineSeparator());
				wr.write(bloqueConexVert + "\n" + System.lineSeparator());
				wr.write(bloqueConexHoriz + System.lineSeparator());
				wr.write("}\n" + System.lineSeparator());
				wr.close();
                                bw.close();
				try {
                                    ProcessBuilder pbuilder;
                        
                                    pbuilder = new ProcessBuilder("dot","matriz.dot", "-Tpng", "-o", "matriz.png");                        
                                    pbuilder.redirectErrorStream(true);
                                    pbuilder.start();                        
                                    } catch (Exception e) {
                                    }
                    } catch (Exception e) {
                    }			
                               
		}
		else
		{
			System.out.println("No existen datos para generarDot");
		}

	}	
	
}