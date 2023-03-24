package ua.foxminded.javaspring;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CalculateTimeSpan {

	Map<String, ArrayList<String>> timeOfLap = new HashMap<>();

	public Map<String, ArrayList<String>> calculateTimeSpan(Map<String, ArrayList<LocalDateTime>> inputTimeOfLap) {
		for (Entry<String, ArrayList<LocalDateTime>> entry : inputTimeOfLap.entrySet()) {
			ArrayList<LocalDateTime> val = entry.getValue();
			LocalDateTime timeOfStarted = val.get(0);
			LocalDateTime timeOfEnded = val.get(1);

			LocalDateTime fromTemp = LocalDateTime.from(timeOfStarted);

			long diffInMinutes = fromTemp.until(timeOfEnded, ChronoUnit.MINUTES);
			fromTemp = fromTemp.plusMinutes(diffInMinutes);

			long diffInSeconds = fromTemp.until(timeOfEnded, ChronoUnit.SECONDS);
			fromTemp = fromTemp.plusSeconds(diffInSeconds);

			long diffInMilli = fromTemp.until(timeOfEnded, ChronoUnit.MILLIS);

			String formattedDuration = diffInMinutes + ":" + String.format("%02d", diffInSeconds) + "."
					+ String.format("%03d", diffInMilli);

			ArrayList<String> time = new ArrayList<>();

			time.add(formattedDuration);
			timeOfLap.put(entry.getKey(), time);

		}

		return timeOfLap;
	}

}
