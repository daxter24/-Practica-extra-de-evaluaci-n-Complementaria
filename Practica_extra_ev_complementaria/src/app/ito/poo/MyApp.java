package app.ito.poo;
import java.io.FileNotFoundException;
import java.util.Scanner;
import excepciones.ito.poo.ComposicioExisteException;
import excepciones.ito.poo.EliminarException;

public class MyApp {
	public static void main(String[]Ags) throws EliminarException, ComposicioExisteException, FileNotFoundException {
		Scanner lector=new Scanner(System.in);
		System.out.println("Hola, Bienvenido :D \n En que forma deseas trabajar:\n\n1.- Subir normal\n2.- Subirlas utilizando un formato txt"
				+ "\n3.- Subirlas utilizando datos binarios \n4.- Cancelar");
		int a=lector.nextInt();lector.nextLine();
		switch(a) {
		case 1: Aplicacion.run();break;
		case 2: Aplicaciontxt.run2();break;
		case 3: Aplicacionbin.run();break;
		case 4:break;
		}
		
	}
}
