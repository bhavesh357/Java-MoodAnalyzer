package com.bl.extension;

public class MoodAnalysisException extends Exception{
    public enum Error{
        MESSAGEEMPTY, MESSAGENULL
    }

    public MoodAnalysisException(Error error, String msg) {
        super(msg);
    }
}
