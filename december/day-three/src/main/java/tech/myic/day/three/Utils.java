package tech.myic.day.three;

import tech.myic.day.three.part.one.Driver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    private Utils() {
    }

    public static List<String> getInputDataList(String filename) throws IOException {
        List<String> list = new ArrayList<>();
        try (InputStream in = Driver.class.getResourceAsStream("/".concat(filename))) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
                String line;
                while ((line = br.readLine()) != null) {
                    list.add(line);
                }
            }
        }
        return list;
    }

}
