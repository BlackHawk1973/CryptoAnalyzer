package com.javarush.burykh.cryptoanalyzer.file.exception;

public class FileManagerException extends RuntimeException {
    String reason;

    public FileManagerException(String reason) {
        this.reason = reason;
    }

    public FileManagerException(String reason, Throwable cause) {
        super(cause);
        this.reason = reason;
    }

    public String getMessage() {
        return reason;
    }
}
