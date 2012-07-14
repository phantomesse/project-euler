package project.euler;

import project.euler.problems.problem20.Problem22;

/**
 *
 * @author LZOU
 */
public class ProjectEuler {

    private static final Problem currentProblem = new Problem22();
    
    public static void main(String[] args) {
        System.out.println("Answer: " + currentProblem.getAnswer());
    }
}