package project.euler.problems.problem30;

import project.euler.Problem;
import project.euler.libraries.NumberProperties;

/**
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 * 
 * @author Lauren Zou
 */
public class Problem34 extends Problem {
    
    private final int STARTING_NUMBER = 3;
    private final int UPPER_BOUND = 9999999;
    
    public Problem34() {
        super(34);
        
        int sum = 0;
        for (int number = STARTING_NUMBER; number < UPPER_BOUND; number++) {
            int numberCopy = number;
            int numberOfDigits = (number + "").length();
            int sumOfFactorialDigits = 0;
            for (int i = 0; i < numberOfDigits; i++) {
                int digit = numberCopy%10;
                numberCopy /= 10;
                sumOfFactorialDigits += NumberProperties.getFactorial(digit);
            }
            
            if (number == sumOfFactorialDigits) {
                System.out.print(number + "\t");
                System.out.println(sumOfFactorialDigits);
                sum += number;
            }
        }
        setAnswer(sum);
    }
}
