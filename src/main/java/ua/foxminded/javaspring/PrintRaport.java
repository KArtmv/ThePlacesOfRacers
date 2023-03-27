package ua.foxminded.javaspring;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Map.Entry;

public class PrintRaport {

	public void printRaport() throws FileNotFoundException {
		RaceReportModifier modifyBeforePrintReport = new RaceReportModifier();
		Map<Integer, String> timeOfLap = modifyBeforePrintReport.raceReportModifier();

		for (Entry<Integer, String> entry : timeOfLap.entrySet()) {
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
