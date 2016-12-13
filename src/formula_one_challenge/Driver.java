package formula_one_challenge;

import java.util.ArrayList;

public class Driver {
	private Car car;
	private float lengthOfTrack;
	
	public Driver(int carNo, float lengthOfTrack) {
		this.car = new Car(carNo);
		this.lengthOfTrack = lengthOfTrack;
	}
	
	public void drive(int timeSec) {
		this.car.move(timeSec);
	}
	
	public boolean checkFinish() {
		if(this.car.getPosition() >= this.lengthOfTrack) {
			return true;
		} else {
			return false;
		} 
	}
	
	public void checkIsLast(ArrayList<Driver> driver) {
		boolean isLast = true;
		for(int i=0;i<driver.size();i++) {
			Driver temp = (Driver) driver.get(i);
			if(this.car.getCarNo() == temp.getCarNo()) {
				continue; 
			}
			if(this.car.getPosition() > temp.getCarPosition()) { 
				isLast = false;
				break; 
			}
		}
		if(isLast) {
//			System.out.println("Last: "+this.car.getCarNo()+" Speed: "+this.car.getSpeed());
			this.car.nitro();
		}
	}
	
	public void checkAnotherDriverPosition(ArrayList<Driver> driver) {
		for(int i=0;i<driver.size();i++) {
			Driver temp = (Driver) driver.get(i);
			if(this.car.getCarNo() != temp.getCarNo()) {
				float tempDifPosition = this.car.getPosition() - temp.getCarPosition();
				if((tempDifPosition > -10) && (tempDifPosition < 10)) {
					this.car.reducesSpeed();
					break;
				}
			}
		}
	}
	
	public float getCarPosition() {
		return this.car.getPosition();
	}
	
	public float getCarNo() {
		return this.car.getCarNo();
	}
	
	public void printInfo() {
		System.out.println("Car No: " + this.car.getCarNo()
				+ " Speed: " + this.car.getSpeed() + " km/s."
				+ " Position: " + this.car.getPosition() + " m.");
		
	}
}
