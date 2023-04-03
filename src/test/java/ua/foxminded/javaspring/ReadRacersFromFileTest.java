package ua.foxminded.javaspring;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ReadRacersFromFileTest {

	@Test
	void testReadRacersFromFile() throws FileNotFoundException {
		String ABBREVIATIONS_FILE_PATH = "src/main/resources/abbreviations.txt";
		ReadRacersFromFile racersFromFile = new ReadRacersFromFile();
		Map<String, AbbreviationRow> racers = racersFromFile.readRacersFromFile(ABBREVIATIONS_FILE_PATH);

		Map<String, AbbreviationRow> expected = new HashMap<>();

		String input = "DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER\n" 
				+ "SVF_Sebastian Vettel_FERRARI\n"
				+ "LHM_Lewis Hamilton_MERCEDES\n" 
				+ "KRF_Kimi Raikkonen_FERRARI\n" 
				+ "VBM_Valtteri Bottas_MERCEDES\n"
				+ "EOF_Esteban Ocon_FORCE INDIA MERCEDES\n" 
				+ "FAM_Fernando Alonso_MCLAREN RENAULT\n"
				+ "CSR_Carlos Sainz_RENAULT\n" 
				+ "SPF_Sergio Perez_FORCE INDIA MERCEDES\n"
				+ "PGS_Pierre Gasly_SCUDERIA TORO ROSSO HONDA\n" 
				+ "NHR_Nico Hulkenberg_RENAULT\n"
				+ "SVM_Stoffel Vandoorne_MCLAREN RENAULT\n" 
				+ "SSW_Sergey Sirotkin_WILLIAMS MERCEDES\n"
				+ "CLS_Charles Leclerc_SAUBER FERRARI\n" 
				+ "RGH_Romain Grosjean_HAAS FERRARI\n"
				+ "BHS_Brendon Hartley_SCUDERIA TORO ROSSO HONDA\n" 
				+ "MES_Marcus Ericsson_SAUBER FERRARI\n"
				+ "LSW_Lance Stroll_WILLIAMS MERCEDES\n" 
				+ "KMH_Kevin Magnussen_HAAS FERRARI";

		for (String line : input.split("\n")) {
			String[] racer = line.split("_");
			String key = racer[0];
			String name = racer[1];
			String team = racer[2];
			expected.put(key, new AbbreviationRow(name, team));
		}

		assertEquals(expected, racers);

	}

}
