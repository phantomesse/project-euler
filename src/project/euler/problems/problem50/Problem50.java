package project.euler.problems.problem50;

import java.util.ArrayList;
import project.euler.Problem;
import project.euler.libraries.PrimeNumbers;

/**
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 * 
 * @author Lauren Zou
 */
public class Problem50 extends Problem {
    
    private final int LIMIT = 1000000;
    
    public Problem50() {
        super(50);
        
        ArrayList<Long> primes = new ArrayList<Long>();
        long sum = 0;
        int index = 0;
        while (sum < LIMIT) {
            long primeNumber = PrimeNumbers.getNthPrime(index);
            sum += primeNumber;
            primes.add(primeNumber);
            index++;
        }
        long lastPrime = primes.remove(primes.size()-1).longValue();
        sum -= lastPrime;
        
        if (!PrimeNumbers.isPrime(sum)) {
            index = 0;
            while (index < primes.size() && !PrimeNumbers.isPrime(sum)) {
                sum -= primes.get(index);
                index++;
            }
        }
        
        setAnswer(sum);
    }
}
