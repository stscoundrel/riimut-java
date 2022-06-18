package io.github.stscoundrel.riimut.dialects;

import java.util.HashMap;

import io.github.stscoundrel.riimut.Transform;

public class YoungerFuthark implements Dialect {
    enum Variant {
        LONG_BRANCH,
        SHORT_TWIG
    }

    public YoungerFuthark() {
        runeStyle = Variant.LONG_BRANCH;
    }

    public YoungerFuthark(Variant style) {
        runeStyle = style;
    }

    private Variant runeStyle;

    private void setVariant(Variant variant) {
        runeStyle = variant;
    }

    public void useLongBranch() {
        setVariant(Variant.LONG_BRANCH);
    }

    public void useShortTwig() {
        setVariant(Variant.SHORT_TWIG);
    }

    static final HashMap<String, String> LETTERS_TO_LONG_BRANCH_RUNES = new HashMap<String, String>() {
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

    static final HashMap<String, String> LETTERS_TO_SHORT_TWIG_RUNES = new HashMap<String, String>() {
        {
            put("a", "ᛆ");
            put("á", "ᛆ");
            put("b", "ᛒ");
            put("c", "ᛌ");
            put("d", "ᛐ");
            put("ð", "ᚦ");
            put("e", "ᛁ");
            put("é", "ᛁ");
            put("f", "ᚠ");
            put("g", "ᚴ");
            put("h", "ᚽ");
            put("i", "ᛁ");
            put("í", "ᛁ");
            put("j", "ᛁ");
            put("k", "ᚴ");
            put("l", "ᛚ");
            put("m", "ᛘ");
            put("n", "ᚿ");
            put("o", "ᚢ");
            put("ó", "ᚢ");
            put("p", "ᛒ");
            put("q", "ᚴ");
            put("r", "ᚱ");
            put("s", "ᛌ");
            put("t", "ᛐ");
            put("þ", "ᚦ");
            put("u", "ᚢ");
            put("ú", "ᚢ");
            put("v", "ᚢ");
            put("w", "ᚢ");
            put("x", "ᛌ");
            put("y", "ᚢ");
            put("ý", "ᚢ");
            put("z", "ᛌ");
            put("å", "ᚢ");
            put("ä", "ᛆ");
            put("æ", "ᛆ");
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

    public String lettersToLongBranchRunes(String content) {
        return Transform.withDictionary(content, LETTERS_TO_LONG_BRANCH_RUNES);
    }

    public String lettersToShortTwigRunes(String content) {
        return Transform.withDictionary(content, LETTERS_TO_SHORT_TWIG_RUNES);
    }

    public String lettersToRunes(String content) {
        if (runeStyle == Variant.SHORT_TWIG) {
            return Transform.withDictionary(content, LETTERS_TO_SHORT_TWIG_RUNES);
        }

        return Transform.withDictionary(content, LETTERS_TO_LONG_BRANCH_RUNES);
    }

    public String runesToLetters(String content) {
        return Transform.withDictionary(content, RUNES_TO_LETTERS);
    }
}
