/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.euler.problems.problem30;

import project.euler.Problem;
import project.euler.libraries.Fraction;

/**
 * Discover all the fractions with an unorthodox cancelling method.
 * 
 * @author Lauren Zou
 */
public class Problem33 extends Problem {
    
    private final int LOW = 10;
    private final int HIGH = 99;
    
    public Problem33() {
        super(33);
        
        Fraction productFraction = new Fraction(1,1);
        for (int numerator = LOW; numerator <= HIGH; numerator++) {
            for (int denominator = numerator+1; denominator <= HIGH; denominator++) {
                Fraction fraction = new Fraction(numerator, denominator);
                Fraction cancelReducedFraction = getReducedUsingCancel(numerator, denominator);
                if (isCancelReducedCorrect(cancelReducedFraction, fraction.getReducedFraction(), fraction)) {
                    System.out.println(fraction + " = " + fraction.getReducedFraction());
                    productFraction = productFraction.multiply(fraction.getReducedFraction());
                }
            }
        }
        System.out.println("Product: " + productFraction);
        
        setAnswer(productFraction.getDenominator());
    }
    
    /**
     * Checks if the fraction reduced via the cancel reduced method is actually the valid reduced fraction.
     * 
     * @param cancelReducedFraction the fraction reduced via the cancel reduced method
     * @param reducedFraction the fraction that is properly reduced
     * @param originalFraction the original fraction
     * @return if cancel reduced is the valid reduced fraction
     */
    private boolean isCancelReducedCorrect(Fraction cancelReducedFraction, Fraction reducedFraction, Fraction originalFraction) {
        if (cancelReducedFraction.getNumerator() == 0 || cancelReducedFraction.getDenominator() == 0)
            return false;
        if (cancelReducedFraction.equals(originalFraction))
            return false;
        if (originalFraction.getNumerator()%10 == 0 && originalFraction.getDenominator()%10 == 0)
            return false; // this is trivial. We only want non-trivial reduced fractions.
        return cancelReducedFraction.getReducedFraction().equals(reducedFraction); 
    }
    
    /**
     * Reduces fractions in a way that an inexperienced mathematician would, by cancelling out the same digits in the numerator and denominator.
     * For example: 49/98 reduces to 4/8 by cancelling out the 9s.
     * This method is not always correct.
     * 
     * @param numerator
     * @param denominator
     * @return reduced fraction
     */
    private Fraction getReducedUsingCancel(int numerator, int denominator) {
        int[] numeratorArr = new int[] { numerator/10, numerator%10 };
        int[] denominatorArr = new int[] { denominator/10, denominator%10 };
        
        if (numeratorArr[0] == denominatorArr[0])
            return new Fraction(numeratorArr[1], denominatorArr[1]);
        if (numeratorArr[0] == denominatorArr[1])
            return new Fraction(numeratorArr[1], denominatorArr[0]);
        if (numeratorArr[1] == denominatorArr[0])
            return new Fraction(numeratorArr[0], denominatorArr[1]);
        if (numeratorArr[1] == denominatorArr[1])
            return new Fraction(numeratorArr[0], denominatorArr[0]);
        return new Fraction(numerator, denominator);
    }
}