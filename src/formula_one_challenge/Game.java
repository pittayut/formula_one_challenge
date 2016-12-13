package formula_one_challenge;

import java.util.ArrayList;

public class Game implements Runnable{
	private ArrayList<Driver> driver; 
	
	public Game(int noTeam, float lengthOfTrack) {
		this.driver = new ArrayList<Driver>(noTeam);
		
		for(int i=0;i<noTeam;i++) {
			this.driver.add(new Driver(i+1, lengthOfTrack));
		}
	}
	
	public void run() {
		// TODO Auto-generated method stub
		int cycle = 0;
		boolean isWinner = false;
		
		long time = System.currentTimeMillis();
		for(;;) {
			if(cycle > 0){
			// Condition checking
			for(int i=0;i<driver.size();i++) {
				Driver d = (Driver) this.driver.get(i);
				if(d.checkFinish()) {
					isWinner = true;
					break;
				}
				d.checkAnotherDriverPosition(this.driver);
				d.checkIsLast(this.driver);
			}
			
			// if got winner
			if(isWinner) {
				System.out.println("Finish");
				for(int i=0;i<driver.size();i++) {
					Driver d = (Driver) this.driver.get(i);
					d.printInfo();
				}
				break;
			}
			}
			// Move position
			for(int i=0;i<driver.size();i++) {
				Driver d = (Driver) this.driver.get(i);
				d.drive(2);
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			
			cycle++;
		}
		time = System.currentTimeMillis() - time;
		
		System.out.println("Completion times: " + (time/1000) + " Second.");
		
	}

}
