package main.java.com.football.fixture;

import java.util.List;

public class Tournament 
{
	private List<Team> teams;
	private static Tournament uniqueTournament;
	
	public static Tournament GetInstance(List<Team> teams)
	{
		if(uniqueTournament==null)
		{
			uniqueTournament = new Tournament();
		}
		uniqueTournament.teams = teams;
		return uniqueTournament;
	}
	
	public static Tournament GetInstance()
	{
		return uniqueTournament;
	}
	
	public Fixture GetFixture(List<Integer> teamGenesValues, List<Boolean> localGenesValues)
	{
		return new Fixture(teams, teamGenesValues, localGenesValues);
	}
	
	public Fixture GetFixture(List<Integer> daysGenesValues)
	{
		return new Fixture(teams, daysGenesValues);
	}
	
}
