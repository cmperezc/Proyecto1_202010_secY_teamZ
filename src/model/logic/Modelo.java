package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.data_structures.Nodo;
import model.data_structures.listaDoble;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private listaDoble<Comparendo> datos;
	public static String PATH = "./data/comparendos_dei_2018_small.geojson";
	MergeSort me= new MergeSort();
	Shell sh=new Shell();
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */


	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */


	public double[] cargarDatos(String PATH) throws java.text.ParseException {
		datos = new listaDoble<>();
		double minLongitud =Double.MAX_VALUE;
		double minLatitud =Double.MAX_VALUE;
		double maxLongitud =Double.MIN_VALUE;
		double maxLatitud =Double.MIN_VALUE;
		
		//TODO Cambiar la clase del contenedor de datos por la Estructura de Datos propia adecuada para resolver el requerimiento 
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
				if (longitud<minLongitud) {
					minLongitud = longitud;
				}
				if (latitud<minLatitud) {
					minLatitud=latitud;
				}
				if (latitud>maxLatitud) {
					maxLatitud=latitud;
				}
				if (longitud>maxLongitud) {
					maxLongitud=longitud;
				}
			}

		} catch (FileNotFoundException | ParseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		double[] coordenadas = {maxLongitud,maxLatitud, minLongitud,minLatitud};
		return coordenadas;

	}
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamaño();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(Comparendo item)
	{	
		datos.agregarInicio(item);
	}

	public Comparendo Requerimiento1b(String comp){
		Comparendo s=null;
		int i=0;
		Nodo<Comparendo> inicio= datos.darInicio();
		while(i<datos.darTamaño()){
			
			if(inicio.getItem().darInfraccion().equals(comp)){
				s=inicio.getItem();
			}
			inicio=inicio.darSiguiente();
			}
		return s;
	}
	public Comparendo[] Requrimiento2b(String comp){
		Comparendo [] c=darArreglo(comp);
		sh.sort(c);
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


}
