package ua.foxminded.javaspring;

import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class RaceResultsSorter {

	public Map<String, AbbreviationRow> raceResultsSorter(Map<String, AbbreviationRow> racers, Map<String, String> calculatedTime) {
		Map<String, AbbreviationRow> sorted = new TreeMap<>();

		for (Entry<String, AbbreviationRow> entry : racers.entrySet()) {
			if (calculatedTime.containsKey(entry.getKey())) {
				String time = calculatedTime.get(entry.getKey());
				sorted.put(time, entry.getValue());
			}
		}
		return sorted;
	}
}
