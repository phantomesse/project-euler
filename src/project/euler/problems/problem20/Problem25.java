package project.euler.problems.problem20;

import java.math.BigInteger;
import project.euler.Problem;

/**
 * What is the first term in the Fibonacci sequence to contain 1000 digits?
 * 
 * @author Lauren Zou
 */
public class Problem25 extends Problem {
    public Problem25() {
        super(25);
        
        BigInteger prevFibonacci = BigInteger.ONE;
        BigInteger fibonacci = BigInteger.ONE;
        int index = 2;
        do {
            BigInteger temp = fibonacci;
            fibonacci = fibonacci.add(prevFibonacci);
            prevFibonacci = temp;
            index++;
        } while ((fibonacci + "").length() < 1000);
        setAnswer(index);
    }
}