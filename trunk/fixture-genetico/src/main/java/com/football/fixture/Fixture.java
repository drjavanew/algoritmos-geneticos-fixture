package main.java.com.football.fixture;

import java.util.ArrayList;
import java.util.List;

public class Fixture {
	private List<Team> teams;
	private List<Integer> teamGenesValues;
	private List<Boolean> localGenesValues;
	private List<TournamentDay> days;

	public Fixture(List<Team> teams, List<Integer> teamGenesValues,
			List<Boolean> localGenesValues) {
		this.teams = teams;
		this.teamGenesValues = teamGenesValues;
		this.localGenesValues = localGenesValues;
		days = new ArrayList<TournamentDay>();
	}

	public List<TournamentDay> GetDays() {
		if (days.isEmpty()) {
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
		//Si tiene partidos repetidos directamente queda descartado y no tienen sentido las demas condiciones
		if(hasRepeatedGames())
			aptitude += 84 - getCountRepeatedGames();
		else{
			aptitude += tournamentDayHasMoreThanOneClassic() ? 0 : 5;
		}

		return aptitude;
	}

}
