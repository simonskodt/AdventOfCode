package Day02;

import utils.FastIO;
import java.io.IOException;

public class Part2 {

    static private int score;

    public static void main(String[] args) {

        String filepath = "src/Day02/input.in";

        try (FastIO io = new FastIO(filepath, System.out)) {
            String line;

            while ((line = io.readLine()) != null) {
                char[] chars = line.toCharArray();
                char a = chars[0], b = chars[2];

                switch (a) {
                    case 'A' -> rock(b);
                    case 'B' -> paper(b);
                    case 'C' -> scissors(b);
                }
            }

            io.println(score);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * X: need to lose (0p)
     * Y: need to draw (3p)
     * Z: need to win (6p)
     *
     * A vs X = DRAW = (1 + 3) = 4
     * A vs Y = WIN  = (2 + 6) = 8
     * A vs Z = LOSS = (3 + 0) = 3
     * B vs X = LOSS = (1 + 0) = 1
     * B vs Y = DRAW = (2 + 3) = 5
     * B vs Z = WIN  = (3 + 6) = 9
     * C vs X = WIN  = (1 + 6) = 7
     * C vs Y = LOSS = (2 + 0) = 2
     * C vs Z = DRAW = (3 + 3) = 6
     */
    static private void rock(char b) {
        switch (b) {
            case 'X' -> score += 3; // A vs Z = LOSS = (3 + 0) = 3
            case 'Y' -> score += 4; // A vs X = DRAW = (1 + 3) = 4
            case 'Z' -> score += 8; // A vs Y = WIN  = (2 + 6) = 8
        }
    }

    static private void paper(char b) {
        switch (b) {
            case 'X' -> score += 1; // B vs X = LOSS = (1 + 0) = 1
            case 'Y' -> score += 5; // B vs Y = DRAW = (2 + 3) = 5
            case 'Z' -> score += 9; // B vs Z = WIN  = (3 + 6) = 9
        }
    }

    static private void scissors(char b) {
        switch (b) {
            case 'X' -> score += 2; // C vs Y = LOSS = (2 + 0) = 2
            case 'Y' -> score += 6; // C vs Z = DRAW = (3 + 3) = 6
            case 'Z' -> score += 7; // C vs X = WIN  = (1 + 6) = 7
        }
    }
}
