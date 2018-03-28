package histogram;

import java.util.*;
import java.io.*;

public class Histogram{
	HashMap<String,Integer> map;
	
	public Histogram(){
		map = new HashMap<String,Integer>();
	}
	
	public void addWord(String word) {
		Integer count = map.get(word);
		if (count == null) {
			map.put(word, 1);
		}
		else {
			map.put(word, ++count);
		}
	}
	
	public void readFile(String path) throws FileNotFoundException{
		Scanner file = new Scanner(new File(path));
		file.useDelimiter("[\\p{Punct}\\s]+");
		while( file.hasNext()){
			String w = file.next();
			addWord(w.toLowerCase());
		}
		file.close();
	}
	
	public void printMap() throws FileNotFoundException{
		PrintWriter out = new PrintWriter(new FileOutputStream("output.txt"));
		
		for (String key : map.keySet()){
			Integer count = map.get(key);
			out.print(key + " | ");
			for (int i=0;i<count;i++) {
				out.print("=");
			}
			out.println(" (" + count.toString() + ")");
		}
		out.close();
	}


}