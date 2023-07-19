package com.greychaindesign.loan_management.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static boolean isDateGreaterThan(String date1, String date2) {
        try {
            Date d1 = sdf.parse(date1);
            Date d2 = sdf.parse(date2);
            return d1.compareTo(d2) > 0;
        } catch (ParseException e) {
            return false;
        }
    }

    public static String getCurrentDate() {
        return sdf.format(new Date());
    }
}
