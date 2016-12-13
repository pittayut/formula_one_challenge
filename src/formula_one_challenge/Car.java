package formula_one_challenge;

public class Car {
	private float topSpeed;
	private float acceleration;
	private float hf;
	
	private int carNo;
	private float position;
	private float speed;
	private boolean isUseNitro;
	private boolean isSpeedChange;
	
	public Car(int carNo) {
		this.carNo = carNo;
		this.topSpeed = (150 + 10 * carNo); 			// km per hour
		this.acceleration = (2 * carNo); 				// meter per second square.
		this.hf = (float) 0.8;
		this.isUseNitro = false;
		this.isSpeedChange = false;
		
		if(carNo == 1) {
			this.position = 0;							// meters
		} else {
			this.position = (-1) * (200 * carNo);		// meters
		}
	}
	
	// This method used to move the car position.
	public void move(int timeSec) {	
		
		if(!this.isSpeedChange) {
			calSpeed(timeSec, this.speed);
			this.isSpeedChange = false;
		}
		
		this.position += calDistance(timeSec, this.speed);
//		System.out.println("Car No: " + this.carNo + " Speed: " + this.speed + " Position " + this.position);
	}
	
	//Calculate speed from time(sec) and first speed(km/s)
	public void calSpeed(int timeSec, float firstSpeed) {
		
		float tempSpeed = ((this.acceleration * timeSec) + (firstSpeed * 1000 / 60 / 60));
		float tempTopSpeed = this.topSpeed * 1000 / 60 / 60;
		
		if(tempSpeed >= tempTopSpeed) {
			this.speed = this.topSpeed; 
		} else {
			this.speed = tempSpeed / 1000 * 60 * 60;
		}
	}
	
	//Calculate the distance
	private float calDistance(int timeSec, float speed) {
		float tempSpeed = speed / 1000 * 60 * 60;
		return (tempSpeed * timeSec) + ((1/2) * this.acceleration * (timeSec*timeSec));
	}
	
	//Reduce the speed
	public void reducesSpeed() {
		this.speed = hf * this.speed;
		System.out.println("--- Car "+ this.carNo +" Reduce Speed " + this.speed);
		this.isSpeedChange = true;
	}
	
	//Use nitro to increases the speed 
	public void nitro() {
		if(!this.isUseNitro) {
			float speedMPS = this.speed * 1000 / 60 / 60;
			float topSpeedMPS = this.topSpeed * 1000 / 60 / 60;
			float tempSpeed = speedMPS * 2;
			
			if(tempSpeed >= topSpeedMPS) {
				this.speed = this.topSpeed;
			} else {
				this.speed = tempSpeed /1000 * 60 * 60;
			}
			this.isUseNitro = true;
			this.isSpeedChange = true;
		}
	}
	
	public float getPosition() {
		return this.position;
	}
	
	public int getCarNo() {
		return this.carNo;
	}
	
	public float getSpeed() {
		return this.speed;
	}
	
}

