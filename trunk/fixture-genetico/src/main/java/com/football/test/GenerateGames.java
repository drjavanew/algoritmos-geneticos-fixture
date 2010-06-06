package main.java.com.football.test;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

import main.java.com.football.generic.algorithm.*;

public class GenerateGames {
	private static int MAX_ALLOWED_EVOLUTIONS = 100;
	private enum teams {
		ARGENTINOS_JRS, 
		ESTUDIANTES_LP,
		GODOY_CRUZ, 
		INDEPENDIENTE,
		BANFIELD,
		NO_BOYS,
		LANUS, 
		RACING,
		VELEZ,
		HURACAN,
		TIGRE,
		GIMNASIA_ESGRIMA_LP,
		RIVER_PLATE,
		COLON,
		SAN_LORENZO,
		BOCA,
		ALL_BOYS,
		QUILMES,
		OLIMPO,
		ARSENAL
	};
	public static void main(String[] args) {
		try
		{
			//Configuración por defecto del JGAP (cruzas, mutaciones, selección, etc)
			Configuration conf = new DefaultConfiguration();
			//Clase donde definimos la fcn de aptitud
			FitnessFunction myFunc = new FixtureFitnessFunction();
			conf.setFitnessFunction(myFunc);
			//Cantidad de genes: 19 fechas => uno por fecha???
			Gene[] sampleGenes = new Gene[19];
			for (int i=0;i<19;i++)
			{
				//aca todavia no se como armar los genes/cromosomas...
				sampleGenes[i] = new IntegerGene(conf, 0, 18);
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
			System.out.println("HOLA");
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
