package main.java.com.football.fixture;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.*;

public class Fixture {
	private List<Team> switchedTeams;
	private List<Team> teams;
	private List<TournamentDay> dates;
	public static final double MAX_BOUND = 10000000.0d;
	private static List<Team> bigFiveTeams;
	
	public static final int MIN_CLASSIC_DAY = 7;
	public static final int MAX_CLASSIC_DAY = 17;
	
	static 
	{
		bigFiveTeams = new ArrayList<Team>();
		bigFiveTeams.add(new Team("INDEPENDIENTE"));
		bigFiveTeams.add(new Team("RACING"));
		bigFiveTeams.add(new Team("BOCA"));
		bigFiveTeams.add(new Team("SAN_LORENZO"));
		bigFiveTeams.add(new Team("RIVER_PLATE"));
	}

	public Fixture(List<Team> teams)
	{
		this.teams = teams;
	}

	public List<TournamentDay> GetDays(List<Integer> fixtureCombination) 
	{
		switchedTeams = new ArrayList<Team>();
		List<Team> copyOfTeams = new ArrayList<Team>(teams);
		dates = new ArrayList<TournamentDay>();
		for(int i = 0; i < fixtureCombination.size(); i++)
		{
			switchedTeams.add(copyOfTeams.get(fixtureCombination.get(i)));
			copyOfTeams.remove(copyOfTeams.get(fixtureCombination.get(i)));
		}
		GenerateDates();
		return dates;
	}
	
	private void switchTeams(int id1, int id2)
	{
		Team aux = switchedTeams.get(id1);
		switchedTeams.set(id1, switchedTeams.get(id2));
		switchedTeams.set(id2, aux);
	}

	private void GenerateDates()
	{
		/*Fecha 1*/
		List<SoccerGame> games = new ArrayList<SoccerGame>();
		games.add(new SoccerGame(new Team(switchedTeams.get(0)), new Team(switchedTeams.get(1))));
		games.add(new SoccerGame(new Team(switchedTeams.get(2)), new Team(switchedTeams.get(3))));
		games.add(new SoccerGame(new Team(switchedTeams.get(4)), new Team(switchedTeams.get(5))));
		games.add(new SoccerGame(new Team(switchedTeams.get(6)), new Team(switchedTeams.get(7))));
		games.add(new SoccerGame(new Team(switchedTeams.get(8)), new Team(switchedTeams.get(9))));
		games.add(new SoccerGame(new Team(switchedTeams.get(10)), new Team(switchedTeams.get(11))));
		games.add(new SoccerGame(new Team(switchedTeams.get(12)), new Team(switchedTeams.get(13))));
		games.add(new SoccerGame(new Team(switchedTeams.get(14)), new Team(switchedTeams.get(15))));
		games.add(new SoccerGame(new Team(switchedTeams.get(16)), new Team(switchedTeams.get(17))));
		games.add(new SoccerGame(new Team(switchedTeams.get(18)), new Team(switchedTeams.get(19))));
		TournamentDay day = new TournamentDay(games);
		dates.add(day);
		/*Fecha 2*/
		games = new ArrayList<SoccerGame>();
		games.add(new SoccerGame(new Team(switchedTeams.get(13)), new Team(switchedTeams.get(10))));
		games.add(new SoccerGame(new Team(switchedTeams.get(11)), new Team(switchedTeams.get(6))));
		games.add(new SoccerGame(new Team(switchedTeams.get(7)), new Team(switchedTeams.get(8))));
		games.add(new SoccerGame(new Team(switchedTeams.get(9)), new Team(switchedTeams.get(4))));
		games.add(new SoccerGame(new Team(switchedTeams.get(5)), new Team(switchedTeams.get(2))));
		games.add(new SoccerGame(new Team(switchedTeams.get(3)), new Team(switchedTeams.get(0))));
		games.add(new SoccerGame(new Team(switchedTeams.get(1)), new Team(switchedTeams.get(18))));
		games.add(new SoccerGame(new Team(switchedTeams.get(19)), new Team(switchedTeams.get(16))));
		games.add(new SoccerGame(new Team(switchedTeams.get(17)), new Team(switchedTeams.get(14))));
		games.add(new SoccerGame(new Team(switchedTeams.get(15)), new Team(switchedTeams.get(12))));
		day = new TournamentDay(games);
		dates.add(day);
		/*Fecha 3*/
		games = new ArrayList<SoccerGame>();
		games.add(new SoccerGame(new Team(switchedTeams.get(16)), new Team(switchedTeams.get(1))));
		games.add(new SoccerGame(new Team(switchedTeams.get(18)), new Team(switchedTeams.get(3))));
		games.add(new SoccerGame(new Team(switchedTeams.get(0)), new Team(switchedTeams.get(5))));
		games.add(new SoccerGame(new Team(switchedTeams.get(2)), new Team(switchedTeams.get(4))));
		games.add(new SoccerGame(new Team(switchedTeams.get(7)), new Team(switchedTeams.get(9))));
		games.add(new SoccerGame(new Team(switchedTeams.get(8)), new Team(switchedTeams.get(11))));
		games.add(new SoccerGame(new Team(switchedTeams.get(6)), new Team(switchedTeams.get(13))));
		games.add(new SoccerGame(new Team(switchedTeams.get(10)), new Team(switchedTeams.get(15))));
		games.add(new SoccerGame(new Team(switchedTeams.get(12)), new Team(switchedTeams.get(17))));
		games.add(new SoccerGame(new Team(switchedTeams.get(14)), new Team(switchedTeams.get(19))));
		day = new TournamentDay(games);
		dates.add(day);
		/*Fecha 4*/
		games = new ArrayList<SoccerGame>();
		games.add(new SoccerGame(new Team(switchedTeams.get(17)), new Team(switchedTeams.get(10))));
		games.add(new SoccerGame(new Team(switchedTeams.get(15)), new Team(switchedTeams.get(6))));
		games.add(new SoccerGame(new Team(switchedTeams.get(13)), new Team(switchedTeams.get(8))));
		games.add(new SoccerGame(new Team(switchedTeams.get(11)), new Team(switchedTeams.get(7))));
		games.add(new SoccerGame(new Team(switchedTeams.get(9)), new Team(switchedTeams.get(2))));
		games.add(new SoccerGame(new Team(switchedTeams.get(4)), new Team(switchedTeams.get(0))));
		games.add(new SoccerGame(new Team(switchedTeams.get(5)), new Team(switchedTeams.get(18))));
		games.add(new SoccerGame(new Team(switchedTeams.get(3)), new Team(switchedTeams.get(16))));
		games.add(new SoccerGame(new Team(switchedTeams.get(1)), new Team(switchedTeams.get(14))));
		games.add(new SoccerGame(new Team(switchedTeams.get(19)), new Team(switchedTeams.get(12))));
		day = new TournamentDay(games);
		dates.add(day);
		/*Fecha 5*/
		games = new ArrayList<SoccerGame>();
		games.add(new SoccerGame(new Team(switchedTeams.get(12)), new Team(switchedTeams.get(1))));
		games.add(new SoccerGame(new Team(switchedTeams.get(14)), new Team(switchedTeams.get(3))));
		games.add(new SoccerGame(new Team(switchedTeams.get(16)), new Team(switchedTeams.get(5))));
		games.add(new SoccerGame(new Team(switchedTeams.get(18)), new Team(switchedTeams.get(4))));
		games.add(new SoccerGame(new Team(switchedTeams.get(0)), new Team(switchedTeams.get(2))));
		games.add(new SoccerGame(new Team(switchedTeams.get(9)), new Team(switchedTeams.get(11))));
		games.add(new SoccerGame(new Team(switchedTeams.get(7)), new Team(switchedTeams.get(13))));
		games.add(new SoccerGame(new Team(switchedTeams.get(8)), new Team(switchedTeams.get(15))));
		games.add(new SoccerGame(new Team(switchedTeams.get(6)), new Team(switchedTeams.get(17))));
		games.add(new SoccerGame(new Team(switchedTeams.get(10)), new Team(switchedTeams.get(19))));
		day = new TournamentDay(games);
		dates.add(day);
		/*Fecha 6*/
		games = new ArrayList<SoccerGame>();
		games.add(new SoccerGame(new Team(switchedTeams.get(1)), new Team(switchedTeams.get(10))));
		games.add(new SoccerGame(new Team(switchedTeams.get(19)), new Team(switchedTeams.get(6))));
		games.add(new SoccerGame(new Team(switchedTeams.get(17)), new Team(switchedTeams.get(8))));
		games.add(new SoccerGame(new Team(switchedTeams.get(15)), new Team(switchedTeams.get(7))));
		games.add(new SoccerGame(new Team(switchedTeams.get(0)), new Team(switchedTeams.get(9))));
		games.add(new SoccerGame(new Team(switchedTeams.get(13)), new Team(switchedTeams.get(11))));
		games.add(new SoccerGame(new Team(switchedTeams.get(2)), new Team(switchedTeams.get(18))));
		games.add(new SoccerGame(new Team(switchedTeams.get(4)), new Team(switchedTeams.get(16))));
		games.add(new SoccerGame(new Team(switchedTeams.get(5)), new Team(switchedTeams.get(14))));
		games.add(new SoccerGame(new Team(switchedTeams.get(3)), new Team(switchedTeams.get(12))));
		day = new TournamentDay(games);
		dates.add(day);
		/*Fecha 7*/
		games = new ArrayList<SoccerGame>();
		games.add(new SoccerGame(new Team(switchedTeams.get(6)), new Team(switchedTeams.get(1))));
		games.add(new SoccerGame(new Team(switchedTeams.get(10)), new Team(switchedTeams.get(3))));
		games.add(new SoccerGame(new Team(switchedTeams.get(12)), new Team(switchedTeams.get(5))));
		games.add(new SoccerGame(new Team(switchedTeams.get(14)), new Team(switchedTeams.get(4))));
		games.add(new SoccerGame(new Team(switchedTeams.get(16)), new Team(switchedTeams.get(2))));
		games.add(new SoccerGame(new Team(switchedTeams.get(18)), new Team(switchedTeams.get(0))));
		games.add(new SoccerGame(new Team(switchedTeams.get(9)), new Team(switchedTeams.get(13))));
		games.add(new SoccerGame(new Team(switchedTeams.get(11)), new Team(switchedTeams.get(15))));
		games.add(new SoccerGame(new Team(switchedTeams.get(7)), new Team(switchedTeams.get(17))));
		games.add(new SoccerGame(new Team(switchedTeams.get(8)), new Team(switchedTeams.get(19))));
		day = new TournamentDay(games);
		dates.add(day);
		/*Fecha 8*/
		games = new ArrayList<SoccerGame>();
		games.add(new SoccerGame(new Team(switchedTeams.get(5)), new Team(switchedTeams.get(10))));
		games.add(new SoccerGame(new Team(switchedTeams.get(3)), new Team(switchedTeams.get(6))));
		games.add(new SoccerGame(new Team(switchedTeams.get(1)), new Team(switchedTeams.get(8))));
		games.add(new SoccerGame(new Team(switchedTeams.get(19)), new Team(switchedTeams.get(7))));
		games.add(new SoccerGame(new Team(switchedTeams.get(18)), new Team(switchedTeams.get(9))));
		games.add(new SoccerGame(new Team(switchedTeams.get(17)), new Team(switchedTeams.get(11))));
		games.add(new SoccerGame(new Team(switchedTeams.get(15)), new Team(switchedTeams.get(13))));
		games.add(new SoccerGame(new Team(switchedTeams.get(0)), new Team(switchedTeams.get(16))));
		games.add(new SoccerGame(new Team(switchedTeams.get(2)), new Team(switchedTeams.get(14))));
		games.add(new SoccerGame(new Team(switchedTeams.get(4)), new Team(switchedTeams.get(12))));
		day = new TournamentDay(games);
		dates.add(day);
		/*Fecha 9*/
		games = new ArrayList<SoccerGame>();
		games.add(new SoccerGame(new Team(switchedTeams.get(7)), new Team(switchedTeams.get(1))));
		games.add(new SoccerGame(new Team(switchedTeams.get(8)), new Team(switchedTeams.get(3))));
		games.add(new SoccerGame(new Team(switchedTeams.get(6)), new Team(switchedTeams.get(5))));
		games.add(new SoccerGame(new Team(switchedTeams.get(10)), new Team(switchedTeams.get(4))));
		games.add(new SoccerGame(new Team(switchedTeams.get(12)), new Team(switchedTeams.get(2))));
		games.add(new SoccerGame(new Team(switchedTeams.get(14)), new Team(switchedTeams.get(0))));
		games.add(new SoccerGame(new Team(switchedTeams.get(16)), new Team(switchedTeams.get(18))));
		games.add(new SoccerGame(new Team(switchedTeams.get(9)), new Team(switchedTeams.get(15))));
		games.add(new SoccerGame(new Team(switchedTeams.get(13)), new Team(switchedTeams.get(17))));
		games.add(new SoccerGame(new Team(switchedTeams.get(11)), new Team(switchedTeams.get(19))));
		day = new TournamentDay(games);
		dates.add(day);
		/*Fecha 10*/
		games = new ArrayList<SoccerGame>();
		games.add(new SoccerGame(new Team(switchedTeams.get(2)), new Team(switchedTeams.get(10))));
		games.add(new SoccerGame(new Team(switchedTeams.get(4)), new Team(switchedTeams.get(6))));
		games.add(new SoccerGame(new Team(switchedTeams.get(5)), new Team(switchedTeams.get(8))));
		games.add(new SoccerGame(new Team(switchedTeams.get(3)), new Team(switchedTeams.get(7))));
		games.add(new SoccerGame(new Team(switchedTeams.get(16)), new Team(switchedTeams.get(9))));
		games.add(new SoccerGame(new Team(switchedTeams.get(1)), new Team(switchedTeams.get(11))));
		games.add(new SoccerGame(new Team(switchedTeams.get(19)), new Team(switchedTeams.get(13))));
		games.add(new SoccerGame(new Team(switchedTeams.get(17)), new Team(switchedTeams.get(15))));
		games.add(new SoccerGame(new Team(switchedTeams.get(18)), new Team(switchedTeams.get(14))));
		games.add(new SoccerGame(new Team(switchedTeams.get(0)), new Team(switchedTeams.get(12))));
		day = new TournamentDay(games);
		dates.add(day);
		/*Fecha 11*/
		games = new ArrayList<SoccerGame>();
		games.add(new SoccerGame(new Team(switchedTeams.get(13)), new Team(switchedTeams.get(1))));
		games.add(new SoccerGame(new Team(switchedTeams.get(11)), new Team(switchedTeams.get(3))));
		games.add(new SoccerGame(new Team(switchedTeams.get(7)), new Team(switchedTeams.get(5))));
		games.add(new SoccerGame(new Team(switchedTeams.get(8)), new Team(switchedTeams.get(4))));
		games.add(new SoccerGame(new Team(switchedTeams.get(6)), new Team(switchedTeams.get(2))));
		games.add(new SoccerGame(new Team(switchedTeams.get(10)), new Team(switchedTeams.get(0))));
		games.add(new SoccerGame(new Team(switchedTeams.get(12)), new Team(switchedTeams.get(18))));
		games.add(new SoccerGame(new Team(switchedTeams.get(14)), new Team(switchedTeams.get(16))));
		games.add(new SoccerGame(new Team(switchedTeams.get(9)), new Team(switchedTeams.get(17))));
		games.add(new SoccerGame(new Team(switchedTeams.get(15)), new Team(switchedTeams.get(19))));
		day = new TournamentDay(games);
		dates.add(day);
		/*Fecha 12*/
		games = new ArrayList<SoccerGame>();
		games.add(new SoccerGame(new Team(switchedTeams.get(18)), new Team(switchedTeams.get(10))));
		games.add(new SoccerGame(new Team(switchedTeams.get(0)), new Team(switchedTeams.get(6))));
		games.add(new SoccerGame(new Team(switchedTeams.get(2)), new Team(switchedTeams.get(8))));
		games.add(new SoccerGame(new Team(switchedTeams.get(4)), new Team(switchedTeams.get(7))));
		games.add(new SoccerGame(new Team(switchedTeams.get(14)), new Team(switchedTeams.get(9))));
		games.add(new SoccerGame(new Team(switchedTeams.get(5)), new Team(switchedTeams.get(11))));
		games.add(new SoccerGame(new Team(switchedTeams.get(3)), new Team(switchedTeams.get(13))));
		games.add(new SoccerGame(new Team(switchedTeams.get(1)), new Team(switchedTeams.get(15))));
		games.add(new SoccerGame(new Team(switchedTeams.get(19)), new Team(switchedTeams.get(17))));
		games.add(new SoccerGame(new Team(switchedTeams.get(16)), new Team(switchedTeams.get(12))));
		day = new TournamentDay(games);
		dates.add(day);
		/*Fecha 13*/
		games = new ArrayList<SoccerGame>();
		games.add(new SoccerGame(new Team(switchedTeams.get(17)), new Team(switchedTeams.get(1))));
		games.add(new SoccerGame(new Team(switchedTeams.get(15)), new Team(switchedTeams.get(3))));
		games.add(new SoccerGame(new Team(switchedTeams.get(13)), new Team(switchedTeams.get(5))));
		games.add(new SoccerGame(new Team(switchedTeams.get(11)), new Team(switchedTeams.get(4))));
		games.add(new SoccerGame(new Team(switchedTeams.get(7)), new Team(switchedTeams.get(2))));
		games.add(new SoccerGame(new Team(switchedTeams.get(8)), new Team(switchedTeams.get(0))));
		games.add(new SoccerGame(new Team(switchedTeams.get(6)), new Team(switchedTeams.get(18))));
		games.add(new SoccerGame(new Team(switchedTeams.get(10)), new Team(switchedTeams.get(16))));
		games.add(new SoccerGame(new Team(switchedTeams.get(12)), new Team(switchedTeams.get(14))));
		games.add(new SoccerGame(new Team(switchedTeams.get(9)), new Team(switchedTeams.get(19))));
		day = new TournamentDay(games);
		dates.add(day);
		/*Fecha 14*/
		games = new ArrayList<SoccerGame>();
		games.add(new SoccerGame(new Team(switchedTeams.get(14)), new Team(switchedTeams.get(10))));
		games.add(new SoccerGame(new Team(switchedTeams.get(16)), new Team(switchedTeams.get(6))));
		games.add(new SoccerGame(new Team(switchedTeams.get(18)), new Team(switchedTeams.get(8))));
		games.add(new SoccerGame(new Team(switchedTeams.get(0)), new Team(switchedTeams.get(7))));
		games.add(new SoccerGame(new Team(switchedTeams.get(12)), new Team(switchedTeams.get(9))));
		games.add(new SoccerGame(new Team(switchedTeams.get(2)), new Team(switchedTeams.get(11))));
		games.add(new SoccerGame(new Team(switchedTeams.get(4)), new Team(switchedTeams.get(13))));
		games.add(new SoccerGame(new Team(switchedTeams.get(5)), new Team(switchedTeams.get(15))));
		games.add(new SoccerGame(new Team(switchedTeams.get(3)), new Team(switchedTeams.get(17))));
		games.add(new SoccerGame(new Team(switchedTeams.get(1)), new Team(switchedTeams.get(19))));
		day = new TournamentDay(games);
		dates.add(day);
		/*Fecha 15*/
		games = new ArrayList<SoccerGame>();
		games.add(new SoccerGame(new Team(switchedTeams.get(9)), new Team(switchedTeams.get(1))));
		games.add(new SoccerGame(new Team(switchedTeams.get(19)), new Team(switchedTeams.get(3))));
		games.add(new SoccerGame(new Team(switchedTeams.get(17)), new Team(switchedTeams.get(5))));
		games.add(new SoccerGame(new Team(switchedTeams.get(15)), new Team(switchedTeams.get(4))));
		games.add(new SoccerGame(new Team(switchedTeams.get(13)), new Team(switchedTeams.get(2))));
		games.add(new SoccerGame(new Team(switchedTeams.get(11)), new Team(switchedTeams.get(0))));
		games.add(new SoccerGame(new Team(switchedTeams.get(7)), new Team(switchedTeams.get(18))));
		games.add(new SoccerGame(new Team(switchedTeams.get(8)), new Team(switchedTeams.get(16))));
		games.add(new SoccerGame(new Team(switchedTeams.get(6)), new Team(switchedTeams.get(14))));
		games.add(new SoccerGame(new Team(switchedTeams.get(10)), new Team(switchedTeams.get(12))));
		day = new TournamentDay(games);
		dates.add(day);
		/*Fecha 16*/
		games = new ArrayList<SoccerGame>();
		games.add(new SoccerGame(new Team(switchedTeams.get(3)), new Team(switchedTeams.get(1))));
		games.add(new SoccerGame(new Team(switchedTeams.get(12)), new Team(switchedTeams.get(6))));
		games.add(new SoccerGame(new Team(switchedTeams.get(14)), new Team(switchedTeams.get(8))));
		games.add(new SoccerGame(new Team(switchedTeams.get(16)), new Team(switchedTeams.get(7))));
		games.add(new SoccerGame(new Team(switchedTeams.get(10)), new Team(switchedTeams.get(9))));
		games.add(new SoccerGame(new Team(switchedTeams.get(18)), new Team(switchedTeams.get(11))));
		games.add(new SoccerGame(new Team(switchedTeams.get(0)), new Team(switchedTeams.get(13))));
		games.add(new SoccerGame(new Team(switchedTeams.get(2)), new Team(switchedTeams.get(15))));
		games.add(new SoccerGame(new Team(switchedTeams.get(4)), new Team(switchedTeams.get(17))));
		games.add(new SoccerGame(new Team(switchedTeams.get(5)), new Team(switchedTeams.get(19))));
		day = new TournamentDay(games);
		dates.add(day);
		/*Fecha 17*/
		games = new ArrayList<SoccerGame>();
		games.add(new SoccerGame(new Team(switchedTeams.get(6)), new Team(switchedTeams.get(10))));
		games.add(new SoccerGame(new Team(switchedTeams.get(9)), new Team(switchedTeams.get(3))));
		games.add(new SoccerGame(new Team(switchedTeams.get(1)), new Team(switchedTeams.get(5))));
		games.add(new SoccerGame(new Team(switchedTeams.get(19)), new Team(switchedTeams.get(4))));
		games.add(new SoccerGame(new Team(switchedTeams.get(17)), new Team(switchedTeams.get(2))));
		games.add(new SoccerGame(new Team(switchedTeams.get(15)), new Team(switchedTeams.get(0))));
		games.add(new SoccerGame(new Team(switchedTeams.get(13)), new Team(switchedTeams.get(18))));
		games.add(new SoccerGame(new Team(switchedTeams.get(11)), new Team(switchedTeams.get(16))));
		games.add(new SoccerGame(new Team(switchedTeams.get(7)), new Team(switchedTeams.get(14))));
		games.add(new SoccerGame(new Team(switchedTeams.get(8)), new Team(switchedTeams.get(12))));
		day = new TournamentDay(games);
		dates.add(day);
		/*Fecha 18*/
		games = new ArrayList<SoccerGame>();
		games.add(new SoccerGame(new Team(switchedTeams.get(4)), new Team(switchedTeams.get(1))));
		games.add(new SoccerGame(new Team(switchedTeams.get(5)), new Team(switchedTeams.get(3))));
		games.add(new SoccerGame(new Team(switchedTeams.get(10)), new Team(switchedTeams.get(8))));
		games.add(new SoccerGame(new Team(switchedTeams.get(12)), new Team(switchedTeams.get(7))));
		games.add(new SoccerGame(new Team(switchedTeams.get(6)), new Team(switchedTeams.get(9))));
		games.add(new SoccerGame(new Team(switchedTeams.get(14)), new Team(switchedTeams.get(11))));
		games.add(new SoccerGame(new Team(switchedTeams.get(16)), new Team(switchedTeams.get(13))));
		games.add(new SoccerGame(new Team(switchedTeams.get(18)), new Team(switchedTeams.get(15))));
		games.add(new SoccerGame(new Team(switchedTeams.get(0)), new Team(switchedTeams.get(17))));
		games.add(new SoccerGame(new Team(switchedTeams.get(2)), new Team(switchedTeams.get(19))));
		day = new TournamentDay(games);
		dates.add(day);
		/*Fecha 19*/
		games = new ArrayList<SoccerGame>();
		games.add(new SoccerGame(new Team(switchedTeams.get(7)), new Team(switchedTeams.get(10))));
		games.add(new SoccerGame(new Team(switchedTeams.get(8)), new Team(switchedTeams.get(6))));
		games.add(new SoccerGame(new Team(switchedTeams.get(9)), new Team(switchedTeams.get(5))));
		games.add(new SoccerGame(new Team(switchedTeams.get(3)), new Team(switchedTeams.get(4))));
		games.add(new SoccerGame(new Team(switchedTeams.get(1)), new Team(switchedTeams.get(2))));
		games.add(new SoccerGame(new Team(switchedTeams.get(19)), new Team(switchedTeams.get(0))));
		games.add(new SoccerGame(new Team(switchedTeams.get(17)), new Team(switchedTeams.get(18))));
		games.add(new SoccerGame(new Team(switchedTeams.get(15)), new Team(switchedTeams.get(16))));
		games.add(new SoccerGame(new Team(switchedTeams.get(13)), new Team(switchedTeams.get(14))));
		games.add(new SoccerGame(new Team(switchedTeams.get(11)), new Team(switchedTeams.get(12))));
		day = new TournamentDay(games);
		dates.add(day);
	}
	
	/*
	 * Devuelve true si el mismo equipo juega de local o visitante
	 * dos fechas seguidas
	 */
	public boolean isLocalOrVisitantTwice()
	{
		boolean isLocalAfter = true;
		boolean isLocalBefore = true;
		for (Team team : teams)
		{
			isLocalBefore = dates.get(0).isLocal(team);
			for (int i = 1; i < dates.size(); i++)
			{
				isLocalAfter = dates.get(i).isLocal(team);
				if (isLocalBefore == isLocalAfter)
					return true;
				isLocalBefore = isLocalAfter;
			}
		}
		return false;
	}
	
	public int getCountLocalOrVisitantTwice()
	{
		boolean isLocalAfter = true;
		boolean isLocalBefore = true;
		int count = 0;
		for (Team team : teams)
		{
			isLocalBefore = dates.get(0).isLocal(team);
			for (int i = 1; i < dates.size(); i++)
			{
				isLocalAfter = dates.get(i).isLocal(team);
				if (isLocalBefore == isLocalAfter)
					count++;
				isLocalBefore = isLocalAfter;
			}
		}
		return count;
	}

	public int getCountRepeatedGames()
	{
		TournamentDay tournamentDay = null;
		int count = 0;
		for (int i = 0; i < dates.size(); i++)
		{
			tournamentDay = dates.get(i);
			List<SoccerGame> games = tournamentDay.GetGames();
			for (SoccerGame game : games)
			{
				for (int j = i + 1; j < dates.size(); j++)
				{
					if (dates.get(j).hasGame(game))
						count++;
				}
			}
		}
		return count;
	}
	
	public boolean tournamentDayHasMoreThanOneClassic()
	{
		for (TournamentDay day : dates)
		{
			if (day.getClassicCount() > 1)
				return true;
		}
		return false;
	}
	
	public boolean hasRepeatedGames()
	{
		TournamentDay tournamentDay = null;
		for (int i = 0; i < dates.size(); i++)
		{
			tournamentDay = dates.get(i);
			List<SoccerGame> games = tournamentDay.GetGames();
			for (SoccerGame game : games)
			{
				for (int j = i + 1; j < dates.size(); j++)
				{
					if (dates.get(j).hasGame(game))
						return true;
				}
			}
		}
		return false;
	}

	public double GetLocalOrVisitantTwicePenalty(double maxFitness) {
		double penalty = 0;
		boolean isLocalAfter = true;
		boolean isLocalBefore = true;

		for (Team team : teams) {
			isLocalBefore = this.dates.get(0).isLocal(team);
			int count = 0;
			for (int i = 1; i < this.dates.size(); i++) {
				isLocalAfter = dates.get(i).isLocal(team);
				if (isLocalBefore == isLocalAfter)
					count++;
				isLocalBefore = isLocalAfter;
			}
			// Permito que 1 equipo juegue como maximo dos fechas seguidas
			// de local o visitante
			if (count - 1 > 0)
				penalty += (count - 1) * (count - 1) * 50;
		}

		return Math.min(maxFitness, penalty);
	}
	
	public double GetBigFiveLocalOrVisitantTwicePenalty(double maxFitness) {
		double penalty = 0;
		//Penalizacion: Si un equipo juega de local contra uno de los 5 equipos grandes, deberá jugar el próximo
		//partido contra otro equipo grande como visitante, y asi sucesivamente.
		ArrayList<Team> copyTeams = new ArrayList<Team>(teams);
		copyTeams.removeAll(bigFiveTeams);
		for (Team team : copyTeams){
			ArrayList<SoccerGame> tmp = new ArrayList<SoccerGame>();
			
			for (int i = 0; i < this.dates.size(); i++) {
				SoccerGame game = dates.get(i).getGame(team);
				if ( bigFiveTeams.contains(game.getTeamVisitor()) || bigFiveTeams.contains(game.getTeamLocal()))
					tmp.add(game);
			}
			
			boolean isLocalAfter = true;
			boolean isLocalBefore = tmp.get(0).getTeamLocal().equals(team);
			int count = 0;
			
			for (int i = 1; i < tmp.size(); i++) {
				isLocalAfter = tmp.get(i).getTeamLocal().equals(team);
				if (isLocalBefore == isLocalAfter)
					count++;
				isLocalBefore = isLocalAfter;
			}
			
			penalty += count * count * 50;
		}

		return Math.min(maxFitness, penalty);
	}
	
	public double GetClassicPenalty(double maxFitness) {
		double penalty = 0;
		//Los clásicos deben jugarse entre la fecha 7 y 17.
		ArrayList<SoccerGame> tmp = new ArrayList<SoccerGame>(SoccerGame.classicSoccerGames);
		for (int i = MIN_CLASSIC_DAY - 1; i < MAX_CLASSIC_DAY; i++ ){
			for (SoccerGame game : this.dates.get(i).GetGames()){
				if (tmp.contains(game))
					tmp.remove(game);
			}
		}

		penalty += tmp.size() * tmp.size() * 50;
		return Math.min(maxFitness, penalty);
	}
	
	public double GetAptitude(List<Integer> fixtureCombination){
		this.GetDays(fixtureCombination);
		double aptitude = MAX_BOUND;
		//Nunca puede haber partidos repetidos x como armo los fixtures...
		aptitude -= tournamentDayHasMoreThanOneClassic() ? 5 : 0;
		aptitude -= this.GetLocalOrVisitantTwicePenalty(MAX_BOUND/3);
		aptitude -= this.GetBigFiveLocalOrVisitantTwicePenalty(MAX_BOUND/3);
		aptitude -= this.GetClassicPenalty(MAX_BOUND/3);
		return aptitude;
	}

}
