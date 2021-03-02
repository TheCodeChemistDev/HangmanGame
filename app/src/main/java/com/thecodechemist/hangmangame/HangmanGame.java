package com.thecodechemist.hangmangame;

import java.util.Dictionary;
import java.util.HashMap;

public class HangmanGame {


    public int gameStatus = 1;
    public int remainingGuesses = 10;
    public HashMap<Character, Boolean> lettersGuessed = new HashMap<>();

    public HangmanGame() {
        lettersGuessed.put('a', false);
        lettersGuessed.put('b', false);
        lettersGuessed.put('c', false);
        lettersGuessed.put('d', false);
        lettersGuessed.put('e', false);
        lettersGuessed.put('f', false);
        lettersGuessed.put('g', false);
        lettersGuessed.put('h', false);
        lettersGuessed.put('i', false);
        lettersGuessed.put('j', false);
        lettersGuessed.put('k', false);
        lettersGuessed.put('l', false);
        lettersGuessed.put('m', false);
        lettersGuessed.put('n', false);
        lettersGuessed.put('o', false);
        lettersGuessed.put('p', false);
        lettersGuessed.put('q', false);
        lettersGuessed.put('r', false);
        lettersGuessed.put('s', false);
        lettersGuessed.put('t', false);
        lettersGuessed.put('u', false);
        lettersGuessed.put('v', false);
        lettersGuessed.put('w', false);
        lettersGuessed.put('x', false);
        lettersGuessed.put('y', false);
        lettersGuessed.put('z', false);
    }
    public String getNewWord() {
        return "word";
    }

    public String getNewWord(int wordLength) {

        switch(wordLength) {
            case 5:
                return "bacon";
            case 6:
                return "runner";
            case 7:
                return "laughed";
            case 8:
                return "switched";
            case 9:
                return "steadings";
            case 10:
                return "incredible";
            default:
                return "";
        }
    }

    public String createClue(String word) {
        int wordLength = word.length();
        String clue = "";
        for(int i = 0; i < wordLength; i++) {
            clue += "-";
        }
        return  clue;
    }

    public String createClue(String word, String clue, char guess) {

        //Check if the letter has already been guessed
        if(lettersGuessed.get(guess) == true) {
            return clue;
        }

        //Mark the letter as having been guessed
        lettersGuessed.put(guess, true);

        //Loop through the characters of the word replace any dashes in the clue with correctly
        //guessed answers
        String newClue = "";
        for(int i = 0; i < word.length(); i++) {
            if(guess == word.charAt(i)) {
                newClue += word.charAt(i);
            } else {
                newClue += clue.charAt(i);
            }
        }

        //Decrease the remaining guesses if the guess was incorrect
        if(newClue.equals(clue)) {
            this.remainingGuesses = this.remainingGuesses - 1;
        }

        //End the game is the user wins or loses
        if(newClue.equals(word)) {
            //Winner
            this.gameStatus = 0;
        } else if(remainingGuesses == 0) {
            //Loser
            this.gameStatus = 0;
        }


        return newClue;
    }

    public void setGameStatus(int i) {
        this.gameStatus = i;
    }

    public int getGameStatus() {
        int gameStatus = this.gameStatus;
        return gameStatus;
    }

    public int getRemainingGuesses() {
        int remainingGuesses = this.remainingGuesses;
        return remainingGuesses;
    }

    public void setRemainingGuesses(int i) {
        this.remainingGuesses = i;
    }
}
