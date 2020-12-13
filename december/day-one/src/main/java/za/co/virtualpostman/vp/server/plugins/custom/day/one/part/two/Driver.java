package za.co.virtualpostman.vp.server.plugins.custom.day.one.part.two;

import java.io.IOException;
import java.util.List;
import tech.myic.day.one.Utils;

public class Driver {

    public static void main(String[] args) {
        List<Integer> inputs;
        try {
            inputs = Utils.getInputDataList("day-one-input.csv");
        } catch (IOException ex) {
            throw new RuntimeException("Error finding file", ex);
        }

        int product = getProduct(inputs);
        System.out.println("Product: " + product);
    }

    private static int getProduct(List<Integer> inputs) {
        int product = 0;
        for (int i = 0; i < inputs.size() - 1; i++) {
            int entry = inputs.get(i);
            for (int j = i + 1; j < inputs.size() - 1; j++) {
                int nextEntry = inputs.get(j);
                for (int k = j + 1; k < inputs.size() - 1; k++) {
                    int dNextEntry = inputs.get(k);
                    int sum = entry + nextEntry + dNextEntry;
                    if (sum == 2020) {
                        product = entry * nextEntry * dNextEntry;
                        break;
                    }
                }

            }
        }
        return product;
    }
}
