package ar.edu.itba.sia;

public class UniversalSelection<C extends Chromosome<C>> extends AccumulativeSelection<C> {

    @Override
    void setRandomRs() {
        double r = Math.random();
        double rSubJ;

        for (int j = 1; j <= k; j++) {
            rSubJ = (r + j - 1) / k;
            randoms[j] = rSubJ;
        }
    }
}