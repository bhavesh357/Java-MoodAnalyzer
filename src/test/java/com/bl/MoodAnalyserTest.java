package com.bl;

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
        Assert.assertEquals("SAD",moodAnalyser.analyzeMood("I am in Sad Mood"));
    }
    @Test
    public void whenGivenMessage_WhenAny_ReturnsHappy() {
        Assert.assertEquals("HAPPY",moodAnalyser.analyzeMood("I am in Any Mood"));
    }
}
