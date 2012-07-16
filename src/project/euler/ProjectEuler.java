package project.euler;

import project.euler.problems.problem40.Problem49;

/**
 *
 * @author LZOU
 */
public class ProjectEuler {

    private static final Problem currentProblem = new Problem49();
    
    public static void main(String[] args) {
        System.out.println("Problem #" + currentProblem.getProblemNumber());
        System.out.println("Answer: " + currentProblem.getAnswer());
    }
}