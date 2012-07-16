package project.euler.problems.problem001;

import project.euler.Problem;
import project.euler.libraries.StringPlay;

/**
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * @author Lauren Zou
 */
public class Problem04 extends Problem {
    
    private final int DIGITS = 3;
    
    public Problem04() {
        super(4);
        
        int low = (int)Math.pow(10, DIGITS-1);
        int high = (int)Math.pow(10, DIGITS)-1;
        int largestPalindrome = 0;
        for (int number1 = high; number1 >= low; number1--) {
            for (int number2 = high; number2 >= low; number2--) {
                int product = number1*number2;
                if (StringPlay.isPalindrome(product + "") && product > largestPalindrome)
                    largestPalindrome = product;
            }
        }
        setAnswer(largestPalindrome);
    }
}