import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	public static void main(String[] args) throws IOException {
		long start = System.nanoTime();
		double points = Double.parseDouble(args[0]);
		int threads = Integer.parseInt(args[1]);

		double count_inside_all = 0;
		Multithreading[] all_threads = new Multithreading[threads];
		
        for (int i=0; i<threads; i++) 
        { 
        	all_threads[i] = new Multithreading(points/threads);
        	all_threads[i].start();
        } 
		
        for (int i=0; i<threads; i++) 
        {            
            try {
				all_threads[i].join();
				count_inside_all += all_threads[i].count_inside;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        } 
        		
		double pi_esti = count_inside_all/points * 4.0;
		
		double end = (double)(System.nanoTime()- start) * 1e-9;

		System.out.println("Total number of points: " + points);
		System.out.println("Points within circle: " + count_inside_all);
		System.out.println("Pi estimation: " + pi_esti);
		System.out.printf("Execution time (s): %.3f \n", end);
		
	}

}

class Multithreading extends Thread { 
	
	double count_inside;
	private double points;
	private double circle_r;
	
	public Multithreading(double points) {
		this.points = points;
		count_inside = 0;
		circle_r = 1;
	}
	
    public void run() 
    { 
        try
        { 
        	for(int i = 0; i < points;i++)  {
    			double x = ThreadLocalRandom.current().nextDouble();
    			double y = ThreadLocalRandom.current().nextDouble();
    			
    			double cat_x = 1-x;
    			double cat_y = 1-y;
    			if(cat_x*cat_x + cat_y*cat_y <= circle_r*circle_r)
    				count_inside++;
    		}
  
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
    } 
} 