package com.github.stscoundrel.riimut.dialects;

import java.util.HashMap;

import com.github.stscoundrel.riimut.Transform;

public class MedievalFuthork implements Dialect {
    static final HashMap<String, String> LETTERS_TO_RUNES = new HashMap<String, String>() {
        {
            put("a", "ᛆ");
            put("á", "ᛆ");
            put("b", "ᛒ");
            put("c", "ᚴ");
            put("d", "ᚦ");
            put("ð", "ᚦ");
            put("e", "ᚽ");
            put("é", "ᚽ");
            put("f", "ᚠ");
            put("g", "ᚵ");
            put("h", "ᚼ");
            put("i", "ᛁ");
            put("í", "ᛁ");
            put("j", "ᛁ");
            put("k", "ᚴ");
            put("l", "ᛚ");
            put("m", "ᛘ");
            put("n", "ᚿ");
            put("o", "ᚮ");
            put("ó", "ᚮ");
            put("ǫ", "ᚰ");
            put("p", "ᛕ");
            put("q", "ᚴ");
            put("r", "ᚱ");
            put("s", "ᛋ");
            put("t", "ᛏ");
            put("u", "ᚢ");
            put("ú", "ᚢ");
            put("ü", "ᚢ");
            put("v", "ᚠ");
            put("w", "ᚠ");
            put("x", "ᛋ");
            put("y", "ᛦ");
            put("ý", "ᛦ");
            put("z", "ᛋ");
            put("å", "ᚮ");
            put("ä", "ᛅ");
            put("æ", "ᛅ");
            put("œ", "ᚯ");
            put("ö", "ᚯ");
            put("ø", "ᚯ");
            put("þ", "ᚦ");
            put(" ", ":");
        }
    };

    static final HashMap<String, String> RUNES_TO_LETTERS = new HashMap<String, String>() {
        {
            put("ᚠ", "f");
            put("ᚢ", "u");
            put("ᚦ", "þ");
            put("ᚮ", "o");
            put("ᚱ", "r");
            put("ᚴ", "k");
            put("ᚼ", "h");
            put("ᚿ", "n");
            put("ᛁ", "i");
            put("ᛆ", "a");
            put("ᛌ", "s");
            put("ᛋ", "s");
            put("ᛐ", "t");
            put("ᛏ", "t");
            put("ᛒ", "b");
            put("ᛘ", "m");
            put("ᛚ", "l");
            put("ᛦ", "y");
            put(":", " ");

            // Sting diacritic secondary sounds.
            put("ᚯ", "ø");
            put("ᛅ", "æ");
            put("ᚰ", "ǫ");
            put("ᛕ", "ᴘ");
            put("ᚽ", "e");
            put("ᚵ", "g");
        }
    };

    public String lettersToRunes(String content) {
        return Transform.withDictionary(content, LETTERS_TO_RUNES);
    }

    public String runesToLetters(String content) {
        return Transform.withDictionary(content, RUNES_TO_LETTERS);
    }
}
