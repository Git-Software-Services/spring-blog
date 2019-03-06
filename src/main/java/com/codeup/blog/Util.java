package com.codeup.blog;

public class Util {
    public static String upperCasedTitle(String title) {
        StringBuilder result = new StringBuilder(title.length());
        String words[] = title.split("\\ ");
        for (int i = 0; i < words.length; i++) {
            result.append(Character.toUpperCase(words[i].charAt(0))).append(words[i].substring(1)).append(" ");
        }
        String newResult = result.toString();
        return newResult;
    }
}
