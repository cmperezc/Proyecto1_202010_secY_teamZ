package model.logic;

public class comparendoC1 implements Comparable<comparendoC1>{
	String infraccion;
	int contador;
	public comparendoC1(String infracion, int contador) {
		super();
		this.infraccion = infracion;
		this.contador = contador;
	}
	public String getInfracion() {
		return infraccion;
	}
	public void setInfracion(String infracion) {
		this.infraccion = infracion;
	}
	public int getContador() {
		return contador;
	}
	public void setContador() {
		contador ++;
	}
	@Override
	public int compareTo(comparendoC1 o) {
		return this.infraccion.compareTo(o.infraccion);
	}
	

}
