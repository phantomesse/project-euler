package project.euler.problems.problem10;

import project.euler.Problem;

/**
 * How many letters would be needed to write all the numbers in words from 1 to 1000?
 * 
 * @author Lauren Zou
 */
public class Problem17 extends Problem {
    public Problem17() {
        super(17);
        
        int lettersUsed = 0;
        for (int number = 1; number <= 1000; number++) {
            String numberStr = numberToWord(number).replaceAll(" ", "");
            lettersUsed += numberStr.length();
        }
        setAnswer(lettersUsed);
    }
    
    private String numberToWord(int number) {
        switch(number) {
            case 0: return "";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            case 10: return "ten";
            case 11: return "eleven";
            case 12: return "twelve";
            case 13: return "thirteen";
            case 14: return "fourteen";
            case 15: return "fifteen";
            case 16: return "sixteen";
            case 17: return "seventeen";
            case 18: return "eighteen";
            case 19: return "nineteen";
            case 1000: return "one thousand";
        }
        if (number < 100) {
            // Accounts for cases 20-99
            String str = "";
            switch (number/10) {
                case 2: str = "twenty"; break;
                case 3: str = "thirty"; break;
                case 4: str = "forty"; break;
                case 5: str = "fifty"; break;
                case 6: str = "sixty"; break;
                case 7: str = "seventy"; break;
                case 8: str = "eighty"; break;
                case 9: str = "ninety"; break;
            }
            return str + " " + numberToWord(number%10);
        }
        // Accounts for cases 100 - 999
        String str = "";
        switch (number/100) {
            case 1: str = "one"; break;
            case 2: str = "two"; break;
            case 3 : str = "three"; break;
            case 4: str = "four"; break;
            case 5: str = "five"; break;
            case 6: str = "six"; break;
            case 7: str = "seven"; break;
            case 8: str = "eight"; break;
            case 9: str = "nine"; break;
        }
        if (number%100 == 0)
            return str + " hundred";
        return str + " hundred and " + numberToWord(number%100);
    }
}
