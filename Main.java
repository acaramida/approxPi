import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	public static void main(String[] args) throws IOException {
		long start = System.nanoTime();
		long points = Long.parseLong(args[0]);
		int threads = Integer.parseInt(args[1]);
		int flag = 0;
		if (args[args.length - 1].equalsIgnoreCase("-b")) {
			flag = 1;
		}

		double count_inside_all = 0;
		Multithreading[] all_threads = new Multithreading[threads];

		for (int i = 0; i < threads; i++) {
			all_threads[i] = new Multithreading(points / threads);
			all_threads[i].start();
		}

		for (int i = 0; i < threads; i++) {
			try {
				all_threads[i].join();
				count_inside_all += all_threads[i].count_inside;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		double pi_esti = count_inside_all / points * 4.0;

		double time_taken = (double) (System.nanoTime() - start) * 1e-9;

		if (flag == 1) {
			System.out.printf("%.0f\t%d\t%.3f\n", points, threads, time_taken);
		} else {
			System.out.printf("Total number of points: %.1g\n", (double)points);
			System.out.println("Points within circle: " + count_inside_all);
			System.out.println("Pi estimation: " + pi_esti);
			System.out.printf("Execution time (s): %.3f \n", time_taken);
		}

	}

}

class Multithreading extends Thread {

	double count_inside;
	private long points;

	public Multithreading(long points) {
		this.points = points;
		count_inside = 0;
	}

	public void run() {
		try {
			for (long i = 0; i < points; i++) {
				double x = ThreadLocalRandom.current().nextDouble();
				double y = ThreadLocalRandom.current().nextDouble();

				if (x * x + y * y <= 1)
					count_inside++;
			}

		} catch (Exception e) {
			// Throwing an exception
			System.out.println("Exception is caught");
		}
	}
}