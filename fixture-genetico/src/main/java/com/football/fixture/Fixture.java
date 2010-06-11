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
			int size = teams.size();
			for(int i = 0; i < teamGenesValues.size()/(size/2); i++)
			{
				TournamentDay aDay = new TournamentDay(teamGenesValues.subList(i*(size/2), (i+1)*(size/2)), localGenesValues.subList(i*(size/2), (i+1)*(size/2)), teams);
				days.add(aDay);
			}
		}
		return days;
	}
	
	public boolean hasRepeatedGames() {
		TournamentDay tournamentDay = null;
		for (int i = 0; i < days.size(); i++) {
			tournamentDay = days.get(i);
			List<SoccerGame> games = tournamentDay.GetGames();
			for (SoccerGame game : games) {
				for (int j = i + 1; j < days.size(); j++) {
					if (days.get(j).hasGame(game))
						return true;
				}
			}
		}
		return false;
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
