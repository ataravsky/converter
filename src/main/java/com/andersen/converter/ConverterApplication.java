package com.andersen.converter;

import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@SpringBootApplication
public class ConverterApplication {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, JDOMException {
        SpringApplication.run(ConverterApplication.class, args);
    }

}
