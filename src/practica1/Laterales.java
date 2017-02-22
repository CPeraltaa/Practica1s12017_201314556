package practica1;

public class Laterales
{
	public Nodo_Lateral primero;
	public Nodo_Lateral ultimo;

	public Laterales()
	{
		primero = null;
		ultimo = null;
	}
	public final boolean vacia()
	{
            return primero == null;
	}
	public void insertar(Nodo_Lateral inserta)
	{
		if (vacia())
		{
			primero = ultimo = inserta;
		}
		else
		{
			if (inserta.y < primero.y)
			{
				insertarFrente(inserta);
			}
			else if (inserta.y > ultimo.y)
			{
				insertarFinal(inserta);
			}
			else
			{
				insertarMedio(inserta);
			}
		}
	}
	public void insertarFrente(Nodo_Lateral inserta)
	{
		primero.anterior = inserta;
		inserta.siguiente = primero;
		primero = primero.anterior;
	}
	public void insertarFinal(Nodo_Lateral inserta)
	{
		ultimo.siguiente = inserta;
		inserta.anterior = ultimo;
		ultimo = ultimo.siguiente;
	}
	public void insertarMedio(Nodo_Lateral inserta)
	{
		Nodo_Lateral temporal1;
		Nodo_Lateral temporal2;
		temporal1 = primero;
		while (temporal1.y < inserta.y)
		{
			temporal1 = temporal1.siguiente;
		}
		temporal2 = temporal1.anterior;

		temporal2.siguiente = inserta;
		temporal1.anterior = inserta;
		inserta.siguiente = temporal1;
		inserta.anterior = temporal2;
	}
	public void recorrer()
	{
		if (!vacia())
		{
			Nodo_Lateral temporal = primero;
			while (temporal != null)
			{
				temporal = temporal.siguiente;
			}
		}
	}

	public boolean existe(int y)
	{
		if (vacia())
		{
			return false;
		}
		else
		{
			Nodo_Lateral temporal;
			temporal = primero;
			while (temporal != null)
			{
				if (temporal.y == y)
				{
					return true;
				}
				else if (temporal.siguiente == null)
				{
					return false;
				}
				temporal = temporal.siguiente;
			}
		}
		return false;
	}

	public Nodo_Lateral busqueda(int y)
	{
		if (existe(y))
		{
			Nodo_Lateral temporal;
			temporal = primero;
			while (temporal.y != y)
			{
				temporal = temporal.siguiente;
			}
			return temporal;
		}
		else
		{
			return (new Nodo_Lateral(-1));
		}
	}
}