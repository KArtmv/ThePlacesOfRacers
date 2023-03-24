package ua.foxminded.javaspring;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TakeRacers {

	Map<String, ArrayList<String>> racers = new HashMap<>();

	public Map<String, ArrayList<String>> takeRacers(String fileWithNameOfRacers) throws FileNotFoundException {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(fileWithNameOfRacers));
			while (sc.hasNextLine()) {
				String[] racer = sc.nextLine().split("_");
				for (int j = 0; j < racer.length; j++) {
					ArrayList<String> nameAndCarOfRacer = new ArrayList<>();
					nameAndCarOfRacer.add(racer[1]);
					nameAndCarOfRacer.add(racer[2]);
					racers.put(racer[0], nameAndCarOfRacer);
				}
			}
		} catch (FileNotFoundException e) {
		} catch (NoSuchElementException e) {
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
		return racers;

	}
}
