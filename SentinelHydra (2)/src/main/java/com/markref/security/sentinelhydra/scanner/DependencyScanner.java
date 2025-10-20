package com.markref.security.sentinelhydra.scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class DependencyScanner implements Runnable {

    private final File pomFile;
    private final List<String> trustedRepos = Arrays.asList("central", "jcenter", "maven.google.com");

    public DependencyScanner(String pomPath) {
        this.pomFile = new File(pomPath);
    }

    @Override
    public void run() {
        while (true) {
            try {
                scanPom();
                Thread.sleep(10000);
            } catch (Exception e) {
                System.out.println("Scanner error: " + e.getMessage());
            }
        }
    }

    private void scanPom() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(pomFile);
        doc.getDocumentElement().normalize();

        NodeList dependencies = doc.getElementsByTagName("dependency");
        for (int i = 0; i < dependencies.getLength(); i++) {
            Node dep = dependencies.item(i);
            if(dep.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) dep;
                String groupId = getText(element, "groupId");
                String artifactId = getText(element, "artifactId");

                if (groupId.contains("suspicious") || artifactId.contains("hacker")) {
                    System.out.println("[ALERT] Suspicious dependency detected: " +
                            groupId + ":" + artifactId);
                }
            }
        }
    }

    private String getText(Element element, String tag) {
        NodeList list = element.getElementsByTagName(tag);
        return list.getLength() > 0 ? list.item(0).getTextContent() : "";
    }
}