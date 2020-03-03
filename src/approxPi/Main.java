package approxPi;

public class Main {

	public static void main(String[] args) {
		final String name = "approxPi ";
		final long start = System.currentTimeMillis();
		int points = 0;//TODO
		int p_inside = 0;
		float pi_esti = 0;
		//TODO implementation
		
		
		final long end = System.currentTimeMillis()-start;
		System.out.println("$ " + name + points);
		System.out.println("Total number of points: " + points);
		System.out.println("Points within circle: " + p_inside);
		System.out.println("Pi estimation: " + pi_esti);
		
		System.out.println("Execution time: " + end);
	}

}
