package project.euler;

import javax.swing.*;
import project.euler.problems.problem50.Problem52;

/**
 *
 * @author LZOU
 */
public class ProjectEuler extends JFrame {

    private static final Problem currentProblem = new Problem52();
    
    public static void main(String[] args) {
        System.out.println("Answer: " + currentProblem.getAnswer());
    }
}