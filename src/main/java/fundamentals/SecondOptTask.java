package fundamentals;

import sun.font.FontRunIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SecondOptTask {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<Integer> integerArrayList = new ArrayList<Integer>();

    public static void arrayFiller() throws IOException {
        System.out.println("Введите количество чисел");
        int quantity = Integer.parseInt(reader.readLine());
        System.out.println("Введите числа");
        for (int i = 0; i < quantity; i++) {
            try {
                Integer inpNum = Integer.parseInt(reader.readLine());
                integerArrayList.add(inpNum);
            } catch (NumberFormatException numExp) {
                numExp.printStackTrace();
            }
        }
    }

    //Найти самое короткое и самое длинное число и их длину.
    public static void lengthCounter() {
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

        //Вывести найденные числа и их длину.
        System.out.println("Самое короткое число: " + minNum);
        System.out.println("Длина самого короткого числа: " + minLength);
        System.out.println("Самое длинное число: " + maxNum);
        System.out.println("Длина самого длинного числа: " + maxLength);
    }


    //Вывести числа в порядке возрастания значения их длины
    public static void lengthSort() {

        Integer[] arraySorted = new Integer[integerArrayList.size()];
        arraySorted = integerArrayList.toArray(arraySorted);

        for (int i = arraySorted.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (String.valueOf(arraySorted[j]).length() > String.valueOf(arraySorted[j + 1]).length()) {
                    int tmp = arraySorted[j];
                    arraySorted[j] = arraySorted[j + 1];
                    arraySorted[j + 1] = tmp;
                }
            }
        }

        System.out.println("Числа в порядке возрастания значения их длины: ");
        System.out.println(Arrays.toString(arraySorted));

    }
}
