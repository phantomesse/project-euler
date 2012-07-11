package project.euler.problems.problem01;

import java.math.BigInteger;
import java.util.Arrays;
import project.euler.Problem;
import project.euler.libraries.NumberProperties;

/**
 * Find the largest prime factor of a composite number.
 * 
 * @author Lauren Zou
 */
public class Problem03 extends Problem {
    
    private final BigInteger NUMBER = new BigInteger("600851475143");
    
    public Problem03() {
        super(3);
        
        int[] factors = NumberProperties.getPrimeFactorizationNoDuplicate(NUMBER);
        Arrays.sort(factors);
        setAnswer(factors[factors.length-1]);
    }
}