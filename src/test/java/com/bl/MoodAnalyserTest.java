package com.bl;

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
    public void whenGivenMessage_WhenSad_ReturnsSad() {
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
    public void whenGivenMessage_WhenSHappy_ReturnsHappy() {
        moodAnalyser = new MoodAnalyser("I am in Any Mood");
        Assert.assertEquals("HAPPY",moodAnalyser.analyseMood());
    }

    @Test
    public void whenNotGiveMessage_ReturnsHappy() {
        moodAnalyser = new MoodAnalyser();
        Assert.assertEquals("HAPPY",moodAnalyser.analyseMood());
    }
}
