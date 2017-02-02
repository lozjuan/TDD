import java.util.*;

import static java.util.Arrays.sort;

public class Anagram {

    public String word;

    public Anagram(String word) {
        this.word = word;
    }

    public List<String> match(List<String> words) {
        List<String> anagram = new ArrayList<>();
        for (String candidate : words) {
            String sortedWord = sort(candidate);
            if (sort(word).equals(sortedWord) && !word.equals(candidate.toLowerCase())){
                anagram.add(candidate);
            }
        }
        return anagram;
    }

    public static String sort(String word) {
        char[] sorted = word.toLowerCase().toCharArray();
        Arrays.sort(sorted);
        return new String(sorted);
    }

    public static void main(String[] args) {

    }
}
