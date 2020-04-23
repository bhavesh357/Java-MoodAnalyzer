package com.bl;

import com.bl.extension.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    MoodAnalyser moodAnalyser;
    /*
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
    }*/

    @Test
    public void whenGivenMessage_WhenSad_ReturnsSad() throws MoodAnalysisException {
        moodAnalyser = new MoodAnalyser("I am in Sad Mood");
        Assert.assertEquals("SAD",moodAnalyser.analyseMood());
    }
    /*
    @Test
    public void whenNotGiveMessage_ReturnsSad() {
        moodAnalyser = new MoodAnalyser();
        Assert.assertEquals("SAD",moodAnalyser.analyseMood());
    }

     */

    @Test
    public void whenGivenMessage_WhenSHappy_ReturnsHappy() throws MoodAnalysisException {
        moodAnalyser = new MoodAnalyser("I am in Any Mood");
        Assert.assertEquals("HAPPY",moodAnalyser.analyseMood());
    }

    @Test
    public void whenNotGiveMessage_ReturnsHappy() throws MoodAnalysisException {
        moodAnalyser = new MoodAnalyser();
        Assert.assertEquals("HAPPY",moodAnalyser.analyseMood());
    }

    @Test
    public void whenGivenNull_ShouldReturnHappy() throws MoodAnalysisException {
        moodAnalyser = new MoodAnalyser(null);
        Assert.assertEquals("HAPPY",moodAnalyser.analyseMood());
    }
    @Test
    public void whenGivenNull_ShouldReturnExceptionMessage() throws MoodAnalysisException{
        try{
            moodAnalyser = new MoodAnalyser(null);
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Message is Null", e.getMessage());
        }
    }
}
