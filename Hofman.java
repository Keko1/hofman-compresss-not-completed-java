import java.util.*;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

public class Hofman {
	private String text;

	public Hofman() {
		text = "";
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Map<String, Integer> stringCounter(String s) {

		Map<String, Integer> map1 = new HashMap<String, Integer>();
		if (s != null) {
			for (char c : s.toCharArray()) {
				Integer count = map1.get(c + "");
				int sum = (count == null ? 1 : count + 1);
				map1.put(c + "", sum);
			}
		}

		Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2 = SortByValue(map1);
		map1 = SortByValue(map1);
		
		System.out.println(map2);
		
//		for(String a : map2.keySet()){
//			System.out.println(a + " " + map2.get(a));
//		}
		
//<<<<<<<<<<<<<<<<<<<<<<<<adding the least values>>>>>>>>>>>>>>>>>>>>>>>>
		while (map2.size() > 2) {

			Iterator<String> it = map2.keySet().iterator();

			String key1 = it.next();
			int value1 = map2.get(key1);

			String key2 = it.next();
			int value2 = map2.get(key2);

			map2.put(key1 + key2, value1 + value2);
			map2 = SortByValue(map2);

			map2.remove(key1);
			map2.remove(key2);
			
			map2 = SortByValue(map2);
			
		}
		return map2;
	}

	// <<<<<<<<<<<<<<<<<<<sotring the map>>>>>>>>>>>>>>>>>>>
	public static HashMap<String, Integer> SortByValue(Map<String, Integer> map1) {

		ValueComparator vc = new ValueComparator(map1);

		HashMap<String, Integer> sortedMap = new HashMap<String, Integer>();

		sortedMap.putAll(map1);

		return sortedMap;

	}

}
