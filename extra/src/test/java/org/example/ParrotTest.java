package org.example;


import org.example.Races.Parrot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParrotTest {

    @Test
    void parrotShouldLearnNewWordIfNotKnown() {
        List<String> tricks = new ArrayList<>();
        List<String> vocab = new ArrayList<>();
        Parrot parrot = new Parrot("Coco", 2, "sing", 0.5, "neutral", false, tricks, false, vocab);

        parrot.learnNewWord("banana");

        assertTrue(parrot.getVocabulary().contains("banana"));
    }

    @Test
    void parrotShouldSayRandomWordIfVocabularyNotEmpty() {
        List<String> tricks = new ArrayList<>();
        List<String> vocab = new ArrayList<>();
        vocab.add("hello");
        vocab.add("cracker");
        Parrot parrot = new Parrot("Polly", 3, "talk", 0.6, "happy", false, tricks, false, vocab);

        assertDoesNotThrow(() -> parrot.sayRandomWord());
    }

    @Test
    void parrotShouldStaySilentIfNoWordsKnown() {
        List<String> tricks = new ArrayList<>();
        List<String> vocab = new ArrayList<>();
        Parrot parrot = new Parrot("Chirpy", 1, "none", 0.3, "neutral", false, tricks, false, vocab);

        assertDoesNotThrow(() -> parrot.sayRandomWord());
    }
}

