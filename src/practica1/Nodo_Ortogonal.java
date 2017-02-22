package practica1;

public class Nodo_Ortogonal
{
	public int x;
	public int y;
	public int puntos;
        public char letra;
	public Nodo_Ortogonal arriba;
	public Nodo_Ortogonal abajo;
	public Nodo_Ortogonal izquierda;
	public Nodo_Ortogonal derecha;
	public Nodo_Ortogonal(int x, int y, int costoV, int tiempoV)
	{
		this.x = x;
		this.y = y;		
		arriba = null;
		abajo = null;
		izquierda = null;
		derecha = null;
	}
	public Nodo_Ortogonal()
	{
		x = 0;
		y = 0;		
		arriba = null;
		abajo = null;
		izquierda = null;
		derecha = null;
	}
}