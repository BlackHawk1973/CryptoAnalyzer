package com.javarush.burykh.cryptoanalyzer.file;

import com.javarush.burykh.cryptoanalyzer.file.exception.FileManagerException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileManager {
    public static final StandardOpenOption[] FILE_WRITE_OPTIONS =
            { StandardOpenOption.CREATE, StandardOpenOption.APPEND};


    public List<String> readFile(String fileName) {
        try {
            Path filepath = Path.of(fileName);
            return Files.readAllLines(filepath);
        } catch (IOException | InvalidPathException e) {
            throw new FileManagerException(e.getMessage(), e);
        }
    }

    public void writeFile(String content, String fileName) {
        try {
            Path filepath = Path.of(fileName);
            Files.writeString(filepath, content + System.lineSeparator(), FILE_WRITE_OPTIONS);
        }  catch (IOException e) {
            throw new FileManagerException(e.getMessage(), e);
        }
    }
}
