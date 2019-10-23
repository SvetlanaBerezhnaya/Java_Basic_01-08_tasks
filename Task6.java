package com.epam;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Task6 {
    private static String fileName = "C://Users/PC/IdeaProjects/Task6/Task6.xml";
    private static int tabIndex = 0;

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        tabIndex(fileName);
    }

    public static void tabIndex(String fileName) throws ParserConfigurationException, IOException, SAXException {
        File file = new File(fileName);
        if (file.exists()) {
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(fileName);
                doc.getDocumentElement().normalize();
                Node n = doc.getDocumentElement();
                parse(n);
                System.out.println("File tab-index is: " + tabIndex);
            } catch (Exception e) {
                e.getMessage();
            }
        } else {
            throw new FileNotFoundException("File " + fileName + " not found.");
        }
    }

    private static void parse(Node n) {
        if (n.hasChildNodes()) {
            tabIndex++;
            for (int i = 0; i < n.getChildNodes().getLength(); i++) {
                Node n2 = n.getChildNodes().item(i);
                if (n2.getNodeType() == Node.ELEMENT_NODE)
                    if (n2.hasChildNodes() && n2.getChildNodes().getLength() > 0)
                        parse(n2);
            }
        }
    }
}