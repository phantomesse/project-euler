package project.euler.libraries;

import java.util.ArrayList;

/**
 *
 * @author Lauren Zou
 */
public class Fraction {
    
    private int numerator;
    private int denominator;
    
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public Fraction getReducedFraction() {
        int[] numeratorFactors = NumberProperties.getPrimeFactorization(numerator);
        int[] denominatorFactors = NumberProperties.getPrimeFactorization(denominator);
        ArrayList<Integer> numeratorFactorsList = new ArrayList<Integer>();
        ArrayList<Integer> denominatorFactorsList = new ArrayList<Integer>();
        for (int factor : numeratorFactors)
            numeratorFactorsList.add(new Integer(factor));
        for (int factor : denominatorFactors)
            denominatorFactorsList.add(new Integer(factor));
        ArrayList<Integer> referenceList = new ArrayList<Integer>(numeratorFactorsList);
        for (Integer factor : referenceList) {
            if (denominatorFactorsList.contains(factor)) {
                denominatorFactorsList.remove(factor);
                numeratorFactorsList.remove(factor);
            }
        }
        
        int reducedNumerator = 1, reducedDenominator = 1;
        for (Integer factor : numeratorFactorsList)
            reducedNumerator *= factor.intValue();
        for (Integer factor : denominatorFactorsList)
            reducedDenominator *= factor.intValue();
        return new Fraction(reducedNumerator, reducedDenominator);
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    /**
     * Multiplies this fraction by another fraction. Does not modify this fractio.
     * 
     * @param fraction fraction to be multiplied by
     * @return reduced fraction that is the product of this fraction and another fraction
     */
    public Fraction multiply(Fraction fraction) {
        int newNumerator = numerator*fraction.getNumerator();
        int newDenominator = denominator*fraction.getDenominator();
        return (new Fraction(newNumerator, newDenominator)).getReducedFraction();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fraction) {
            Fraction fraction = (Fraction)obj;
            return fraction.getNumerator() == numerator && fraction.getDenominator() == denominator;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}