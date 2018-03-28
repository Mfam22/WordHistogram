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
	
	public Object[][] generateList() {
		Object[][] result = new Object[map.size()][2];
		int i = 0;
		for (String key : map.keySet()) {
			Integer count = map.get(key);
			result[i][0] = key;
			result[i][1] = count;
			i++;
		}
		Arrays.sort(result, new Comparator<Object[]>() {
			@Override
			public int compare(final Object[] ob1, final Object[] ob2) {
				final Integer val1 = (Integer) ob1[1];
				final Integer val2 = (Integer) ob2[1];
				return val2.compareTo(val1);
			}
		});
//		System.out.println(Arrays.deepToString(result));
		return result;
	}
	
	public void printMap() throws FileNotFoundException{
		PrintWriter out = new PrintWriter(new FileOutputStream("output.txt"));
		Object[][] sorted = generateList();
		for (Object[] inner : sorted){
			String key = (String) inner[0];
			Integer count = (Integer) inner[1];
			out.print(key + " | ");
			for (int i=0;i<count;i++) {
				out.print("=");
			}
			out.println(" (" + count.toString() + ")");
		}
		out.close();
	}


}