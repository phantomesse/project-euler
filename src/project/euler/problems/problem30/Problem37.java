package project.euler.problems.problem30;

import project.euler.Problem;
import project.euler.libraries.NumberProperties;

/**
 * Find the sum of all eleven primes that are both truncatable from left to right and right to left.
 * 
 * @author Lauren Zou
 */
public class Problem37 extends Problem {
    
    private final int START_PRIME = 11;
    
    public Problem37() {
        super(37);
        
        long sum = 0;
        int truncatablePrimesFound = 0;
        int number = START_PRIME;
        while (truncatablePrimesFound < 11) {
            if (NumberProperties.isPrime(number)) {
                if (isTruncatablePrime(number)) {
                    truncatablePrimesFound++;
                    sum += number;
                    System.out.println(number);
                }
            }
            number += 2;
        }
        
        setAnswer(sum);
    }
    
    private boolean isTruncatablePrime(int prime) {
        int numberOfDigits = (prime + "").length();
        
        // Test truncating from right to left
        int number = prime;
        for (int i = 0; i < numberOfDigits-1; i++) {
            number /= 10;
            if (!NumberProperties.isPrime(number))
                return false;
        }
        
        // Test truncating from left to right
        String numberStr = prime + "";
        for (int i = 1; i < numberOfDigits; i++) {
            number = Integer.parseInt((numberStr).substring(i, numberOfDigits));
            if (!NumberProperties.isPrime(number))
                return false;
        }
        
        return true;
    }
    
}
