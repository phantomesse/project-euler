package project.euler.libraries;

/**
 * Produces a number from a sequence.
 * 
 * @author Lauren Zou
 */
public class NumberGetter {
        
    /**
     * Gets the nth term of the Fibonacci sequence.
     * 
     * @param index n
     * @return nth term where n is determined by the parameter index
     */
    public static long getFibonacciTerm(int index) {
        if (index <= 1)
            return index;
        return getFibonacciTerm(index-1) + getFibonacciTerm(index-2);
    }
    
    /**
     * Checks if a number is a triangle number.
     * 
     * @param number T<sub>n></sub> potential triangle number
     * @return number is a pentagonal number or not
     */
    public static boolean isTriangleNumber(long number) {
        double n = (Math.sqrt(8*number+1)-1)/2;
        return n == Math.floor(n);
    }
    
    /**
     * Gets a triangle number T<sub>n</sub> = n(n+1)/2 based on index n.
     * 
     * @param index n
     * @return T<sub>n</sub>
     */
    public static long getTriangleNumber(int index) {
        return (index+1)*index/2;
    }
    
    /**
     * Checks if a number is a pentagonal number.
     * 
     * @param number P<sub>n</sub> potential pentagonal number
     * @return number is a pentagonal number or not
     */
    public static boolean isPentagonalNumber(long number) {
        double n = (Math.sqrt(number*24 +1)+1)/6;
        return n == Math.floor(n);
    }
    
    /**
     * Gets a pentagonal number P<sub>n</sub> = n(3n-1)/2 based on index n.
     * 
     * @param index n
     * @return P<sub>n</sub>
     */
    public static long getPentagonalNumber(int index) {
        return (index*3 - 1)*index/2;
    }
    
    /**
     * Checks if a number is a hexagonal number.
     * 
     * @param number H<sub>n</sub> potential pentagonal number
     * @return number is a hexagonal number or not
     */
    public static boolean isHexagonalNumber(long number) {
        double n = (Math.sqrt(number*8 +1)+1)/4;
        return n == Math.floor(n);
    }
    
    /**
     * Gets a hexagonal number H<sub>n</sub> = n(2n-1) based on index n.
     * 
     * @param index n
     * @return H<sub>n</sub>
     */
    public static long getHexagonalNumber(int index) {
        return (index*2 - 1)*index;
    }
}
