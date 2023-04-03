package ua.foxminded.javaspring;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RaceReportModifier {

	CalculateMaxLengthNameAndTeam lengthOfString = new CalculateMaxLengthNameAndTeam();

	public Map<Integer, String> raceReportModifier(Map<String, AbbreviationRow> timeOfLap) {
		LengthOfNameAndTeam lengthOfNameAndTeam = lengthOfString.calculateMaxLengthNameAndTeam(timeOfLap);
		int lengthOfName = lengthOfNameAndTeam.getLengthOfName();
		int lengthOfTeam = lengthOfNameAndTeam.getLengthOfTeam();

		Map<Integer, String> timesOfLap = new LinkedHashMap<>();
		int i = 1;

		for (Entry<String, AbbreviationRow> entry : timeOfLap.entrySet()) {
			String time = entry.getKey();
			AbbreviationRow val = entry.getValue();
			String name = val.getName();
			String team = val.getTeam();
			Repeat repeat = new Repeat();
			StringBuilder view = new StringBuilder();
			view.append(name)
				.append(repeat.repeat(" ", lengthOfName - name.length()))
				.append("|").append(team)
				.append(repeat.repeat(" ", lengthOfTeam - team.length())).append("|")
				.append(time);

			timesOfLap.put(i, view.toString());

			i++;
		}
		return timesOfLap;
	}
}
