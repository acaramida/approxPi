package approxPi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		InputStreamReader r = new InputStreamReader(System.in); 
	    BufferedReader br = new BufferedReader(r);
	    System.out.println("Enter number of simulations");    
	    String n = br.readLine();    
	    
		final String name = "approxPi ";
		final long start = System.currentTimeMillis();
		int points = Integer.parseInt(n);
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
