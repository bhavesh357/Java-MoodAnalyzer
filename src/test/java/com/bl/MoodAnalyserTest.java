package com.bl;

import com.bl.extension.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void givenMoodAnalyserClassName_WhenProper_ShouldReturnObject() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Sad Mood");
        MoodAnalyser result = MoodAnalyserFactory.createMoodAnalyser("I am in Sad Mood");
        Assert.assertEquals(moodAnalyser,result);
    }
}
