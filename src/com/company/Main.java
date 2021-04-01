package com.company;

import com.company.shortener.LocalStorage;
import com.company.shortener.Shortener;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LocalStorage storage = new LocalStorage();
        Shortener shortener = new Shortener(storage);

        Scanner in = new Scanner(System.in);

        while (true) {
            String operation = in.next();
            if (operation.equals("finish")) {
                break;
            }

            if (operation.equals("encode")) {
                String value = in.next();

                System.out.println("Your shortened URL is: " + shortener.encode(value));
            } else if (operation.equals("decode")) {
                String value = in.next();
                String originalURL = shortener.decode(value);

                if (originalURL == null) System.out.println("You haven't shortened that url before");
                else System.out.println("Your original URL is: " + originalURL);
            } else {
                System.out.println("Invalid operation");
            }
        }
    }
}
