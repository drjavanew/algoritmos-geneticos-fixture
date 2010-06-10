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

}
