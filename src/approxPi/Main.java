package approxPi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	public static void main(String[] args) throws IOException {
		InputStreamReader r = new InputStreamReader(System.in); 
	    BufferedReader br = new BufferedReader(r);  
	    String[] n = br.readLine().split(" ");   
	    
		final long start = System.nanoTime();
		int points = Integer.parseInt(n[n.length-1]);
		double pi_esti = 0;
		float circle_r = 1;
		int count_inside = 0;
		
		for(int i = 0; i < points;i++)  {
			double x = ThreadLocalRandom.current().nextDouble();
			double y = ThreadLocalRandom.current().nextDouble();
			
			double cat_x = 1-x;
			double cat_y = 1-y;
			if(cat_x*cat_x + cat_y*cat_y <= circle_r*circle_r)
				count_inside++;
		}
		
		pi_esti = count_inside/points * 4.0;
		final long end = System.nanoTime()-start;
		System.out.println("Total number of points: " + points);
		System.out.println("Points within circle: " + count_inside);
		System.out.println("Pi estimation: " + pi_esti);
		
		if(n[0].equalsIgnoreCase("time"))
			System.out.println("Execution time: " + end);
	}

}
