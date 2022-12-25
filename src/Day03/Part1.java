package Day03;

import utils.FastIO;
import java.io.IOException;

public class Part1 {
    public static void main(String[] args) {

        String filepath = "src/Day03/input.in";

        try (FastIO io = new FastIO(filepath, System.out)) {

            String line;
            int totalAmount = 0;

            while ((line = io.readLine()) != null) {

                int center = line.length()/2;
                String fst = line.substring(0, center);
                String snd = line.substring(center);

                for (int i = 0; i < fst.length(); i++) {
                    char c = fst.charAt(i);
                    if (snd.contains(Character.toString(c))) {
                        totalAmount += Character.isUpperCase(c)
                                ? uppercasePriorities(c)
                                : lowercasePriorities(c);
                        break;
                    }
                }
            }

            io.print(totalAmount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int lowercasePriorities(char c) {
        return c - 96;
    }

    private static int uppercasePriorities(char c) {
        return c - 38;
    }
}