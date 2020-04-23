package com.bl;

import com.bl.extension.MoodAnalysisException;

public class MoodAnalyser {
    String message;

    public MoodAnalyser() {
        this("I am in Any Mood");
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() throws MoodAnalysisException {
        try{
            if(message.contains("Sad")){
                return "SAD";
            }else {
                return "HAPPY";
            }
        }catch (NullPointerException e){
            throw new MoodAnalysisException(MoodAnalysisException.Error.MESSAGENULL,"Message is Null");
        }
    }
}
