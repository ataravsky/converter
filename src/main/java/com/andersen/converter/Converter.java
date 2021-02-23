package com.andersen.converter;

import jdk.nashorn.internal.parser.JSONParser;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.XMLFormatter;

@Service
public class Converter {

    public static void jsonToXml(MultipartFile file, String to) throws IOException, JDOMException {
        byte[] bytes = file.getBytes();
        String jsonStr = new String(bytes);
        JSONObject json = new JSONObject(jsonStr);

        try (FileWriter fileWriter = new FileWriter(to)){
            fileWriter.write(XML.toString(json));
        }
    }

    public static void xmlToJson(MultipartFile file, String to) throws IOException {
        byte[] bytes = file.getBytes();
        String xmlStr = new String(bytes);

        try (FileWriter fileWriter = new FileWriter(to)){
            fileWriter.write(String.valueOf(XML.toJSONObject(xmlStr)));
        }
    }
}
