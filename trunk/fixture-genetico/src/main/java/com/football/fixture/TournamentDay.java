package main.java.com.football.fixture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TournamentDay 
{
	
	private List<SoccerGame> games = new ArrayList<SoccerGame>();
	
	public TournamentDay(List<SoccerGame> games)
	{
		this.games = games;
	}
	
	public List<SoccerGame> GetGames()
	{
		return games;
	}
	
	/*
	 * Devuelve true si el equipo juega de local en la fecha
	 */
	public boolean isLocal(Team team) {
		for (SoccerGame g : GetGames()) {
			if (g.getTeamLocal().equals(team))
				return true;
			if (g.getTeamVisitor().equals(team))
				return false;
		}
		return false;
	}
	
	/*
	 * Devuelve al cantidad de clasicos que tiene la fecha
	 */
	public int getClassicCount() {
		int cont = 0;
		for (SoccerGame g : GetGames()) {
			cont += g.isClassic() ? 1 : 0;
		}
		return cont;		
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
	
	public byte[] getRecord()
	{
		//20 equipos, 5 bits x equipo, total 100 bits = 12.5 bytes ==> 13 bytes x registro, ahora simplificado para probar...
		byte[] record = new byte[20];
		byte gameNumber=0;
		for(SoccerGame game : games)
		{
			record[gameNumber++] = game.getTeamLocal().getId();
			record[gameNumber++] = game.getTeamVisitor().getId();
		}
		return record;
	}
	
	public static TournamentDay getDay(byte[] record)
	{
		List<SoccerGame> aux = new ArrayList<SoccerGame>();
		for(int i = 0; i < record.length; i++)
		{
			SoccerGame game = new SoccerGame(new Team(record[i+1]), new Team(record[i]));
		}
		return new TournamentDay(aux);
	}
	
}
