package main.java.com.football.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import main.java.com.football.fixture.Fixture;
import main.java.com.football.fixture.SoccerGame;
import main.java.com.football.fixture.Team;
import main.java.com.football.fixture.Tournament;
import main.java.com.football.fixture.TournamentDay;
import main.java.com.football.generic.algorithm.FixtureFitnessFunction;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.CrossoverOperator;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;
import org.jgap.impl.MutationOperator;

public class GenerateGames 
{

	private static int MAX_ALLOWED_EVOLUTIONS = 10;
	
	private static List<Team> teams;
	
	private static Tournament tournament;
	
	private static void Init()
	{
		teams = new ArrayList<Team>();
		teams.add(new Team("ARGENTINOS_JRS"));
		teams.add(new Team("ESTUDIANTES_LP"));
		teams.add(new Team("GODOY_CRUZ"));
		teams.add(new Team("INDEPENDIENTE"));
		teams.add(new Team("BANFIELD"));
		teams.add(new Team("NO_BOYS"));
		teams.add(new Team("LANUS"));
		teams.add(new Team("RACING"));
		teams.add(new Team("VELEZ"));
		teams.add(new Team("HURACAN"));
		teams.add(new Team("TIGRE"));
		teams.add(new Team("GIMNASIA_ESGRIMA_LP"));
		teams.add(new Team("RIVER_PLATE"));
		teams.add(new Team("COLON"));
		teams.add(new Team("SAN_LORENZO"));
		teams.add(new Team("BOCA"));
		teams.add(new Team("ALL_BOYS"));
		teams.add(new Team("QUILMES"));
		teams.add(new Team("OLIMPO"));
		teams.add(new Team("ARSENAL"));
		tournament = Tournament.GetInstance(teams);
	}

	public static void main(String[] args)
	{
		try
		{
			//Inicializo equipos y torneo
			Init();
			//Configuración por defecto del JGAP (cruzas, mutaciones, selección, etc)
			Configuration conf = new DefaultConfiguration();
			//Clase donde definimos la fcn de aptitud
			FitnessFunction myFunc = new FixtureFitnessFunction();
			conf.setFitnessFunction(myFunc);
			//Cantidad de genes: 20 genes que toman valores de 0 a 19-i para definir el fixture (son los 20! q dice Dubuc)
			Gene[] sampleGenes = new Gene[20];
			for (int i = 0; i < 20; i++)
				sampleGenes[i] = new IntegerGene(conf, 0, 19-i);
			Chromosome sampleChromosome = new Chromosome(conf, sampleGenes);
			conf.setSampleChromosome( sampleChromosome );
			conf.setPreservFittestIndividual(true);
			CrossoverOperator crossoverOperator = new CrossoverOperator(conf,10,true);
			MutationOperator mutationOperator = new MutationOperator(conf,50);//1/50 gene mutation rate
			conf.addGeneticOperator(crossoverOperator);
			conf.addGeneticOperator(mutationOperator);
			conf.setAlwaysCaculateFitness(true);
			conf.setMinimumPopSizePercent(90);
			conf.setPopulationSize(100);
			Genotype population = Genotype.randomInitialGenotype( conf );
			for( int i = 0; i < MAX_ALLOWED_EVOLUTIONS; i++ )
			{
			    population.evolve();
			}
			IChromosome bestSolutionSoFar = population.getFittestChromosome();
			List<Integer> fixtureCombination = new ArrayList<Integer>();
			Gene[] genes = bestSolutionSoFar.getGenes();
			for(int i = 0; i < genes.length; i++)
				fixtureCombination.add((Integer)genes[i].getAllele());
			Fixture fixture = tournament.GetFixture();
			List<TournamentDay> days = fixture.GetDays(fixtureCombination);
			Iterator<TournamentDay> it = days.iterator();
			int i = 0;
			while(it.hasNext())
			{
				i++;
				System.out.println("Fecha " + i + ":");
				for(SoccerGame game : it.next().GetGames())
				{
					Team local = game.getTeamLocal();
					Team visitor = game.getTeamVisitor();
					System.out.println(local.getName() + " vs " + visitor.getName());
				}
			}
			
			System.out.println("tournamentDayHasMoreThanOneClassic - " + fixture.tournamentDayHasMoreThanOneClassic());
			System.out.println("hasRepeatedGames - " + fixture.hasRepeatedGames());
		}
		catch(InvalidConfigurationException ex)
		{
			System.out.println("InvalidConfigurationException: " + ex.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println("Exception: " + ex.getMessage());
		}
	}
}
