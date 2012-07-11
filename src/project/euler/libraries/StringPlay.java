package project.euler.libraries;

/**
 * Works with strings.
 * 
 * @author Lauren Zou
 */
public class StringPlay {
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
}
