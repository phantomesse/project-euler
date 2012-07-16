package project.euler.libraries;

/**
 * Works with strings.
 * 
 * @author Lauren Zou
 */
public class StringPlay {
    
    /**
     * Checks if two strings are permutations of each other.
     */
    public static boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        for (int i = 0; i < str1.length(); i++) {
            if (!str2.contains(str1.substring(i,i+1)))
                return false;
        }
        for (int i = 0; i < str2.length(); i++) {
            if (!str1.contains(str2.substring(i,i+1)))
                return false;
        }
        return true;
    }
    
    /**
     * Checks if a string is a palindrome.
     * 
     * @param str potential palindrome
     * @return true if is palindrome and false if not
     */
    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length()/2; i++)
            if (str.charAt(i) != str.charAt(str.length()-i-1))
                return false;
        return true;
    }
    
    /**
     * Checks if a number is pandigital.
     * 
     * @param number potential pandigital number
     * @return number is pandigital or not
     */
    public static boolean isPandigital(String number) {
        int numberOfDigits = number.length();
        for (int i = 1; i <= numberOfDigits; i++) {
            if (!number.contains(i + ""))
                return false;
        }
        return true;
    }
}
