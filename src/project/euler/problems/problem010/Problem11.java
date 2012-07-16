package project.euler.problems.problem010;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.euler.Problem;
import project.euler.problems.problem001.Problem08;

/**
 * What is the greatest product of four adjacent numbers on the same straight line in the 20 by 20 grid?
 * 
 * @author Lauren Zou
 */
public class Problem11 extends Problem {

    private final String FILE = "src/project/euler/problems/problem010/problem11_grid.txt";
    
    public Problem11() {
        super(11);
        
        int[][] grid = new int[20][20];
        try {
            Scanner fileReader = new Scanner(new File(FILE));
            int index = 0;
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] temp = line.split(" ");
                for (int i = 0; i < temp.length; i++) {
                    grid[index][i] = Integer.parseInt(temp[i]);
                }
                index++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Problem08.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        int largest = 0;

        // Horizontal
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length - 3; j++) {
                int product = 1;
                for (int k = 0; k < 4; k++) {
                    product *= grid[i][j + k];
                }
                if (product > largest) {
                    largest = product;
                }
            }
        }

        // Vertical
        for (int i = 0; i < grid.length - 3; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int product = 1;
                for (int k = 0; k < 4; k++) {
                    product *= grid[i + k][j];
                }
                if (product > largest) {
                    largest = product;
                }
            }
        }

        // Diagonal Right
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int k = 0, product = 1;
                while (k < 4 && i + k < grid.length && j + k < grid[i].length) {
                    product *= grid[i + k][j + k];
                    k++;
                }
                if (k == 4 && product > largest) {
                    largest = product;
                }
            }
        }

        // Diagonal Left
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int k = 0, product = 1;
                while (k < 4 && i + k < grid.length && j - k >= 0) {
                    product *= grid[i + k][j - k];
                    k++;
                }
                if (k == 4 && product > largest) {
                    largest = product;
                }
            }
        }
        
        setAnswer(largest);
    }
}
