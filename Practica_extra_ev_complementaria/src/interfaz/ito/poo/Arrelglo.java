package interfaz.ito.poo;

import clases.ito.poo.Composicion;

public interface Arrelglo<T> {
	public boolean addComposicion(T composicion);
	public boolean existeComposicion(T composicion);
	public T getComposicion(int pos);
	public int getSize();
	public boolean delete (T composicion);
	public boolean isFree();
	public boolean isFull();

}
