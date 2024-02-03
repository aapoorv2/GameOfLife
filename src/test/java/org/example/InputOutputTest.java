package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class InputOutputTest {
    @Test
    public void testGetRowInputFromTheUser() {
        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = InputOutput.instance().getRowInputFromTheUser();

        assertEquals(5, result);
    }

    @Test
    public void testGetColumnInputFromTheUser() {
        String input = "3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = InputOutput.instance().getColumnInputFromTheUser();

        assertEquals(3, result);
    }

    @Test
    public void testGetFillPercentageFromTheUser() {
        String input = "50\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = InputOutput.instance().getFillPercentageFromTheUser();

        assertEquals(50, result);
    }

}