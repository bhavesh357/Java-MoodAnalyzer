package com.bl;

import com.bl.extension.MoodAnalysisException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static Object createObject(String message) {
        return createObject("com.bl.MoodAnalyser",message);
    }

    public static Object createObject(String className, String message) {
        Object myObj = null;
        try {
            Class<?> objClass = Class.forName(className);
            Constructor<?> constructor = objClass.getConstructor(String.class);
            myObj = constructor.newInstance(message);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.Error.CLASSWRONG,"No Such Class Error");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return myObj;
    }
}
