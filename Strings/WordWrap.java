package Strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordWrap {

    /**
     * Given a string and a width, wrap the string into multiple lines such that each line has width characters or less.
     *
     * @param text The maximum width of each line. Must be greater than 0.
     * @param width The maximum width of each line. Must be greater than 0.
     * @return List of strings, each string represents a line of text.
     */
    public List<String> wrap(String text, int width) {

        if (text == null || text.isEmpty()) {
            return List.of();
        }

        if (width <= 0) {
            throw new IllegalArgumentException("Width must be greater than 0");
        }

        List<String> words = List.of(text.split(" "));
        StringBuilder stringBuilder = new StringBuilder();
        List<String> wrapList = new ArrayList<>();

        for(String word : words){
            if(stringBuilder.length() + word.length() < width){
                stringBuilder.append(" ").append(word);
            } else {
                if(!stringBuilder.isEmpty()){
                    wrapList.add(stringBuilder.toString().trim());
                }

                stringBuilder = new StringBuilder();
                stringBuilder.append(word);
            }
        }

        if(!stringBuilder.isEmpty()){
            wrapList.add(stringBuilder.toString().trim());
        }

        return wrapList;
    }
}

class WordWrapTest {

    private WordWrap wordWrap;
    private int width = 15;

    @BeforeEach
    void setUp() {
        wordWrap = new WordWrap();
    }

    @Test
    void wrap() {
        final String text = "This is an example of a word wrap algorithm implementation";
        var wrapList = wordWrap.wrap(text, width);
        assertEquals(5, wrapList.size());
    }

    @Test
    void testEmptyText() {
        var wrapList = wordWrap.wrap("", width);
        assertEquals(0, wrapList.size());
    }

    @Test
    void testNullText() {
        var wrapList = wordWrap.wrap(null, width);
        assertEquals(0, wrapList.size());
    }

    @Test
    void testSingleLongWord() {
        String longWord = "Supercalifragilisticexpialidocious";
        var wrapList = wordWrap.wrap(longWord, 10);
        assertEquals(1, wrapList.size());
        assertEquals(longWord, wrapList.get(0));
    }

}
