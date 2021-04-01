package com.company.shortener;

public class Shortener {
    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private StorageManager storage;
    private Encoder encoder;
    private Decoder decoder;

    public Shortener(StorageManager storage) {
        this.storage = storage;
        //Ensure to use the same alphabet for encoder and decoder
        encoder = new Encoder(ALPHABET);
        decoder = new Decoder(ALPHABET);
    }

    public String encode(String originalURL) {
        return encoder.encode(originalURL, storage);
    }

    public String decode(String shortURL) {
        return decoder.decode(shortURL, storage);
    }
}
