package Calculacte;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
public class Controller {

    @RequestMapping("/CalculacteHolidayPay/{begin}/{end}/{money}")
    public double calculateHolidayPay(@PathVariable String begin, @PathVariable String end, @PathVariable double money) {
        Calendar calendar1 = StringToCalendar.stringToCalendar(begin);
        Calendar calendar2 = StringToCalendar.stringToCalendar(end);
        return new CalculacteHolidayPay(calendar1, calendar2, money).moneyForHolidfyPay();
    }
}
