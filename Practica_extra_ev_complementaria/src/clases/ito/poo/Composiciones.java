package clases.ito.poo;

import excepciones.ito.poo.ComposicioExisteException;
import interfaz.ito.poo.Arrelglo;

public class Composiciones implements Arrelglo<Composicion>{

	private Composicion grupo []=null;
	private int ultimo=0;
	private final int INC=5;
	
	public Composiciones() {
		super();
		this.grupo=new Composicion[INC];
		this.ultimo=-1;
	} 
	private void crecerArreglo() {
	    Composicion temporal[]=new Composicion[this.grupo.length+INC];
	    for(int i=0;i<this.grupo.length;i++)	
	    grupo=temporal;
	    }
	
	public boolean addComposicion(Composicion composicion) {
		// TODO Auto-generated method stub
		boolean bandera=false;
		if(!existeComposicion(composicion)) {
			if(isFull())
				crecerArreglo();
			int i=0;
			for(;i<=this.ultimo;i++)
				if(composicion.compareTo(grupo[i])<0) {
					break;
				}
			for(int j=this.ultimo;j>=i;j--)
				grupo[j+1]=grupo[j];
			grupo[i]=composicion;
			this.ultimo++;
			bandera=true;
			}
		return bandera;
	}

	public boolean existeComposicion(Composicion composicion) {
		// TODO Auto-generated method stub
		boolean existe=false;
		for(int i=0;i<=this.ultimo;i++)
			if(composicion.compareTo(grupo[i])==0) {
				existe=true;
				break;
			}
		return existe;
	}

	@Override
	public Composicion getComposicion(int pos) {
		// TODO Auto-generated method stub
		Composicion cb=null;
		if(!this.isFree()&& pos<=this.ultimo)
			cb=grupo[pos];
		return cb;
	}
	
	public boolean delete(Composicion composicion){
		boolean delete=false;
		if(this.existeComposicion(composicion)) {
			int i=0;
			for(;i<=this.ultimo;i++)
				if(composicion.compareTo(grupo[i])==0)
					break;
			for(;i<this.ultimo;i++)
				grupo[i]=grupo[i+1];
			this.ultimo--;
			delete=true;
		}
		return delete;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.ultimo+1;
	}

	@Override
	public boolean isFree() {
		// TODO Auto-generated method stub
		return this.ultimo==-1;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return this.ultimo+1==this.grupo.length;
	}

}
