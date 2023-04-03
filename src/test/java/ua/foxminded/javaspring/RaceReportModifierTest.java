package ua.foxminded.javaspring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import java.util.Map;

public class RaceReportModifierTest {
    private final RaceReportModifier raceReportModifier = new RaceReportModifier();

    @Test
    void testRaceReportModifier() {
        Map<String, AbbreviationRow> timeOfLap = new LinkedHashMap<>();
        timeOfLap.put("1:04.415", new AbbreviationRow("Sebastian Vettel", "FERRARI"));
        timeOfLap.put("1:12.013", new AbbreviationRow("Daniel Ricciardo", "RED BULL RACING TAG HEUER"));
        timeOfLap.put("1:12.434", new AbbreviationRow("Valtteri Bottas", "MERCEDES"));

        Map<Integer, String> expected = new LinkedHashMap<>();
        expected.put(1, "Sebastian Vettel|FERRARI                  |1:04.415");
        expected.put(2, "Daniel Ricciardo|RED BULL RACING TAG HEUER|1:12.013");
        expected.put(3, "Valtteri Bottas |MERCEDES                 |1:12.434");

        Map<Integer, String> actual = raceReportModifier.raceReportModifier(timeOfLap);

        Assertions.assertEquals(expected, actual);
    }
}