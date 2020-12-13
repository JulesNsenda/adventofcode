package tech.myic.day.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import tech.myic.day.two.part.one.Driver;

public class Utils {

    private Utils() {
    }

    public static List<PasswordDetails> getPasswordDetailsLines() throws IOException {
        List<PasswordDetails> lines = new ArrayList<>();
        try (InputStream in = Driver.class.getResourceAsStream("/day-two-input.csv")) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.replaceAll("\"", "").split(",");
                    lines.add(new PasswordDetails(parts[0], parts[1].replaceAll(":", ""), parts[2]));
                }
            }
        }
        return lines;
    }

}
