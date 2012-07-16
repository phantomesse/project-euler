package project.euler.problems.problem20;

import java.math.BigInteger;
import project.euler.Problem;
import project.euler.libraries.NumberProperties;

/**
 * Find the sum of digits in 100!
 * 
 * @author Lauren Zou
 */
public class Problem20 extends Problem {
    
    private final int NUMBER = 100;
    
    public Problem20() {
        super(20);
        
        BigInteger factorial = NumberProperties.getFactorial(BigInteger.valueOf(NUMBER));
        String factorialString = factorial.toString();
        int sum = 0;
        for (int i = 0; i < factorialString.length(); i++) {
            sum += Integer.parseInt(factorialString.substring(i, i+1));
        }
        setAnswer(sum);
    }
}
