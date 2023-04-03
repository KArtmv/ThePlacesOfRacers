package ua.foxminded.javaspring;

import java.util.Objects;

public class AbbreviationRow {

	private String name;
	private String team;

	public AbbreviationRow(String name, String team) {
		this.name = name;
		this.team = team;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, team);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbbreviationRow other = (AbbreviationRow) obj;
		return Objects.equals(name, other.name) && Objects.equals(team, other.team);
	}

	public String getName() {
		return this.name;
	}

	public String getTeam() {
		return this.team;
	}
}