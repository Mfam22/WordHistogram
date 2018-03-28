package histogram;

import java.io.FileNotFoundException;

public class Runner{
	public static void main(String[] args) throws FileNotFoundException{
		Histogram histogram = new Histogram();
		histogram.readFile("input.txt");
		histogram.printMap();
	}
}
