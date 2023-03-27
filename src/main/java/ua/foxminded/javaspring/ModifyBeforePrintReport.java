package ua.foxminded.javaspring;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ModifyBeforePrintReport {

	public void modifyBeforePrintReport() throws FileNotFoundException {
		SotrByTime sotrByTime = new SotrByTime();
		Map<String, List<String>> timeOfLap = sotrByTime.sotrByTime();

		
		Map<String, List<String>> timesOfLap = new LinkedHashMap<>();
		int i = 1;
		int lengthOfNameMAX = 0;
		int lengthOfTeamMAX = 0;
		for (Entry<String, List<String>> entry : timeOfLap.entrySet()) {
			List<String> val = entry.getValue();
			String time = entry.getKey();
			String name = val.get(0);
			String team = val.get(1);
			val.clear();
			val.add(name);
			val.add("| " + team);
			val.add("| " + time);
			timesOfLap.put(String.format("%02d", i) + ". ", val);

			int lengthOfName = name.toCharArray().length;
			if (lengthOfName > lengthOfNameMAX) {
				lengthOfNameMAX = lengthOfName;
			}

			int lengthOfTeam = team.toCharArray().length;
			if (lengthOfTeam > lengthOfTeamMAX) {
				lengthOfTeamMAX = lengthOfTeam + 2;
			}

			i++;
		}

		for (Map.Entry<String, List<String>> entry : timesOfLap.entrySet()) {
			String key = entry.getKey();
			List<String> val = entry.getValue();
			String name = val.get(0);
			String team = val.get(1);
			String time = val.get(2);

			Repeat repeat = new Repeat();

			StringBuilder view = new StringBuilder();
			view.append(key).append(name).append(repeat.repeat(" ", lengthOfNameMAX - name.length())).append(team)
					.append(repeat.repeat(" ", lengthOfTeamMAX - team.length())).append(time);
			System.out.println(view);

			if (key.equals("15. ")) {
				System.out.println(repeat.repeat("-", view.length()));
			}

		}
	}
}
