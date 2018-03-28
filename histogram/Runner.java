package histogram;

import java.io.FileNotFoundException;

public class Runner{
	
	// Completes the primary task of reading the Hickory Dickory Dock example and putting
	// it into output.txt
	public static void main(String[] args) throws FileNotFoundException {
		Histogram histogram = new Histogram();
		histogram.readFile("input.txt");
		histogram.printMap();	
	}
}
