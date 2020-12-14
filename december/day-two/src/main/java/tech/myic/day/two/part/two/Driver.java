package tech.myic.day.two.part.two;

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
                String password = line.getPassword();
                
                String[] positions = policy.split("-");
                int low = Integer.valueOf(positions[0]) - 1;
                int high = Integer.valueOf(positions[1]) - 1;

                int count = 0;
                
                char[] ps = password.toCharArray();
                for (int position = 0; position < ps.length; position++) {
                    char p = ps[position];
                    if ((String.valueOf(p).equals(line.getCharacter()))) {
                        if (position == low || position == high) {
                            count += 1;
                        }
                    }
                }
                
                if (count == 1) {
                    valid += 1;
                }
            }

            System.out.println(valid);
        } catch (IOException ex) {
            throw new RuntimeException("Error processing", ex);
        }
    }
}
