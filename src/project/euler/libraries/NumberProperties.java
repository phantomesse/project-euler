package project.euler.libraries;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Gets/checks properties of a number.
 * 
 * @author Lauren Zou
 */
public class NumberProperties {
    
    /**
     * Gets the sum of the proper divisors of a number.
     * For example, the sum of the proper divisors of 28 is 1 + 2 + 4 + 7 + 14 = 28
     * 
     * @param number number to sum of proper divisors from
     * @return sum of proper divisors
     */
    public static int getSumOfProperDivisors(int number) {
        int sum = -number;
        int[] factors = NumberProperties.getFactors(number);
        for (int factor : factors)
            sum += factor;
        return sum;
    }
    
    /**
     * Gets the factors of a number.
     * 
     * @param number number to get factors from
     * @return factors
     */
    public static int[] getFactors(long number) {
        ArrayList<Integer> factorsList = new ArrayList<Integer>();
        for (int i = 1; i <= number; i++) {
            if (number%i == 0 && !factorsList.contains(i))
                factorsList.add(i);
        }
        
        int[] factors = new int[factorsList.size()];
        for (int i = 0; i < factors.length; i++)
            factors[i] = factorsList.get(i).intValue();
        return factors;
    }
    
    /**
     * Gets the number of factors of a number.
     * 
     */
    public static int getNumberOfFactors(long number) {
        int numberOfFactors = 0;
        for (int i = 1; i < Math.sqrt(number); i++) {
            if (number%i == 0) {
                if (i == Math.sqrt(number))
                    numberOfFactors += 1;
                else
                    numberOfFactors += 2;
            }
        }
        return numberOfFactors;
    }
    
    /**
     * Gets the factorial of a number.
     * For example, the factorial of 5 is 5*4*3*2*1.
     * 
     * @param number number to get factorial of
     * @return factorial of the number
     */
    public static long getFactorial(long number) {
        if (number <= 1)
            return 1;
        return number*getFactorial(number-1);
    }
    
    /**
     * Gets the factorial of a number.
     * For example, the factorial of 5 is 5*4*3*2*1.
     * 
     * @param number number to get factorial of
     * @return factorial of the number
     */
    public static BigInteger getFactorial(BigInteger number) {
        if (number.equals(BigInteger.ONE))
            return number;
        return number.multiply(getFactorial(number.subtract(BigInteger.ONE)));
    }
    
    /**
     * Gets the prime factorization of a number. The int array returned will include duplicates.
     * 
     * @param number number to prime factorize
     * @return prime factorization
     */
    public static int[] getPrimeFactorization(int number) {
        ArrayList<Integer> factorsList = new ArrayList<Integer>();
        for (int i = 2; i < Math.ceil(Math.sqrt(number))+1; i++) {
            while (number%i == 0) {
                factorsList.add(i);
                number /= i;
            }
        }
        if (number != 1)
            factorsList.add(number);
        
        int[] factors = new int[factorsList.size()];
        for (int i = 0; i < factors.length; i++)
            factors[i] = factorsList.get(i).intValue();
        return factors;
    }
    
    /**
     * Gets the prime factorization of a number. The int array returned will include duplicates.
     * 
     * @param number number to prime factorize
     * @return prime factorization
     */
    public static int[] getPrimeFactorization(BigInteger number) {
        ArrayList<Integer> factorsList = new ArrayList<Integer>();
        for (int i = 2; BigInteger.valueOf(i*i).compareTo(number) == -1; i++) {
            while (number.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
                factorsList.add(i);
                number = number.divide(BigInteger.valueOf(i));
            }
        }
        if (!number.equals(BigInteger.ONE))
            factorsList.add(new Integer(number.intValue()));
        
        int[] factors = new int[factorsList.size()];
        for (int i = 0; i < factors.length; i++)
            factors[i] = factorsList.get(i).intValue();
        return factors;
    }
    
    /**
     * Gets the prime factorization of a number without duplicates.
     * 
     * @param number number to prime factorize
     * @return prime factorization without duplicates
     */
    public static int[] getPrimeFactorizationNoDuplicate(int number) {
        ArrayList<Integer> factorsList = new ArrayList<Integer>();
        for (int i = 2; i < Math.ceil(Math.sqrt(number))+1; i++) {
            while (number%i == 0) {
                if (!factorsList.contains(i))
                    factorsList.add(i);
                number /= i;
            }
        }
        if (number != 1 && !factorsList.contains(number))
            factorsList.add(number);
        
        int[] factors = new int[factorsList.size()];
        for (int i = 0; i < factors.length; i++)
            factors[i] = factorsList.get(i).intValue();
        return factors;
    }
    
    /**
     * Gets the prime factorization of a number without duplicates.
     * 
     * @param number number to prime factorize
     * @return prime factorization without duplicates
     */
    public static int[] getPrimeFactorizationNoDuplicate(BigInteger number) {
        ArrayList<Integer> factorsList = new ArrayList<Integer>();
        for (int i = 2; BigInteger.valueOf(i*i).compareTo(number) == -1; i++) {
            while (number.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
                if (!factorsList.contains(i))
                    factorsList.add(i);
                number = number.divide(BigInteger.valueOf(i));
            }
        }
        if (!number.equals(BigInteger.ONE) && !factorsList.contains(new Integer(number.intValue())))
            factorsList.add(new Integer(number.intValue()));
            
        
        int[] factors = new int[factorsList.size()];
        for (int i = 0; i < factors.length; i++)
            factors[i] = factorsList.get(i).intValue();
        return factors;
    }
}
