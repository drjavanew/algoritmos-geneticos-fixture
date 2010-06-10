package main.java.com.football.fixture;

public class Team {

	private String name;
	private int popularity; // puede ser un numero de 1 a 10, siendo 10 para los equipos mas populares
	
	public Team(String name, int popularity){
		this.name = name;
		this.popularity = popularity;
	}
	
	public Team(Team team){
		this.name = team.name;
		this.popularity = team.popularity;
	}

	public String getName() {
		return name;
	}

	public int getPopularity() {
		return popularity;
	}
	
	
}
