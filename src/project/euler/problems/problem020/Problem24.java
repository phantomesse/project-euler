package project.euler.problems.problem20;

import project.euler.Problem;
import project.euler.libraries.NumberProperties;

/**
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4,
 * 5, 6, 7, 8 and 9?
 *
 * @author LZOU
 */
public class Problem24 extends Problem {

    private final int PERMUTATION_INDEX = 1000000;
    private final String FIRST_PERMUTATION = "0123456789";
    
    public Problem24() {
        super(24);
        
        // Build the millionth permutation one place at a time.
        String permutation = "";
        String digitsLeft = FIRST_PERMUTATION;
        int numberOfPermutations = 0;
        for (int place = 1; place < FIRST_PERMUTATION.length(); place++) {
            int digitsLeftIndex = 0;
            char digit = digitsLeft.charAt(digitsLeftIndex);
            while (numberOfPermutations + NumberProperties.getFactorial(FIRST_PERMUTATION.length() - place) * (digitsLeftIndex + 1) < PERMUTATION_INDEX) {
                digitsLeftIndex++;
                digit = digitsLeft.charAt(digitsLeftIndex);
            }
            numberOfPermutations += NumberProperties.getFactorial(FIRST_PERMUTATION.length() - place) * (digitsLeftIndex);
            System.out.println("Number of permutations: " + numberOfPermutations);
            System.out.println("DIGIT: " + digit);
            permutation += digit;
            
            // Remove digit from digits left
            String[] digitsLeftArr = digitsLeft.split(digit+"");
            digitsLeft = "";
            for (int i = 0; i < digitsLeftArr.length; i++)
                digitsLeft += digitsLeftArr[i];
            System.out.println("Digits Left: " + digitsLeft + "\n");
        }
        permutation += digitsLeft;
        
        setAnswer(permutation);
    }
}
