package com.bl;

public class MoodAnalyser {
    String message;

    public MoodAnalyser() {
        this("I am in Sad Mood");
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyzeMood() {
        if(message.contains("Sad")){
            return "SAD";
        }else {
            return "";
        }
    }
}
