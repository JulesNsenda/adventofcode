package za.co.virtualpostman.vp.server.plugins.custom.day.one.part.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args) throws IOException {
        List<Integer> inputs = getListOfInputs();
        int product = getProduct(inputs);
        System.out.println("Product: " + product);
    }

    private static int getProduct(List<Integer> inputs) {
        int product = 0;
        for (int i = 0; i < inputs.size() - 1; i++) {
            int entry = inputs.get(i);
            for (int j = i + 1; j < inputs.size() - 1; j++) {
                int nextEntry = inputs.get(j);
                int sum = entry + nextEntry;
                if (sum == 2020) {
                    product = entry * nextEntry;
                    break;
                }
            }
        }
        return product;
    }

    private static List<Integer> getListOfInputs() throws IOException {
        List<Integer> list = new ArrayList<>();
        try (InputStream in = Driver.class.getResourceAsStream("/day-one-input.csv")) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
                String l;
                while ((l = br.readLine()) != null) {
                    list.add(Integer.valueOf(l));
                }
            }
        }
        return list;
    }

}
