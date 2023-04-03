package ua.foxminded.javaspring;

import java.util.Map;
import java.util.Map.Entry;

public class PrintReport {

	public void printReport(Map<Integer, String> timesOfLap) {
		for (Entry<Integer, String> entry : timesOfLap.entrySet()) {
			String key = String.format("%02d", entry.getKey()) + ". ";
			String val = entry.getValue();

			System.out.println(key + val);

			if (key.equals("15. ")) {
				Repeat repeat = new Repeat();
				System.out.println(repeat.repeat("-", val.length() + 4));
			}
		}
	}
}
