package practica1;

public class Nodo_Cabecera
{
	public int x;
	public Nodo_Cabecera siguiente;
	public Nodo_Cabecera anterior;
	public Lista_Vertical Columna;

	public Nodo_Cabecera(int x)
	{
		this.x = x;		
		Columna = new Lista_Vertical();
		siguiente = null;
		anterior = null;

	}	
}