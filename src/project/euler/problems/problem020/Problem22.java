package project.euler.problems.problem20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.euler.Problem;

/**
 * What is the total of all the name scores in the file of first names?
 * 
 * @author Lauren Zou
 */
public class Problem22 extends Problem {
    
    private final String FILE = "src/project/euler/problems/problem020/problem22_names.txt";
    
    public Problem22() {
        super(22);
        
        String[] names = new String[0];
        try {
            Scanner fileReader = new Scanner(new File(FILE));
            StringBuilder strBuilder = new StringBuilder();
            while (fileReader.hasNext()) {
                strBuilder.append(fileReader.next());
            }
            names = (strBuilder.toString().substring(1, strBuilder.length()-1)).split("\",\"");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Problem22.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Arrays.sort(names);
        int totalNameScore = 0;
        for (int i = 0; i < names.length; i++) {
            totalNameScore += getNameScore(names[i], i+1);
        }
        setAnswer(totalNameScore);
    }
    
    private int getNameScore(String name, int index) {
        int score = 0;
        for (int i = 0; i < name.length(); i++) {
            score += (int)(name.charAt(i))-64;
        }
        return score*index;
    }
}
