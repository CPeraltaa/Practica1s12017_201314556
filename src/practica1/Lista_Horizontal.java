package practica1;

public class Lista_Horizontal
{
	public Nodo_Ortogonal primero;
	public Nodo_Ortogonal ultimo;

	public Lista_Horizontal()
	{
		primero = null;
		ultimo = null;
	}
	public boolean vacia()
	{
            return primero == null;
	}
	public void insertar(Nodo_Ortogonal inserta)
	{
		if (vacia())
		{
			primero = ultimo = inserta;
		}
		else
		{
			if (inserta.x < primero.x)
			{
				insertarFrente(inserta);
			}
			else if (inserta.x > ultimo.x)
			{
				insertarFinal(inserta);
			}
			else
			{
				insertarMedio(inserta);
			}
		}
	}
	public void insertarFrente(Nodo_Ortogonal inserta)
	{
		primero.izquierda = inserta;
		inserta.derecha = primero;
		primero = primero.izquierda;
	}
	public void insertarFinal(Nodo_Ortogonal inserta)
	{
		ultimo.derecha = inserta;
		inserta.izquierda = ultimo;
		ultimo = ultimo.derecha;
	}
	public void insertarMedio(Nodo_Ortogonal inserta)
	{
		Nodo_Ortogonal temporal1;
		Nodo_Ortogonal temporal2;
		temporal1 = primero;
		while (temporal1.x < inserta.x)
		{
			temporal1 = temporal1.derecha;
		}
		temporal2 = temporal1.izquierda;
		temporal2.derecha = inserta;
		temporal1.izquierda = inserta;
		inserta.derecha = temporal1;
		inserta.izquierda = temporal2;
	}
	public void recorrer()
	{
		if (!vacia())
		{
			Nodo_Ortogonal temporal = primero;
			while (temporal != null)
			{
				temporal = temporal.derecha;
			}
		}
	}
}