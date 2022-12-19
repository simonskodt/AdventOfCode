package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DifferentScanningFromFileTechniques {

    static void fastIO() {
        FastIO io = new FastIO(System.in, System.out);
        String line;
        while (io.hasNextLine()) {
            line = io.readLine();
        }
    }

    static void traditionalReading() {
        String filepath = "input.in";
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // processing of line
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void newReading() {
        String filepath = "input.in";
        try {
            Files.lines(Paths.get(filepath)).forEach(line -> {
                // processing of line
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
