package tech.myic.day.three.part.one;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import tech.myic.day.three.Utils;

public class Driver {

    public static void main(String[] args) {
        try {
            List<String> inputsData = Utils.getInputDataList("day-three-test.txt");
            int numberOfTrees = getNumberOfTrees(inputsData);
            System.out.println("Number of trees: " + numberOfTrees);
        } catch (IOException ex) {
            throw new RuntimeException("Error occured", ex);
        }

    }

    public static int getNumberOfTrees(List<String> inputsData) {
        List<String> newInputs = new ArrayList<>();
        int numberOfRows = inputsData.size();

        for (String oldLine : inputsData) {
            String newLine = "";
            for (int i = 0; i < numberOfRows; i++) {
                newLine = newLine.concat(oldLine);
            }
            newInputs.add(newLine);
        }

        int numberofTrees = 0;
        int position = 1;
        for (String newInput : newInputs) {
            char[] lineChars = newInput.toCharArray();
            for (int i = position; i <= lineChars.length; i++) {
                char val = lineChars[i];
                if (val == '#') {
                    numberofTrees += 1;
                }
                if (i == position) {
                    position = 3 + position;
                    break;
                }
            }
            position += 1;
        }
        return numberofTrees;
    }

  
}
