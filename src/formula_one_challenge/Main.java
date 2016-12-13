package formula_one_challenge;

public class Main {

	public static void main(String[] args) {
		(new Thread(new Game(10,10000))).start();
	}
}
