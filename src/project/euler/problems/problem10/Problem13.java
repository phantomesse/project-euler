package project.euler.problems.problem10;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.euler.Problem;

/**
 * Find the first ten digits of the sum of one-hundred 50-digit numbers.
 * 
 * @author Lauren Zou
 */
public class Problem13 extends Problem {
    
    private final String FILE = "src/project/euler/problems/problem10/problem13_numbers.txt";
    
    public Problem13() {
        super(13);
        
        BigInteger sum = BigInteger.ZERO;
        try {
            Scanner fileReader = new Scanner(new File(FILE));
            while (fileReader.hasNextLine()) {
                BigInteger number = new BigInteger(fileReader.nextLine());
                sum = sum.add(number);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Problem13.class.getName()).log(Level.SEVERE, null, ex);
        }
        String firstTenDigits = sum.toString().substring(0, 10);
        setAnswer(firstTenDigits);
    }
}
