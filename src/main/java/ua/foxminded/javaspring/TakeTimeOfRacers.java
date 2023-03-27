package ua.foxminded.javaspring;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TakeTimeOfRacers {

	public Map<String, List<String>> takeTimeOfRacers() {
		Map<String, List<LocalDateTime>> timeOfRacers = new HashMap<>();

		String[] fileNames = { "src/main/resources/start.log", "src/main/resources/end.log" };
		for (String fileName : fileNames) {
			try (Scanner scanner = new Scanner(new File(fileName))) {
				while (scanner.hasNextLine()) {
					String input = scanner.nextLine();
					Pattern pattern = Pattern.compile("(\\w+)(\\d{4}-\\d{2}-\\d{2}_\\d{2}:\\d{2}:\\d{2}\\.\\d{3})");
					Matcher matcher = pattern.matcher(input);
					if (matcher.matches()) {
						String racer = matcher.group(1);
						String time = matcher.group(2).replace("_", " ");
						LocalDateTime dateTime = LocalDateTime.parse(time,
								DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));

						timeOfRacers.computeIfAbsent(racer, k -> new ArrayList<>()).add(dateTime);
					}
				}
			} catch (FileNotFoundException e) {
				System.err.println("File not found: " + fileName);
			}
		}

		CalculateTimeSpan calculateTimeSpan = new CalculateTimeSpan();
		
		return calculateTimeSpan.calculateTimeSpan(timeOfRacers);
	}
}
