package main.java.com.football.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import main.java.com.football.fixture.SoccerGame;
import main.java.com.football.fixture.Team;
import main.java.com.football.fixture.TournamentDay;

public class ClassicSoccerGameTest {

	public static void main(String[] args) {
		ClassicSoccerGameTest test = new ClassicSoccerGameTest();
		test.isClassic();
		System.out.println();
		test.getClassicCountPerTournamentDay();
	}

	public void isClassic() {
		System.out.println("**********isClassic");
		SoccerGame game1 = new SoccerGame(new Team("BOCA", true), new Team(
				"RIVER_PLATE", true));
		SoccerGame game2 = new SoccerGame(new Team("SAN_LORENZO", true),
				new Team("BANFIELD", true));
		System.out.println("true - " + game1.isClassic());
		System.out.println("false - " + game2.isClassic());
	}

	public void getClassicCountPerTournamentDay() {
		System.out.println("**********getClassicCountPerTournamentDay");
		SoccerGame game1 = new SoccerGame(new Team("BOCA", true), new Team(
				"RIVER_PLATE", true));
		SoccerGame game2 = new SoccerGame(new Team("SAN_LORENZO", true),
				new Team("BANFIELD", true));		
		SoccerGame game3 = new SoccerGame(new Team("SAN_LORENZO", true),
				new Team("HURACAN", true));
		SoccerGame game4 = new SoccerGame(new Team("ARGENTINOS_JRS", true),
				new Team("HURACAN", true));
		
		List<SoccerGame> games = new ArrayList<SoccerGame>();		
		games.add(game1);
		games.add(game2);
		games.add(game3);

		TournamentDay tournamentDay = new TournamentDay(null, null, null);
		tournamentDay.setGames(games);
		
		System.out.println("2 - " + tournamentDay.getClassicCount());
		
		games.clear();
		games.add(game2);
		games.add(game4);
		tournamentDay.setGames(games);
		System.out.println("0 - " + tournamentDay.getClassicCount());
	}
}
