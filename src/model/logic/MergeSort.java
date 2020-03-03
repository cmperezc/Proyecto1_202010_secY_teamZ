package model.logic;

public class MergeSort {
	private static Comparable[] aux; 
	public static void merge(Comparable[] a, int lo, int mid, int hi,int lk)
	{	
		

		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++){
	
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++)
			// Merge back to a[lo..hi].
			if (i > mid) 
				a[k] = aux[j++];
			else if (j > hi )
				a[k] = aux[i++];
			else if (less(aux[j], aux[i],lk))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
	}
	private static boolean less(Comparable v, Comparable w, int lk)
	{
		boolean f=false;
		if(lk==0){
			f= v.compareTo(w) < 0;	
		}
		else if(lk==1){
			
			ComparatorInfraccion c= new ComparatorInfraccion();
			f= c.compare((Comparendo)v,(Comparendo) w) <0;
		}
		else if(lk==2){
			ComparatorLocalidad c= new ComparatorLocalidad();
			f= c.compare((Comparendo)v,(Comparendo) w) <0;
		}
		return f;
		
	}
	private static void exch(Comparable[] a, int i, int j)
	{
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	public static void sort(Comparable[] a,int lk) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1,lk); 
	}

	private static void sort(Comparable[] a, int lo, int hi, int lk) {
		if (hi <= lo) return; 
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid,lk);

		sort(a, mid+1, hi,lk);

		merge(a, lo, mid, hi,lk);
	} 
}
