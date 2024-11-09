package SpellCheck;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SpellCheckTreeSet {

    public static void main(String[] args) throws FileNotFoundException {
        Set<String> dictionaryOfWords = readDictionary("SpellCheck/words_alpha.txt");
        Set<String> document = readWords("SpellCheck/The-End.txt");
        int numMisspelledWords = 0;

        for (String word : document) {
            if (!dictionaryOfWords.contains(word)) {
                numMisspelledWords++;
            }
        }
        System.out.println("Number of misspelled words: " + numMisspelledWords);
    }

    private static Set<String> readDictionary(String filename) throws FileNotFoundException {
        Scanner inScan = new Scanner(new File(filename));

        inScan.useDelimiter("[^a-zA-Z]+");
        Set<String> words = new TreeSet<String>();
        while (inScan.hasNext()) {
            words.add(inScan.next().toLowerCase());
        }
        inScan.close();
        return words;
    }

    private static Set<String> readWords(String filename) throws FileNotFoundException {
        Set<String> words = new HashSet<String>();
        Scanner inScan = new Scanner(new File(filename));

        inScan.useDelimiter("[^a-zA-Z]+");
        while (inScan.hasNext()) {
            words.add(inScan.next().toLowerCase());
        }
        inScan.close();
        return words;
    }
}
