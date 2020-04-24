package com.bl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyser createMoodAnalyser(String message) {
        Object myObj = null;
        try {
            Class<?> moodAnalyserClass = Class.forName("com.bl.MoodAnalyser");
            Constructor<?> constructor = moodAnalyserClass.getConstructor(String.class);
            myObj = constructor.newInstance(message);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return (MoodAnalyser) myObj;
    }
}
