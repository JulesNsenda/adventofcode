/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.myic.day.three;

import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import tech.myic.day.three.part.one.Driver;

/**
 *
 * @author jules
 */
public class DriverTest {

    public DriverTest() {
    }

    @Test
    public void testGetNumberOfTrees() throws IOException {
        System.out.println("getNumberOfTrees");
        List<String> inputsData = Utils.getInputDataList("day-three-test.txt");
        int expResult = 7;
        int result = Driver.getNumberOfTrees(inputsData);
        assertEquals(expResult, result);
    }

}
