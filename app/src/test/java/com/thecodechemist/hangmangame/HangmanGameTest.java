package com.thecodechemist.hangmangame;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class HangmanGameTest {

    public static HangmanGame hangmanGame;
    public static Random random;

    @BeforeClass
    public static void setup() {
        hangmanGame = new HangmanGame();
        random = new Random();
    }

    @Test
    public void test_getWord() {

        String word = hangmanGame.getNewWord();

        assertEquals("word", word);
    }

    @Test
    public void test_getWordOfRandomLength() {
        int wordLength = random.nextInt(5) + 5;
        String word = hangmanGame.getNewWord(wordLength);

        assertEquals(wordLength, word.length());
    }

    @Test
    public void test_createClue() {
        String word = hangmanGame.getNewWord();
        String clue = hangmanGame.createClue(word);

        assertEquals("----", clue);
    }

    @Test
    public void test_createClueAfterFirstCorrectGuess() {
        String word = hangmanGame.getNewWord();
        String clue = hangmanGame.createClue(word);
        clue = hangmanGame.createClue(word, clue, 'r');


        assertEquals("--r-", clue);
    }

    @Test
    public void test_createClueAfterIncorrectGuess() {
        String word = hangmanGame.getNewWord();
        String clue = hangmanGame.createClue(word);
        clue = hangmanGame.createClue(word, clue, 'x');


        assertEquals("----", clue);
    }

    @Test
    public void test_createClueAfterSecondGuess() {
        String word = hangmanGame.getNewWord();
        String clue = hangmanGame.createClue(word);
        clue = hangmanGame.createClue(word, clue, 'r');
        clue = hangmanGame.createClue(word, clue, 'w');

        assertEquals("w-r-", clue);
    }


}