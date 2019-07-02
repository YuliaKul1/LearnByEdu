package fundamentals;

import sun.font.FontRunIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FourthOptTask {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int number = Integer.parseInt(reader.readLine());
            int[][] intsArr = intCreator(number);
            intPrinter(intsArr);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static int[][] intCreator(int n) {
        int[][] multiArr = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                multiArr[i][j] = (int) (Math.random() * 10);
            }

        }
        return multiArr;
    }


    static void intPrinter(int[][] multiArr) {

        for (int i = 0; i < multiArr.length; i++) {
            for (int j = 0; j < multiArr.length; j++) {
                System.out.print(multiArr[i][j] + "\t");
            }
            System.out.println();
        }

    }

}
