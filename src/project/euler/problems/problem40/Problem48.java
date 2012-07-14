package project.euler.problems.problem40;

import java.math.BigInteger;

import project.euler.Problem;

/**
 * Find the last ten digits of 1<sup>1</sup> + 2<sup>2</sup> + ... + 1000<sup>1000</sup>.
 * 
 * @author Lauren Zou
 *
 */
public class Problem48 extends Problem {
	
	private final long LIMIT = 1000;
	
	public Problem48() {
		super(46);
		
		BigInteger sum = BigInteger.ZERO;
		for (long number = 1; number <= LIMIT; number++) {
			BigInteger powered = BigInteger.valueOf(number);
			for (int i = 1; i < number; i++)
				powered = powered.multiply(BigInteger.valueOf(number));
			sum = sum.add(powered);
		}
		String sumStr = sum.toString();
		String lastTenDigits = sumStr.substring(sumStr.length() - 10);
		
		setAnswer(lastTenDigits);
	}
}