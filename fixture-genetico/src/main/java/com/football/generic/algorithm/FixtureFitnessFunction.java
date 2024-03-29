package main.java.com.football.generic.algorithm;

import java.util.ArrayList;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.IChromosome;

import main.java.com.football.fixture.Fixture;
import main.java.com.football.fixture.SoccerGame;
import main.java.com.football.fixture.Team;
import main.java.com.football.fixture.Tournament;
import main.java.com.football.fixture.TournamentDay;
import main.java.com.football.test.GenerateGames;

/*
 * Esta clase se encarga de cumplir el rol de la funcion de aptitud
 */

public class FixtureFitnessFunction extends FitnessFunction {

	public FixtureFitnessFunction(){
		
	}
	
	public double evaluate(IChromosome a_subject)
	{
		List<Integer> fixtureCombination = new ArrayList<Integer>();
		Gene[] genes = a_subject.getGenes();
		for(int i=0; i<genes.length; i++)
			fixtureCombination.add((Integer)genes[i].getAllele());
		Fixture fixture = Tournament.GetInstance().GetFixture();
		double apt = fixture.GetAptitude(fixtureCombination);
		return apt;
	}
	
}
