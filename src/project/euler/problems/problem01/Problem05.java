package project.euler.problems.problem01;

import project.euler.Problem;

/**
 * What is the smallest number divisible by each of the numbers 1 to 20?
 * 
 * @author LZOU
 */
public class Problem05 extends Problem {
    
    private final int MAX_DIVISIBLE = 20;
    
    public Problem05() {
        super(5);
        
        int number = 0;
        boolean divisibleByAll = false;
        do {
            number += MAX_DIVISIBLE;
            int divisor = 2;
            while (number%divisor == 0 && divisor < MAX_DIVISIBLE) {
                divisor++;
                if (divisor == MAX_DIVISIBLE)
                    divisibleByAll = true;
            }
        } while (!divisibleByAll);
        setAnswer(number);
    }
}
