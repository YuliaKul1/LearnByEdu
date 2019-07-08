package fundamentals;

import org.apache.commons.collections4.CollectionUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class SecondOptTask {

    public static void main(String[] args) throws IOException {

//        lengthSort(arrayFiller());
        Numbers numbers = cntEvenOdd(arrayFiller());
        System.out.println("Количество числе содержащих только четные цифры: \n" + numbers.getEvenCnt());
        System.out.println("Количество числе содержащих одинаково четных и нечетных: \n" + numbers.getEvenOddEquals());
    }

    static ArrayList<Integer> arrayFiller() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
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
            return integerArrayList;
        }
    }

    //Найти самое короткое и самое длинное число и их длину.
    static void lengthCounter(ArrayList<Integer> arrayList) {
        if (CollectionUtils.isNotEmpty(arrayList)) {
            int minNum = arrayList.get(0);
            int maxNum = arrayList.get(0);
            int minLength = String.valueOf(minNum).length();
            int maxLength = String.valueOf(maxNum).length();
            int tempMinLength;
            int tempMaxLength;
            for (Integer i : arrayList) {
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
        } else {
            System.out.println("Список пуст");
        }
    }

    //Вывести числа в порядке возрастания значения их длины
    public static void lengthSort(ArrayList<Integer> arrayList) {

        Integer[] arraySorted = new Integer[arrayList.size()];
        arraySorted = arrayList.toArray(arraySorted);

        Collections.sort(arrayList, Comparator.comparing(num -> String.valueOf(num).length()));
        /*
        //первая версия решения
        for (int i = arraySorted.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (String.valueOf(arraySorted[j]).length() > String.valueOf(arraySorted[j + 1]).length()) {
                    int tmp = arraySorted[j];
                    arraySorted[j] = arraySorted[j + 1];
                    arraySorted[j + 1] = tmp;
                }
            }
        }
        */

        System.out.println("Числа в порядке возрастания значения их длины: ");
        for (Integer number : arrayList) {
            System.out.println(number);
        }

    }


    public static class Numbers {
        private Integer evenCnt;
        private Integer evenOddEquals;

        public Integer getEvenCnt() {
            return evenCnt;
        }

        public Integer getEvenOddEquals() {
            return evenOddEquals;
        }

        public Numbers(int evenCnt, int evenOddEquals) {
            this.evenCnt = evenCnt;
            this.evenOddEquals = evenOddEquals;
        }

        public Numbers(int evenCnt) {
            this.evenCnt = evenCnt;
        }
    }

    //Найти количество чисел, содержащих только четные цифры
    //Среди оставшихся найти количество числе, в которых количество четных и нечетных одинаково
    static Numbers cntEvenOdd(ArrayList<Integer> arrayList) {
        int evenCnt = 0;
        int numEvenOddEquals = 0;
        ArrayList<Integer> arrayNotEven = new ArrayList<>();

        for (Integer number : arrayList) {
            String numString = number.toString();
            char[] numChar = numString.toCharArray();
            int cntEven = 0;
            int cntOdd = 0;
            for (char numEvenOdd : numChar) {
                if (numEvenOdd % 2 == 0) {
                    cntEven++;
                } else {
                    cntOdd++;
                }
            }
            if (cntEven == cntOdd) {
                numEvenOddEquals++;
            }
            if (cntOdd == 0) {
                evenCnt++;
            }
        }
        return new Numbers(evenCnt, numEvenOddEquals);
    }
}
