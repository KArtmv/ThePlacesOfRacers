package ua.foxminded.javaspring;

import java.util.Map;
import java.util.Map.Entry;

public class CalculateMaxLengthNameAndTeam {

	public LengthOfNameAndTeam calculateMaxLengthNameAndTeam(Map<String, AbbreviationRow> timeOfLap) {

		int lengthOfNameMAX = 0;
		int lengthOfTeamMAX = 0;

		for (Entry<String, AbbreviationRow> entry : timeOfLap.entrySet()) {
			AbbreviationRow val = entry.getValue();
			String name = val.getName();
			String team = val.getTeam();
			

			int lengthOfName = name.toCharArray().length;
			if (lengthOfName > lengthOfNameMAX) {
				lengthOfNameMAX = lengthOfName;
			}

			int lengthOfTeam = team.toCharArray().length;
			if (lengthOfTeam > lengthOfTeamMAX) {
				lengthOfTeamMAX = lengthOfTeam;
			}
		}
		return new LengthOfNameAndTeam(lengthOfNameMAX, lengthOfTeamMAX);
	}
}
