package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class LoggerTest {

    @Test
    public void writeLog() throws FileNotFoundException {
        Logger logger = new Logger();
        PrintWriter newPrintWriter = new PrintWriter("Log.txt");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        logger.writeLog("test");
        Assert.assertNotNull(newPrintWriter);
    }
}