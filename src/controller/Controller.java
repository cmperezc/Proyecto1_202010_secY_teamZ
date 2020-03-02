
package controller;

import java.util.List;
import java.util.Scanner;

import model.data_structures.listaDoble;
import model.logic.Comparendo;
import model.logic.MergeSort;
import model.logic.QuickSort;
import model.logic.Shell;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";
		modelo = new Modelo();
		Comparable []lis=null; 
		Shell s =new Shell();
		MergeSort ms =new MergeSort();
		QuickSort qs =new QuickSort();
		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:


				long start = System.currentTimeMillis();
				listaDoble<Comparendo> lista = modelo.cargarDatos();
				long end = System.currentTimeMillis();
				
				view.printMessage("Tiempo de carga (mseg): " + (end-start));
				view.printMessage("Datos cargados: " + lista.darTamaño() + "\n");
				view.printMessage("Primer dato: " + lista.darInicio().getItem().toString() + "\n");
				view.printMessage("Ultimo dato: " + lista.darUltimoElemento().toString() + "\n");
				lis=modelo.copiarComparendos();
				break;

			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				String p2=view.Preguntar("Infraccion");
				Comparendo c=modelo.Requerimiento1b(p2);
				if(c==null){
					System.out.println("No se encontraron datos");
				}else{
					System.out.println(c.toString());	
				}
				
				break;
			case 6:
				String p3=view.Preguntar("Infraccion");
				Comparendo[] c2=modelo.Requrimiento2b(p3);
				view.MostrarLista(c2);

				break;
			case 7:
				Comparendo[] c3= (Comparendo[])modelo.copiarComparendos();
				ms.sort(c3, 1);
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				break;
			case 11:
				fin = true;
				break;
			default: 
			
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}

