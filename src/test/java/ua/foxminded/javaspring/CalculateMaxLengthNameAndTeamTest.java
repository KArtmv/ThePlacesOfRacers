package ua.foxminded.javaspring;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculateMaxLengthNameAndTeamTest {

	private CalculateMaxLengthNameAndTeam maxLengthCalculator;
	private Map<String, AbbreviationRow> racers;

	@BeforeEach
	void setUp() {
		maxLengthCalculator = new CalculateMaxLengthNameAndTeam();
		racers = new HashMap<>();
	}

	@Test
	void testCalculateMaxLengthNameAndTeamWithEmptyInput() {
		LengthOfNameAndTeam expected = new LengthOfNameAndTeam(0, 0);
		LengthOfNameAndTeam actual = maxLengthCalculator.calculateMaxLengthNameAndTeam(racers);
		assertEquals(expected.getLengthOfName(), actual.getLengthOfName());
		assertEquals(expected.getLengthOfTeam(), actual.getLengthOfTeam());
	}

	@Test
	void testCalculateMaxLengthNameAndTeamWithSingleInput() {
		racers.put("KMH", new AbbreviationRow("Kevin Magnussen", "HAAS FERRARI"));
		LengthOfNameAndTeam expected = new LengthOfNameAndTeam(15, 12);
		LengthOfNameAndTeam actual = maxLengthCalculator.calculateMaxLengthNameAndTeam(racers);
		assertEquals(expected.getLengthOfName(), actual.getLengthOfName());
		assertEquals(expected.getLengthOfTeam(), actual.getLengthOfTeam());
	}

	@Test
	void testCalculateMaxLengthNameAndTeam() {
		racers.put("DRR", new AbbreviationRow("Daniel Ricciardo", "RED BULL RACING TAG HEUER"));
		racers.put("SVF", new AbbreviationRow("Sebastian Vettel", "FERRARI"));
		racers.put("LHM", new AbbreviationRow("Lewis Hamilton", "MERCEDES"));
		LengthOfNameAndTeam expected = new LengthOfNameAndTeam(16, 25);
		LengthOfNameAndTeam actual = maxLengthCalculator.calculateMaxLengthNameAndTeam(racers);
		assertEquals(expected.getLengthOfName(), actual.getLengthOfName());
		assertEquals(expected.getLengthOfTeam(), actual.getLengthOfTeam());
	}
}
