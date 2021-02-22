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
}
