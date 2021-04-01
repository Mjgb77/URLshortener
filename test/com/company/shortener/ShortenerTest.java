package com.company.shortener;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortenerTest {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    Shortener getShortener() {
        InMemoryStorageManager storage = new InMemoryStorageManager();
        ShortenerEncoder shortenerEncoder = new ShortenerEncoder(ALPHABET);
        return new Shortener(storage, shortenerEncoder);
    }

    @Test
    void toShortURL() {
        Shortener shortener = getShortener();
        String originalURL = "https://www.jetbrains.com/";
        String shortURL = shortener.toShortURL(originalURL);
        assertNotNull(shortURL);
    }

    @Test
    void toOriginalURL() {
        Shortener shortener = getShortener();
        // This shortened URL doesn't exists
        String shortURL = "notvis";
        String originalURL = shortener.toOriginalURL(shortURL);
        assertNull(originalURL);
    }

    @Test
    void fullConversionTest() {
        Shortener shortener = getShortener();
        String URLA = "https://www.jetbrains.com/";
        String URLB = "https://codeforces.com/";

        String shortA = shortener.toShortURL(URLA);
        String shortB = shortener.toShortURL(URLB);
        String shortC = shortener.toShortURL(URLA);

        assertEquals(URLA, shortener.toOriginalURL(shortA));
        assertEquals(URLB, shortener.toOriginalURL(shortB));

        // A previously shortened url keeps it conversion
        assertEquals(URLA, shortener.toOriginalURL(shortC));
    }
}