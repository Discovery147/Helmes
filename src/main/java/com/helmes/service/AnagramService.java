package com.helmes.service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class AnagramService {
    Collection collectAnagrams(String[] dictionary, String searchAnagramsFor) {
        final String searchAnagramsFinalFor = searchAnagramsFor.toLowerCase();
        return Stream.of(dictionary)
                .parallel()
                .filter(word -> word.length() == searchAnagramsFor.length())
                .filter(word -> isAnagram(word.toLowerCase(), new StringBuilder(searchAnagramsFinalFor)))
                .collect(Collectors.toSet());
    }

    private boolean isAnagram(String wordFromDictionary, StringBuilder searchAnagramsFor) {
        for (Character sybmol : wordFromDictionary.toCharArray()) {
            int index = searchAnagramsFor.indexOf(String.valueOf(sybmol));
            if (index == -1) {
                return false;
            } else {
                searchAnagramsFor.deleteCharAt(index);
            }
        }
        return true;
    }
}