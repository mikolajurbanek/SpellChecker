import java.util.ArrayList;

/**
 *
 * ICS 23 Summer 2004
 * Project #5: Lost for Words
 *
 * Implement your word checker here.  A word checker has two responsibilities:
 * given a word list, answer the questions "Is the word 'x' in the wordlist?"
 * and "What are some suggestions for the misspelled word 'x'?"
 *
 * WordChecker uses a class called WordList that I haven't provided the source
 * code for.  WordList has only one method that you'll ever need to call:
 *
 *     public boolean lookup(String word)
 *
 * which returns true if the given word is in the WordList and false if not.
 */

public class WordChecker
{
    /**
     * Constructor that initializes a new WordChecker with a given WordList.
     *
     * @param wordList Initial word list to check against.
     * @see WordList
     */
    WordList wordList;
    NewCharInWordPlacer newCharInWordPlacer = new NewCharInWordPlacer();
    SwitchAdjacentChars switchAdjacentChars = new SwitchAdjacentChars();
    DeletingCharacterFromWord deletingCharacterFromWord = new DeletingCharacterFromWord();
    LettersReplacer lettersReplacer = new LettersReplacer();

    public WordChecker(WordList wordList)
    {
        this.wordList = wordList;
    }


    /**
     * Returns true if the given word is in the WordList passed to the
     * constructor, false otherwise.
     *
     * @param word Word to chack against the internal word list
     * @return bollean indicating if the word was found or not.
     */
    public boolean wordExists(String word)
    {
        return wordList.lookup(word);
//        return true;
    }


    /**
     * Returns an ArrayList of Strings containing the suggestions for the
     * given word.  If there are no suggestions for the given word, an empty
     * ArrayList of Strings (not null!) should be returned.
     *
     * @param word String to check against
     * @return A list of plausible matches
     */
    public ArrayList getSuggestions(String word)
    {
        ArrayList<String> sugestions = new ArrayList<String>();
        sugestions.addAll(switchAdjacentChars.switchAdjacent(word));
        sugestions.addAll(newCharInWordPlacer.letterPlacer(word));
        sugestions.addAll(deletingCharacterFromWord.letterDeleter(word));
        sugestions.addAll(lettersReplacer.letterReplacer(word));
        return sugestions;

    }


}
