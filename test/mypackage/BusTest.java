package mypackage;

import java.util.Date;
import java.lang.RuntimeException;

import static org.junit.Assert.*;

import org.junit.Test;

import mypackage.Bus;

@SuppressWarnings({"unused"})
public class BusTest {

	@Test(expected = RuntimeException.class)
	public void createBusWithNegativeEngineCapacity() {
		Date now = new Date();
		Bus bus = new Bus("Mercedes-Benz", now, 151515, -1, 0);
	}
	
	@Test(expected = RuntimeException.class)
	public void createBusWithInvalidFuelType() {
		Date now = new Date();
		Bus bus = new Bus("Mercedes-Benz", now, 151515, 2000, -1);
		bus = new Bus("Mercedes-Benz", now, 151515, 2000, 100);
	}

}
