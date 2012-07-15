package project.euler;

import project.euler.problems.problem10.Problem11;

/**
 *
 * @author LZOU
 */
public class ProjectEuler {

    private static final Problem currentProblem = new Problem11();
    
    public static void main(String[] args) {
        System.out.println("Answer: " + currentProblem.getAnswer());
    }
}