package project.euler.libraries;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lauren Zou
 */
public class PrimeNumbers implements Serializable {
    private static PrimeNumbers instance;
    private ArrayList<Long> primeNumbers = new ArrayList<Long>();
    private final String FILE = "src/project/euler/libraries/primeNumbers.txt";
    
    public static PrimeNumbers getInstance() {
        if (instance == null)
            instance = new PrimeNumbers();
        return instance;
    }
    
    /**
     * Upon initialization, get all the primes up to 1000.
     */
    private PrimeNumbers() {
        primeNumbers = new ArrayList<Long>();
        // Get all the prime numbers from primeNumbers.txt
        File file = new File(FILE);
        if (file.exists()) {
            try {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNext()) {
                    String numberStr = fileScanner.next();
                    primeNumbers.add(Long.parseLong(numberStr));
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PrimeNumbers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            // If the primeNumbers.txt doesn't exist, generate prime numbers from 0 to 50 and save as a new file
            StringBuilder stringBuilder = new StringBuilder();
            for (long number = 0; number < 1000; number++) {
                if (privateIsPrime(number)) {
                    primeNumbers.add(number);
                    stringBuilder.append(number).append(" ");
                }
            }
            
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter(FILE));
                out.write(stringBuilder.substring(0, stringBuilder.length() - 1));
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(PrimeNumbers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    public ArrayList<Long> getPrimeNumbers() {
        return primeNumbers;
    }
    
    /**
     * Adds a prime number and adds any prime number between the last prime number and this prime number.
     * 
     * @param primeNumber 
     */
    private void addPrime(long primeNumber) {        
        // Add all prime numbers between the last prime number and the current prime number
        long lastPrime = primeNumbers.get(primeNumbers.size()-1);
        for (long number = lastPrime+1; number < primeNumber; number++) {
            if (privateIsPrime(number))
                primeNumbers.add(number);
        }
        primeNumbers.add(primeNumber);
        
        writeToDatabase();
    }
    
    /**
     * Writes the current primeNumbers arraylist to the primeNumbers.txt file
     */
    private void writeToDatabase() {
        StringBuilder stringBuilder = new StringBuilder();
        
        // Add all the numbers currently in the database to stringBuilder.
        int index = 0;
        try {
            Scanner fileScanner = new Scanner(new File(FILE));
            while (fileScanner.hasNext()) {
                stringBuilder.append(fileScanner.next()).append(" ");
                index++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PrimeNumbers.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Add all numbers not currently in database
        for (int i = index; i < primeNumbers.size(); i++) {
            stringBuilder.append(primeNumbers.get(i)).append(" ");
        }
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(FILE));
            out.write(stringBuilder.substring(0, stringBuilder.length() - 1));
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(PrimeNumbers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Checks if a number is prime by first looking at the primeNumbers database and then, if not in database, by checking if it's prime.
     * 
     * @param number
     * @return 
     */
    public boolean nonStaticIsPrime(long number) {
        if (primeNumbers.contains(number))
            return true;
        if (primeNumbers.get(primeNumbers.size()-1) > number)
            return false; // number is below the largest prime number in the database and is not a prime number
        // Now calculate whether the number is prime
        if (privateIsPrime(number)) {
            addPrime(number);
            return true;
        }
        return false;
    }
    
    /**
     * Checks if a number is prime by using the {@link #isPrime(long)} method.
     * 
     * @param number
     * @return 
     */
    public static boolean isPrime(long number) {
        return PrimeNumbers.getInstance().nonStaticIsPrime(number);
    }
    
    /**
     * Gets the nth prime by retrieving the nth prime from the primeNumbers ArrayList. Note that the first prime is not n=1 but rather n=0. So the 0th prime is 2.
     * 
     * @param index the n in nth
     * @return the prime at the nth index and 0 if the index is beyond how many primes have already been calculated
     */
    public static long getNthPrime(int index) {
        ArrayList<Long> primeNumbers = PrimeNumbers.getInstance().getPrimeNumbers();
        return primeNumbers.get(index);
    }
    
    /**
     * Checks if a number is prime.
     * 
     * @param number potential prime number
     * @return number is prime or not
     */
    private boolean privateIsPrime(long number) {
        if (number < 2)
            return false;
        if (number == 2)
            return true;
        if (number%2 == 0)
            return false;
        for (int i = 3; i*i <= number; i += 2)
            if (number%i == 0)
                return false;
        return true;
    }
}