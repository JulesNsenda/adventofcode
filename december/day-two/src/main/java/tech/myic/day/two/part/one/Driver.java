package tech.myic.day.two.part.one;

import java.io.IOException;
import java.util.List;
import tech.myic.day.two.PasswordDetails;
import tech.myic.day.two.Utils;

public class Driver {

    public static void main(String[] args) {
        try {
            List<PasswordDetails> lines = Utils.getPasswordDetailsLines();
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
}
