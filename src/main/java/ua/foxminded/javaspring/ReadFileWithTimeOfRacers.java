package ua.foxminded.javaspring;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFileWithTimeOfRacers {

	public Map<String, LocalDateTime> readFileWithTimeOfRacers(String fileName) {
		Map<String, LocalDateTime> timeOfRacers = new HashMap<>();
		Pattern pattern = Pattern.compile("(\\w+)(\\d{4}-\\d{2}-\\d{2}_\\d{2}:\\d{2}:\\d{2}\\.\\d{3})");
		DateTimeFormatter formatterPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");

		try (Scanner scanner = new Scanner(new File(fileName))) {
			while (scanner.hasNextLine()) {
				String input = scanner.nextLine();
				Matcher matcher = pattern.matcher(input);
				if (matcher.matches()) {
					String racer = matcher.group(1);
					String time = matcher.group(2);
					LocalDateTime dateTime = LocalDateTime.parse(time, formatterPattern);
					timeOfRacers.put(racer, dateTime);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + fileName);
		}
		return timeOfRacers;
	}
}
