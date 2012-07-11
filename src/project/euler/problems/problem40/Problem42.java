package project.euler.problems.problem40;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.euler.Problem;
import project.euler.libraries.NumberGetter;
import project.euler.problems.problem01.Problem08;

/**
 * How many triangle words does the list of common English words contain?
 * 
 * @author LZOU
 */
public class Problem42 extends Problem {
    
    private final String FILE = "src/project/euler/problems/problem40/problem42_words.txt";
    
    public Problem42() {
        super(42);
        
        Scanner fileReader = new Scanner(System.in);
        try {
            fileReader = new Scanner(new File(FILE));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Problem08.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        StringBuilder wordsStr = new StringBuilder();
        while (fileReader.hasNext())
            wordsStr.append(fileReader.next());
        
        // Iterate through all words
        int numberOfTriangleWords = 0;
        String[] wordsArr = (wordsStr.toString()).substring(1, wordsStr.length()-1).split("\",\"");
        for (String word : wordsArr) {
            int wordValue = getValue(word);
            if (NumberGetter.isTriangleNumber(wordValue))
                numberOfTriangleWords++;
        }
        setAnswer(numberOfTriangleWords);
    }
        
    private int getValue(String word) {
        int wordLength = word.length();
        int wordValue = 0;
        for (int i = 0; i < wordLength; i++)
            wordValue += (int)word.charAt(i)-65+1;
        return wordValue;
    }
}
