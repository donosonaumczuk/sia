package ar.edu.itba.sia.crossovers;

import ar.edu.itba.sia.CharacterChromosome;
import ar.edu.itba.sia.RandomStatic;

import java.util.ArrayList;

public class AnnularCrossover extends UniformCrossover {
    public AnnularCrossover(double probability, double p) {
        super(probability, p);
    }

    @Override
    public ArrayList<CharacterChromosome> crossover(CharacterChromosome mom, CharacterChromosome dad) {
        ArrayList<Object> alleles1 = mom.getAlleles();
        ArrayList<Object> alleles2 = dad.getAlleles();
        if (probability > RandomStatic.nextDouble()) {
            int size = alleles1.size();
            int locus = RandomStatic.nextInt(size);
            int l = RandomStatic.nextInt(size / 2) + 1;
            int index;

            for (int i = 0; i < l; i++) {
                index = (locus + i) % size;
                exchangeAlleles(alleles1, alleles2, index);
            }
        }

        return createChildren(alleles1, alleles2, dad);
    }
}
