package practica1;

public class Lista_Vertical
{
	public Nodo_Ortogonal primero;
	public Nodo_Ortogonal ultimo;

	public Lista_Vertical()
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
			primero = inserta;
			ultimo = inserta;
		}
		else
		{
			if (inserta.y < primero.y)
			{
				insertaFrente(inserta);
			}
			else if (inserta.y > ultimo.y)
			{
				insertaFinal(inserta);
			}
			else
			{
				insertarMedio(inserta);
			}
		}
	}

	public void insertaFrente(Nodo_Ortogonal inserta)
	{
		primero.arriba = inserta;
		inserta.abajo = primero;
		primero = primero.arriba;
	}

	public void insertarMedio(Nodo_Ortogonal inserta)
	{
		Nodo_Ortogonal temporal1;
		Nodo_Ortogonal temporal2;
		temporal1 = primero;
		while (temporal1.y < inserta.y)
		{
			temporal1 = temporal1.abajo;
		}
		temporal2 = temporal1.arriba;

		temporal2.abajo = inserta;
		temporal1.arriba = inserta;
		inserta.abajo = temporal1;
		inserta.arriba = temporal2;
	}

	public void insertaFinal(Nodo_Ortogonal inserta)
	{
		ultimo.abajo = inserta;
		inserta.arriba = ultimo;
		ultimo = ultimo.abajo;
	}
	public void recorrer()
	{
		if (!vacia())
		{
			Nodo_Ortogonal temporal = primero;
			while (temporal != null)
			{
				temporal = temporal.abajo;
			}
		}
	}
}