package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HelloWorldTest {
    @Test
    public void testGetMessage() {
        HelloWorld hw = new HelloWorld();
        assertEquals("Hello, World!", hw.getMessage());
    }
}
