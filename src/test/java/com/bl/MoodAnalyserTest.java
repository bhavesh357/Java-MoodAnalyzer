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
        Assert.assertEquals("SAD",moodAnalyser.analyseMood(Message.SAD_MESSAGE));
    }
    @Test
    public void whenGivenMessage_WhenAny_ReturnsHappy() {
        Assert.assertEquals("HAPPY",moodAnalyser.analyseMood(Message.ANY_MESSAGE));
    }

    @Test
    public void whenGivenMessageInConstructor_WhenSad_ReturnsSad(){
        moodAnalyser = new MoodAnalyser(Message.SAD_MESSAGE);
        Assert.assertEquals("SAD",moodAnalyser.analyseMood());
    }


    @Test
    public void whenGivenMessageInConstructor_WhenSHappy_ReturnsHappy(){
        moodAnalyser = new MoodAnalyser(Message.ANY_MESSAGE);
        Assert.assertEquals("HAPPY",moodAnalyser.analyseMood());
    }

    @Test
    public void whenGivenNull_ShouldReturnExceptionMessage(){
        try{
            moodAnalyser = new MoodAnalyser(null);
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(Message.NULL_MESSAGE, e.getMessage());
        }
    }
    @Test
    public void whenGivenEmpty_ShouldReturnExceptionMessage(){
        try{
            moodAnalyser = new MoodAnalyser("");
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(Message.Empty_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyserMessage_WhenProper_ShouldReturnObject() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(Message.SAD_MESSAGE);
        Object result = MoodAnalyserFactory.createObject(Message.SAD_MESSAGE);
        Assert.assertEquals(moodAnalyser,result);
    }

    @Test
    public void givenClassName_WhenProper_ShouldReturnObject(){
        Object result = MoodAnalyserFactory.createObject("com.bl.MoodAnalyser",Message.SAD_MESSAGE);
        MoodAnalyser moodAnalyser = new MoodAnalyser(Message.SAD_MESSAGE);
        Assert.assertEquals(moodAnalyser,result);
    }

    @Test
    public void givenClassName_WhenImProper_ShouldReturnException(){
        try{
            Object result = MoodAnalyserFactory.createObject("com.bl.MoodAnalyzer",Message.SAD_MESSAGE);
            MoodAnalyser moodAnalyser = new MoodAnalyser(Message.SAD_MESSAGE);
            Assert.assertEquals(moodAnalyser,result);
        } catch (MoodAnalysisException e){
            Assert.assertEquals(Message.NO_CLASS_MESSAGE,e.getMessage());
        }
    }

    @Test
    public void givenMethodParameter_WhenProper_ShouldReturnException(){
            Object result = MoodAnalyserFactory.createObject("com.bl.MoodAnalyser",String.class,Message.SAD_MESSAGE);
            MoodAnalyser moodAnalyser = new MoodAnalyser(Message.SAD_MESSAGE);
            Assert.assertEquals(moodAnalyser,result);
    }

    @Test
    public void givenMethodParameter_WhenImProper_ShouldReturnException(){
        try {
            Object result = MoodAnalyserFactory.createObject("com.bl.MoodAnalyser", Integer.class, Message.SAD_MESSAGE);
        }catch(MoodAnalysisException e){
            Assert.assertEquals(Message.NO_METHOD_MESSAGE,e.getMessage());
        }
    }

    @Test
    public void givenMethodName_WhenProper_ShouldReturnMood() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object result = MoodAnalyserFactory.createObject("com.bl.MoodAnalyser",String.class,Message.HAPPY_MESSAGE);
        Object mood = MoodAnalyserFactory.callMethod(result,"analyseMood");
        Assert.assertEquals("HAPPY",mood);
    }
    @Test
    public void givenMethodName_WhenImProper_ShouldReturnMood(){
        Object result = MoodAnalyserFactory.createObject("com.bl.MoodAnalyser",String.class,Message.HAPPY_MESSAGE);
        try{
            Object mood = MoodAnalyserFactory.callMethod(result,"analyseMood");
        } catch(MoodAnalysisException e){
            Assert.assertEquals(Message.NO_METHOD_MESSAGE,e.getMessage());
        }
    }
    @Test
    public void givenVariableName_WhenProper_ShouldReturnMood() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object result = MoodAnalyserFactory.createObject("com.bl.MoodAnalyser",String.class,Message.SAD_MESSAGE);
        MoodAnalyserFactory.changeVariable(result,"message",Message.HAPPY_MESSAGE);
        Object mood = MoodAnalyserFactory.callMethod(result,"analyseMood");
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenVariableName_WhenImProper_ShouldReturnMood() {
        Object result = MoodAnalyserFactory.createObject("com.bl.MoodAnalyser",String.class,Message.SAD_MESSAGE);
        try{
            MoodAnalyserFactory.changeVariable(result,"mesage",Message.HAPPY_MESSAGE);
        }catch (MoodAnalysisException e) {
            Assert.assertEquals(Message.NO_FIELD_MESSAGE,e.getMessage());
        }
        Object mood = MoodAnalyserFactory.callMethod(result,"analyseMood");
    }

    @Test
    public void givenVariableName_WhenMessageNull_ShouldReturnMood() {
        Object result = MoodAnalyserFactory.createObject("com.bl.MoodAnalyser",String.class,Message.SAD_MESSAGE);
        try{
            MoodAnalyserFactory.changeVariable(result,"message",null);
            Object mood = MoodAnalyserFactory.callMethod(result,"analyseMood");
        }catch (MoodAnalysisException e) {
            Assert.assertEquals(Message.NULL_MESSAGE, e.getMessage());
        }
    }

}
