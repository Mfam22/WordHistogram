package histogram;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestHistogram {
	Histogram h;
	private final String correctPath = "correct/";
	
	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestHistogram.class);
		
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		
		System.out.println(result.wasSuccessful());
	}
	
	@BeforeEach
	void setUp() throws Exception {
		
		//Creates a new histogram for each test so there is no overlap
		h = new Histogram();
	}

	// Tests adding a word into the Histograms HashMap
	@Test
	void testAddWord() {
		h.addWord("Present");
		Integer val = h.getCount("present");
		if (val == null)
			fail("Word was not added into the histogram");
	}
	
	@Test
	void testReadFile() throws FileNotFoundException {
		PrintWriter out = new PrintWriter(new FileOutputStream("temp.txt"));
		out.print("Do you like Green eggs and ham?\n" + 
				"I do not like them, Sam-I-am.\n" + 
				"I do not like Green eggs and ham.");
		out.close();
		h.readFile("temp.txt");
		
		// Remove temporarily created file
		File temp = new File("temp.txt");
		temp.delete();
		
		// Produces output.txt
		h.printMap();
		Scanner correct = new Scanner(new File(correctPath + "GreenEggs.txt"));
		Scanner produced = new Scanner(new File("output.txt"));
		while (correct.hasNext())
			assertEquals(correct.nextLine(),produced.nextLine());
		correct.close();
		produced.close();
	}
	
	// More comprehensive test, tests adding, getting count, and clearing
	@Test
	void testModifyHistogram() {
		h.addWord("Hello");
		h.addWord("hello");
		h.addWord("World");
		int count = h.getCount("hello");
		assertEquals(count,2);
		h.clearMap();
		assertNull(h.getCount("hello"));
		
	}
	
	// Test the Hickory Dickory Dock file
	@Test
	void testHickory() throws FileNotFoundException {
		h.readFile("input.txt");
		h.printMap();
		Scanner correct = new Scanner(new File(correctPath + "Hickory.txt"));
		Scanner produced = new Scanner(new File("output.txt"));
		while (correct.hasNext())
			assertEquals(correct.nextLine(),produced.nextLine());
		correct.close();
		produced.close();
	}


}
