package com.array;

public class pangram_sentence {
    public static void main(String[] args) {
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }
    public static boolean checkIfPangram(String sentence) {
        boolean[] seen = new boolean[26];
        for (char c : sentence.toCharArray()) {
            if (Character.isLowerCase(c)) {
                seen[c - 'a'] = true;
            }
        }
        for (boolean letter : seen) {
            if (!letter) {
                return false;
            }
        }
        return true;
    }
}
