import java.util.ArrayList;


public class DeletingCharacterFromWord {


    ArrayList<String> letterDeletedCharWords = new ArrayList<>();


    public ArrayList<String> letterDeleter(String word){

        char[] theWord = word.toCharArray();
        char[] newWord = new char[theWord.length];


        for (int j=0; j<newWord.length; j++) {  //loop for deleting each place
            for (int i = 0; i<theWord.length; i++) {  //loop for iterating through old word
                if(i==j){
                    newWord[i] = ' ';
                }
                else {
                    newWord[i] = theWord[i];
                }

            }
            letterDeletedCharWords.add(new String(newWord).replaceAll("\\s", ""));

        }

//        for (String w: letterDeletedCharWords) {
//            System.out.println(w);
//
//        }

        return letterDeletedCharWords;
    }


}


