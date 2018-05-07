package com.formation.app;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testAppConstructor() {
        try {
            new App();
        } catch (Exception e) {
            Assert.fail("Construction failed.");
        }
    }

    @Test
    public void testAppMain() {
        App.main(null);
        try {
            Assert.assertEquals("Hello World!" + System.getProperty("line.separator"), outContent.toString());
        } catch (AssertionError e) {
            Assert.fail("\"message\" is not \"Hello World!\"");
        }
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

}
