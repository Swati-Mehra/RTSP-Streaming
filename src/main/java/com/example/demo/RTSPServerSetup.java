package com.example.demo;

import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class RTSPServerSetup {

    public static void main(String[] args) {
        try {
            // Define the batch file path
            String batFilePath = "setup_rtsp.bat";
            
            // Ensure the batch file exists
            File batFile = new File(batFilePath);
            if (!batFile.exists()) {
                System.out.println("Batch file not found: " + batFilePath);
                return;
            }

            // Run the batch file
            ProcessBuilder processBuilder = new ProcessBuilder(batFilePath);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            
            // Capture and print the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            process.waitFor();
            System.out.println("RTSP server setup and streaming completed.");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Process was interrupted.");
        }
    }
}