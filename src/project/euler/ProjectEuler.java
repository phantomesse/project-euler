package project.euler;

import project.euler.problems.problem60.Problem67;

/**
 *
 * @author LZOU
 */
public class ProjectEuler {

    private static final Problem currentProblem = new Problem67();
    
    public static void main(String[] args) {
        System.out.println("Answer: " + currentProblem.getAnswer());
    }
}