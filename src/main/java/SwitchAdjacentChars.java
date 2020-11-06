import java.util.ArrayList;

public class SwitchAdjacentChars {

    ArrayList<String> switchAdjacentCharsWords = new ArrayList<>();

    public ArrayList switchAdjacent(String word) {

        char[] theWord = word.toCharArray();
        char tempLetter;
        for (int i = 0; i < theWord.length -1; i++) {


            tempLetter = theWord[i];
            theWord[i] = theWord[i+1];
            theWord[i+1] = tempLetter;

            String newWord = new String(theWord);
            switchAdjacentCharsWords.add(newWord);
            theWord = word.toCharArray();
        }
        return switchAdjacentCharsWords;
    }
}
