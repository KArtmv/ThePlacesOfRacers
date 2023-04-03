package ua.foxminded.javaspring;

public class Repeat {

	public String repeat(String symbol, int multiplyResult) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < multiplyResult; i++) {
			stringBuilder.append(symbol);
		}
		return stringBuilder.toString();
	}

}