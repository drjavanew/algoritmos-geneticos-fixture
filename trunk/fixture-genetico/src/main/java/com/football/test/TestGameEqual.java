package main.java.com.football.test;

import java.util.ArrayList;
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
		System.out.println();
		test.testLocalGame();
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
				"River", true));
		
		SoccerGame game2 = new SoccerGame(new Team("River", true), new Team(
				"Boca", true));
		
		SoccerGame game3 = new SoccerGame(new Team("River", true), new Team(
				"Racing", true));
		
		System.out.println("game1 = game2 - " + game1.equals(game2));
		System.out.println("game2 = game3 - " + game2.equals(game3));
	}
	
	private void tournamentHasGame() {
		System.out.println("**********tournamentHasGame");
		Team boca = new Team("Boca", true);
		Team river = new Team("River", true);
		Team estudiantes = new Team("Estudiantes", true);
		Team racing = new Team("Racing", true);
		List<Team> teams =new ArrayList<Team>();
		teams.add(boca);
		teams.add(river);
		teams.add(estudiantes);
		teams.add(racing);
		SoccerGame game1 = new SoccerGame(boca, river);
		SoccerGame game2 = new SoccerGame(estudiantes, boca);
		SoccerGame game3 = new SoccerGame(river, racing);
		List<SoccerGame> games = new ArrayList<SoccerGame>();
		games.add(game1);
		games.add(game2);
		games.add(game3);
		TournamentDay tournamentDay = new TournamentDay(null, null, teams);
		tournamentDay.setGames(games);
		
		SoccerGame existGame = new SoccerGame(river, racing);
		
		SoccerGame notExistGame = new SoccerGame(river, estudiantes);
		
		
		System.out.println("true - " + tournamentDay.hasGame(existGame));
		System.out.println("false - " + tournamentDay.hasGame(notExistGame));
	}
	
	private void testLocalGame() {
		System.out.println("**********testLocalGame");
		Team boca = new Team("Boca", true);
		Team river = new Team("River", true);
		Team estudiantes = new Team("Estudiantes", true);
		Team racing = new Team("Racing", true);
		List<Team> teams =new ArrayList<Team>();
		teams.add(boca);
		teams.add(river);
		teams.add(estudiantes);
		teams.add(racing);
		SoccerGame game1 = new SoccerGame(boca, river);
		SoccerGame game2 = new SoccerGame(estudiantes, racing);
		List<SoccerGame> games = new ArrayList<SoccerGame>();
		games.add(game1);
		games.add(game2);
		TournamentDay tournamentDay = new TournamentDay(null, null, teams);
		tournamentDay.setGames(games);
		
		System.out.println("false - " + tournamentDay.isLocal(boca));
		System.out.println("true - " + tournamentDay.isLocal(racing));
	}

}
