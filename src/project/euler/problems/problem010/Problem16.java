package project.euler.problems.problem010;

import java.math.BigInteger;
import project.euler.Problem;

/**
 * What is the sum of the digits of the number 2<sup>1000</sup>?
 * 
 * @author Lauren Zou
 */
public class Problem16 extends Problem {
    
    private final int POWER = 1000;
    
    public Problem16() {
        super(16);
        
        BigInteger number = (BigInteger.valueOf(2)).pow(POWER);
        String numberStr = number.toString();
        int sum = 0;
        for (int i = 0; i < numberStr.length(); i++)
            sum += Integer.parseInt(numberStr.substring(i, i+1));
        setAnswer(sum);
    }
}
