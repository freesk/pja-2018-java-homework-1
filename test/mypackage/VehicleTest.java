package mypackage;

//java lib
import java.util.Date;
import java.lang.RuntimeException;
import java.util.Calendar;

// junit 
//import org.junit.Before;
//import org.junit.After;
import org.junit.Test;

import junit.framework.Assert;

// my classes 
import mypackage.Vehicle;

@SuppressWarnings({"unused", "deprecation"})
public class VehicleTest {

//	@Before
//	public void setUp() throws Exception {
//		System.out.println("VehicleTest @Before");
//	}
	
//	@After
//	public void tearDown() throws Exception {
//		System.out.println("VehicleTest @After");
//	}
	
	@Test(expected = RuntimeException.class)
	public void createVehicleWithoutProducerName() {
		final Date now = new Date();
		Vehicle vehicle = new Vehicle(null, now, 14141);
	}
	
	@Test(expected = RuntimeException.class)
	public void createVehicleWithEmptyProducerName() {
		final Date now = new Date();
		Vehicle vehicle = new Vehicle("", now, 14141);
	}
	
	@Test(expected = RuntimeException.class)
	public void createVehicleWithTooLongProducerName() {
		final Date now = new Date();
		Vehicle vehicle = new Vehicle("This is a too long producer name that fails the validation", now, 14141);
	}
	
	@Test(expected = RuntimeException.class)
	public void createVehicleWithoutDate() {
		Vehicle vehicle = new Vehicle("Toyota", null, 14141);
	}
	
	@Test(expected = RuntimeException.class)
	public void createVehicleWithNegativeMileage() {
		final Date now = new Date();
		Vehicle vehicle = new Vehicle("Toyota", now, -1);
	}
	
	@Test(expected = RuntimeException.class)
	public void createVehicleWithInvalidMileage() {
		final Date now = new Date();
		Vehicle vehicle = new Vehicle("Toyota", now, 999999 + 1);
	}
	
	@Test(expected = RuntimeException.class)
	public void createVehicleWithTomorrowsDate() {
		Date date = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		c.add(Calendar.DATE, 1);
		Vehicle vehicle = new Vehicle("Toyota", date, 14141);
	}
	
	@Test
	public void getAgeInMs() {
		Date date = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		// day before
		c.add(Calendar.DATE, -1);
		date = c.getTime();
		Vehicle vehicle = new Vehicle("Toyota", date, 14141);
		// convert ms to a number of days 		
		int days = (int) ((vehicle.getAgeInMs() / (1000*60*60*24)) % 7);
		// make sure the difference is 1 day 
		Assert.assertEquals(1, days);
		
	}
	
	@Test(expected = RuntimeException.class)
	public void updateMileageWithNegativeNumber() {
		Date date = new Date();
		Vehicle vehicle = new Vehicle("Toyota", date, 14141);
		vehicle.updateMileage(-1);
	}
	
	@Test(expected = RuntimeException.class)
	public void updateMileageWithInvalidValue() {
		Date date = new Date();
		Vehicle vehicle = new Vehicle("Toyota", date, 999999 + 1);
		vehicle.updateMileage(-1);
	}
	
}
