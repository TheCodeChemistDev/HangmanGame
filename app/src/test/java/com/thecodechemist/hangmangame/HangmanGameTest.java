package com.thecodechemist.hangmangame;

import org.junit.Test;

import static org.junit.Assert.*;

public class HangmanGameTest {

    @Test
    public void test_getWord() {
        HangmanGame hangmanGame = new HangmanGame();
        String word = hangmanGame.getNewWord();

        assertEquals("word", word);
    }

}