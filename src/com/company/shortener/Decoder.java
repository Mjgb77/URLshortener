package com.company.shortener;

public class Decoder extends Coder {

    public Decoder(String alphabet) {
        super(alphabet);
    }

    private int shortURLtoID(String shortURL) {
        int id = 0;
        for (char c : shortURL.toCharArray()) {
            if (posByToken.containsKey(c)) {
                id = id * ALPHABET_SZ + posByToken.get(c);
            }
        }
        return id;
    }

    public String decode(String shortURL, StorageManager storage) {
        int id = shortURLtoID(shortURL);
        if (storage.hasID(id)) {
            return storage.getFromID(id);
        } else return null;
    }
}
