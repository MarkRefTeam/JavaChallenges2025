package com.markref.security;

import com.markref.security.controller.AntiHackSystem;
import com.markref.security.controller.PhishingSecurityController;
import com.markref.security.logging.ConsoleLogger;
import com.markref.security.logging.FileLogger;
import com.markref.security.logging.Logger;
import com.markref.security.security.PhishingDetector;
import com.markref.security.security.crypto.DataProtector;
import com.markref.security.sentinelhydra.scanner.DependencyScanner;
import com.markref.security.simulate.PhishingSimulator;
import com.markref.security.util.ConsoleColors;
import com.markref.security.util.Print;

public class Main {

    private static Logger consoleLogger;
    private static Logger fileLogger;
    private static PhishingDetector detector;
    private static PhishingSecurityController phishingController;
    private static PhishingSimulator simulator;
    private static AntiHackSystem antiHackSystem;
    private static HydraDefenseSystem hydraDefenseSystem;
    private static DataProtector dataProtector;

    public static void main(String[] args) {
        System.out.println(ConsoleColors.GREEN + "Hydra is starting..." + ConsoleColors.RESET);

        Print.section("BOOT / WIRING", ConsoleColors.CYAN);
        bootAndWire();

        Runtime.getRuntime().addShutdownHook(new Thread(() ->
                consoleLogger.log(ConsoleColors.YELLOW + "Hydra shutting down..." + ConsoleColors.RESET)
        ));

        Print.section("SCANNERS", ConsoleColors.BLUE);
        startScanners();

        Print.section("BRUTE FORCE SIM", ConsoleColors.PURPLE);
        runBruteForceDemo();

        Print.section("PHISHING SIM", ConsoleColors.YELLOW);
        runPhishingDemo();

        Print.section("ENCRYPT DEMO", ConsoleColors.GREEN);
        runEncryptDemo();

        Print.section("HYDRA HEADS REPORT", ConsoleColors.CYAN);
        hydraDefenseSystem.report();

        System.out.println(ConsoleColors.GREEN + "Hydra is up. Monitors active." + ConsoleColors.RESET);
    }

    // -----------------------------------------
    // Sections
    // -----------------------------------------

    private static void bootAndWire() {
        consoleLogger = new ConsoleLogger();
        fileLogger = new FileLogger("log.txt");

        detector = new PhishingDetector();
        phishingController = new PhishingSecurityController(detector, consoleLogger);
        simulator = new PhishingSimulator(phishingController);

        antiHackSystem = new AntiHackSystem();
        hydraDefenseSystem = new HydraDefenseSystem();

        try {
            dataProtector = new DataProtector();
        } catch (Exception e) {
            consoleLogger.log(ConsoleColors.RED + "Failed to initialize DataProtector: " + e.getMessage() + ConsoleColors.RESET);
            dataProtector = null;
        }
    }

    private static void startScanners() {
        DependencyScanner scanner = new DependencyScanner("pom.xml");
        Thread scannerThread = new Thread(scanner);
        scannerThread.setDaemon(true);
        scannerThread.start();
        consoleLogger.log("DependencyScanner started (daemon) on pom.xml");
    }

    private static void runBruteForceDemo() {
        String user = "mark";
        for (int i = 1; i <= 6; i++) {
            consoleLogger.log("Login attempt #" + i + " for user=" + user);
            antiHackSystem.recordFailedAttempt(user);
            if (antiHackSystem.isLocked(user)) {
                System.out.println(ConsoleColors.RED + user + " is LOCKED." + ConsoleColors.RESET);
                break;
            }
        }
    }

    private static void runPhishingDemo() {
        String phishingMessage = "Urgent! Click here to reset your password!";
        String normalMessage = "Hello, how are you today?";

        phishingController.checkMessage(phishingMessage);
        phishingController.checkMessage(normalMessage);

        simulator.simulatePhishing();
        simulator.simulateLegitimate();
    }

    private static void runEncryptDemo() {
        if (dataProtector == null) {
            System.out.println(ConsoleColors.YELLOW + "Encryption demo skipped (DataProtector unavailable)" + ConsoleColors.RESET);
            return;
        }
        String message = "That is a secret message";
        try {
            byte[] aad = "Hydra:v1".getBytes(java.nio.charset.StandardCharsets.UTF_8);

            String encrypted = dataProtector.encrypt(message, aad);
            String decrypted = dataProtector.decrypt(encrypted, aad);

            System.out.println("Original : " + message);
            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decrypted);
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED + "Encryption error: " + e.getMessage() + ConsoleColors.RESET);
            e.printStackTrace();
        }
    }


    static Thread installShutdownHook(Logger logger) {
        Thread t = new Thread(() ->
                logger.log(ConsoleColors.YELLOW + "Hydra shutting down..." + ConsoleColors.RESET)
        );
        Runtime.getRuntime().addShutdownHook(t);
        return t;
    }
}