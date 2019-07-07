package com.helmes.service;

import java.util.*;

class AnagramService {
    Collection collectAnagrams(String[] dictionary, String searchAnagramsFor) {
        char[] originalArray = searchAnagramsFor.toCharArray();
        Arrays.sort(originalArray);
        int originalHash = calculateHashCode(originalArray);

        HashSet<String> set = new HashSet<>();
        for (String word : dictionary) {
            if (word.length() == originalArray.length && isAnagram(word, originalArray, originalHash)) {
                set.add(word);
            }
        }
        return set;
    }

    private boolean isAnagram(String wordFromDictionary, char[] original, int originalHash) {
        char[] arrayFromDictionary = wordFromDictionary.toCharArray();
        int hashFromDictionary = calculateHashCode(arrayFromDictionary);
        if (originalHash == hashFromDictionary) {
            Arrays.sort(arrayFromDictionary);
            return Arrays.equals(arrayFromDictionary, original);
        }
        return false;
    }

    private int calculateHashCode(char[] arrayFromDictionary) {
        int hashFromDictionary = 0;
        for (char c : arrayFromDictionary) {
            hashFromDictionary += (c % 32) * 32;
        }
        return hashFromDictionary;
    }

}