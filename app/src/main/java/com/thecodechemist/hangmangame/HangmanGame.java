package com.thecodechemist.hangmangame;

public class HangmanGame {


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

        String newClue = "";
        for(int i = 0; i < word.length(); i++) {
            if(guess == word.charAt(i)) {
                newClue += word.charAt(i);
            } else {
                newClue += clue.charAt(i);
            }
        }
        return newClue;
    }
}
