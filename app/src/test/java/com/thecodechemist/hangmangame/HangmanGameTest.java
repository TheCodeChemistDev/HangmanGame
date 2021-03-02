package com.thecodechemist.hangmangame;

import android.util.Log;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

import static org.junit.Assert.*;

public class HangmanGameTest {

    @Test
    public void test_getWord() {

        HangmanGame hangmanGame = new HangmanGame();
        String word = hangmanGame.getNewWord();

        assertEquals("word", word);
    }

    @Test
    public void test_getWordOfRandomLength() {
        Random random = new Random();
        int wordLength = random.nextInt(5) + 5;
        HangmanGame hangmanGame = new HangmanGame();
        String randomLengthWord = hangmanGame.getNewWord(wordLength);

        assertEquals(wordLength, randomLengthWord.length());
    }

    @Test
    public void test_createClue() {
        HangmanGame hangmanGame = new HangmanGame();
        String word = "word";
        String clue = hangmanGame.createClue(word);

        assertEquals("----", clue);
    }

    @Test
    public void test_createClueAfterFirstCorrectGuess() {
        HangmanGame hangmanGame = new HangmanGame();
        String word = "word";
        String clue = hangmanGame.createClue(word);
        clue = hangmanGame.createClue(word, clue, 'r');


        assertEquals("--r-", clue);
    }


    @Test
    public void test_createClueAfterIncorrectGuess() {
        HangmanGame hangmanGame = new HangmanGame();
        String word = "word";
        String clue = hangmanGame.createClue(word);
        clue = hangmanGame.createClue(word, clue, 'x');


        assertEquals("----", clue);
    }

    @Test
    public void test_createClueAfterSecondGuess() {
        HangmanGame hangmanGame = new HangmanGame();
        String word = "word";
        String clue = hangmanGame.createClue(word);
        clue = hangmanGame.createClue(word, clue, 'r');
        clue = hangmanGame.createClue(word, clue, 'w');

        assertEquals("w-r-", clue);
    }

    @Test
    public void test_winGame() {
        HangmanGame hangmanGame = new HangmanGame();
        String word = "word";
        String clue = hangmanGame.createClue(word);
        clue = hangmanGame.createClue(word, clue, 'r');
        clue = hangmanGame.createClue(word, clue, 'w');
        clue = hangmanGame.createClue(word, clue, 'o');
        clue = hangmanGame.createClue(word, clue, 'd');

        assertEquals(hangmanGame.getGameStatus(), 0);
    }

    @Test
    public void test_decreaseGuessesAfterIncorrectGuess() {
        HangmanGame hangmanGame = new HangmanGame();
        String word = "word";
        String clue = hangmanGame.createClue(word);
        clue = hangmanGame.createClue(word, clue, 'x');

        assertEquals(9, hangmanGame.getRemainingGuesses());

    }

    @Test
    public void test_loseGameWhenRemainingGuessesEqualsZero() {
        HangmanGame hangmanGame = new HangmanGame();
        String word = "word";
        String clue = hangmanGame.createClue(word);
        clue = hangmanGame.createClue(word, clue, 'a');
        clue = hangmanGame.createClue(word, clue, 'b');
        clue = hangmanGame.createClue(word, clue, 'c');
        clue = hangmanGame.createClue(word, clue, 'e');
        clue = hangmanGame.createClue(word, clue, 'f');
        clue = hangmanGame.createClue(word, clue, 'g');
        clue = hangmanGame.createClue(word, clue, 'h');
        clue = hangmanGame.createClue(word, clue, 'i');
        clue = hangmanGame.createClue(word, clue, 'j');
        clue = hangmanGame.createClue(word, clue, 'k');

        assertEquals(hangmanGame.getGameStatus(), 0);


    }

    @Test
    public void test_remainingGuessesAfterRepeatingLetter() {
        HangmanGame hangmanGame = new HangmanGame();
        String word = "word";
        String clue = hangmanGame.createClue(word);
        clue = hangmanGame.createClue(word, clue, 'a');
        clue = hangmanGame.createClue(word, clue, 'a');

        assertEquals(hangmanGame.getRemainingGuesses(), 9);
    }

}