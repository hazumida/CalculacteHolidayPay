package Calculacte;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static java.lang.Integer.parseInt;

public class HolidayPay {
    private static HolidayPay singletion = null;

    private List<Calendar> listHolidayPay = new ArrayList<>();

    private HolidayPay() {
        this.listHolidayPay = HolidayPay.addDate(listHolidayPay);
    }

    public static HolidayPay get() {
        if (singletion == null) singletion = new HolidayPay();
        return singletion;
    }

    public List<Calendar> getList() {
        return listHolidayPay;
    }

    private static List<Calendar> addDate(List<Calendar> listHolidayPay) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/HolidayPay.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] date = line.split("\\.");
                    listHolidayPay.add(new GregorianCalendar(parseInt(date[2]), parseInt(date[1]) - 1, parseInt(date[0])));
                } catch (NumberFormatException er) {
                    System.out.println(er.getMessage());
                }
            }
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
        return listHolidayPay;
    }
}
