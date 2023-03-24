package ua.foxminded.javaspring;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class PrintReport {

	Map<String, ArrayList<String>> timesOfLap = new LinkedHashMap<>();

	public void printReport(Map<String, ArrayList<String>> input) {
		int i = 1;
		int lengthOfNameMAX = 0;
		int lengthOfTeamMAX = 0;
		for (Map.Entry<String, ArrayList<String>> entry : input.entrySet()) {
			ArrayList<String> val = entry.getValue();
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

		for (Map.Entry<String, ArrayList<String>> entry : timesOfLap.entrySet()) {
			String key = entry.getKey();
			ArrayList<String> val = entry.getValue();
			String name = val.get(0);
			String team = val.get(1);
			String time = val.get(2);

			Repeat repeat = new Repeat();
			String view = key + name + repeat.repeat(" ", lengthOfNameMAX - name.toCharArray().length) + team
					+ repeat.repeat(" ", lengthOfTeamMAX - team.toCharArray().length) + time;

			System.out.println(view);

			if (key.equals("15. ")) {
				System.out.println(repeat.repeat("-", view.toCharArray().length));
			}

		}
	}
}
