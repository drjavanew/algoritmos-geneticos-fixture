package main.java.com.football.generic.algorithm;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

import main.java.com.football.fixture.SoccerGame;

/*
 * Esta clase se encarga de cumplir el rol de la funcion de aptitud
 */

public class FixtureFitnessFunction extends FitnessFunction {

	public FixtureFitnessFunction(){
		
	}
	
	public double evaluate(IChromosome a_subject)
	{
		return 1;
	}
	
}
