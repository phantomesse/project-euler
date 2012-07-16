/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.euler;

/**
 *
 * @author LZOU
 */
public class Problem {

    private int problemNumber;
    private String answer;
    private static final String PATH = "project.euler.problems.problem";
    
    public Problem(int problemNumber) {
        this.problemNumber = problemNumber;
    }
    
    public int getProblemNumber() {
        return problemNumber;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    public void setAnswer(long answer) {
        this.answer = answer + "";
    }
    
    public String getAnswer() {
        return answer;
    }
}