package ua.foxminded.javaspring;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CalculateTimeSpan {

	public Map<String, String> calculateTimeSpan(Map<String, LocalDateTime> end, Map<String, LocalDateTime> start) {

		Map<String, String> timeOfLap = new HashMap<>();

		for (Entry<String, LocalDateTime> entry : end.entrySet()) {
			String key = entry.getKey();
			LocalDateTime timeOfEnded = entry.getValue();

			if (start.containsKey(key)) {
				LocalDateTime timeOfStarted = start.get(key);
				LocalDateTime fromTemp = LocalDateTime.from(timeOfStarted);

				long diffInMinutes = fromTemp.until(timeOfEnded, ChronoUnit.MINUTES);
				fromTemp = fromTemp.plusMinutes(diffInMinutes);

				long diffInSeconds = fromTemp.until(timeOfEnded, ChronoUnit.SECONDS);
				fromTemp = fromTemp.plusSeconds(diffInSeconds);

				long diffInMilli = fromTemp.until(timeOfEnded, ChronoUnit.MILLIS);

				String formattedDuration = String.format("%d:%02d.%03d", diffInMinutes, diffInSeconds, diffInMilli);

				timeOfLap.put(key, formattedDuration);
			}
		}
		return timeOfLap;
	}
}
