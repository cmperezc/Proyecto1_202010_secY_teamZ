package test.data_structures;




import model.data_structures.listaDoble;
import model.logic.Modelo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class testLista {
	private Modelo modelo;
	private listaDoble<Integer> c;
	private listaDoble<Integer> c1;
	
	@Before
	public void SetUp1(){
		 c=new listaDoble<Integer>();
		for(int i=0;i<100;i++){
			c.agregarfinal(i);
			
		}
	}
	@Before
	public void SetUp2(){
		c1=new listaDoble<Integer>();
	}
	
	@Test
	public void testAgregar() {
		SetUp1();
		assertTrue(c.darElemento(99)==99);
		c.agregarInicio(299);
		assertTrue(c.darElemento(0)==299);
		assertTrue(c.darElemento(1)==0);
		
	}
	@Test
	public  void testEliminarPrimero(){
		SetUp1();
		c.eliminar(0);
		assertTrue(c.darElemento(0)==1);
	}
	@Test
	public  void testEliminarUltimo(){
		SetUp1();
		c.eliminar(99);
		assertTrue(c.darUltimoElemento()==98);
	}
	@Test
	public  void testEliminar(){
		SetUp1();
		
		c.eliminar(2);
		
		assertTrue(c.darElemento(2)==3);
	}	
	
	@Test
	public  void testSize(){
		SetUp1();
		assertTrue(c.darTamaño()==100);
		SetUp2();
		assertTrue(c1.darTamaño()==0);
	}
	@Test
	public  void testEmpty(){
		SetUp1();
		assertTrue(c.estaVacia()==false);
		SetUp2();
		
		assertTrue(c1.estaVacia()==true);
	}
	@Test
	public  void testGet(){
		SetUp1();
		int h= c.darElemento(2);
		int j=c.darElemento(28);
		int k=c.darElemento(82);

		assertTrue(h==2);
		assertTrue(j==28);
		assertTrue(k==82);
		
	}
	@Test
	public  void testGetLast(){
		SetUp1();
		SetUp2();
		assertTrue(c.darUltimoElemento()==99);
		
		assertTrue(c1.darUltimoElemento()==null);
		c.agregarfinal(10023);
		assertTrue(c.darUltimoElemento()==10023);
		
	}
}
