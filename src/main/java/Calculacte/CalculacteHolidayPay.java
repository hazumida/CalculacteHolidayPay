package Calculacte;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalculacteHolidayPay {
    private static final List<Calendar> listHolidayPay = HolidayPay.get().getList();
    private Calendar beginHolidayPay;
    private Calendar endHolidayPay;
    private double money;

    public CalculacteHolidayPay(Calendar beginHolidayPay, Calendar endHolidayPay, double money) {
        this.beginHolidayPay = beginHolidayPay;
        this.endHolidayPay = endHolidayPay;
        this.money = money;
    }

    public double moneyForHolidfyPay() {
        List<Calendar> listWork = new ArrayList<>();
        boolean flag = true;

        if (beginHolidayPay.after(endHolidayPay)) {
            return 0;
        }

        while (!(beginHolidayPay.after(endHolidayPay))) {
            for (Calendar holidayPay : listHolidayPay) {
                if (holidayPay.equals(beginHolidayPay)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                if (beginHolidayPay.get(Calendar.DAY_OF_WEEK) == 1 || beginHolidayPay.get(Calendar.DAY_OF_WEEK) == 7) {
                    beginHolidayPay.add(Calendar.DAY_OF_YEAR, 1);
                } else {
                    listWork.add(beginHolidayPay);
                    beginHolidayPay.add(Calendar.DAY_OF_YEAR, 1);

                }
            } else {
                beginHolidayPay.add(Calendar.DAY_OF_YEAR, 1);
                flag = true;
                continue;
            }
        }

        return listWork.size() * money;
    }
}
