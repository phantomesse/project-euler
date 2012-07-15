package project.euler.problems.problem30;

import java.util.ArrayList;
import project.euler.Problem;
import project.euler.libraries.NumberProperties;
import project.euler.libraries.PrimeNumbers;

/**
 * How many circular primes are there below one million?
 * 
 * @author LZOU
 */
public class Problem35 extends Problem {
    private final int LOW = 2;
    private final int HIGH = 1000000;
    
    public Problem35() {
        super(35);
        
        int numberOfCircularPrimes = 0;
        for (int number = LOW; number < HIGH; number++) {
            if (isCircularPrime(number)) {
                System.out.println(number + " is a circular prime.");
                numberOfCircularPrimes++;
            }
        }
        setAnswer(numberOfCircularPrimes);
    }
    
    private boolean isCircularPrime(int number) {
        if (!PrimeNumbers.isPrime(number))
            return false;
        ArrayList<Integer> numberArr = new ArrayList<Integer>();
        int numberCopy = number;
        while (numberCopy != 0) {
            numberArr.add(0, numberCopy%10);
            numberCopy /= 10;
        }
        int newNumber = createNumberFromArrayList(numberArr);
        if (!PrimeNumbers.isPrime(newNumber))
            return false;
        
        for (int i = 0; i < (number+"").length(); i++) {
            numberArr = rotate(numberArr);
            newNumber = createNumberFromArrayList(numberArr);
            if (!PrimeNumbers.isPrime(newNumber))
                return false;
        }
        
        return true;
    }
    
    private ArrayList<Integer> rotate(ArrayList<Integer> numberArr) {
        int lastDigit = numberArr.get(numberArr.size()-1);
        numberArr.remove(numberArr.size()-1);
        numberArr.add(0, lastDigit);
        return numberArr;
    }
    
    private int createNumberFromArrayList(ArrayList<Integer> numberArr) {
        StringBuilder numberStr = new StringBuilder();
        for (Integer digit : numberArr)
            numberStr.append(digit.toString());
        return Integer.parseInt(numberStr.toString());
    }
}
