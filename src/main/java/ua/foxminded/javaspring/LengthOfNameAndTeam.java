package ua.foxminded.javaspring;

public class LengthOfNameAndTeam {

	private int lengthOfName;
	private int lengthOfTeam;

	public LengthOfNameAndTeam(int lengthOfName, int lelengthOfTeam) {
		this.lengthOfName = lengthOfName;
		this.lengthOfTeam = lelengthOfTeam;
	}

	public int getLengthOfName() {
		return this.lengthOfName;
	}

	public int getLengthOfTeam() {
		return this.lengthOfTeam;
	}
}