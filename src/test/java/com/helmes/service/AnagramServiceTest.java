package com.helmes.service;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnagramServiceTest {

    private AnagramService anagramService = new AnagramService();
    private static String[] dictionary;

    private static final String DICTIONARY_PATH = "pldf-win.txt";

    @BeforeClass
    public static void init() {
        InputStream resourceStream = ClassLoader.getSystemClassLoader().getResourceAsStream(DICTIONARY_PATH);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resourceStream, "windows-1251"))) {
            dictionary = br.lines().toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void collectAnagramsTest() {
        String word = "торт";
        Collection actualValues = anagramService.collectAnagrams(dictionary, word);
        assertFalse("Анаграммы не найдены!", actualValues.isEmpty());
    }

    @Test
    public void collectAnagramsEmptyTest() {
        String word = "Хочу ULTIMATE EARS BOOM 2";
        Collection actualValues = anagramService.collectAnagrams(dictionary, word);
        assertTrue("Анаграммы найдены!", actualValues.isEmpty());
    }
}