package project.euler.problems.problem20;

import project.euler.Problem;

/**
 * What is the sum of both diagonals in a 1001 by 1001 spiral?
 * 
 * @author LZOU
 */
public class Problem28 extends Problem {
    
    private final int DIM = 1001;
    
    public Problem28() {
        super(28);
        
        int sum = 1;
        int number = 1;
        int difference = 2;
        System.out.print(number);
        while (number < DIM*DIM) {
            for (int i = 0; i < 4; i++) {
                number += difference;
                sum += number;
                System.out.print(" " + number);
            }
            difference += 2;
        }
        
        setAnswer(sum);
    }
}
