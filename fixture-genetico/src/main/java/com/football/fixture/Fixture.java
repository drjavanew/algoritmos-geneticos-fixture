package main.java.com.football.fixture;

import java.util.*;

public class Fixture {
	private List<Team> teams;
	private List<Integer> teamGenesValues;
	private List<Boolean> localGenesValues;
	private List<TournamentDay> days;
	public Fixture(List<Team> teams, List<Integer> teamGenesValues, List<Boolean> localGenesValues)
	{
		this.teams = teams;
		this.teamGenesValues = teamGenesValues;
		this.localGenesValues = localGenesValues;
		days = new ArrayList<TournamentDay>();
	}
	
	public List<TournamentDay> GetDays()
	{
		List<TournamentDay> aux = new ArrayList<TournamentDay>();
		for(int i = 0; i < teamGenesValues.size()/10; i++)
		{
			TournamentDay aDay = new TournamentDay(teamGenesValues.subList(i*10, (i+1)*10), localGenesValues.subList(i*10, (i+1)*10), teams);
			aux.add(aDay);
		}
		return aux;
	}
	
	public int GetAptitude()
	{
		/*List<TournamentDay> days = fixture.GetDays();
		Iterator<TournamentDay> it = days.iterator();
		while(it.hasNext())
		{
			for(SoccerGame game : it.next().GetGames())
			{
				Team local = game.getTeamLocal();
				Team visitor = game.getTeamVisitor();
				//Hacer algo!!!!
				//Lo 1ero que hay q ver es si el fixture es válido (si no se repiten partidos)
			}
		}*/
		return 1;
	}
	
}
