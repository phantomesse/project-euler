package project.euler.problems.problem01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.euler.Problem;

/**
 * Discover the largest product of five consecutive digits in the 1000-digit
 * number.
 *
 * @author Lauren Zou
 */
public class Problem08 extends Problem {
    
    private final String FILE = "src/project/euler/problems/problem01/problem08_number.txt";
    private final int CONSECUTIVE = 5;
    
    public Problem08() {
        super(8);
        
        // Get the number from file
        String number = "";
        try {
            Scanner fileReader = new Scanner(new File(FILE));
            StringBuilder numberBuilder = new StringBuilder();
            while (fileReader.hasNextLine())
                numberBuilder.append(fileReader.nextLine());
            number = numberBuilder.toString();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Problem08.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Iterate through number to find consecutive digits and their products
        int largestProduct = 0;
        for (int index = 0; index < number.length()-CONSECUTIVE; index++) {
            String digits = number.substring(index, index+CONSECUTIVE);
            
            // If the digits contain 0, do not calculate because product is 0
            if (!digits.contains("0")) {
                int product = 1;
                for (int digitIndex = 0; digitIndex < digits.length(); digitIndex++)
                    product *= Integer.parseInt(digits.substring(digitIndex, digitIndex+1));
                if (product > largestProduct)
                    largestProduct = product;
            }
        }
        
        setAnswer(largestProduct);
    }
}