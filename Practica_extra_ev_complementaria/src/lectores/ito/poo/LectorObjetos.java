package lectores.ito.poo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LectorObjetos {

	private ObjectInputStream informacion;
	
	public LectorObjetos(String informacion) throws FileNotFoundException, IOException {
		this.informacion= new ObjectInputStream(new FileInputStream(informacion));
	}
	
	public Object readObject() throws ClassNotFoundException, IOException {
		Object aux=null;
		aux= informacion.readObject();
		return aux;
	}
	
	public void close() throws IOException {
		informacion.close();
	}
}
