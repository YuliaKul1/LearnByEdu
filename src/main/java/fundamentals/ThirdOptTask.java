package fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class ThirdOptTask {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int monthNum = Integer.parseInt(reader.readLine());
            System.out.println("Month: " + getMonth(monthNum));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getMonth(int monthNum) {
        String month;
        //Locale locale = Locale.;
        month = Month.of(monthNum).getDisplayName(TextStyle.FULL,Locale.getDefault());
        return month;
    }
}
