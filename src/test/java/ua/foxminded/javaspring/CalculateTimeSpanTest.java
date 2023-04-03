package ua.foxminded.javaspring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class CalculateTimeSpanTest {

	@Test
	void testCalculateTimeSpan() {
		Map<String, String> startTimes = new HashMap<>();
		DateTimeFormatter formatterPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");

		startTimes.put("SVF", "2018-05-24_12:02:58.917");
		startTimes.put("NHR", "2018-05-24_12:02:49.914");
		startTimes.put("FAM", "2018-05-24_12:13:04.512");

		Map<String, LocalDateTime> formatedTimeOfStart = new HashMap<>();
		for (Map.Entry<String, String> entry : startTimes.entrySet()) {
			String key = entry.getKey();
			String time = entry.getValue();
			LocalDateTime dateTime = LocalDateTime.parse(time, formatterPattern);
			formatedTimeOfStart.put(key, dateTime);
		}

		Map<String, String> endTimes = new HashMap<>();
		endTimes.put("SVF", "2018-05-24_12:04:03.332");
		endTimes.put("NHR", "2018-05-24_12:04:02.979");
		endTimes.put("FAM", "2018-05-24_12:14:17.169");

		Map<String, LocalDateTime> formatedTimeOfEnd = new HashMap<>();
		for (Map.Entry<String, String> entry : endTimes.entrySet()) {
			String key = entry.getKey();
			String time = entry.getValue();
			LocalDateTime dateTime = LocalDateTime.parse(time, formatterPattern);
			formatedTimeOfEnd.put(key, dateTime);
		}

		Map<String, String> expected = new HashMap<>();
		expected.put("SVF", "1:04.415");
		expected.put("NHR", "1:13.065");
		expected.put("FAM", "1:12.657");

		CalculateTimeSpan calculateTimeSpan = new CalculateTimeSpan();
		Map<String, String> actual = calculateTimeSpan.calculateTimeSpan(formatedTimeOfEnd, formatedTimeOfStart);
		assertEquals(expected, actual);
	}
}