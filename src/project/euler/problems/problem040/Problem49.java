package project.euler.problems.problem040;

import java.util.ArrayList;
import project.euler.Problem;
import project.euler.libraries.PrimeNumbers;
import project.euler.libraries.StringPlay;

/**
 * Find arithmetic sequences, made of prime terms, whose four digits are permutations of each other.
 * 
 * @author Lauren Zou
 */
public class Problem49 extends Problem {
    
    private final int LOWER_LIMIT = 1000;
    private final int UPPER_LIMIT = 9999;
    
    public Problem49() {
        super(49);
        
        // Find all the prime numbers between lower and upper limits
        int firstPrime = LOWER_LIMIT;
        while (!PrimeNumbers.isPrime(firstPrime)) {
            // First find the first prime number greater than the LOWER_LIMIT
            firstPrime++;
        }
        // Now get all the primes between firstPrime and UPPER_LIMIT
        ArrayList<Long> allPrimeNumbers = PrimeNumbers.getInstance().getPrimeNumbers();
        int index = allPrimeNumbers.indexOf((long)firstPrime);
        ArrayList<Integer> primeNumbersToCheck = new ArrayList<Integer>();
        long primeNumber;
        do {
            primeNumber = allPrimeNumbers.get(index);
            if (primeNumber < UPPER_LIMIT)
                primeNumbersToCheck.add((int)primeNumber);
            index++;
        } while (primeNumber < UPPER_LIMIT);
        
        int found = 0;
        String twelveDigitNumber = "";
        for (int i = 0; i < primeNumbersToCheck.size(); i++) {
            String number = primeNumbersToCheck.get(i).toString();
            
            ArrayList<Integer> permutations = new ArrayList<Integer>();
            for (int j = i+1; j < primeNumbersToCheck.size(); j++) {
                String compareToNumber = primeNumbersToCheck.get(j).toString();
                if (StringPlay.isPermutation(number, compareToNumber)) {
                    permutations.add(Integer.parseInt(compareToNumber));
                }
            }
            if (permutations.size() > 1) {
                permutations.add(0, Integer.parseInt(number));
                
                for (int j = 1; j < permutations.size(); j++) {
                    int difference = permutations.get(j) - permutations.get(0);
                    int thirdTerm = permutations.get(j) + difference;
                    if (permutations.contains(thirdTerm)) {
                        System.out.println(permutations.get(0) + " " + permutations.get(j) + " " + thirdTerm);
                        found++;
                        if (found == 2)
                            twelveDigitNumber = permutations.get(0) + "" + permutations.get(j) + "" + thirdTerm;
                    }
                }
            }
        }
        setAnswer(twelveDigitNumber);
    }
}