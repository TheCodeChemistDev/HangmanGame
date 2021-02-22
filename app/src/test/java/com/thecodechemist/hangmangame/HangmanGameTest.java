package com.thecodechemist.hangmangame;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class HangmanGameTest {

    public static HangmanGame hangmanGame;

    @BeforeClass
    public static void setup() {
        hangmanGame = new HangmanGame();
    }

    @Test
    public void test_getWord() {

        String word = hangmanGame.getNewWord();

        assertEquals("word", word);
    }

    @Test
    public void test_getWordOfRandomLength() {
        Random random = new Random();
        int wordLength = random.nextInt(5) + 5;
        String word = hangmanGame.getNewWord(wordLength);

        assertEquals(wordLength, word.length());
    }



}