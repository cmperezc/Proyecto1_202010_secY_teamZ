package controller;

import java.text.ParseException;
import java.util.Scanner;

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

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				modelo = new Modelo();
				double[] arreglo = new double[4];
				long start = System.currentTimeMillis();
				try {
					arreglo = modelo.cargarDatos("./data/comparendos_dei_2018.geojson");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				long end = System.currentTimeMillis();
				view.printMessage("Tiempo de carga (seg): " + (end-start)/1000.0);
				view.printMessage("total de comparendos en el archivo: " + modelo.darTamano() + "\n");
				view.printMessage("comparendo con mayor objectid " + modelo.comparendoMayorObje().toString3() + "\n");
				view.printMessage("zona Minimax: " + arreglo[0]+","+ arreglo[1] +","+ arreglo[2]+","+ arreglo[3]+ "\n");
				break;

			case 4:
				fin = true;
				break;
			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}

}	

