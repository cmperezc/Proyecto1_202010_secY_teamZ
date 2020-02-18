package model.logic;

import java.util.Date;

public class Comparendo {
	private int objectId;
	private Date fecha_hora;
	private String des_infrac;
	private String medio_dete;
	private String clase_vehi;
	private String tipo_servi;
	private String infraccion;
	private String localidad;

	private double latitud;
	private double longitud;

	public Comparendo(int objeId, Date fecha, String descripcion, String detencion, String claseVeh, String tipoSer, String codInfraccion, String localidadP, double lonP, double latP)
	{
		objectId = objeId;
		fecha_hora = fecha;
		des_infrac = descripcion;
		medio_dete = detencion;
		clase_vehi = claseVeh;
		tipo_servi = tipoSer;
		infraccion = codInfraccion;
		localidad = localidadP;
		longitud = lonP;
		latitud = latP;
	}
	public int darObjectid(){
		return objectId;

	}
	public Date darFecha(){
		return fecha_hora;

	}
	public String darClaseVe(){
		return clase_vehi;

	}public String dartipoSer(){
		return tipo_servi;

	}public String darInfraccion(){
		return infraccion;

	}
	public String darDescInfraccion(){
		return des_infrac;

	}public String darLocalidad(){
		return localidad;

	}
	public String toString2() {
		return   infraccion +","+ objectId +","+  fecha_hora + "," + clase_vehi + "," + tipo_servi +"," + localidad;
	}
	public String toString3() {
		return  objectId + ", " + fecha_hora + "," + "," + infraccion + "," + clase_vehi
				+ "" + tipo_servi+ "," + localidad  ;
	}


	@Override
	public String toString() {
		return "Comparendo [OBJECTID=" + objectId + ", FECHA_HORA=" + fecha_hora + ", DES_INFRAC=" + des_infrac
				+ ", MEDIO_DETE=" + medio_dete + ", CLASE_VEHI=" + clase_vehi + ", TIPO_SERVI=" + tipo_servi
				+ ", INFRACCION=" + infraccion + ", LOCALIDAD=" + localidad + ", latitud=" + latitud + ", longitud="
				+ longitud + "]";
	}

}
