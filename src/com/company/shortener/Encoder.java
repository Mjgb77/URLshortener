package com.company.shortener;


public class Encoder extends Coder {

    public Encoder(String alphabet) {
        super(alphabet);
    }

    private String idToShortURL(int n) {
        if (n < 0) return null;
        StringBuilder shortURL = new StringBuilder();
        if (n == 0) return String.valueOf(ALPHABET.charAt(0));
        while (n > 0) {
            shortURL.append(ALPHABET.charAt(n % ALPHABET_SZ));
            n /= ALPHABET_SZ;
        }
        return shortURL.reverse().toString();
    }

    public String encode(String URL, StorageManager storage) {
        int id = storage.hasURL(URL) ?
                storage.getID(URL) : storage.pushURL(URL);
        return idToShortURL(id);
    }

}
