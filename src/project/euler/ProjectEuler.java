package project.euler;

import project.euler.problems.problem30.Problem30;

/**
 *
 * @author LZOU
 */
public class ProjectEuler {

    private static final Problem currentProblem = new Problem30();
    
    public static void main(String[] args) {
        System.out.println("Answer: " + currentProblem.getAnswer());
    }
}