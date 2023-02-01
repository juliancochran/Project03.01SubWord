import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class SubWordFinder implements WordFinder    {
    private ArrayList<ArrayList<String>> dictionary;
    private String alpha = "abcdefghijklmnopqrstuvwxyz";

    public SubWordFinder()  {
        dictionary = new ArrayList<>();
        for(int i = 0; i < 26; i++)
            dictionary.add(new ArrayList<String>());
        populateDictionary();
    }

    /**
     * Populates the dictionary from the text file contents
     * The dictionary object should contain 26 buckets, each
     * bucket filled with an ArrayList<String>
     * The String objects in the buckets are sorted A-Z because
     * of the nature of the text file words.txt
     */
    @Override
    public void populateDictionary() {

    }

    // this code can be used elsewhere, this is just an example
    private void parseWord(String word) {
        String front = "", back = "";
        for(int i = 2; i < word.length()-2; i++)    {
            front = word.substring(0, i);
            back = word.substring(i);
        }
    }

    /**
     * Retrieve all SubWord objects from the dictionary.
     * A SubWord is defined as a word that can be split into two
     * words that are also found in the dictionary.  The words
     * MUST be split evenly, e.g. no unused characters.
     * For example, "baseball" is a SubWord because it contains
     * "base" and "ball" (no unused characters)
     * To do this, you must look through every word in the dictionary
     * to see if it is a SubWord object
     *
     * @return An ArrayList containing the SubWord objects
     * pulled from the file words.txt
     */
    @Override
    public ArrayList<SubWord> getSubWords() {
        return null;
    }

    /**
     * Look through the entire dictionary object to see if
     * word exists in dictionary
     *
     * @param word The item to be searched for in dictionary
     * @return true if word is in dictionary, false otherwise
     * NOTE: EFFICIENCY O(log N) vs O(N) IS A BIG DEAL HERE!!!
     * You MAY NOT use Collections.binarySearch() here; you must use
     * YOUR OWN DEFINITION of a binary search in order to receive
     * the credit as specified on the grading rubric.
     */
    @Override
    public boolean inDictionary(String word) {
        return Collections.binarySearch(dictionary.get(alpha.indexOf(word.substring(0,1))), word) >= 0;
    }
}
