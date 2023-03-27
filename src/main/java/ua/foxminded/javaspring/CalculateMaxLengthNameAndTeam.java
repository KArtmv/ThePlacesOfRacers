package ua.foxminded.javaspring;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CalculateMaxLengthNameAndTeam {

	public List<Integer> calculateMaxLengthNameAndTeam(Map<String, List<String>> timeOfLap) throws FileNotFoundException {

		int lengthOfNameMAX = 0;
		int lengthOfTeamMAX = 0;

		for (Entry<String, List<String>> entry : timeOfLap.entrySet()) {
			List<String> val = entry.getValue();
			String name = val.get(0);
			String team = val.get(1);

			int lengthOfName = name.toCharArray().length;
			if (lengthOfName > lengthOfNameMAX) {
				lengthOfNameMAX = lengthOfName;
			}

			int lengthOfTeam = team.toCharArray().length;
			if (lengthOfTeam > lengthOfTeamMAX) {
				lengthOfTeamMAX = lengthOfTeam;
			}

		}
		List<Integer> lengthString = new ArrayList<>();
		lengthString.add(lengthOfNameMAX);
		lengthString.add(lengthOfTeamMAX);
		
		return lengthString;
	}
}
