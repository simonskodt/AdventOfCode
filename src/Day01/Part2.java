package Day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Part2 {
    public static void main(String[] args) {
        String filepath = "src/Day01/input.in";

        int[] highs = new int[3]; // highest at idx 0
        int curr = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    if (curr > highs[0])
                        highs = new int[] { curr, highs[0], highs[1] };
                    else if (curr > highs[1])
                        highs = new int[] { highs[0], curr, highs[1] };
                    else if (curr > highs[2])
                        highs = new int[] { highs[0], highs[1], curr };
                    curr = 0;
                } else {
                    curr += Integer.parseInt(line);
                }
            }
            int total = Arrays.stream(highs).reduce(0, Integer::sum);
            System.out.println(total);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}