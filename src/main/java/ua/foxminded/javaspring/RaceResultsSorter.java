package ua.foxminded.javaspring;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class RaceResultsSorter {

	public Map<String, List<String>> raceResultsSorter() throws FileNotFoundException {
		TakeTimeOfRacers timeOfRacers = new TakeTimeOfRacers();
		Map<String, List<String>> racers = timeOfRacers.takeTimeOfRacers();
		TakeRacers takeRacers = new TakeRacers();
		Map<String, List<String>> raceResults = takeRacers.takeRacers();

		racers.forEach((key, value) -> raceResults.merge(key, value, (v1, v2) -> {v1.addAll(v2);return v1;}));

		Map<String, List<String>> sorted = new TreeMap<>();
		for (Entry<String, List<String>> entry : raceResults.entrySet()) {
			List<String> val = entry.getValue();
			String name = val.get(0);
			String team = val.get(1);
			String time = val.get(2);
			sorted.computeIfAbsent(time, k -> new ArrayList<>()).add(name);
			sorted.computeIfAbsent(time, k -> new ArrayList<>()).add(team);

		}
		return sorted;
	}
}
