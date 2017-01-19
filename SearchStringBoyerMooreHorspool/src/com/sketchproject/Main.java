package com.sketchproject;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String content = "We hold these truth to be self-evident";
        String search = "truth";

        /**
         * Build bad table contain values of skip when pattern
         * does not match with data
         */
        Map<Character, Integer> badTable = new HashMap<>();
        int defaultValue = search.length();
        for (int i = 0; i < search.length() - 1; i++) {
            badTable.put(search.charAt(i), search.length() - i - 1);
        }

        System.out.println(boyerMooreHorspool(search, content, badTable, defaultValue));
    }

    /**
     * Matching char from right to left of pattern and against with badTable (skip value table)
     *
     * @param pattern
     * @param text
     * @param badTable
     * @param defaultValue
     * @return
     */
    public static boolean boyerMooreHorspool(String pattern, String text, Map badTable, int defaultValue) {
        for (int i = pattern.length() - 1; i < text.length();) {
            int countMatch = 0;
            int startIndex = i;
            for (int j = pattern.length() - 1; j >= 0; j--) {
                if (pattern.charAt(j) == text.charAt(startIndex)) {
                    countMatch++;
                    startIndex--;
                } else {
                    int skip = (int) badTable.getOrDefault(text.charAt(startIndex), defaultValue);
                    i += skip; // -1 because the i iteration has subtracted by 1 before (in for)
                    break;
                }
            }
            if (countMatch == pattern.length()) {
                return true;
            }
        }
        return false;
    }
}
