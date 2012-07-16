package project.euler.problems.problem040;

import project.euler.Problem;
import project.euler.libraries.NumberProperties;

/**
 * Find the first four consecutive integers to have four distinct primes factors.
 * 
 * @author LZOU
 */
public class Problem47 extends Problem {
    private final int NUM_OF_FACTORS = 4;
    
    public Problem47() {
        super(47);
        
        int number = 2;
        int[] numbers = new int[NUM_OF_FACTORS];
        do {
            int[] factors = NumberProperties.getPrimeFactorizationNoDuplicate(number);
            int numberConsecutive = 1;
            while (factors.length == NUM_OF_FACTORS && numberConsecutive < NUM_OF_FACTORS) {
                number++;
                factors = NumberProperties.getPrimeFactorizationNoDuplicate(number);
                numberConsecutive++;
                if (factors.length == NUM_OF_FACTORS && numberConsecutive == NUM_OF_FACTORS) {
                    int numberCopy = number;
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numberCopy;
                        numberCopy--;
                    }
                }
            }
            number++;
        } while (numbers[0] == 0);
        
        setAnswer(numbers[numbers.length-1]);
    }
}
