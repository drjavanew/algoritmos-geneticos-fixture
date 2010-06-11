package main.java.com.football.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import main.java.com.football.fixture.SoccerGame;
import main.java.com.football.fixture.Team;
import main.java.com.football.fixture.TournamentDay;

public class TestGameEqual {
	public static void main(String[] args) {
		TestGameEqual test = new TestGameEqual();
		test.testTeam();
		System.out.println();
		test.testGame();
		System.out.println();
		test.tournamentHasGame();
	}
	
	private void testTeam() {
		System.out.println("**********testTeam");
		Team boca = new Team("Boca", true);
		Team river = new Team("River", true);
		
		System.out.println("boca = boca - " + boca.equals(boca));
		System.out.println("boca = river - " + boca.equals(river));
		System.out.println("boca = null - " + boca.equals(null));
	}

	private void testGame() {
		System.out.println("**********testGame");
		SoccerGame game1 = new SoccerGame(new Team("Boca", true), new Team(
				"River", true), Calendar.getInstance().getTime());
		
		SoccerGame game2 = new SoccerGame(new Team("River", true), new Team(
				"Boca", true), Calendar.getInstance().getTime());
		
		SoccerGame game3 = new SoccerGame(new Team("River", true), new Team(
				"Racing", true), Calendar.getInstance().getTime());
		
		System.out.println("game1 = game2 - " + game1.equals(game2));
		System.out.println("game2 = game3 - " + game2.equals(game3));
	}
	
	private void tournamentHasGame() {
		System.out.println("**********tournamentHasGame");
		SoccerGame game1 = new SoccerGame(new Team("Boca", true), new Team(
				"River", true), Calendar.getInstance().getTime());
		
		SoccerGame game2 = new SoccerGame(new Team("Estudiantes", true), new Team(
				"Boca", true), Calendar.getInstance().getTime());
		
		SoccerGame game3 = new SoccerGame(new Team("River", true), new Team(
				"Racing", true), Calendar.getInstance().getTime());
		
		List<SoccerGame> games = new ArrayList<SoccerGame>();
		games.add(game1);
		games.add(game2);
		games.add(game3);
		
		
		TournamentDay tournamentDay = new TournamentDay(null, null, null);
		tournamentDay.setGames(games);
		
		SoccerGame existGame = new SoccerGame(new Team("River", true), new Team(
				"Racing", true), Calendar.getInstance().getTime());
		
		SoccerGame notExistGame = new SoccerGame(new Team("River", true), new Team(
				"Estudiantes", true), Calendar.getInstance().getTime());
		
		
		System.out.println("true - " + tournamentDay.hasGame(existGame));
		System.out.println("false - " + tournamentDay.hasGame(notExistGame));
	}

}
