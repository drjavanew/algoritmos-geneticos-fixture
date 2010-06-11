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
		if(days.isEmpty())
		{
			for(int i = 0; i < teamGenesValues.size()/10; i++)
			{
				TournamentDay aDay = new TournamentDay(teamGenesValues.subList(i*10, (i+1)*10), localGenesValues.subList(i*10, (i+1)*10), teams);
				days.add(aDay);
			}
		}
		return days;
	}
	
	public int GetAptitude()
	{
		this.GetDays();
		if(!this.IsValid())
			return 0;
		/*Iterator<TournamentDay> it = days.iterator();
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
	
	private boolean IsValid()
	{
		return true;
		//Me fijo si dos o mas fechas tienen los mismos genes
		/*List<List<Integer>> subLists = new ArrayList<List<Integer>>(teamGenesValues);
		List<Integer> subIndex =new ArrayList<Integer>();
		for(int i = 0; i < 10; i++)
			for(int j=10; j<190; j+=10)
			if(copyOfTeamGenesValues.get(i)==copyOfTeamGenesValues.get(j))
			{
				subIndex.add(i);
				subIndex.add(j);			
			}*/
	}
	
}
