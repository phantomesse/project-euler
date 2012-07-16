package project.euler.problems.problem030;

import project.euler.Problem;
import project.euler.libraries.NumberProperties;
import project.euler.libraries.StringPlay;

/**
 * Find the sum of all numbers that can be written as pandigital products.
 * 
 * @author Lauren Zou
 */
public class Problem32 extends Problem {
    public Problem32() {
        super(32);
        
        int number = 100;
        int sum = 0;
        while ((number + "").length() < 5) {
            int[] factors = NumberProperties.getFactors(number);
            for (int i = 1; i < factors.length/2+1; i++) {
                int multiplicand = factors[i];
                int multiplier = number/multiplicand;
                String equationNumber = multiplicand + "" + multiplier + "" + number;
                if (equationNumber.length() == 9 && StringPlay.isPandigital(equationNumber)) {
                    System.out.println(multiplicand + " x " + multiplier + " = " + number);
                    sum += number;
                    break;
                }
            }
            number++;
        }
        setAnswer(sum);
    }
}
