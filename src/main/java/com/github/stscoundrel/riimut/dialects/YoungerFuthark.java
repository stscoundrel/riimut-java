package com.github.stscoundrel.riimut.dialects;

import java.util.HashMap;

import com.github.stscoundrel.riimut.Transform;

public class YoungerFuthark implements Dialect {
    static final HashMap<String, String> LETTERS_TO_RUNES = new HashMap<String, String>() {
        {
            put("a", "ᛅ");
            put("á", "ᛅ");
            put("b", "ᛒ");
            put("c", "ᛋ");
            put("d", "ᛏ");
            put("ð", "ᚦ");
            put("e", "ᛁ");
            put("é", "ᛁ");
            put("f", "ᚠ");
            put("g", "ᚴ");
            put("h", "ᚼ");
            put("i", "ᛁ");
            put("í", "ᛁ");
            put("j", "ᛁ");
            put("k", "ᚴ");
            put("l", "ᛚ");
            put("m", "ᛘ");
            put("n", "ᚾ");
            put("o", "ᚢ");
            put("ó", "ᚢ");
            put("p", "ᛒ");
            put("q", "ᚴ");
            put("r", "ᚱ");
            put("s", "ᛋ");
            put("t", "ᛏ");
            put("þ", "ᚦ");
            put("u", "ᚢ");
            put("ú", "ᚢ");
            put("v", "ᚢ");
            put("w", "ᚢ");
            put("x", "ᛋ");
            put("y", "ᚢ");
            put("ý", "ᚢ");
            put("z", "ᛋ");
            put("å", "ᚢ");
            put("ä", "ᛅ");
            put("æ", "ᛅ");
            put("ö", "ᚢ");
            put("ø", "ᚢ");
            put("ǫ", "ᚢ");
            put(" ", ":");
        }
    };

    static final HashMap<String, String> RUNES_TO_LETTERS = new HashMap<String, String>() {
        {
            put("ᚠ", "f");
            put("ᚢ", "u");
            put("ᚦ", "þ");
            put("ᚬ", "o");
            put("ᚱ", "r");
            put("ᚴ", "k");
            put("ᚼ", "h");
            put("ᚽ", "h");
            put("ᚾ", "n");
            put("ᚿ", "n");
            put("ᛁ", "i");
            put("ᛅ", "a");
            put("ᛆ", "a");
            put("ᛋ", "s");
            put("ᛌ", "s");
            put("ᛏ", "t");
            put("ᛐ", "t");
            put("ᛒ", "b");
            put("ᛘ", "m");
            put("ᛚ", "l");
            put("ᛦ", "R");
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
