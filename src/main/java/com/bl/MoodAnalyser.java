package com.bl;

public class MoodAnalyser {
    String message;

    public MoodAnalyser() {
        this("I am in Any Mood");
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() {
        try{
            if(message.contains("Sad")){
                return "SAD";
            }else {
                return "HAPPY";
            }
        }catch (NullPointerException e){
            return "HAPPY";
        }
    }
}
