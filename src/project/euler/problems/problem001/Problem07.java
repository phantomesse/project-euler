package project.euler.problems.problem001;

import project.euler.Problem;
import project.euler.libraries.PrimeNumbers;

/**
 * Find the 10001st prime.
 * 
 * @author Lauren Zou
 */
public class Problem07 extends Problem {
    
    private final int PRIME_INDEX = 10001;
    
    public Problem07() {
        super(7);
        
        int number = 1;
        int index = 0;
        while (index < PRIME_INDEX) {
            number++;
            if (PrimeNumbers.isPrime(number))
                index++;
        }
        setAnswer(number);
    }
}