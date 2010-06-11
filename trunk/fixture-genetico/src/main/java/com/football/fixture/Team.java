package main.java.com.football.fixture;

public class Team {

	private String name;
	private boolean isBigTeam; // puede ser un numero de 1 a 10, siendo 10 para los equipos mas populares
	
	public Team(String name, boolean isBigTeam){
		this.name = name;
		this.isBigTeam = isBigTeam;
	}
	
	public Team(Team team){
		this.name = team.name;
		this.isBigTeam = team.isBigTeam;
	}

	public String getName() {
		return name;
	}

	public boolean IsBigTeam() {
		return isBigTeam;
	}
	
	
}
