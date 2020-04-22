package com.bl;

public class MoodAnalyser {

    public String analyzeMood(String message) {
        if(message.contains("Sad")){
            return "SAD";
        }else {
            return "";
        }
    }
}
