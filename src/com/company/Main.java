package com.company;

import com.company.shortener.InMemoryStorageManager;
import com.company.shortener.Shortener;
import com.company.shortener.ShortenerEncoder;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static void main(String[] args) {
        InMemoryStorageManager storage = new InMemoryStorageManager();
        ShortenerEncoder shortenerEncoder = new ShortenerEncoder(ALPHABET);
        Shortener shortener = new Shortener(storage, shortenerEncoder);

        Scanner in = new Scanner(System.in);

        while (true) {
            Optional<Operation> operation = Operation.getOperation(in.next());

            if (operation.isEmpty()) {
                System.out.println("Invalid operation");
            } else {
                switch (operation.get()) {
                    case FINISH:
                        return;
                    case SHORTEN:
                        System.out.println("Your shortened URL is: " + shortener.toShortURL(in.next()));
                        break;
                    case EXPAND:
                        String originalURL = shortener.toOriginalURL(in.next());

                        if (originalURL == null) System.out.println("You haven't shortened that url before");
                        else System.out.println("Your original URL is: " + originalURL);

                        break;
                }
            }
        }
    }
}
