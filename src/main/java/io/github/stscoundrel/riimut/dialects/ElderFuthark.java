package io.github.stscoundrel.riimut.dialects;

import java.util.HashMap;

import io.github.stscoundrel.riimut.Transform;

public class ElderFuthark implements Dialect {
    static final HashMap<String, String> LETTERS_TO_RUNES = new HashMap<String, String>() {
        {
            put("a", "ᚨ");
            put("á", "ᚨ");
            put("b", "ᛒ");
            put("c", "ᚲ");
            put("d", "ᛞ");
            put("ð", "ᚦ");
            put("e", "ᛖ");
            put("é", "ᛖ");
            put("f", "ᚠ");
            put("g", "ᚷ");
            put("h", "ᚻ");
            put("i", "ᛁ");
            put("í", "ᛁ");
            put("j", "ᛃ");
            put("k", "ᚲ");
            put("l", "ᛚ");
            put("m", "ᛗ");
            put("n", "ᚾ");
            put("ŋ", "ᛜ");
            put("o", "ᛟ");
            put("ó", "ᛟ");
            put("ǫ", "ᛟ");
            put("p", "ᛈ");
            put("q", "ᚲ");
            put("r", "ᚱ");
            put("s", "ᛋ");
            put("t", "ᛏ");
            put("u", "ᚢ");
            put("ú", "ᚢ");
            put("v", "ᚹ");
            put("w", "ᚹ");
            put("x", "ᛋ");
            put("y", "ᛁ");
            put("ý", "ᛁ");
            put("z", "ᛉ");
            put("å", "ᛟ");
            put("ä", "ᛇ");
            put("æ", "ᛇ");
            put("ö", "ᚢ");
            put("ø", "ᚢ");
            put("þ", "ᚦ");
            put(" ", ":");
        }
    };

    static final HashMap<String, String> RUNES_TO_LETTERS = new HashMap<String, String>() {
        {
            put("ᚠ", "f");
            put("ᚢ", "u");
            put("ᚦ", "þ");
            put("ᚨ", "a");
            put("ᚱ", "r");
            put("ᚲ", "k");
            put("ᚷ", "g");
            put("ᚹ", "w");
            put("ᚺ", "h");
            put("ᚻ", "h");
            put("ᚾ", "n");
            put("ᛁ", "i");
            put("ᛃ", "j");
            put("ᛇ", "ï");
            put("ᛈ", "p");
            put("ᛉ", "z");
            put("ᛊ", "s");
            put("ᛋ", "s");
            put("ᛏ", "t");
            put("ᛒ", "b");
            put("ᛖ", "e");
            put("ᛗ", "m");
            put("ᛚ", "l");
            put("ᛜ", "ŋ");
            put("ᛝ", "ŋ");
            put("ᛟ", "o");
            put("ᛞ", "d");
            put(":", " ");
        }
    };

    public String lettersToRunes(String content) {
        return Transform.withDictionary(content, LETTERS_TO_RUNES);
    }

    public String runesToLetters(String content) {
        return Transform.withDictionary(content, RUNES_TO_LETTERS);
    }
}
