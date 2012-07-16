package project.euler.problems.problem001;

import project.euler.Problem;

/**
 * Add all the natural numbers below one thousand that are multiples of 3 or 5.
 * 
 * @author Lauren Zou
 */
public class Problem01 extends Problem {
    
    private final int LIMIT = 1000;
    
    public Problem01() {
        super(1);
        
        int sum = 0;
        for (int num = 1; num < LIMIT; num++)
            if (num%3 == 0 || num%5 == 0)
                sum += num;
        setAnswer(sum);
    }
}
