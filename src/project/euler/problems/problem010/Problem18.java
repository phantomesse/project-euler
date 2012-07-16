package project.euler.problems.problem010;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.euler.Problem;

/**
 * Find the maximum sum travelling from the top of the triangle to the base.
 *
 * @author Lauren Zou
 */
public class Problem18 extends Problem {

    private final String FILE = "src/project/euler/problems/problem010/problem18_triangle.txt";

    public Problem18() {
        super(18);

        // Parse triangle into a double array
        int[][] triangle = getTriangle(FILE);

        // Find path
        setAnswer(getMaximumPath(triangle));
    }

    public static int getMaximumPath(int[][] triangle) {
        for (int i = triangle.length - 1; i > 0; i--) {
            for (int j = 0; j < triangle[i].length - 1; j++) {
                triangle[i - 1][j] += (triangle[i][j] > triangle[i][j + 1] ? triangle[i][j] : triangle[i][j + 1]);
            }
        }
        return triangle[0][0];
    }

    public static int[][] getTriangle(String filePath) {
        ArrayList<int[]> triangleList = new ArrayList<int[]>();
        try {
            Scanner fileReader = new Scanner(new File(filePath));
            while (fileReader.hasNextLine()) {
                String[] numbers = fileReader.nextLine().split(" ");
                int[] numbersArr = new int[numbers.length];
                for (int i = 0; i < numbers.length; i++) {
                    numbersArr[i] = Integer.parseInt(numbers[i]);
                }
                triangleList.add(numbersArr);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Problem18.class.getName()).log(Level.SEVERE, null, ex);
        }
        return triangleList.toArray(new int[0][0]);
    }
}
