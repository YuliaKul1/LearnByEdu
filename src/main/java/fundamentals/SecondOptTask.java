package fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SecondOptTask {

    public static void lengthCounter() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        int inpNum;
        for (int i = 0; i < 4; i++) {
            try {
                inpNum = Integer.parseInt(reader.readLine());
                integerArrayList.add(inpNum);
            } catch (NumberFormatException numExp) {
                numExp.printStackTrace();
            }
        }


        int minNum = integerArrayList.get(0);
        int maxNum = integerArrayList.get(0);
        int minLength = String.valueOf(minNum).length();
        int maxLength = String.valueOf(maxNum).length();
        int tempMinLength;
        int tempMaxLength;
        for (Integer i : integerArrayList) {
            tempMinLength = String.valueOf(i).length();
            tempMaxLength = String.valueOf(i).length();
            if (tempMinLength < minLength) {
                minNum = i;
                minLength = tempMinLength;
            }
            if (tempMaxLength > maxLength) {
                maxLength = tempMaxLength;
                maxNum = i;
            }
        }
        System.out.println("Самое короткое число: " + minNum);
        System.out.println("Длина самого короткого числа: " + minLength);
        System.out.println("Самое длинное число: " + maxNum);
        System.out.println("Длина самого длинного числа: " + maxLength);
    }
}
