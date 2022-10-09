package Calculacte;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.lang.Integer.parseInt;

public class StringToCalendar {
    public static Calendar stringToCalendar(String line) {
        try {
            String[] date = line.split("\\.");
            return (new GregorianCalendar(parseInt(date[2]), parseInt(date[1]) - 1, parseInt(date[0])));
        } catch (NumberFormatException er) {
            System.out.println(er.getMessage());
        }
        return null;
    }
}
