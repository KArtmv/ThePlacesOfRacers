package ua.foxminded.javaspring;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CalculateTimeSpan {

	public Map<String, List<String>> calculateTimeSpan(Map<String, List<LocalDateTime>> timeOfRacers) {
		Map<String, List<String>> timeOfLap = new HashMap<>();
		for (Entry<String, List<LocalDateTime>> entry : timeOfRacers.entrySet()) {
			List<LocalDateTime> val = entry.getValue();
			LocalDateTime timeOfStarted = val.get(0);
			LocalDateTime timeOfEnded = val.get(1);

			LocalDateTime fromTemp = LocalDateTime.from(timeOfStarted);

			long diffInMinutes = fromTemp.until(timeOfEnded, ChronoUnit.MINUTES);
			fromTemp = fromTemp.plusMinutes(diffInMinutes);

			long diffInSeconds = fromTemp.until(timeOfEnded, ChronoUnit.SECONDS);
			fromTemp = fromTemp.plusSeconds(diffInSeconds);

			long diffInMilli = fromTemp.until(timeOfEnded, ChronoUnit.MILLIS);

			String formattedDuration = String.format("%s:%02d.%03d", diffInMinutes, diffInSeconds, diffInMilli);

			timeOfLap.computeIfAbsent(entry.getKey(), k -> new ArrayList<>()).add(formattedDuration);

		}
		return timeOfLap;
	}
}
