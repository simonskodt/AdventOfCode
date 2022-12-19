package Day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {
    public static void main(String[] args) {
        String filepath = "src/Day01/input.in";

        int high = Integer.MIN_VALUE, curr = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    if (curr > high) high = curr;
                    curr = 0;
                }
                else
                    curr += Integer.parseInt(line);
            }
            System.out.println(high);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}