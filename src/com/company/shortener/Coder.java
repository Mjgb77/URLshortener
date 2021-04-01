package com.company.shortener;

import java.util.HashMap;

class Coder {

    protected final String ALPHABET;
    protected final int ALPHABET_SZ;
    protected final HashMap<Character, Integer> posByToken;

    Coder(String alphabet) {
        ALPHABET = alphabet;
        ALPHABET_SZ = alphabet.length();
        posByToken = new HashMap<>();
        for (int i = 0; i < ALPHABET_SZ; i++) {
            posByToken.put(ALPHABET.charAt(i), i);
        }
    }
}
