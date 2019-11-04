package com.boot.learn.algorithm;

public class shorturl {
    // Function to generate a short url from integer ID
    public String idToShortURL(int n) {
        // Map to store 62 possible characters
        String map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String shortUrl = "";
        String reverShortUrl = "";

        // Convert given integer id to a base 62 number
        while (n != 0) {
            // use above map to store actual character
            // in short url
            shortUrl += map.charAt(n % 62);
            n = n / 62;
        }

        // Reverse shortURL to complete base conversion
        char[] charArr = shortUrl.toCharArray();
        for (int i = charArr.length - 1; i >= 0; i--) {
            reverShortUrl += charArr[i];
        }

        return reverShortUrl;
    }

    // Function to get integer ID back from a short url
    public int shortURLtoID(String shortURL) {
        int id = 0; // initialize result
        char[] shortArr = shortURL.toCharArray();

        // A simple base conversion logic
        for (int i = 0; i < shortArr.length; i++) {
            if ('a' <= shortArr[i] && shortArr[i] <= 'z')
                id = id * 62 + shortArr[i] - 'a';
            if ('A' <= shortArr[i] && shortArr[i] <= 'Z')
                id = id * 62 + shortArr[i] - 'A' + 26;
            if ('0' <= shortArr[i] && shortArr[i] <= '9')
                id = id * 62 + shortArr[i] - '0' + 52;
        }
        return id;
    }

    public static void main(String[] args) {
        int n = 12345;
        shorturl shorturl = new shorturl();
        String url = shorturl.idToShortURL(n);
        int id = shorturl.shortURLtoID(url);

        System.out.println(url);
        System.out.println(id);
    }
}
