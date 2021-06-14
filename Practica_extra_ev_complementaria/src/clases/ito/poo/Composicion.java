package clases.ito.poo;
import java.time.LocalDate;

import excepciones.ito.poo.ComposicioExisteException;
public class Composicion implements Comparable<Composicion>{

	
	private String tituloComposicion="";
	private String genero="";
	private int duracionSeg=0,duracionMin=0;
	private String interpretes="";
	private java.time.LocalDate fechaRegistro=null;
	private java.time.LocalDate fechaEstreno=null;
	
	
	
	public Composicion(String tituloComposicion, String genero,int duracionSeg, int duracionMin,
			String interpretes, LocalDate fechaRegistro, LocalDate fechaEstreno) {
		super();
		this.genero=genero;
		this.tituloComposicion = tituloComposicion;
		this.duracionSeg = duracionSeg;
		this.duracionMin = duracionMin;
		this.interpretes = interpretes;
		this.fechaRegistro = fechaRegistro;
		this.fechaEstreno = fechaEstreno;
	}
	
	public boolean agregarInterpret(String a ) {
		boolean agregar=false;
		if(a!=null&&!a.equalsIgnoreCase("")) { 
		this.interpretes=a;
		agregar=true;
		}else
			agregar =false;
		return agregar;
	}
	
	public boolean eliminarInterpret(String a){
		boolean elimina=false;
		if(a.equalsIgnoreCase(this.interpretes)) {
			this.interpretes="";
			elimina=true;
		}else
				elimina=false;
		return elimina;
	}
	


	@Override
	public int compareTo(Composicion o)  {
		// TODO Auto-generated method stub
		int compare=0;
		if(this.tituloComposicion.equals(o.getTituloComposicion()))
			compare=0;
		else if(!this.tituloComposicion.equalsIgnoreCase(o.getTituloComposicion()))
			compare=1;
		return compare;
	}

	
	public void setGenero(String genero) {
		this.genero=genero;
	}
	public String getGenero() {
		return genero;
		
	}
	public String getTituloComposicion() {
		return tituloComposicion;
	}


	public void setTituloComposicion(String tituloComposicion) {
		this.tituloComposicion = tituloComposicion;
	}


	public int getDuracionSeg() {
		return duracionSeg;
	}


	public void setDuracionSeg(int duracionSeg) {
		this.duracionSeg = duracionSeg;
	}


	public int getDuracionMin() {
		return duracionMin;
	}


	public void setDuracionMin(int duracionMin) {
		this.duracionMin = duracionMin;
	}


	public String getInterpretes() {
		return interpretes;
	}


	public void setInterpretes(String interpretes) {
		this.interpretes = interpretes;
	}


	public java.time.LocalDate getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(java.time.LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public java.time.LocalDate getFechaEstreno() {
		return fechaEstreno;
	}


	public void setFechaEstreno(java.time.LocalDate fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}


	@Override
	public String toString() {
		return "Composicion [tituloComposicion=" + tituloComposicion+", genero="+genero
				+ ", duracionSeg=" + duracionSeg + ", duracionMin=" + duracionMin + ", interpretes="  +interpretes
				+ ", fechaRegistro=" + fechaRegistro + ", fechaEstreno=" + fechaEstreno + "]";
	}
	

	
	
	
}
