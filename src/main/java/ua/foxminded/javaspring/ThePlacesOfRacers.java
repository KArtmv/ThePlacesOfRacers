package ua.foxminded.javaspring;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Map;

public class ThePlacesOfRacers {

	private static final String ABBREVIATIONS_FILE_PATH = "src/main/resources/abbreviations.txt";
	private static final String END_LOG_FILE_PATH = "src/main/resources/end.log";
	private static final String START_LOG_FILE_PATH = "src/main/resources/start.log";

	public static void main(String[] args) throws FileNotFoundException {
		ReadRacersFromFile takeRacers = new ReadRacersFromFile();
		Map<String, AbbreviationRow> racers = takeRacers.readRacersFromFile(ABBREVIATIONS_FILE_PATH);

		ReadFileWithTimeOfRacers timeOfRacers = new ReadFileWithTimeOfRacers();
		Map<String, LocalDateTime> end = timeOfRacers.readFileWithTimeOfRacers(END_LOG_FILE_PATH);
		Map<String, LocalDateTime> start = timeOfRacers.readFileWithTimeOfRacers(START_LOG_FILE_PATH);

		CalculateTimeSpan timeSpan = new CalculateTimeSpan();
		Map<String, String> calculatedTime = timeSpan.calculateTimeSpan(end, start);

		RaceResultsSorter raceResultsSorter = new RaceResultsSorter();
		Map<String, AbbreviationRow> sorted = raceResultsSorter.raceResultsSorter(racers, calculatedTime);

		RaceReportModifier reportModifier = new RaceReportModifier();

		PrintReport printReport = new PrintReport();
		printReport.printReport(reportModifier.raceReportModifier(sorted));
	}
}
