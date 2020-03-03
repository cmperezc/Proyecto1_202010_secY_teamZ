package model.logic;

public class comparendoC2 implements Comparable<comparendoC2> {
	String infraccion;
	int contador;
	
	public comparendoC2(String infraccion, int contador) {
		super();
		this.infraccion = infraccion;
		this.contador = contador;
	}

	public String getInfraccion() {
		return infraccion;
	}
	public void setInfraccion(String infraccion) {
		this.infraccion = infraccion;
	}
	public int getContador() {
		return contador;
	}
	public void setContador() {
		contador++;
	}
	@Override
	public int compareTo(comparendoC2 o) {
		if (this.contador>o.contador) {
			return -1;
		}else if(this.contador<o.contador){
			return 1;
		}else
			return 0;
	}
	
}
