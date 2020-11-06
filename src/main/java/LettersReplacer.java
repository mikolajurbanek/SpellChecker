import java.util.ArrayList;


public class LettersReplacer {


    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
    ArrayList<String> letterReplacedCharWords = new ArrayList<>();


    public ArrayList<String> letterReplacer(String word) {

        char[] theWord = word.toCharArray();
        char[] newWord = new char[theWord.length];

        for (char c : alphabet) {
            for (int j = 0; j < newWord.length; j++) {  //loop for replace each letter
                for (int i = 0; i < theWord.length; i++) {  //loop for iterating through old word
                    if (i == j) {
                        newWord[i] = c;
                    } else {
                        newWord[i] = theWord[i];
                    }

                }
                letterReplacedCharWords.add(new String(newWord));

            }


        }
//        for (String w : letterReplacedCharWords) {
//            System.out.println(w);
//
//        }
        return letterReplacedCharWords;
    }


}




