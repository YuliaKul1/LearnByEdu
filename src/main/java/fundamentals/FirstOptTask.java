package fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FirstOptTask {

    public static void helloUser() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String name = reader.readLine();
            System.out.println("Hello " + name);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sumNumbers() throws IOException {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int number;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
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
        reader.close();

        for (Integer i : arrayList) {
            sum = sum + i;
        }

        System.out.println(sum);

    }
}
