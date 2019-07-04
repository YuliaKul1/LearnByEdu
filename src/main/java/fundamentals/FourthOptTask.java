package fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

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
            //   System.out.println("Отсортированная матрица");
            //     intPrinter(arrSort(intsArr, 3));
            System.out.println("Матрица с удаленными максимальными элементами");
            intPrinter(arrRemoveMax(intsArr));
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

    //Найти максимальный элемент в матрице
    //и удалить из матрицы все столбцы и строки, содержащие его
    static int[][] arrRemoveMax(int[][] multiArr) {
        int max = multiArr[0][0];
        for (int[] arr : multiArr) {
            for (int num : arr) {
                if (num > max) {
                    max = num;
                }
            }
        }

        ArrayList<int[]> multiList = new ArrayList<>();
        int finalMax = max;
        for (int[] arr : multiArr) {
            if (IntStream.of(arr).noneMatch(x -> x == finalMax)) {
                multiList.add(arr);
            }
        }

        int[][] filterArray = multiList.toArray(new int[multiList.size()][]);
        return filterArray;
    }
}
