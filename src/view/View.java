package view;

import java.util.Scanner;

import model.logic.Comparendo;
import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Cargar los datos ");
			System.out.println("2. Requerimiento 1A ");
			System.out.println("3. Requerimiento 2A ");
			System.out.println("4. Requerimiento 3A ");
			System.out.println("5. Requerimiento 1B ");
			System.out.println("6. Requerimiento 2B ");
			System.out.println("7. Requerimiento 3B ");
			System.out.println("8. Requerimiento 4A ");
			System.out.println("9. Requerimiento 4B ");
			System.out.println("10. Requerimiento 4C ");
			System.out.println("11. Salir ");
		}
		public void printTabla(Comparendo[] ch){
			System.out.println("Infraccion | Particular | Publico");
			int i=0;
			boolean f=true;
			while(i<ch.length){
				System.out.println(ch[i].toString());
			}
			
			
		}
		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			// TODO implementar
		}
		public String Preguntar(String p){
			Scanner lector = new Scanner(System.in);
			System.out.println("Por favor digitar "+ p);
			String option = lector.next();
			return option;
			
		}
		public void MostrarLista(Comparendo[] c){
			for(int i=0;i<c.length;i++){
				System.out.println(c[i].toString());
			}
			System.out.println("El total de comparendos encontrados es"+c.length);
		}
}
