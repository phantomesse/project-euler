package project.euler.problems.problem40;

import project.euler.Problem;
import project.euler.libraries.NumberGetter;

/**
 * After 40755, what is the next triangle number that is also pentagonal and hexagonal?
 * 
 * @author LZOU
 */
public class Problem45 extends Problem {
    public Problem45() {
        super(45);
        
        int index = 2;
        int numberFound = 0;
        while (numberFound < 2) {
            long number = NumberGetter.getHexagonalNumber(index);
            if (NumberGetter.isPentagonalNumber(number) && NumberGetter.isTriangleNumber(number)) {
                setAnswer(number);
                numberFound++;
            }
            index++;
        }
    }
}
