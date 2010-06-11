package main.java.com.football.fixture;

import java.util.Date;

public class SoccerGame {

	private Team teamVisitor;
	private Team teamLocal;
	private boolean classic;
	
	public SoccerGame(Team visitor, Team local, Date date){
		this.teamLocal = local;
		this.teamVisitor = visitor;
	}
	
	public SoccerGame(SoccerGame game, Boolean local){
		if(local)
		{
			this.teamLocal = new Team(game.teamLocal);
			this.teamVisitor = new Team(game.teamVisitor);
		}
		else
		{
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
	
	public boolean isClassic(){
		return this.classic;
	}
	
	public void setClassic(boolean classic){
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
		
		if ((teamLocal.equals(other.teamLocal) || teamLocal.equals(other.teamVisitor)
				&& (teamVisitor.equals(other.teamLocal) || teamVisitor.equals(other.teamVisitor))))
			return true;
		
		return false;
	}
	
	

}
