package project.euler.problems.problem001;

import project.euler.Problem;

/**
 * Find the only Pythagorean triplet, {a, b, c}, for which a + b + c = 1000.
 * 
 * @author Lauren Zou
 */
public class Problem09 extends Problem {
    
    private final int SUM = 1000;
    
    public Problem09() {
        super(9);
        
        int product = 1;
        for (int b = 1; b < SUM; b++) {
            for (int a = 1; a < b; a++) {
                if (Math.pow(SUM-a-b, 2) == a*a + b*b) {
                    product = (int)(a*b*(Math.sqrt(a*a+b*b)));
                    break;
                }
            }
        }
        setAnswer(product);
    }
}
