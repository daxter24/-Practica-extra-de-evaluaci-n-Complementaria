package app.ito.poo;
import lectores.ito.poo.*;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

import clases.ito.poo.Composicion;
import clases.ito.poo.Composiciones;

import excepciones.ito.poo.ComposicioExisteException;
import excepciones.ito.poo.EliminarException;

public class Aplicaciontxt {
	static LectorArchivoTXT ar;
	static EscritorArchivoTXT ar2;

	static Composiciones c;
	static Scanner en=new Scanner (System.in);
	private static Composicion co= new Composicion( null, null, 0, 0, null, null, null);
	
	static Composicion capturaDatos() throws ComposicioExisteException {
		en.nextLine();
		System.out.print("introduce el titlo de la cancion");
		String titulo=en.nextLine();
		co.setTituloComposicion(titulo);
		System.out.println("introduce el genero de la cancion");
		co.setGenero(en.nextLine());
		System.out.println("Introduce los minutos que dura la cancion");
		co.setDuracionMin(en.nextInt());en.nextLine();
		System.out.println("Introduce los segundos que dura la cancion");
		co.setDuracionSeg(en.nextInt());en.nextLine();
		System.out.println("introduce la fecha en que estas regustrando la composicion");
		co.setFechaRegistro(LocalDate.parse(en.nextLine()));
		System.out.println("Introduce la fecha de estreno");
		co.setFechaEstreno(LocalDate.parse(en.nextLine()));
		co.setInterpretes("null");
		for(int i=0;i<c.getSize();i++) {
			if(titulo.equalsIgnoreCase(c.getComposicion(i).getTituloComposicion()))
				throw new ComposicioExisteException("Has introducido un titulo existente");
				
		}
		return co;
	}
	static void agregarComposicion() throws ComposicioExisteException {
		Composicion cb;
cb=capturaDatos();
if(c.addComposicion(cb))
		System.out.println("Tu composicion se agrego con exito!!");
		
	}
	
	static Composicion aleatorio(String aleatorio) {
		co=null; int i=0;
		for(;i<c.getSize();i++) {
			co=c.getComposicion(i);
			System.out.println(c.getComposicion(i)+"\n Es la composicion?:  "+aleatorio);en.nextLine();
			if (en.nextLine().equalsIgnoreCase("Si")) 
				break;
			co=null;
		}
		return co;
	}
	
	static void agregaInterprete() {
		if(!c.isFree()) {
			co=aleatorio("Ingresando");
				System.out.println("Introduce el nombre del interprete");
				co.agregarInterpret(en.nextLine());
			}else
			System.out.println("No existe ninguna Composicion");
		
	}
	static void eliminaInterprete() {
		if(!c.isFree()) {
			co=aleatorio("Eliminando");
				System.out.println("introduce el nombre del interprete para eliminarlo");
				co.eliminarInterpret(en.nextLine());
			
		}else
			System.out.println("No hay composiciones existentes");
	}
	static void listado() {
		if(!c.isFree()) {
			System.out.println("Listado de composiciones ");
			for(int i=0;i<c.getSize();i++) 
				System.out.println(c.getComposicion(i));
		}else
			System.out.println("No se encontro ninguna composicion");
			
	}
	
	
	static void ElimiaComposicion()throws EliminarException{
		   if(!c.isFree()) {
				  Composicion a=aleatorio("Eliminando Composion...");
				  if(a.getInterpretes().equalsIgnoreCase("")||a.getInterpretes().equalsIgnoreCase(null)) {
				 if(a!=null) { 
					  c.delete(a);
					 System.out.println("La composicion fu� eliminada");
				 		}else 
					  System.out.println("Ocurrio un error al eliminar la composicion");
				 }else
					 throw new EliminarException("Para Eliminar una composicion, no debe");
			}else	  
				  System.out.println("No existe ninguna composicion");
	}
	
	
	
	static void menuConsultas () {
		int ln=0;
		while(true) {
			  System.out.println(" 1.- A�adir interprete");  
			  System.out.println(" 2.- Eliminar interprete");  
			  System.out.println(" 3.- salir");
			  ln=en.nextInt();	
			  switch(ln){
			  	case 1:agregaInterprete(); break;
			  	case 2:eliminaInterprete();break;
		     }if(ln>2)
		    	 break;
			  
		}
	}
	
	static void menuPrincipal() throws EliminarException, ComposicioExisteException, FileNotFoundException {
		int l;
		boolean bandera =true;
		while(bandera){
			  System.out.println(" 1.- Agrega una nueva composicion "); 
			  System.out.println(" 2.- mostrar lista de composiciones");    
			  System.out.println(" 3.- Elimina composicion ");  
			  System.out.println(" 4.- Menu de consultas internas");  
			  System.out.println(" 5.-salir");
			  l=en.nextInt();
			  switch(l){
			  	case 1:agregarComposicion();break;
			  	case 2:listado();break;
			  	case 3:ElimiaComposicion();break;
			  	case 4:	menuConsultas();break;	  	
			  	case 5:Registrar(); abrirArchivo();bandera =false; break;
		     }
		}
	}
	static void Registrar() throws FileNotFoundException {
		  if(c.isFree()) 
			System.out.println("No se encuentra nignun registro");
		  else {			  
			    ar2 = new EscritorArchivoTXT("Composiciones.txt");
			  for(int i=0;i<c.getSize();i++) {
				  ar2.writeString(c.getComposicion(i).getTituloComposicion());
				  ar2.writeString(c.getComposicion(i).getGenero());
				  ar2.writeString(c.getComposicion(i).getInterpretes());
				  ar2.writeInt(c.getComposicion(i).getDuracionMin());
				  ar2.writeInt(c.getComposicion(i).getDuracionSeg());
				  ar2.writeString(c.getComposicion(i).getFechaRegistro().toString());
				  if(c.getComposicion(i).getFechaRegistro()==null)
					  ar2.writeStringLn("null \n");
				  else
				  ar2.writeStringLn(c.getComposicion(i).getFechaRegistro().toString()+"\n");
				  
				  ar2.writeString(c.getComposicion(i).getFechaEstreno().toString());
				  if(c.getComposicion(i).getFechaEstreno()==null)
					  ar2.writeStringLn("null \n");
				  else
				  ar2.writeStringLn(c.getComposicion(i).getFechaEstreno().toString()+"\n");
			  }
			  ar2.close();  			  
		  }

	  }
	static  void  abrirArchivo ()  throws FileNotFoundException {
		ar =  new  LectorArchivoTXT ( " Composiciones.txt " );
	}

	
	static void Comenzar() {
		c=new Composiciones();
	}
	static void run2() throws EliminarException, ComposicioExisteException, FileNotFoundException {
		Comenzar();
		menuPrincipal();
	}	
}
