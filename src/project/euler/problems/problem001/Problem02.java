package project.euler.problems.problem001;

import project.euler.Problem;
import project.euler.libraries.NumberGetter;

/**
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 * 
 * @author Lauren Zou
 */
public class Problem02 extends Problem {
    
    private final int LIMIT = 4000000;
    
    public Problem02() {
        super(2);
        
        int sum = 0;
        int index = 3; // the 3rd term of the Fibonacci sequence is the first even term
        int fibTerm;
        do {
            fibTerm = (int) NumberGetter.getFibonacciTerm(index);
            if (fibTerm%2 == 0)
                sum += fibTerm;
            index++;
        } while (fibTerm < LIMIT);
        
        setAnswer(sum);
    }
}