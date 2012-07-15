package project.euler.problems.problem10;

import project.euler.Problem;

/**
 * Find the longest sequence using a starting number under one million.
 * 
 * @author Lauren Zou
 */
public class Problem14 extends Problem {
    
    private final long LIMIT = 1000000;
    
    public Problem14() {
        super(14);
        
        long startingNumber = 1;
        long longestChain = 0;
        long longestChainStartingNumber = 0;
        while (startingNumber < LIMIT) {
            long chainLength = getChainLength(startingNumber, 0);
            if (chainLength > longestChain) {
                longestChain = chainLength;
                longestChainStartingNumber = startingNumber;
            }
            startingNumber++;
        }
        setAnswer(longestChainStartingNumber);
    }
    
    private long getChainLength(long startingNumber, long currentChainLength) {
        if (startingNumber == 1)
            return 1+currentChainLength;
        if (startingNumber%2 == 0) {
            // Account for even numbers
            return getChainLength(startingNumber/2, currentChainLength+=1);
        }
        // Account for odd numbers
        return getChainLength(startingNumber*3+1, currentChainLength+=1);
    }
}
