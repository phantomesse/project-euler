package project.euler.problems.problem010;

import project.euler.Problem;
import project.euler.libraries.NumberGetter;
import project.euler.libraries.NumberProperties;

/**
 * What is the value of the first triangle number to have over five hundred divisors?
 * 
 * @author Lauren Zou
 */
public class Problem12 extends Problem {
    
    private final int NUMBER_OF_DIVISORS = 500;
    
    public Problem12() {
        super(12);
        
        int index = 0;
        long number;
        int numberOfDivisors;
        do {
            number = NumberGetter.getTriangleNumber(index);
            numberOfDivisors = NumberProperties.getNumberOfFactors(number);
            index++;
        } while (numberOfDivisors < NUMBER_OF_DIVISORS);
        setAnswer(number);
    }
}
