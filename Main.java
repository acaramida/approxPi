import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	public static void main(String[] args) throws IOException {
		double points = Double.parseDouble(args[0]);
		
		double circle_r = 1;
		double count_inside = 0;
		
		for(int i = 0; i < points;i++)  {
			double x = ThreadLocalRandom.current().nextDouble();
			double y = ThreadLocalRandom.current().nextDouble();
			
			double cat_x = 1-x;
			double cat_y = 1-y;
			if(cat_x*cat_x + cat_y*cat_y <= circle_r*circle_r)
				count_inside++;
		}
		
		double pi_esti = count_inside/points * 4.0;
		System.out.println("Total number of points: " + points);
		System.out.println("Points within circle: " + count_inside);
		System.out.println("Pi estimation: " + pi_esti);
		
	}

}
