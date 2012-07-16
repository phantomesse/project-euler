package project.euler.problems.problem030;

import project.euler.Problem;

/**
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 * 
 * @author Lauren Zou
 */
public class Problem30 extends Problem {
    
    private final int START_NUMBER = 2;
    private final int LIMIT = 999999;
    private final int POWER = 5;
    
    public Problem30() {
        super(30);
        
        int sum = 0;
        for (int number = START_NUMBER; number < LIMIT; number++) {
            if (number == getSumOfPower(number)) {
                System.out.println(number);
                sum += number;
            }
        }
        setAnswer(sum);
    }
    
    private int getSumOfPower(int number) {
        int numberOfDigits = (number + "").length();
        int sum = 0;
        for (int i = 0; i < numberOfDigits; i++) {
            int digit = number%10;
            number /= 10;
            sum += Math.pow(digit, POWER);
        }
        
        return sum;
    }
}
