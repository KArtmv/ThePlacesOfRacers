package ua.foxminded.javaspring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class RaceResultsSorterTest {
    
    private Map<String, AbbreviationRow> racers;
    private Map<String, String> calculatedTime;
    private RaceResultsSorter sorter;

    @Test
    void testRaceResultsSorter() {
    	racers = new HashMap<>();
    	racers.put("SVF", new AbbreviationRow("Sebastian Vettel", "FERRARI"));
    	racers.put("NHR", new AbbreviationRow("Nico Hulkenberg", "RENAULT"));
    	racers.put("FAM", new AbbreviationRow("Fernando Alonso", "MCLAREN RENAULT"));
    	
    	calculatedTime = new HashMap<>();
    	calculatedTime.put("SVF", "1:04.415");
    	calculatedTime.put("NHR", "1:13.065");
    	calculatedTime.put("FAM", "1:12.657");
    	
    	sorter = new RaceResultsSorter();
        Map<String, AbbreviationRow> expected = new TreeMap<>();
        expected.put("1:04.415", new AbbreviationRow("Sebastian Vettel", "FERRARI"));
        expected.put("1:12.657", new AbbreviationRow("Fernando Alonso", "MCLAREN RENAULT"));
        expected.put("1:13.065", new AbbreviationRow("Nico Hulkenberg", "RENAULT"));
        
        Map<String, AbbreviationRow> actual = sorter.raceResultsSorter(racers, calculatedTime);
        
        assertEquals(expected, actual);
    }
}