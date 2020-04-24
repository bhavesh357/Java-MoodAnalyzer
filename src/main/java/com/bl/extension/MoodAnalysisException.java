package com.bl.extension;

public class MoodAnalysisException extends RuntimeException{
    public enum Error{
        MESSAGEEMPTY, MESSAGENULL,CLASSWRONG,METHODWRONG;
    }

    public MoodAnalysisException(Error error, String msg) {
        super(msg);
    }
}
