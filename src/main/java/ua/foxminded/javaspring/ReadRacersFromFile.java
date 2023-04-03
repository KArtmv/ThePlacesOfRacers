package ua.foxminded.javaspring;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReadRacersFromFile {

	public Map<String, AbbreviationRow> readRacersFromFile(String fileName) throws FileNotFoundException {
		Map<String, AbbreviationRow> racers = new HashMap<>();

		try (Scanner scanner = new Scanner(new File(fileName))) {
			while (scanner.hasNextLine()) {
				String[] racer = scanner.nextLine().split("_");

				AbbreviationRow nameAndTeamOfRacers = new AbbreviationRow(racer[1], racer[2]);
				racers.put(racer[0], nameAndTeamOfRacers);
			}
		}
		return racers;
	}
}