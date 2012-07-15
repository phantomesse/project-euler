package project.euler.problems.problem20;

import java.util.ArrayList;
import project.euler.Problem;
import project.euler.libraries.NumberProperties;

/**
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 * 
 * @author Lauren Zou
 */; 
public class Problem23 extends Problem {
    
    private final int SMALLEST_ABUNDANT = 12;
    private final int LIMIT = 28123;
    
    public Problem23() {
        super(23);
        
        // Array of all numbers between 0 and LIMIT. 1 if is sum of abundant number. 0 if not.
        int[] numbers = new int[LIMIT+1];
        
        ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();
        for (int number = SMALLEST_ABUNDANT; number < LIMIT; number++) {
            if (NumberProperties.getSumOfProperDivisors(number) > number) {
                // Number is an abundant number
                abundantNumbers.add(number);
                
                // Now add this with all the other abundant numbers.
                for (Integer abundantNumber : abundantNumbers) {
                    int sum = number + abundantNumber;
                    if (sum <= LIMIT)
                        numbers[sum] = 1;
                }
            }
        }
        
        int sumOfSums = 0;
        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] == 0)
                sumOfSums += i;
        setAnswer(sumOfSums);
    }
}
