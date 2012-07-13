package project.euler.problems.problem40;

import project.euler.Problem;
import project.euler.libraries.NumberGetter;

/**
 * Find the smallest pair of pentagonal numbers whose sum and difference is pentagonal.
 * 
 * @author Lauren Zou
 */
public class Problem44 extends Problem {
    public Problem44() {
        super(44);
        
        int index1 = 1;
        long difference = 0;
        boolean foundIt = false;
        do {
            long pentNum1 = NumberGetter.getPentagonalNumber(index1);
            int index2 = index1;
            long pentNum2 = pentNum1;
            while (!(NumberGetter.isPentagonalNumber(pentNum1 - pentNum2) && NumberGetter.isPentagonalNumber(pentNum1 + pentNum2)) && index2 > 0) {
                index2--;
                pentNum2 = NumberGetter.getPentagonalNumber(index2);
            }
            if (index2 != 0) {
                difference = pentNum1 - pentNum2;
                foundIt = true;
            }
            else
                index1++;
        } while (!foundIt);
        setAnswer(difference);
    }
}
