package practica1;

public class Nodo_Lateral
{
	public int y;	
	public Nodo_Lateral siguiente;
	public Nodo_Lateral anterior;
	public Lista_Horizontal Fila;

	public Nodo_Lateral(int y)
	{
		this.y = y;		
		Fila = new Lista_Horizontal();
		siguiente = null;
		anterior = null;

	}	
}