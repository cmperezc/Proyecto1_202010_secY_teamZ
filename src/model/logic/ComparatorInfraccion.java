package model.logic;

import java.util.Comparator;

public class ComparatorInfraccion implements Comparator<Comparendo>{

	@Override
	public int compare(Comparendo o1, Comparendo o2) {
		// TODO Auto-generated method stub
		int a=o1.darInfraccion().compareTo(o2.darInfraccion());
		if(a==0){
			a=o1.dartipoSer().compareTo(o2.dartipoSer());	
		}
		return a;
	}
	
	}


