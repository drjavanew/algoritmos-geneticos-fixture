package main.java.com.football.fixture;

public class Team {

	private String name;
	private boolean isBigTeam; // puede ser un numero de 1 a 10, siendo 10 para
								// los equipos mas populares

	public Team(String name, boolean isBigTeam) {
		this.name = name;
		this.isBigTeam = isBigTeam;
	}

	public Team(Team team) {
		this.name = team.name;
		this.isBigTeam = team.isBigTeam;
	}

	public String getName() {
		return name;
	}

	public boolean IsBigTeam() {
		return isBigTeam;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Team other = (Team) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
