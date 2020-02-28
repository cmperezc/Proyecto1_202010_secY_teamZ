package test.data_structures;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.logic.QuickSort;

public class testQuickSort {
	Comparable[] aleatorio;
	Comparable[] ascendente;
	Comparable[] descendente;
	int N=5000;
	QuickSort Qs= new QuickSort();
	@Before
	public void setUp1() {
		aleatorio = new Comparable[N];
		int i=0;
		while(i<N){
			aleatorio[i++]=Math.random();

		}

	}
	@Before
	public void setUp2() {
		ascendente= new Comparable[N];
		int i=0;
		while(i<N){
			ascendente[i]=i;
			i++;
		}

	}
	@Before
	public void setUp3() {
		descendente= new Comparable[N];
		int i=0;
		while(i<N){
			descendente[i]=(N-1-i);
			i++;
		}
	}
	@Test
	public void testoOrdenarAleatorios() {
		setUp1();

		long start = System.currentTimeMillis();
		Qs.sort(aleatorio);
		long end = System.currentTimeMillis();

		System.out.println("El Tiempo de ordenamiento Quick Sort para "+N+" datos Aleatorio (seg): " + (end-start)/1000.0);

		double ant=0;
		for(int i=0;i<aleatorio.length;i++){

			double nuevo=(double)aleatorio[i];
			assertTrue(nuevo>=ant);
			ant=nuevo;

		}
	}

	@Test
	public void testoOrdenarAscendentes() {
		setUp2();

		long start = System.currentTimeMillis();
		Qs.sort(ascendente);
		long end = System.currentTimeMillis();

		System.out.println("El Tiempo de ordenamiento Quick Sort para "+N+"  datos Ascendentes (seg): " + (end-start)/1000.0);


		for(int i=0;i<ascendente.length;i++){

			int nuevo=(int)ascendente[i];

			assertTrue(nuevo==i);


		}
	}
	@Test
	public void testoOrdenarDescendentes() {
		setUp3();
		long start = System.currentTimeMillis();
		Qs.sort(descendente);
		long end = System.currentTimeMillis();

		System.out.println("El Tiempo de ordenamiento Quick Sort para "+N+" datos Descendentes (seg): " + (end-start)/1000.0);

		for(int i=0;i<descendente.length;i++){

			int nuevo=(int)descendente[i];

			assertTrue(nuevo==i);


		}
	}

}
