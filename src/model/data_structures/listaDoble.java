package model.data_structures;

public class listaDoble<T> {

	private Nodo<T> inicio;
	private Nodo<T> fin;
	private int tamaño = 0;


	public listaDoble(){
		inicio=fin=null;
	}

	public int darTamaño(){
		return tamaño;
	}

	public boolean estaVacia(){
		return darTamaño() == 0;
	}

	public void agregarInicio(T item){
		Nodo<T> NuevoInicio = new Nodo<T> (item, inicio, null);
		if (!estaVacia()) {
			inicio.CambiarAnterior(NuevoInicio);
			tamaño++;
		}else{


		}
	}
	public void agregarfinal(T item){
		Nodo<T> Nuevofinal = new Nodo<T> (item, null, fin);
		if (!estaVacia()) {
			inicio.CambiarAnterior(Nuevofinal);
			tamaño++;
		}else{


		}
	}

	public void eliminar(T item){
		//si esta al principio
		if (inicio.obtenerItem().equals(item)) {
			inicio = inicio.darAnterior();
			inicio.CambiarAnterior(null);
			//si esta al final
		}else if (fin.obtenerItem().equals(item)) {
			fin = fin.darAnterior();
			fin.cambiarSiguiente(null);
			//si no esta ni al principio ni al final
		}else{
			Nodo<T> aux=inicio.darSiguiente();
			while (aux!=null) {
				if (aux.obtenerItem().equals(item)) {
					
				}else{
					aux = aux.darSiguiente();
				}
				
			}
		}

}
}




