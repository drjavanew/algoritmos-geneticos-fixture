package main.java.com.football.fixture;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.*;

public class Fixture 
{
	private List<Team> switchedTeams;
	private List<Team> teams;
	private List<TournamentDay> dates;
	
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

	public int GetAptitude(List<Integer> fixtureCombination)
	{
		this.GetDays(fixtureCombination);
		int aptitude = 0;
		//Nunca puede haber partidos repetidos x como armo los fixtures...
		aptitude += tournamentDayHasMoreThanOneClassic() ? 0 : 5;
		return aptitude;
	}

}
