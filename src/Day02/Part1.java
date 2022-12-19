package Day02;

import utils.FastIO;
import java.io.IOException;

public class Part1 {

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
     * X: rock (1 point for rock)
     * Y: paper (2 points for paper)
     * Z: scissors (3 points for scissors)
     *
     * Lost: 0 points
     * Draw: 3 points
     * Win: 6 points
     */
    static private void rock(char b) {
        switch (b) {
            case 'X' -> score += 4; // draw
            case 'Y' -> score += 8; // win)
            case 'Z' -> score += 3; // lost
        }
    }

    static private void paper(char b) {
        switch (b) {
            case 'X' -> score += 1; // lost
            case 'Y' -> score += 5; // draw
            case 'Z' -> score += 9; // win
        }
    }

    static private void scissors(char b) {
        switch (b) {
            case 'X' -> score += 7; // win
            case 'Y' -> score += 2; // lost
            case 'Z' -> score += 6; // draw
        }
    }
}
