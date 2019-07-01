package fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThirdOptTask {
    public static void main(String[] args) {
        System.out.println("Month: " + getMonth());
    }

    private enum months {
        JANUARY,
        FEBRUARY,
        MARCH,
        APRIL,
        MAY,
        JUNE,
        JULY,
        AUGUST,
        SEPTEMBER,
        OCTOBER,
        NOVEMBER,
        DECEMBER;
    }

    static String getMonth() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month;
        try {
            int monthNum = Integer.parseInt(reader.readLine());
            if (monthNum >= 1 && monthNum < 13) {
                month = String.valueOf(months.values()[monthNum-1]);
                return month;
            } else {
                return "wrong month number ";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
