package com.markref.security;

import com.markref.security.controller.PhishingSecurityController;
import com.markref.security.logging.ConsoleLogger;
import com.markref.security.logging.FileLogger;
import com.markref.security.logging.Logger;
import com.markref.security.security.PhishingDetector;
import com.markref.security.security.crypto.DataProtector;
import com.markref.security.simulate.PhishingSimulator;

public class Main {

    public static void main(String[] args) {
        //or throws Exception for encrypt/decrypt running!
        //but after It's everything fine you should use try/catch combine for success!

        try {
            DataProtector protector = new DataProtector();

            String message = "That is a secret message";
            String encrypted = protector.encrypt(message);
            String decrypted = protector.decrypt(encrypted);

            System.out.println("original: " + message);
            System.out.println("encrypted: " + encrypted);
            System.out.println("decrypted: " + decrypted);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("encrypted error happened!");
        }

        //instantiation:

        Logger logger = new ConsoleLogger();
        Logger consoleLogger = new ConsoleLogger();
        Logger fileLogger = new FileLogger("log.txt");
        PhishingDetector detector = new PhishingDetector();
        PhishingSecurityController controller = new PhishingSecurityController(detector, logger);
        PhishingSimulator simulator = new PhishingSimulator(controller);

        //Messages:

        consoleLogger.log("This is a message to the console.");
        fileLogger.log("This is a message to the file");

        String phishingMessage = "Urgent! Click here to reset your password!";
        String normalMessage = "Hello, how are you today?";

        //Logs:

        controller.checkMessage(phishingMessage);
        controller.checkMessage(normalMessage);

        simulator.simulatePhishing();
        simulator.simulateLegitimate();
    }
}
