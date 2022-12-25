package Day03;

import utils.FastIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part2 {
    private static int totalAmount;
    private final static String FILE_PATH = "src/Day03/input.in";

    public static void main(String[] args) {

        try (FastIO io = new FastIO(FILE_PATH, System.out)) {

            String line;
            String[] lines = new String[3];
            int cycle = 0;

            while ((line = io.readLine()) != null) {
                // Reading three lines, then do calculations, and start over
                if (cycle != 2) {
                    lines[cycle++] = line;
                    continue;
                }
                lines[cycle] = line; // reading the last of the three lines

                // Longest line for iteration
                Tuple longerLine = findLongestLineAndIndex(lines);
                // Two shorter lines for comparing
                List<String> shorterLines = findShorterLines(lines, longerLine);

                // Going through longest line to check for match with shorter lines
                for (char c : lines[longerLine.index].toCharArray()) {
                    if (shorterLines.get(0).contains(Character.toString(c))
                            && shorterLines.get(1).contains(Character.toString(c))) {
                        addCharAmount(c);
                        break;
                    }
                }

                lines = new String[3];
                cycle = 0;
            }

            io.print(totalAmount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Class for returning the longest line and its index as a tuple
    static class Tuple {
        String line;
        int index;

        Tuple(String line, int index) {
            this.line = line;
            this.index = index;
        }
    }

    private static Tuple findLongestLineAndIndex(String[] lines) {
        String longestLine = "";
        int index = 0;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].length() > longestLine.length()) {
                longestLine = lines[i];
                index = i;
            }
        }

        return new Tuple(longestLine, index);
    }
    private static List<String> findShorterLines(String[] lines, Tuple longerLine) {
        List<String> shorterLines = new ArrayList<>(Arrays.asList(lines));
        shorterLines.remove(longerLine.index);
        return shorterLines;
    }

    private static void addCharAmount(char c) {
        if (Character.isUpperCase(c))
            totalAmount += uppercasePriorities(c);
        else
            totalAmount += lowercasePriorities(c);
    }

    private static int lowercasePriorities(char c) {
        return c - 96;
    }

    private static int uppercasePriorities(char c) {
        return c - 38;
    }
}
