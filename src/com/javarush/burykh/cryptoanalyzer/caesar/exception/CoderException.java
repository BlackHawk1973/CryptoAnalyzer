package com.javarush.burykh.cryptoanalyzer.caesar.exception;

public class CoderException extends RuntimeException {
    String reason;

    public CoderException(String reason)
    {
        this.reason = reason;
    }

    public CoderException(String reason, Throwable cause) {
        super(cause);
        this.reason = reason;
    }

    public String getMessage() {
        return reason;
    }
}
