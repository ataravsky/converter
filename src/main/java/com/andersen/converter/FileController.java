package com.andersen.converter;

import org.jdom2.JDOMException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class FileController {


    @GetMapping("/")
    public String getFileUploadPage () {
        return "fileUpload";
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam("format") String format,
                                   Model model) throws IOException, JDOMException {
        String toJson = "C:\\toJson.txt";
        String toXml = "C:\\toXml.txt";
        if (!file.isEmpty() && format.equalsIgnoreCase("json")) {
            Converter.jsonToXml(file, toXml);
            model.addAttribute("message","Файл успешно сконвертирован");
        } else if (!file.isEmpty() && format.equalsIgnoreCase("xml")) {
            Converter.xmlToJson(file, toJson);
            model.addAttribute("message","Файл успешно сконвертирован");
        }
        return "fileUpload";
    }
}
