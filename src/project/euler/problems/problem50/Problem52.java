/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.euler.problems.problem50;

import java.util.Arrays;
import project.euler.Problem;

/**
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits in some order.
 * 
 * @author LZOU
 */
public class Problem52 extends Problem {
    public Problem52() {
        super(52);
        
        int number = 1;
        while (true) {
            if (sameDigits(number, number*2) && sameDigits(number, number*3) && sameDigits(number, number*4) && sameDigits(number, number*5) && sameDigits(number, number*6))
                break;
            number++;
        }
        setAnswer(number);
    }
    
    private boolean sameDigits(int num1, int num2) {
        int[] digits1 = new int[(num1+"").length()];
        int[] digits2 = new int[(num2+"").length()];
        if (digits1.length != digits2.length)
            return false;
        for (int i = 0; i < digits1.length; i++) {
            digits1[i] = num1%10;
            num1 /= 10;
        }
        for (int i = 0; i < digits2.length; i++) {
            digits2[i] = num2%10;
            num2 /= 10;
        }
        Arrays.sort(digits1);
        Arrays.sort(digits2);
        for (int i = 0; i < digits1.length; i++)
            if (digits1[i] != digits2[i])
                return false;        
        return true;
    }
}
