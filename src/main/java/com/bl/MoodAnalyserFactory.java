package com.bl;

import com.bl.extension.MoodAnalysisException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserFactory {
    public static Object createObject(String message) {
        return createObject("com.bl.MoodAnalyser",message);
    }

    public static Object createObject(String className, String message) {
        return createObject(className,String.class,message);
    }

    public static Object createObject(String className, Class<?> paraClass, String message) {
        Object myObj = null;
        try {
            Class<?> objClass = Class.forName(className);
            Constructor<?> constructor = objClass.getConstructor(paraClass);
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
            throw new MoodAnalysisException(MoodAnalysisException.Error.METHODWRONG,"No Such Method Error");
        }
        return myObj;
    }

    public static Object callMethod(Object result, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = result.getClass().getDeclaredMethod(methodName);
        return method.invoke(result);
    }
}
