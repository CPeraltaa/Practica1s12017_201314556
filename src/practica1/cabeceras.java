package practica1;

public class cabeceras
{
	public Nodo_Cabecera primero;
	public Nodo_Cabecera ultimo;

	public cabeceras()
	{
		primero = null;
		ultimo = null;
	}
	public boolean vacia()
	{
            return primero == null;
	}
	public void insertar(Nodo_Cabecera inserta)
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
	public void insertarFrente(Nodo_Cabecera inserta)
	{
		primero.anterior = inserta;
		inserta.siguiente = primero;
		primero = primero.anterior;
	}
	public void insertarFinal(Nodo_Cabecera inserta)
	{
		ultimo.siguiente = inserta;
		inserta.anterior = ultimo;
		ultimo = ultimo.siguiente;
	}
	public void insertarMedio(Nodo_Cabecera inserta)
	{
		Nodo_Cabecera temporal1;
		Nodo_Cabecera temporal2;
		temporal1 = primero;
		while (temporal1.x < inserta.x)
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
			Nodo_Cabecera temporal = primero;
			while (temporal != null)
			{
				temporal = temporal.siguiente;
			}
		}
	}
	public boolean existe(int x)
	{
		if (vacia())
		{
			return false;
		}
		else
		{
			Nodo_Cabecera temporal;
			temporal = primero;
			while (temporal != null)
			{
				if (temporal.x == x)
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
	public Nodo_Cabecera busqueda(int x)
	{
		if (existe(x))
		{
			Nodo_Cabecera temporal;
			temporal = primero;
			while (temporal.x != x)
			{
				temporal = temporal.siguiente;
			}
			return temporal;
		}
		else
		{
			return (new Nodo_Cabecera(-1));
		}
	}	
}