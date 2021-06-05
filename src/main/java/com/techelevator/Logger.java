package com.techelevator;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Logger {

    public static void writeLog(String logMessage) {
        try(PrintWriter writer = new PrintWriter(new FileWriter("Log.txt", true))) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
            writer.println(dtf.format(LocalDateTime.now()) + " " + logMessage);
        } catch (IOException e) {
            System.out.println("Error writing to Log file");
        }
    }
}