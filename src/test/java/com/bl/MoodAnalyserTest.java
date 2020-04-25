package com.bl;

import com.bl.extension.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserTest {
    MoodAnalyser moodAnalyser;

    @Before
    public void initialize(){
        moodAnalyser = new MoodAnalyser();
    }

    @Test
    public void whenGivenMessage_WhenSad_ReturnsSad() {
        Assert.assertEquals("SAD",moodAnalyser.analyseMood("I am in Sad Mood"));
    }
    @Test
    public void whenGivenMessage_WhenAny_ReturnsHappy() {
        Assert.assertEquals("HAPPY",moodAnalyser.analyseMood("I am in Any Mood"));
    }

    @Test
    public void whenGivenMessageInConstructor_WhenSad_ReturnsSad(){
        moodAnalyser = new MoodAnalyser("I am in Sad Mood");
        Assert.assertEquals("SAD",moodAnalyser.analyseMood());
    }


    @Test
    public void whenGivenMessageInConstructor_WhenSHappy_ReturnsHappy(){
        moodAnalyser = new MoodAnalyser("I am in Any Mood");
        Assert.assertEquals("HAPPY",moodAnalyser.analyseMood());
    }

    @Test
    public void whenGivenNull_ShouldReturnExceptionMessage(){
        try{
            moodAnalyser = new MoodAnalyser(null);
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Message is Null", e.getMessage());
        }
    }
    @Test
    public void whenGivenEmpty_ShouldReturnExceptionMessage(){
        try{
            moodAnalyser = new MoodAnalyser("");
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Message is Empty", e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyserMessage_WhenProper_ShouldReturnObject() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Sad Mood");
        Object result = MoodAnalyserFactory.createObject("I am in Sad Mood");
        Assert.assertEquals(moodAnalyser,result);
    }

    @Test
    public void givenClassName_WhenProper_ShouldReturnObject(){
        Object result = MoodAnalyserFactory.createObject("com.bl.MoodAnalyser","I am in Sad Mood");
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Sad Mood");
        Assert.assertEquals(moodAnalyser,result);
    }

    @Test
    public void givenClassName_WhenImProper_ShouldReturnException(){
        try{
            Object result = MoodAnalyserFactory.createObject("com.bl.MoodAnalyzer","I am in Sad Mood");
            MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Sad Mood");
            Assert.assertEquals(moodAnalyser,result);
        } catch (MoodAnalysisException e){
            Assert.assertEquals("No Such Class Error",e.getMessage());
        }
    }

    @Test
    public void givenMethodParameter_WhenProper_ShouldReturnException(){
            Object result = MoodAnalyserFactory.createObject("com.bl.MoodAnalyser",String.class,"I am in Sad Mood");
            MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Sad Mood");
            Assert.assertEquals(moodAnalyser,result);
    }

    @Test
    public void givenMethodParameter_WhenImProper_ShouldReturnException(){
        try {
            Object result = MoodAnalyserFactory.createObject("com.bl.MoodAnalyser", Integer.class, "I am in Sad Mood");
        }catch(MoodAnalysisException e){
            Assert.assertEquals("No Such Method Error",e.getMessage());
        }
    }

    @Test
    public void givenMethodName_WhenProper_ShouldReturnMood() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object result = MoodAnalyserFactory.createObject("com.bl.MoodAnalyser",String.class,"I am in Happy Mood");
        Object mood = MoodAnalyserFactory.callMethod(result,"analyseMood");
        Assert.assertEquals("HAPPY",mood);
    }
    @Test
    public void givenMethodName_WhenImProper_ShouldReturnMood(){
        Object result = MoodAnalyserFactory.createObject("com.bl.MoodAnalyser",String.class,"I am in Happy Mood");
        try{
            Object mood = MoodAnalyserFactory.callMethod(result,"analyseMood");
        } catch(MoodAnalysisException e){
            Assert.assertEquals("No Such Method Error",e.getMessage());
        }
    }
    @Test
    public void givenVariableName_WhenProper_ShouldReturnMood() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object result = MoodAnalyserFactory.createObject("com.bl.MoodAnalyser",String.class,"I am in Sad Mood");
        MoodAnalyserFactory.changeVariable(result,"message","I am in Happy Mood");
        Object mood = MoodAnalyserFactory.callMethod(result,"analyseMood");
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenVariableName_WhenImProper_ShouldReturnMood() {
        Object result = MoodAnalyserFactory.createObject("com.bl.MoodAnalyser",String.class,"I am in Sad Mood");
        try{
            MoodAnalyserFactory.changeVariable(result,"mesage","I am in Happy Mood");
        }catch (MoodAnalysisException e) {
            Assert.assertEquals("No Such Field Error",e.getMessage());
        }
        Object mood = MoodAnalyserFactory.callMethod(result,"analyseMood");
    }

    @Test
    public void givenVariableName_WhenMessageNull_ShouldReturnMood() {
        Object result = MoodAnalyserFactory.createObject("com.bl.MoodAnalyser",String.class,"I am in Sad Mood");
        try{
            MoodAnalyserFactory.changeVariable(result,"message",null);
            Object mood = MoodAnalyserFactory.callMethod(result,"analyseMood");
        }catch (MoodAnalysisException e) {
            Assert.assertEquals("Message is Null", e.getMessage());
        }
    }

}
