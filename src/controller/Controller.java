
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import model.data_structures.listaDoble;
import model.logic.Comparendo;
import model.logic.ComparendoInfracciones;
import model.logic.MergeSort;
import model.logic.QuickSort;
import model.logic.Shell;
import model.logic.comparendoC1;
import model.logic.comparendoC2;
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
		Scanner entradaEscaner = new Scanner (System.in);
		SimpleDateFormat parser=new SimpleDateFormat("yyyy/MM/dd");
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
				
				break;

			case 2:
		        String entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
				view.printMessage("zona Minimax: " +modelo.Requerimiento1a(entradaTeclado).toString()+  "\n");
				break;
			case 3:
				String p4=view.Preguntar("Fecha");
				
				Comparendo[] c4=null;
				try {
					c4 = modelo.Requrimiento1b(parser.parse(p4));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				view.MostrarLista(c4);

				break;
			case 4:
				String fecha2 = entradaEscaner.nextLine();
				String fecha3 = entradaEscaner.nextLine();
				
				try {
					ComparendoInfracciones[] b = modelo.requerimiento3A(parser.parse(fecha2), parser.parse(fecha3));
					for (ComparendoInfracciones actual : b) {

						view.printMessage("zona Minimax: " +actual.getInfraccion()+"/"+actual.getContadorFecha1()+ "/"+ actual.getContadorFecha2()+ "\n");
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
				Comparendo[] c3= modelo.copiarComparendos();
				ms.sort(c3, 1);
				for(int i=0;i<c3.length;i++){
					System.out.println(c3[i].darInfraccion()+"  "+ c3[i].dartipoSer());
				}
				break;
			case 8:
				String fecha21 = entradaEscaner.nextLine();
				String fecha31 = entradaEscaner.nextLine();
				String Localidad = entradaEscaner.nextLine ();
				try {
			
					comparendoC1[] b = modelo.requerimiento1C(parser.parse(fecha21), parser.parse(fecha31), Localidad);
			
					for (comparendoC1 actual : b) {

						view.printMessage("zona Minimax: " +actual.getInfracion()+"/"+actual.getContador()+"\n");
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 9:
				String fecha22 = entradaEscaner.nextLine();
				String fecha32 = entradaEscaner.nextLine();
				
				try {
					System.out.println(" afda");
					comparendoC2[] b = modelo.requerimiento2C(parser.parse(fecha22), parser.parse(fecha32));
				double i = entradaEscaner.nextDouble();
					
					for (comparendoC2 actual : b) {

						view.printMessage(" " +actual.getInfraccion()+"/"+actual.getContador()+"\n");
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 10:
				Comparendo[] c8= modelo.copiarComparendos();
				ms.sort(c8, 2);
				String ant="";
				for(int i=0;i<c8.length;i++){
					
				}
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

