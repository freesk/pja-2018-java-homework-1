package mypackage;

import java.util.Date;

public class Bus extends Vehicle {
	// in cm^3
	private int engineCapacity;
	// methanol 0
	// diesel 1
	// gasoline 2
	private int fuelType = 2;
	
	public Bus(String nameOfTheProducer, Date dateOfManufacture, int mileage, int engineCapacity, int fuelType) {
		super(nameOfTheProducer, dateOfManufacture, mileage);
		setCapacity(engineCapacity);
		setFuelType(fuelType);
	}

	public Bus(String nameOfTheProducer, Date dateOfManufacture, int mileage, int engineCapacity, int fuelType, boolean isLowFloor,
			boolean isArticulated) {
		super(nameOfTheProducer, dateOfManufacture, mileage, isLowFloor, isArticulated);
		setCapacity(engineCapacity);
		setFuelType(fuelType);
	}
	
	public void setFuelType(int n) throws RuntimeException {
		if(n < 0 || n > 2)
			throw new RuntimeException("fuel type can be defiend with 0, 1 or 2 only");
		else 
			fuelType = n;
	}
	
	public int getFuelType() {
		return fuelType;
	}
	
	public int getCapacity(int n) {
		return engineCapacity;
	}
	
	public void setCapacity(int n) throws RuntimeException {
		if(n > 0)
			engineCapacity = n;
		else 
			throw new RuntimeException("engineCapacity must be greater than 0");
	}

}
