package project.euler;

import project.euler.problems.problem20.Problem23;

/**
 *
 * @author LZOU
 */
public class ProjectEuler {

    private static final Problem currentProblem = new Problem23();
    
    public static void main(String[] args) {
        System.out.println("Answer: " + currentProblem.getAnswer());
    }
}