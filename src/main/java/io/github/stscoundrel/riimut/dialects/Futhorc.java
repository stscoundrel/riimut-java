package io.github.stscoundrel.riimut.dialects;

import java.util.HashMap;

import io.github.stscoundrel.riimut.Transform;

public class Futhorc implements Dialect {
    static final HashMap<String, String> LETTERS_TO_RUNES = new HashMap<String, String>() {
        {
            put("a", "ᚪ");
            put("á", "ᚪ");
            put("b", "ᛒ");
            put("c", "ᚳ");
            put("d", "ᛞ");
            put("ð", "ᛞ");
            put("e", "ᛖ");
            put("é", "ᛖ");
            put("f", "ᚠ");
            put("g", "ᚷ");
            put("h", "ᚻ");
            put("i", "ᛁ");
            put("í", "ᛇ");
            put("ï", "ᛇ");
            put("ʒ", "ᛇ");
            put("j", "ᛡ");
            put("k", "ᚳ");
            put("l", "ᛚ");
            put("m", "ᛗ");
            put("n", "ᚾ");
            put("ŋ", "ᛝ");
            put("o", "ᚩ");
            put("ó", "ᚩ");
            put("ǫ", "ᚩ");
            put("p", "ᛈ");
            put("q", "ᚳ");
            put("r", "ᚱ");
            put("s", "ᛋ");
            put("t", "ᛏ");
            put("u", "ᚢ");
            put("ú", "ᚢ");
            put("v", "ᚹ");
            put("w", "ᚹ");
            put("x", "ᛉ");
            put("y", "ᚣ");
            put("ý", "ᚣ");
            put("z", "ᛉ");
            put("å", "ᚩ");
            put("ä", "ᚫ");
            put("æ", "ᚫ");
            put("œ", "ᛟ");
            put("ö", "ᛟ");
            put("ø", "ᛟ");
            put("þ", "ᚦ");
            put(" ", ":");
        }
    };

    static final HashMap<String, String> RUNES_TO_LETTERS = new HashMap<String, String>() {
        {
            put("ᚠ", "f");
            put("ᚢ", "u");
            put("ᚦ", "þ");
            put("ᚩ", "o");
            put("ᚱ", "r");
            put("ᚳ", "c");
            put("ᚷ", "g");
            put("ᚹ", "w");
            put("ᚻ", "h");
            put("ᚾ", "n");
            put("ᛁ", "i");
            put("ᛡ", "j");
            put("ᛄ", "j");
            put("ᛇ", "ï");
            put("ᛈ", "p");
            put("ᛉ", "x");
            put("ᛋ", "s");
            put("ᚴ", "s");
            put("ᛏ", "t");
            put("ᛒ", "b");
            put("ᛖ", "e");
            put("ᛗ", "m");
            put("ᛚ", "l");
            put("ᛝ", "ŋ");
            put("ᛟ", "œ");
            put("ᛞ", "d");
            put("ᚪ", "a");
            put("ᚫ", "æ");
            put("ᚣ", "y");
            put(":", " ");
            put("ᛠ", "ea");
        }
    };

    public String lettersToRunes(String content) {
        return Transform.withDictionary(content, LETTERS_TO_RUNES);
    }

    public String runesToLetters(String content) {
        return Transform.withDictionary(content, RUNES_TO_LETTERS);
    }
}
