package ua.foxminded.javaspring;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TakeRacers {

	public Map<String, List<String>> takeRacers() throws FileNotFoundException {
		Map<String, List<String>> racers = new HashMap<>();

		try (Scanner sc = new Scanner(new File("src/main/resources/abbreviations.txt"))) {
			while (sc.hasNextLine()) {
				String[] racer = sc.nextLine().split("_");
				String key = racer[0];
				String name = racer[1];
				String team = racer[2];

				racers.computeIfAbsent(key, k -> new ArrayList<>()).add(name);
				racers.computeIfAbsent(key, k -> new ArrayList<>()).add(team);
			}
		}

		return racers;
	}
}