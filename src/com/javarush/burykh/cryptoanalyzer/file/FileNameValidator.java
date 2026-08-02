package com.javarush.burykh.cryptoanalyzer.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileNameValidator {

    public void validateForWriting(String fileName) {
        Path path = validatePath(fileName);
        if(Files.exists(path)) {
            if(Files.isDirectory(path)) {
//               throw new FileManagementExeption("File " + path + " is Directory");
            }

            if(!Files.isWritable(path)) {
//                throw new FileManagementExeption("File " + path + " is not accessible for writing");
            }
        }
    }

    public void validateForReading(String fileName) {
        Path path = validatePath(fileName);
        if(Files.notExists(path)) {
//            throw new FileManagementExeption("File " + path + " doesn't exist");
        }

        if(Files.isDirectory(path)) {
//            throw new FileManagementExeption("File " + path + " is Directory");
        }

        if(!Files.isReadable(path)) {
//            throw new FileManagementExeption("You don't have right to read from file: " + path);
        }
    }

    private Path validatePath(String fileName) {
        try {
            Path path = Path.of(fileName);
            return path;
        } catch (InvalidPathException e) {
//            throw new FileManagementExeption("Invalid path.Reason: " + e.getMessage(), e);
            return null;
        }
    }
}
