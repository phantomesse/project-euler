package project.euler.problems.problem40;

import project.euler.Problem;

/**
 * Finding the nth digit of the fractional part of the irrational number.
 * 
 * @author LZOU
 */
public class Problem40 extends Problem {
    private StringBuffer irrationalStr;
    private int appendingNumber = 1;
    
    public Problem40() {
        super(40);
        
        int product = getDigit(1)*getDigit(10)*getDigit(100)*getDigit(1000)*getDigit(10000)*getDigit(100000)*getDigit(1000000);
        setAnswer(product);
    }
    
    private int getDigit(int index) {
        if (irrationalStr == null)
            irrationalStr = new StringBuffer();
        while (irrationalStr.length() < index) {
            irrationalStr.append(appendingNumber);
            appendingNumber++;
        }
        return Integer.parseInt(irrationalStr.substring(index-1, index));
    }
}
