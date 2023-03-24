package ua.foxminded.javaspring;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class DataAggregation {

	Map<String, ArrayList<String>> timeOfRacers = new TreeMap<>();

	public void dataAggregation() throws FileNotFoundException {
		TakeRacers racers = new TakeRacers();
		String fileWithNameOfRacers = "abbreviations.txt";
		Map<String, ArrayList<String>> racersArray = racers.takeRacers(fileWithNameOfRacers);

		TakeTimeOfRacers timeOfRacersStarted = new TakeTimeOfRacers();
		String fileWithTimeStarted = "start.log";
		Map<String, ArrayList<LocalDateTime>> timeOfStarted = timeOfRacersStarted.takeTimeOfRacers(fileWithTimeStarted);

		TakeTimeOfRacers timeOfRacersEnded = new TakeTimeOfRacers();
		String fileWithTimeEnded = "end.log";
		Map<String, ArrayList<LocalDateTime>> timeOfEnded = timeOfRacersEnded.takeTimeOfRacers(fileWithTimeEnded);

		timeOfEnded.forEach((key, value) -> timeOfStarted.merge(key, value, (v1, v2) -> {v1.addAll(v2);return v1;}));

		CalculateTimeSpan timeSpan = new CalculateTimeSpan();
		Map<String, ArrayList<String>> timeOfLap = timeSpan.calculateTimeSpan(timeOfStarted);

		racersArray.forEach((key, value) -> timeOfLap.merge(key, value, (v1, v2) -> {v1.addAll(v2);return v1;}));

		for (Map.Entry<String, ArrayList<String>> entry : timeOfLap.entrySet()) {
			ArrayList<String> val = entry.getValue();
			String time = val.get(0);
			String name = val.get(1);
			String team = val.get(2);
			val.clear();
			val.add(name);
			val.add(team);
			timeOfRacers.put(time, val);
		}

		PrintReport report = new PrintReport();
		report.printReport(timeOfRacers);
	}
}
