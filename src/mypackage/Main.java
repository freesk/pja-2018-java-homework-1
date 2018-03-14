package mypackage;

import java.util.Calendar;
import java.util.Date;
import java.lang.RuntimeException;

import mypackage.Bus;
import mypackage.Vehicle;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Date today = new Date();
		
		Date yesterday = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(yesterday); 
		c.add(Calendar.DATE, -1);
		yesterday = c.getTime();
	
		Vehicle v1 = new Vehicle("Honda", today, 141);
		Vehicle v2 = new Vehicle("Honda", yesterday, 14141, true, true);
		
		final Bus b1 = new Bus("Mercedes-Benz", today, 151515, 3000, 2, false, true);
		
		Vehicle v3;
		
		try {
			v3 = new Vehicle("Honda", yesterday, -1);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
				
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(b1);
		
	
	}

}
