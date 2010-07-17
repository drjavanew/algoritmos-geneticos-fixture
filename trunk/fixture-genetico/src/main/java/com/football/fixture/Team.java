package main.java.com.football.fixture;

import java.util.ArrayList;
import java.util.List;

public class Team 
{

	private static List<String> teams;
	
	private String name;
	private byte id;

	static
	{ 
		teams = new ArrayList<String>();
		teams.add("ARGENTINOS_JRS");
		teams.add("ESTUDIANTES_LP");
		teams.add("GODOY_CRUZ");
		teams.add("INDEPENDIENTE");
		teams.add("BANFIELD");
		teams.add("NO_BOYS");
		teams.add("LANUS");
		teams.add("RACING");
		teams.add("VELEZ");
		teams.add("HURACAN");
		teams.add("TIGRE");
		teams.add("GIMNASIA_ESGRIMA_LP");
		teams.add("RIVER_PLATE");
		teams.add("COLON");
		teams.add("SAN_LORENZO");
		teams.add("BOCA");
		teams.add("CHACARITA");
		teams.add("QUILMES");
		teams.add("OLIMPO");
		teams.add("ARSENAL");
	}
	
	public Team(String name) {
		this.name = name;
		for(byte i = 0; i < teams.size(); i++)
			if(teams.get(i).equalsIgnoreCase(name))
				id = i;
	}

	public Team(Team team) {
		this.name = team.name;
		this.id = team.id;
	}

	public Team(byte id) {
		this.id = id;
		this.name = teams.get(id);
	}
	
	public String getName() {
		return name;
	}
	
	public byte getId()
	{
		return id;
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
