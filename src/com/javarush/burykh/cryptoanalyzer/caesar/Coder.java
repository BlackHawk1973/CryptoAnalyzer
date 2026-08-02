package com.javarush.burykh.cryptoanalyzer.caesar;

import com.javarush.burykh.cryptoanalyzer.file.FileManager;
import com.javarush.burykh.cryptoanalyzer.file.FileNameValidator;

import java.util.List;

public class Coder {
    private Cipher cipher;
    private FileNameValidator fileNameValidator;
    private FileManager fileManager;

    public Coder() {
        this.cipher = new Cipher();
        this.fileNameValidator = new FileNameValidator();
        this.fileManager = new FileManager();
    }

    public void encrypt (String inputFileName, String outputFileName, int shiftKey) {
        fileNameValidator.validateForReading(inputFileName);
        fileNameValidator.validateForWriting(outputFileName);

        List<String> source =  fileManager.readFile(inputFileName);
        for (String line : source) {
            String encriptLine = cipher.encript(line, shiftKey);
            fileManager.writeFile(encriptLine, outputFileName);
        }
    }

    public void decrypt (String inputFileName, String outputFileName, int shiftKey) {
        fileNameValidator.validateForReading(inputFileName);
        fileNameValidator.validateForWriting(outputFileName);

        List<String> source =  fileManager.readFile(inputFileName);
        for (String line : source) {
            String decriptLine = cipher.decript(line, shiftKey);
            fileManager.writeFile(decriptLine, outputFileName);
        }
    }
}
