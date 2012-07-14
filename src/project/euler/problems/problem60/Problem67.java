package project.euler.problems.problem60;

import project.euler.Problem;
import project.euler.problems.problem10.Problem18;

/**
 * Using an efficient algorithm find the maximal sum in the triangle?
 *
 * @author Lauren Zou
 */
public class Problem67 extends Problem {

    private final String FILE = "src/project/euler/problems/problem60/problem67_triangle.txt";

    public Problem67() {
        super(67);

        // Parse triangle into a double array
        int[][] triangle = Problem18.getTriangle(FILE);

        // Find path using algorithm from problem 18
        setAnswer(Problem18.getMaximumPath(triangle));
    }
}
