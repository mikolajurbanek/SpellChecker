import Hashers.StringHasher;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Checker {
    public Checker() {
    }
//    List<String> wordsFromFile = new ArrayList<>();

    public void check(String wordToCheck, String path, StringHasher checkMethod, PrintStream printStream) throws IOException {


        File myFile = new File(path);

        WordList wordList = new WordList(wordToCheck, myFile.getCanonicalPath(), checkMethod);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(myFile.getCanonicalPath()));
        String readLine = bufferedReader.readLine();
        int tableSize = Integer.parseInt(readLine);
        WordLineReader wordLineReader = new WordLineReader(readLine);
        WordChecker wordChecker = new WordChecker(wordList);
        ArrayList wordSuggestions = wordChecker.getSuggestions(wordToCheck);

//        label34:
//        for(WordChecker wordChecker = new WordChecker(wordList); readLine != null; wordLineReader = new WordLineReader(readLine)) {
//            while(true) {
//                ArrayList wordSuggestions;
//                do {
//                    String word;
//                    do {
//                        if (!wordLineReader.hasNextWord()) {
//                            readLine = bufferedReader.readLine();
//                            continue label34;
//                        }
//
//                        word = wordLineReader.nextWord().toUpperCase();
////                        System.out.println(word);
////                        wordsFromFile.add(word);
//                    } while(wordChecker.wordExists(word));
//
        if(!wordChecker.wordExists(wordToCheck)) {
            printStream.println();
            printStream.println("     word not found: " + wordToCheck);

//                } while(wordSuggestions.size() <= 0);

            Collections.sort(wordSuggestions);
            printStream.println("  perhaps you meant: ");
            Iterator iterator = wordSuggestions.iterator();

            while (iterator.hasNext()) {
                String potentialHint = (String) iterator.next();
                wordChecker.wordExists(potentialHint);
//                    printStream.println("          " + hint + " ");
            }
        }
//                for (Object w: wordSuggestions) {
//                    System.out.println("d" + w);
//                }
//            }
//        }


        bufferedReader.close();
    }
}