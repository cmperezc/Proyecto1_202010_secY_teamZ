
package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.data_structures.Nodo;
import model.data_structures.listaDoble;
import model.logic.Comparendo;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	
	public static String PATH = "./data/comparendos_dei_2018_small.geojson";
	//public static String PATH = "./data/comparendos_dei_2018.geojson";
	public listaDoble<Comparendo> datos;
	public Shell sh;
	public MergeSort mg;
	
	public listaDoble<Comparendo> cargarDatos() {
		sh=new Shell();
		mg= new MergeSort();
		//TODO Cambiar la clase del contenedor de datos por la Estructura de Datos propia adecuada para resolver el requerimiento 
		datos = new listaDoble<Comparendo>();

		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(PATH));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();
			
			
			SimpleDateFormat parser=new SimpleDateFormat("yyyy/MM/dd");

			for(JsonElement e: e2) {
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();
				
				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();	
				Date FECHA_HORA = parser.parse(s); 
				
				String MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETE").getAsString();
				String CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHI").getAsString();
				String TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVI").getAsString();
				String INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRAC").getAsString();	
				String LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();

				double longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();
				
				double latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				Comparendo c = new Comparendo(OBJECTID, FECHA_HORA, DES_INFRAC, MEDIO_DETE, CLASE_VEHI, TIPO_SERVI, INFRACCION, LOCALIDAD, longitud, latitud);
				datos.agregarfinal(c);
				
			}

		} catch (FileNotFoundException | ParseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		return datos;	
		
	}
	public Comparendo Requerimiento1b(String comp){
		Comparendo s=null;
		int i=0;
		Nodo<Comparendo> inicio= datos.darInicio();
		while(inicio.darSiguiente()!=null){
			
			if(inicio.getItem().darInfraccion().equals(comp)){
				s=inicio.getItem();
				
			}
			inicio=inicio.darSiguiente();
			}
		return s;
	}
	
	
	public Comparendo[] Requrimiento2b(String comp){
		Comparendo [] c=darArreglo(comp);
		mg.sort(c,01
				);
		return c;
	}

	
	public Comparendo[] darArreglo(String comp){
		int i=0;
		Nodo<Comparendo> inicio= datos.darInicio();
		while(!(inicio.darSiguiente()==null)){
			if(inicio.obtenerItem().darInfraccion().equals(comp)){
				i++;
			}
			inicio=inicio.darSiguiente();
		}
		Comparendo[] respuesta =new Comparendo[i];
		
		 inicio= datos.darInicio();
		while(!(inicio.darSiguiente()==null)){
			if(inicio.obtenerItem().darInfraccion().equals(comp)){
				i++;
			}
			inicio=inicio.darSiguiente();
		}
		return respuesta;
	}
	
	public int TotalComparendos(){
		return datos.darTamaño();
	}
	public Comparendo comparendoMayorObje(){
		 return datos.darUltimoElemento();
	}
	public Comparable[]copiarComparendos(){
		
		Comparable[] c= new Comparable[datos.darTamaño()];
		
		for(int i=0;i<datos.darTamaño();i++ ){
			c[i]=datos.darElemento(i);
		}
		return c;
	}
}
