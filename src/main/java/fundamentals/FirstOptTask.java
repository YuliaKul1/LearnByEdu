package fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FirstOptTask {

    public static void main(String[] args)  {
        System.out.println("Hello " + helloUser());
        System.out.println("Сумма чисел " + sumNumbers());
    }

    static String helloUser() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return " ";
    }

    static int sumNumbers() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int number;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String inputString = reader.readLine();
            while (!"".equals(inputString)) {
                try {
                    number = Integer.parseInt(inputString);
                    arrayList.add(number);
                    inputString = reader.readLine();

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int sum = 0;
        for (Integer i : arrayList) {
            sum = sum + i;
        }
        return sum;
    }
}
