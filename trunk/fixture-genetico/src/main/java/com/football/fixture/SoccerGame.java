package main.java.com.football.fixture;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SoccerGame {

	private Team teamVisitor;
	private Team teamLocal;
	private boolean classic;
	private static List<SoccerGame> classicSoccerGames;

	static 
	{
		classicSoccerGames = new ArrayList<SoccerGame>();
		classicSoccerGames.add(new SoccerGame(new Team("INDEPENDIENTE"), new Team(
				"RACING")));
		classicSoccerGames.add(new SoccerGame(new Team("ESTUDIANTES_LP"), new Team(
				"GIMNASIA_ESGRIMA_LP")));
		classicSoccerGames.add(new SoccerGame(new Team("SAN_LORENZO"), new Team(
				"HURACAN")));
		classicSoccerGames.add(new SoccerGame(new Team("BOCA"), new Team(
				"RIVER_PLATE")));
		classicSoccerGames.add(new SoccerGame(new Team("BANFIELD"), new Team(
				"LANUS")));
	}

	public SoccerGame(Team visitor, Team local) {
		this.teamLocal = local;
		this.teamVisitor = visitor;
	}

	public SoccerGame(SoccerGame game, Boolean local) {
		if (local) {
			this.teamLocal = new Team(game.teamLocal);
			this.teamVisitor = new Team(game.teamVisitor);
		} else {
			this.teamLocal = new Team(game.teamVisitor);
			this.teamVisitor = new Team(game.teamLocal);
		}
	}

	public Team getTeamVisitor() {
		return teamVisitor;
	}

	public Team getTeamLocal() {
		return teamLocal;
	}

	public boolean isClassic() {
		for (SoccerGame game : classicSoccerGames) {
			if (this.equals(game))
				return true;
		}
		return false;		
	}

	public void setClassic(boolean classic) {
		this.classic = classic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((teamLocal == null) ? 0 : teamLocal.hashCode());
		result = prime * result
				+ ((teamVisitor == null) ? 0 : teamVisitor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final SoccerGame other = (SoccerGame) obj;
		if (teamLocal == null) {
			if (other.teamLocal != null)
				return false;
		}
		if (teamVisitor == null) {
			if (other.teamVisitor != null)
				return false;
		}

		if ((teamLocal.equals(other.teamLocal) || teamLocal
				.equals(other.teamVisitor))
				&& (teamVisitor.equals(other.teamLocal) || teamVisitor
						.equals(other.teamVisitor)))
			return true;

		return false;
	}

}
