package main.java.com.football.fixture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class TournamentDay {
	private List<Integer> gamesGenesValues;
	private List<Boolean> localGenesValues;
	private List<Team> teams;
	private static List<SoccerGame> allGamesCombinations = new ArrayList<SoccerGame>();
	private List<SoccerGame> games = new ArrayList<SoccerGame>();
	
	public TournamentDay(List<Integer> genesValues, List<Boolean> localGenesValues, List<Team> teams)
	{
		this.gamesGenesValues = genesValues;
		this.localGenesValues = localGenesValues;
		this.teams = teams;
		if(allGamesCombinations.size()==0)
			AddGames();
	}
	private void AddGames()
	{
		List<Team> copyOfTeams = new ArrayList<Team>();
		copyOfTeams.addAll(teams);
		while(copyOfTeams.size() > 1)
		{
			for(int i = 0; i < copyOfTeams.size()-1; i++)
			{
				Team local = new Team(copyOfTeams.get(0));
				Team visitor = new Team(copyOfTeams.get(1));
				SoccerGame game = new SoccerGame(visitor, local, new Date());
				allGamesCombinations.add(game);
				Team aTeam = new Team(copyOfTeams.get(1));
				copyOfTeams.remove(1);
				copyOfTeams.add(aTeam);
			}
			copyOfTeams.remove(0);
		}
	}
	public List<SoccerGame> GetGames()
	{
		if(games.isEmpty())
		{
			List<SoccerGame> copyOfGames = new ArrayList<SoccerGame>();
			copyOfGames.addAll(allGamesCombinations);
			for(int i=0;i<teams.size()/2;i++)
			{
				int subIndex = (int)gamesGenesValues.get(i);
				Boolean isLocal = (Boolean)localGenesValues.get(i);
				SoccerGame gameToAdd = new SoccerGame(copyOfGames.get(subIndex), isLocal);
				games.add(gameToAdd);
				/*Elimino los partidos que involucren a los equipos que ya se jugaron*/
				subIndex = 0;
				List<Integer> subIndexToDelete = new ArrayList<Integer>();
				for(SoccerGame game : copyOfGames)
				{
					String local = game.getTeamLocal().getName();
					String visitor = game.getTeamVisitor().getName();
					String localToCompare = gameToAdd.getTeamLocal().getName();
					String visitorToCompare = gameToAdd.getTeamVisitor().getName();
					if((local.equalsIgnoreCase(localToCompare))||(visitor.equalsIgnoreCase(visitorToCompare))||
						(local.equalsIgnoreCase(visitorToCompare))||(visitor.equalsIgnoreCase(localToCompare)))
						subIndexToDelete.add(subIndex);
					subIndex++;
				}
				Collections.sort(subIndexToDelete, Collections.reverseOrder());
				for(Integer j : subIndexToDelete)
				{
					subIndex = (int)j;
					copyOfGames.remove(subIndex);
				}
			}
		}
		return games;
	}
	
	public boolean hasGame(SoccerGame game) {
		for (SoccerGame g : GetGames()) {
			if (g.equals(game))
				return true;
		}
		return false;
	}
	
	/*
	 * Esto se usa para probar el hasGame
	 */
	public void setGames(List<SoccerGame> games) {
		this.games = games;
	}
}
