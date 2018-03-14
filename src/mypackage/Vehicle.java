package mypackage;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.lang.RuntimeException;

public class Vehicle {
	
	private final int maxMileage = 999999;
	private final int maxProducerName = 20;
	private int mileage = 0;
	private Date dateOfManufacture = null;
	private String nameOfTheProducer = "";
	
	// false by default 
	public boolean isLowFloor = false;
	public boolean isArticulated = false;
	
	public Vehicle(
			String nameOfTheProducer, 
			Date dateOfManufacture,
			int mileage) {
		
		if(nameOfTheProducer == null || nameOfTheProducer.isEmpty())
			throw new RuntimeException("nameOfTheProducer is missing");
		
		if(nameOfTheProducer.length() > maxProducerName)
			throw new RuntimeException("maxProducerName is limited to " + maxProducerName + " symbols");
		
		if(dateOfManufacture == null)
			throw new RuntimeException("dateOfManufacture is missing");
		
		if(!isValidDate(dateOfManufacture))
			throw new RuntimeException("dateOfManufacture cannot be defined in the future");

		updateMileage(mileage);
				
		this.nameOfTheProducer = nameOfTheProducer;
		this.dateOfManufacture = dateOfManufacture;
		this.mileage = mileage;
	}
	
	public Vehicle(
			String nameOfTheProducer, 
			Date dateOfManufacture,
			int mileage,
			boolean isLowFloor,
			boolean isArticulated) {
		this(nameOfTheProducer, dateOfManufacture, mileage);
		this.isLowFloor = isLowFloor;
		this.isArticulated = isArticulated;
	}
	
	public void updateMileage(int n) throws RuntimeException {
		if(n <= 0 || n >= maxMileage)
			throw new RuntimeException("mileage must be between 0 and " + maxMileage);
		this.mileage = n; 
	}
	
	public int getMileage() {
		return mileage;
	}
	
	public long getAgeInMs() {
		final Date now = new Date();
		final long diff = getDateDiff(now, dateOfManufacture, TimeUnit.MILLISECONDS);
		return diff;
	}
	
	private boolean isValidDate(Date date) {
		// get now
		final Date now = new Date();
		// make sure it is past
		return date.before(now);
	}
	
	private long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date1.getTime() - date2.getTime();
	    return timeUnit.convert(diffInMillies, timeUnit);
	}
	
	@Override
	public String toString() {
		return nameOfTheProducer + " " + dateOfManufacture + " " + mileage + " " + isLowFloor + " " + isArticulated;
	}

}
