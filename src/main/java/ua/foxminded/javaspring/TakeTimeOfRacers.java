package ua.foxminded.javaspring;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TakeTimeOfRacers {

	Map<String, ArrayList<LocalDateTime>> timeOfRacers = new HashMap<>();

	public Map<String, ArrayList<LocalDateTime>> takeTimeOfRacers(String fileWithTime) throws FileNotFoundException {
		Scanner scTimeOfStart = null;
		try {
			scTimeOfStart = new Scanner(new File(fileWithTime));
			while (scTimeOfStart.hasNextLine()) {
				String input = scTimeOfStart.nextLine();
				Pattern pattern = Pattern.compile("(\\w+)(\\d{4}-\\d{2}-\\d{2}_\\d{2}:\\d{2}:\\d{2}\\.\\d{3})");
				Matcher matcher = pattern.matcher(input);
				if (matcher.matches()) {
					String racer = matcher.group(1);
					String time = matcher.group(2).replaceAll("_", " ");

					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
					LocalDateTime dateTime = LocalDateTime.parse(time, formatter);
					ArrayList<LocalDateTime> timeOfRacerArray = new ArrayList<>();
					timeOfRacerArray.add(dateTime);
					timeOfRacers.put(racer, timeOfRacerArray);
				}

			}
		} catch (FileNotFoundException e) {
		} catch (NoSuchElementException e) {
		} finally {
			if (scTimeOfStart != null) {
				scTimeOfStart.close();
			}
		}

//		System.out.println(timeOfRacers);
		return timeOfRacers;
	}
}
