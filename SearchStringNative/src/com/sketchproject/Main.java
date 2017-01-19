package com.sketchproject;

public class Main {

    public static void main(String[] args) {
        String sentence = "PHIL DROPPED HIS PHONE";
        String query = "drop";
        System.out.println(search(query, sentence));
    }

    public static boolean search(String keyword, String content) {
        keyword = keyword.toLowerCase();
        content = content.toLowerCase();

        if (keyword.length() > 0 && content.length() >= keyword.length()) {
            for (int i = 0; i < content.length() - keyword.length(); i++) {
                int startMatch = i;
                int charMatch = 0;
                for (int j = 0; j < keyword.length(); j++) {
                    if (content.charAt(startMatch) == keyword.charAt(j)) {
                        startMatch++;
                        charMatch++;
                    } else {
                        break;
                    }
                }
                if(charMatch == keyword.length()){
                    return true;
                }
            }
        }
        return false;
    }
}
