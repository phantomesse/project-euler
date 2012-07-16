package project.euler.problems.problem010;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import project.euler.Problem;

/**
 * How many Sundays fell on the first of the month during the twentieth century?
 * 
 * @author Lauren Zou
 */
public class Problem19 extends Problem {
    
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MMM dd, yyyy");
    private final Calendar START_DATE = new GregorianCalendar(1901, 0, 1);
    private final Calendar END_DATE = new GregorianCalendar(2000, 11, 31);
    
    public Problem19() {
        super(19);
        
        int numberOfSundays = 0;
        Calendar date = START_DATE;
        while (date.before(END_DATE)) {
            if (date.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                System.out.println(DATE_FORMAT.format(date.getTime()));
                numberOfSundays++;
            }
            date.set(Calendar.MONTH, date.get(Calendar.MONTH)+1);
        }
        setAnswer(numberOfSundays);
    }
}
