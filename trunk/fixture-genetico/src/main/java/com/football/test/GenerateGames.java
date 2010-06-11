package main.java.com.football.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

public class GenerateGames 
{

	private static int MAX_ALLOWED_EVOLUTIONS = 500;
	
	private static List<Team> teams;
	
	private static Tournament tournament;
	
	private static void Init()
	{
		teams = new ArrayList<Team>();
		teams.add(new Team("ARGENTINOS_JRS", false));
		teams.add(new Team("ESTUDIANTES_LP", false));
		teams.add(new Team("GODOY_CRUZ", false));
		teams.add(new Team("INDEPENDIENTE", true));
		teams.add(new Team("BANFIELD", false));
		teams.add(new Team("NO_BOYS", false));
		teams.add(new Team("LANUS", false));
		teams.add(new Team("RACING", false));
		/*teams.add(new Team("VELEZ", false));
		teams.add(new Team("HURACAN", false));
		teams.add(new Team("TIGRE", false));
		teams.add(new Team("GIMNASIA_ESGRIMA_LP", false));
		teams.add(new Team("RIVER_PLATE", true));
		teams.add(new Team("COLON", false));
		teams.add(new Team("SAN_LORENZO", true));
		teams.add(new Team("BOCA", true));
		teams.add(new Team("ALL_BOYS", false));
		teams.add(new Team("QUILMES", false));
		teams.add(new Team("OLIMPO", false));
		teams.add(new Team("ARSENAL", false));*/
		tournament = Tournament.GetInstance(teams);
	}
	/*Este main es para probar pasarle valores a los genes y ver como arma el fixture*/
//	public static void main(String[] args)
//	{
//		Init();
//		List<Integer> gamesGenes = new ArrayList<Integer>();
//		List<Boolean> localGenes = new ArrayList<Boolean>();
//		Date now = new Date();
//		Random rnd = new Random(now.getTime());
//		for(int i=0;i<teams.size()-1;i++)
//		{
//			//Partido 1: debo pasar un valor entre 0 y 190
//			localGenes.add(rnd.nextInt(1)==0);
//			gamesGenes.add(rnd.nextInt(6));
//			//Partido 2: debo pasar un valor entre 0 y 152
//			localGenes.add(rnd.nextInt(1)==0);
//			gamesGenes.add(0);
//			/*//Partido 3: debo pasar un valor entre 0 y 119
//			localGenes.add(rnd.nextInt(1)==0);
//			gamesGenes.add(rnd.nextInt(120));
//			//Partido 4: debo pasar un valor entre 0 y 90
//			localGenes.add(rnd.nextInt(1)==0);
//			gamesGenes.add(rnd.nextInt(91));
//			//Partido 5: debo pasar un valor entre 0 y 65
//			localGenes.add(rnd.nextInt(1)==0);
//			gamesGenes.add(rnd.nextInt(66));
//			//Partido 6: debo pasar un valor entre 0 y 44
//			localGenes.add(rnd.nextInt(1)==0);
//			gamesGenes.add(rnd.nextInt(45));
//			//Partido 7: debo pasar un valor entre 0 y 27
//			localGenes.add(rnd.nextInt(1)==0);
//			gamesGenes.add(rnd.nextInt(28));
//			//Partido 8: debo pasar un valor entre 0 y 14
//			localGenes.add(rnd.nextInt(1)==0);
//			gamesGenes.add(rnd.nextInt(15));
//			//Partido 9: debo pasar un valor entre 0 y 5
//			localGenes.add(rnd.nextInt(1)==0);
//			gamesGenes.add(rnd.nextInt(6));
//			//Partido 10: solo queda un partido posible
//			localGenes.add(rnd.nextInt(1)==0);
//			gamesGenes.add(0);*/
//		}
//		Fixture fixture = tournament.GetFixture(gamesGenes, localGenes);
//		List<TournamentDay> days = fixture.GetDays();
//		Iterator<TournamentDay> it = days.iterator();
//		int i = 0;
//		while(it.hasNext())
//		{
//			i++;
//			System.out.println("Fecha " + i + ":");
//			for(SoccerGame game : it.next().GetGames())
//			{
//				Team local = game.getTeamLocal();
//				Team visitor = game.getTeamVisitor();
//				System.out.println(local.getName() + " vs " + visitor.getName());
//			}
//		}
//	}
	
	
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
			//Cantidad de genes: 10 partidos x fechas => 190 genes
			Gene[] sampleGenes = new Gene[56];
			for (int i=0;i<teams.size()-1;i++)
			{
				//Partido 1: debo pasar un valor entre 0 y 189
				sampleGenes[i*teams.size()] = new IntegerGene(conf, 0, 1);
				sampleGenes[(i*teams.size())+1] = new IntegerGene(conf, 0, 27);
				//Partido 2: debo pasar un valor entre 0 y 152
				sampleGenes[(i*teams.size())+2] = new IntegerGene(conf, 0, 1);
				sampleGenes[(i*teams.size())+3] = new IntegerGene(conf, 0, 14);
				//Partido 3: debo pasar un valor entre 0 y 119
				sampleGenes[(i*teams.size())+4] = new IntegerGene(conf, 0, 1);
				sampleGenes[(i*teams.size())+5] = new IntegerGene(conf, 0, 5);
				//Partido 4: debo pasar un valor entre 0 y 90
				sampleGenes[(i*teams.size())+6] = new IntegerGene(conf, 0, 1);
				sampleGenes[(i*teams.size())+7] = new IntegerGene(conf, 0, 0);
				//Partido 5: debo pasar un valor entre 0 y 65
				/*sampleGenes[(i*teams.size())+8] = new IntegerGene(conf, 0, 1);
				sampleGenes[(i*teams.size())+9] = new IntegerGene(conf, 0, 0);
				//Partido 6: debo pasar un valor entre 0 y 44
				sampleGenes[i*20+10] = new IntegerGene(conf, 0, 1);
				sampleGenes[i*20+11] = new IntegerGene(conf, 0, 44);
				//Partido 7: debo pasar un valor entre 0 y 27
				sampleGenes[i*20+12] = new IntegerGene(conf, 0, 1);
				sampleGenes[i*20+13] = new IntegerGene(conf, 0, 27);
				//Partido 8: debo pasar un valor entre 0 y 14
				sampleGenes[i*20+14] = new IntegerGene(conf, 0, 1);
				sampleGenes[i*20+15] = new IntegerGene(conf, 0, 14);
				//Partido 9: debo pasar un valor entre 0 y 5
				sampleGenes[i*20+16] = new IntegerGene(conf, 0, 1);
				sampleGenes[i*20+17] = new IntegerGene(conf, 0, 5);
				//Partido 10: solo queda un partido posible
				sampleGenes[i*20+18] = new IntegerGene(conf, 0, 1);
				sampleGenes[i*20+19] = new IntegerGene(conf, 0, 0);*/
			}
			Chromosome sampleChromosome = new Chromosome(conf, sampleGenes );
			conf.setSampleChromosome( sampleChromosome );
			conf.setPopulationSize( 500 );
			Genotype population = Genotype.randomInitialGenotype( conf );
			for( int i = 0; i < MAX_ALLOWED_EVOLUTIONS; i++ )
			{
			    population.evolve();
			}
			IChromosome bestSolutionSoFar = population.getFittestChromosome();
			List<Integer> teamGenes = new ArrayList<Integer>();
			List<Boolean> localGenes = new ArrayList<Boolean>();
			Gene[] genes = bestSolutionSoFar.getGenes();
			for(int i=0; i<genes.length; i++)
			{
				localGenes.add((Integer)genes[i].getAllele()==0);
				teamGenes.add((Integer)genes[++i].getAllele());
			}
			Fixture fixture = tournament.GetFixture(teamGenes, localGenes);
			List<TournamentDay> days = fixture.GetDays();
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
			System.out.println(ex.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
