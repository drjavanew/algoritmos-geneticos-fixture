package main.java.com.football.fixture;

import java.util.List;

public class Tournament 
{
	private List<Team> teams;
	private Fixture fixture;
	private static Tournament uniqueTournament;
	
	public Tournament(List<Team> teams)
	{
		this.fixture = new Fixture(teams); 
	}
	
	public static Tournament GetInstance(List<Team> teams)
	{
		if(uniqueTournament==null)
		{
			uniqueTournament = new Tournament(teams);
		}
		return uniqueTournament;
	}
	
	public static Tournament GetInstance()
	{
		return uniqueTournament;
	}
	
	public Fixture GetFixture()
	{
		return this.fixture;
	}
	
}
