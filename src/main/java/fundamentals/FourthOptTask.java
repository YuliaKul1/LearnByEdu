package fundamentals;

import sun.font.FontRunIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class FourthOptTask {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Введите размер матрицы");
            int number = Integer.parseInt(reader.readLine());
            System.out.println("Введите наибольшее возможное значение");
            int bound = Integer.parseInt(reader.readLine());
            int[][] intsArr = intCreator(number, bound);
            System.out.println("Изначальная матрица");
            intPrinter(intsArr);
            System.out.println("Отсортированная матрица");
            intPrinter(arrSort(intsArr, 3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int[][] intCreator(int n, int bound) {
        Random r = new Random();
        int[][] multiArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                multiArr[i][j] = r.nextInt(bound * 2) - bound;
            }
        }
        return multiArr;
    }

    static void intPrinter(int[][] multiArr) {
        for (int[] number : multiArr) {
            for (int i = 0; i < number.length; i++) {
                System.out.print(number[i] + "\t");
            }
            System.out.println();
        }
    }

    //упорядочить строки матрицы в порядке возрастания значений kго столбца элементов
    static int[][] arrSort(int[][] multiArr, int k) {

        //решение через циклы
        /*  for (int i = 0; i < multiArr.length - 1; i++) {
            for (int j = 0; j < multiArr.length; j++) {
                int[] arrTmp = multiArr[i];
                if (multiArr[i][k] > multiArr[i + 1][k]) {
                    multiArr[i] = multiArr[i + 1];
                    multiArr[i + 1] = arrTmp;
                }
            }
        }
        */

        //решение Java8
        Arrays.sort(multiArr, Comparator.comparing(a -> a[k]));
        return multiArr;
    }
}
