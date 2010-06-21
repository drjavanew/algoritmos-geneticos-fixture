package main.java.com.football.fixture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fixture {
	private List<Team> teams;
	private List<Integer> daysGenesValues;
	private List<Integer> teamGenesValues;
	private List<Boolean> localGenesValues;
	private List<TournamentDay> days;
	private List<TournamentDay> generatedDays;
	private List<SoccerGame> auxGames;
	
	public Fixture(List<Team> teams, List<Integer> teamGenesValues,
			List<Boolean> localGenesValues) {
		this.teams = teams;
		this.teamGenesValues = teamGenesValues;
		this.localGenesValues = localGenesValues;
		days = new ArrayList<TournamentDay>();
	}
	
	public Fixture(List<Team> teams, List<Integer> dateGenesValues)
	{
		this.teams = teams;
		this.daysGenesValues = dateGenesValues;
		days = new ArrayList<TournamentDay>();
		generatedDays = new ArrayList<TournamentDay>();
		GenerateDays(teams.size()-1);
		AddDays();
	}
	
	private void GenerateDays(int numberOfSwaps)
	{
		for(int i=0; i < numberOfSwaps; i++)
		{
			if(numberOfSwaps > 3)
			{
				GenerateDays(numberOfSwaps - 2);
			}
			else
			{
				auxGames=new ArrayList<SoccerGame>();
				for(int j=0; j< teams.size(); j+=2)
				{
					SoccerGame aux = new SoccerGame(new Team(teams.get(j+1)), new Team(teams.get(j)));
					auxGames.add(aux);
				}
				generatedDays.add(new TournamentDay(auxGames));
			}
			swap(teams.size() - numberOfSwaps);
		}
	}
	
	private void swap(int i)
	{
		Team aux = new Team(teams.get(i));
		teams.remove(i);
		teams.add(aux);
	}
	
	private void AddDays()
	{
		List<TournamentDay> copyOfGeneratedDays = new ArrayList<TournamentDay>(generatedDays);
		for(int i=0;i<daysGenesValues.size();i++)
		{
			TournamentDay dayToAdd = copyOfGeneratedDays.get(daysGenesValues.get(i)); 
			days.add(dayToAdd);
			List<Integer> subIndexToDelete = new ArrayList<Integer>();
			for(int j=0;j<copyOfGeneratedDays.size();j++)
			{
				//Guardo los subíndices de las fechas que ya tengan algun partido jugado
				for(SoccerGame game : dayToAdd.GetGames())
				{
					if(copyOfGeneratedDays.get(j).hasGame(game))
					{
						subIndexToDelete.add(j);
						break;
					}
				}
			}
			//Ordeno de mayor a menor los subíndices
			Collections.sort(subIndexToDelete, Collections.reverseOrder());
			//Elimino los subíndices de las fechas que ya tengan algun partido jugado
			for(Integer subIndex : subIndexToDelete)
				copyOfGeneratedDays.remove((int)subIndex);
		}
	}

	public List<TournamentDay> GetDays() 
	{
		if (days.isEmpty()) 
		{
			int size = teams.size();
			for (int i = 0; i < teamGenesValues.size() / (size / 2); i++) {
				TournamentDay aDay = new TournamentDay(teamGenesValues.subList(
						i * (size / 2), (i + 1) * (size / 2)), localGenesValues
						.subList(i * (size / 2), (i + 1) * (size / 2)), teams);
				days.add(aDay);
			}
		}
		return days;
	}
	
	/*
	 * Devuelve true si el mismo equipo juega de local o visitante
	 * dos fechas seguidas
	 */
	public boolean isLocalOrVisitantTwice() {
		boolean isLocalAfter = true;
		boolean isLocalBefore = true;
		for (Team team : teams) {
			isLocalBefore = days.get(0).isLocal(team);
			for (int i = 1; i < days.size(); i++) {
				isLocalAfter = days.get(i).isLocal(team);
				if (isLocalBefore == isLocalAfter)
					return true;
				isLocalBefore = isLocalAfter;
			}
		}
		return false;
	}
	
	
	public int getCountLocalOrVisitantTwice() {
		boolean isLocalAfter = true;
		boolean isLocalBefore = true;
		int count = 0;
		for (Team team : teams) {
			isLocalBefore = days.get(0).isLocal(team);
			for (int i = 1; i < days.size(); i++) {
				isLocalAfter = days.get(i).isLocal(team);
				if (isLocalBefore == isLocalAfter)
					count++;
				isLocalBefore = isLocalAfter;
			}
		}
		return count;
	}

	public int getCountRepeatedGames() {
		TournamentDay tournamentDay = null;
		int count = 0;
		for (int i = 0; i < days.size(); i++) {
			tournamentDay = days.get(i);
			List<SoccerGame> games = tournamentDay.GetGames();
			for (SoccerGame game : games) {
				for (int j = i + 1; j < days.size(); j++) {
					if (days.get(j).hasGame(game))
						count++;
				}
			}
		}
		return count;
	}
	
	public boolean tournamentDayHasMoreThanOneClassic() {
		for (TournamentDay day : days) {
			if (day.getClassicCount() > 1)
				return true;
		}
		return false;
	}
	
	public boolean hasRepeatedGames() {
		TournamentDay tournamentDay = null;
		for (int i = 0; i < days.size(); i++) {
			tournamentDay = days.get(i);
			List<SoccerGame> games = tournamentDay.GetGames();
			for (SoccerGame game : games) {
				for (int j = i + 1; j < days.size(); j++) {
					if (days.get(j).hasGame(game)){
						return true;
					}
				}
			}
		}
		return false;
	}

	public int GetAptitude() {
		this.GetDays();
		int aptitude = 0;
		
		aptitude += 84 - getCountRepeatedGames();
		
		if (!hasRepeatedGames()){
			aptitude += tournamentDayHasMoreThanOneClassic() ? 0 : 5;
		}
		return aptitude;
	}

}
