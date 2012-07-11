package project.euler.problems.problem10;

import project.euler.Problem;
import project.euler.libraries.NumberProperties;

/**
 * Calculate the sum of all the primes below two million.
 * 
 * @author Lauren Zou
 */
public class Problem10 extends Problem {
    
    private final int LIMIT = 2000000;
    
    public Problem10() {
        super(10);
        
        // Create an array with LIMIT number of booleans. If the index is prime, then add to sum.
        long sum = 0;
        boolean[] primes = new boolean[LIMIT];
        for (int i = 2; i < primes.length; i++) {
            if (NumberProperties.isPrime(i))
                sum += i;
        }
        setAnswer(sum);
    }
}
