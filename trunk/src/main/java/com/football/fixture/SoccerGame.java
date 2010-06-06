package main.java.com.football.fixture;

import java.util.Date;

public class SoccerGame {

	private Team teamVisitor;
	private Team teamLocal;
	private Date date;
	private boolean classic;
	
	public SoccerGame(Team visitor, Team local, Date date){
		this.date = date;
		this.teamLocal = local;
		this.teamVisitor = visitor;
	}
	
	public Team getTeamVisitor() {
		return teamVisitor;
	}

	public Team getTeamLocal() {
		return teamLocal;
	}

	public Date getDate() {
		return date;
	}
	
	public boolean isClassic(){
		return this.classic;
	}
	
	public void setClassic(boolean classic){
		this.classic = classic;
	}

}
