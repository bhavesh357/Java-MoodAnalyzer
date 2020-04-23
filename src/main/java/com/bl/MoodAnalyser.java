package com.bl;

import com.bl.extension.MoodAnalysisException;

public class MoodAnalyser {
    String message;

    public MoodAnalyser() {

    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood(String message) throws MoodAnalysisException {
        try{
            if(message.equals("")){
                throw new MoodAnalysisException(MoodAnalysisException.Error.MESSAGEEMPTY,"Message is Empty");
            }
            if(message.contains("Sad")){
                return "SAD";
            }else {
                return "HAPPY";
            }
        }catch (NullPointerException e){
            throw new MoodAnalysisException(MoodAnalysisException.Error.MESSAGENULL,"Message is Null");
        }
    }

    public String analyseMood() throws MoodAnalysisException {
        return this.analyseMood(message);
    }
}
