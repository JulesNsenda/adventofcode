package tech.myic.day.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
        try {
            List<PasswordDetails> lines = getPasswordDetailsLines();
            int valid = 0;
            for (PasswordDetails line : lines) {
                String policy = line.getPolicy();
                String[] policies = policy.split("-");
                String password = line.getPassword();

                int count = 0;
                char[] ps = password.toCharArray();
                for (char p : ps) {
                    if (String.valueOf(p).equals(line.getCharacter())) {
                        count += 1;
                    }
                }

                int min = Integer.valueOf(policies[0]);
                int max = Integer.valueOf(policies[1]);

                if (count >= min && count <= max) {
                    valid += 1;
                }
            }

            System.out.println(valid);
        } catch (IOException ex) {
            throw new RuntimeException("Error processing", ex);
        }
    }

    private static List<PasswordDetails> getPasswordDetailsLines() throws IOException {
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
