package model.logic;

public class ComparendoInfracciones implements Comparable<ComparendoInfracciones> {
	String infraccion;
	int contadorFecha1;
	int contadorFecha2;
	public ComparendoInfracciones(String infraccion, int contadorFecha1, int contadorFecha2) {
		super();
		this.infraccion = infraccion;
		this.contadorFecha1 = contadorFecha1;
		this.contadorFecha2 = contadorFecha2;
	}

	public String getInfraccion() {
		return infraccion;
	}
	public void setInfraccion(String infraccion) {
		this.infraccion = infraccion;
	}
	public int getContadorFecha1() {
		return contadorFecha1;
	}
	public void setContadorFecha1() {
		contadorFecha1 ++;
	}
	public int getContadorFecha2() {
		return contadorFecha2;
	}
	public void setContadorFecha2() {
		 contadorFecha2 ++;
	}

	@Override
	public int compareTo(ComparendoInfracciones o) {
		return this.infraccion.compareTo(o.infraccion);
	}
}
