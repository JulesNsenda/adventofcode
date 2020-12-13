package tech.myic.day.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import za.co.virtualpostman.vp.server.plugins.custom.day.one.part.one.Driver;

public class Utils {

    private Utils() {
    }

    public static List<Integer> getInputDataList(String fileName) throws IOException {
        List<Integer> list = new ArrayList<>();
        try (InputStream in = Driver.class.getResourceAsStream("/".concat(fileName))) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    list.add(Integer.valueOf(line));
                }
            }
        }
        return list;
    }

}
