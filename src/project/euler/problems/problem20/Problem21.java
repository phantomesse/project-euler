package project.euler.problems.problem20;

import project.euler.Problem;
import project.euler.libraries.NumberProperties;

/**
 * Evaluate the sum of all amicable pairs under 10000.
 * 
 * @author Lauren Zou
 */
public class Problem21 extends Problem {
    
    private final int LIMIT = 10000;
    
    public Problem21() {
        super(21);
        
        int sum = 0;
        for (int number = 1; number <= LIMIT; number++) {
            int amicable = NumberProperties.getSumOfProperDivisors(number);
            if (amicable != number && NumberProperties.getSumOfProperDivisors(amicable) == number) {
                System.out.println(number + " " + amicable);
                sum += number;
            }
        }
        setAnswer(sum);
    }
}
