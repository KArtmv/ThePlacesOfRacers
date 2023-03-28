package ua.foxminded.javaspring;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RaceReportModifier {

	public Map<Integer, String> raceReportModifier() throws FileNotFoundException {
		RaceResultsSorter raceResultsSorter = new RaceResultsSorter();
		Map<String, List<String>> timeOfLap = raceResultsSorter.raceResultsSorter();

		CalculateMaxLengthNameAndTeam lengthOfString = new CalculateMaxLengthNameAndTeam();
		lengthOfString.calculateMaxLengthNameAndTeam(timeOfLap);
		
		LengthOfNameAndTeam lengthOfNameAndTeam = new LengthOfNameAndTeam();
		int lengthOfName = lengthOfNameAndTeam.getLengthOfName();
		int lengthOfTeam = lengthOfNameAndTeam.getLengthOfTeam();

		Map<Integer, String> timesOfLap = new LinkedHashMap<>();
		int i = 1;

		for (Entry<String, List<String>> entry : timeOfLap.entrySet()) {
			String time = entry.getKey();
			List<String> val = entry.getValue();
			String name = val.get(0);
			String team = val.get(1);
			Repeat repeat = new Repeat();
			StringBuilder view = new StringBuilder();
			view.append(name).append(repeat.repeat(" ", lengthOfName - name.length())).append("|").append(team)
					.append(repeat.repeat(" ", lengthOfTeam - team.length())).append("|").append(time);

			timesOfLap.put(i, view.toString());

			i++;
		}
		return timesOfLap;

	}
}
