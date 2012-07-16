package project.euler.problems.problem030;

import project.euler.Problem;
import project.euler.libraries.StringPlay;

/**
 * Find the sum of all numbers less than one million, which are palindromic in base 10 and base 2.
 * 
 * @author Lauren Zou
 */
public class Problem36 extends Problem {
    
    private final int LIMIT = 1000000;
    
    public Problem36() {
        super(36);
        
        int sum = 0;
        for (int base10 = 0; base10 < LIMIT; base10++) {
            if (StringPlay.isPalindrome(base10 + "")) {
                String base2 = Integer.toBinaryString(base10);
                if (StringPlay.isPalindrome(base2))
                    sum += base10;
            }
        }
        setAnswer(sum);
    }
}
