package SugestionMethods;

import java.util.ArrayList;

public class NewCharInWordPlacer {

    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
    ArrayList<String> letterInsertedWords = new ArrayList<>();
    boolean isLetterInserted = false;

    public ArrayList<String> letterPlacer(String word) {

        char[] theWord = word.toCharArray();
        char[] newWord = new char[theWord.length+1];

        for (char c: alphabet) {
            for (int j = 0; j<newWord.length; j++) {  //loop for insertin in each place
                for (int i = 0; i<theWord.length; i++) {  //loop for iterating through old word
                    if(i==j){
                        newWord[i] = c;
                        newWord[i+1] = theWord[i];
                        isLetterInserted = true;
                    } else {
                        if(isLetterInserted) {
                            newWord[i+1] = theWord[i];
                        } else{
                            newWord[i] = theWord[i];
                        }
                    }
                    if(i==theWord.length-1 && isLetterInserted==false){
                        newWord[i+1]=c;
                    }

                }
                letterInsertedWords.add(new String(newWord));
                isLetterInserted = false;

            }

        }
//        for (String w: letterInsertedWords) {
//            System.out.println(w);
//
//        }

        return letterInsertedWords;
    }


}
