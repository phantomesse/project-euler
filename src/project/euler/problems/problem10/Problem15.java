package project.euler.problems.problem10;

import java.math.BigInteger;
import project.euler.Problem;

/**
 * Starting in the top left corner in a 20 by 20 grid, how many routes are there to the bottom right corner?
 * 
 * @author Lauren Zou
 */
public class Problem15 extends Problem {

    private final int DIMENSIONS = 20;
    
    public Problem15() {
        super(15);

        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.ONE;
        for (int i = 1; i <= DIMENSIONS*2; i++)
            numerator = numerator.multiply(BigInteger.valueOf(i));
        System.out.println("Numerator: " + numerator);
        
        for (int i = 1; i <= DIMENSIONS; i++)
            denominator = denominator.multiply(BigInteger.valueOf(i));
            
        System.out.println("Denominator: " + denominator.multiply(denominator));
        BigInteger paths = numerator.divide(denominator.multiply(denominator));
        setAnswer(paths.toString());
    }
}
