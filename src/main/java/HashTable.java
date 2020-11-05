import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * ICS 23 Summer 2004
 * Project #5: Lost for Words
 *
 * Implement your hash table here.  You are required to use the separate
 * chaining strategy that we discussed in lecture, meaning that collisions
 * are resolved by having each cell in the table be a linked list of all of
 * the strings that hashed to that cell.
 */

public class HashTable
{
    /**
     * The constructor is given a table size (i.e. how big to make the array)
     * and a StringHasher, which is used to hash the strings.
     *
     * @param tableSize number of elements in the hash array
     *        hasher    Object that creates the hash code for a string
     * @see StringHasher
     */
    String[] theArray;
    int arraySize;
    List<Integer> wordsFromFile = new ArrayList<>();
    StringHasher hasher;


    public HashTable(int tableSize, StringHasher hasher)
    {
        arraySize = tableSize;
        theArray = new String[tableSize];
        this.hasher = hasher;
        Arrays.fill(theArray, "-1");
    }


    public void hashFunction(){
        System.out.println("usage of hashfunc");

        for (int i = 0; i <arraySize; i++){

           Integer newElement = wordsFromFile.get(i);
//            theArray[newElement] = wordsFromFile.get(i);

        }

    }

    /**
     * Takes a string and adds it to the hash table, if it's not already
     * in the hash table.  If it is, this method has no effect.
     *
     * @param s String to add
     */
    public void add(String s)
    {
        int wordIndex = hasher.hash(s);
        while(theArray[wordIndex]!="-1"){
            wordIndex++;
        }


        theArray[wordIndex] = s;

    }


    /**
     * Takes a string and returns true if that string appears in the
     * hash table, false otherwise.
     *
     * @param wordToCheck String to look up
     */
    public boolean lookup(String wordToCheck)
    {
        int arrayIndexHash = hasher.hash(wordToCheck);
        while(theArray[arrayIndexHash] != "-1"){
            if(theArray[arrayIndexHash].equals(wordToCheck)){
                System.out.println(theArray[arrayIndexHash]);
                System.out.println( wordToCheck + " word was found at index " + String.valueOf(arrayIndexHash));
                return true;
            }
            ++arrayIndexHash;
        }

        return false;

    }


    /**
     * Takes a string and removes it from the hash table, if it
     * appears in the hash table.  If it doesn't, this method has no effect.
     *
     * @param s String to remove
     */
    public void remove(String s)
    {

    }
}
