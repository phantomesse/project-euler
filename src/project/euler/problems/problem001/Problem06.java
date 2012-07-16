package project.euler.problems.problem001;

import project.euler.Problem;

/**
 * What is the difference between the sum of the squares and the square of the sums?
 * 
 * @author Lauren Zou
 */
public class Problem06 extends Problem {
    
    private final int NUMBER_OF_NATURALS = 100;
    
    public Problem06() {
        super(6);
        
        // Get sum of squares
        int sumOfSquares = 0;
        for (int i = 1; i <= NUMBER_OF_NATURALS; i++) {
            sumOfSquares += i*i;
        }
        
        // Get square of sums
        int squareOfSums = 0;
        for (int i = 1; i <= NUMBER_OF_NATURALS; i++) {
            squareOfSums += i;
        }
        squareOfSums *= squareOfSums;
        
        setAnswer(squareOfSums - sumOfSquares);
    }
}
