package io.github.stscoundrel.riimut.dialects;

import junit.framework.TestCase;

public class YoungerFutharkTest extends TestCase {
    public void testTransformDefaultsToLongBranch() {
        String letters = "aábcdðeéfghiíjklmnoópqrstþuúvwxyýzåäæœöøǫþ";
        String runes = "ᛅᛅᛒᛋᛏᚦᛁᛁᚠᚴᚼᛁᛁᛁᚴᛚᛘᚾᚢᚢᛒᚴᚱᛋᛏᚦᚢᚢᚢᚢᛋᚢᚢᛋᚢᛅᛅᚢᚢᚢᚢᚦ";

        YoungerFuthark youngerFuthark = new YoungerFuthark();
        String result = youngerFuthark.lettersToRunes(letters);

        assertEquals(runes, result);
    }

    public void testTransformsLettersToLongBranchRunes() {
        String letters = "aábcdðeéfghiíjklmnoópqrstþuúvwxyýzåäæœöøǫþ";
        String runes = "ᛅᛅᛒᛋᛏᚦᛁᛁᚠᚴᚼᛁᛁᛁᚴᛚᛘᚾᚢᚢᛒᚴᚱᛋᛏᚦᚢᚢᚢᚢᛋᚢᚢᛋᚢᛅᛅᚢᚢᚢᚢᚦ";

        YoungerFuthark youngerFuthark = new YoungerFuthark();
        String result = youngerFuthark.lettersToLongBranchRunes(letters);

        assertEquals(runes, result);
    }

    public void testTransformsLettersToShortTwigRunes() {
        String letters = "aábcdðeéfghiíjklmnoópqrstþuúvwxyýzåäæœöøǫþ";
        String runes = "ᛆᛆᛒᛌᛐᚦᛁᛁᚠᚴᚽᛁᛁᛁᚴᛚᛘᚿᚢᚢᛒᚴᚱᛌᛐᚦᚢᚢᚢᚢᛌᚢᚢᛌᚢᛆᛆᚢᚢᚢᚢᚦ";

        YoungerFuthark youngerFuthark = new YoungerFuthark();
        String result = youngerFuthark.lettersToShortTwigRunes(letters);

        assertEquals(runes, result);
    }

    public void testTransformsLettersToStavelessRunes() {
        String letters = "aábcdðeéfghiíjklmnoópqrstþuúvwxyýzåäæöœøǫþ";
        String runes = "⸝⸝ˏ╵⸍וᛁᛁᛙᛍᚽᛁᛁᛁᛍ⸌⠃⸜ˎˎˏᛍ◟╵⸍ו╮╮╮╮╵╮╮╵ˎ⸝⸝ˎˎˎˎו";

        YoungerFuthark youngerFuthark = new YoungerFuthark();
        String result = youngerFuthark.lettersToStavelessRunes(letters);
        assertEquals(runes, result);
    }

    public void testTransformsRunesToLetters() {
        // Both long branch & short twig should produce same letters.
        String longBranchRunes = "ᚠᚢᚦᚬᚱᚴᚼᚽᚾᚿᛁᛅᛆᛋᛌᛏᛐᛒᛘᛚᛦ:";
        String shortTwigRunes = "ᚠᚢᚦᚬᚱᚴᚽᚽᚿᚿᛁᛆᛆᛌᛌᛐᛐᛒᛘᛚᛦ:";
        String stavelessRunes = "ᛙ╮וˎ⡄ᛍᚽ⸜ᛁ⸝╵⸍,⠃⸌⡄:";
        String letters = "fuþorkhhnniaassttbmlR ";
        String stavelessLetters = "fuþoRkhniastbmlR ";

        YoungerFuthark youngerFuthark = new YoungerFuthark();
        String result1 = youngerFuthark.runesToLetters(longBranchRunes);
        String result2 = youngerFuthark.runesToLetters(shortTwigRunes);
        String result3 = youngerFuthark.runesToLetters(stavelessRunes);

        assertEquals(letters, result1);
        assertEquals(letters, result2);
        assertEquals(stavelessLetters, result3);
    }

    public void testTransformsTextContentToRunes() {
        // From Old Groms runestone.
        String letters = "auk tani karþi kristna";
        String runes = "ᛅᚢᚴ:ᛏᛅᚾᛁ:ᚴᛅᚱᚦᛁ:ᚴᚱᛁᛋᛏᚾᛅ";

        YoungerFuthark youngerFuthark = new YoungerFuthark();
        String result = youngerFuthark.lettersToRunes(letters);

        assertEquals(runes, result);
    }

    public void testTransformsRunesToTextContent() {
        // From Old Groms runestone.
        String runes = "ᛅᚢᚴ:ᛏᛅᚾᛁ:ᚴᛅᚱᚦᛁ:ᚴᚱᛁᛋᛏᚾᛅ";
        String letters = "auk tani karþi kristna";

        YoungerFuthark youngerFuthark = new YoungerFuthark();
        String result = youngerFuthark.runesToLetters(runes);

        assertEquals(letters, result);
    }

    public void testStyleVariantSetters() {
        String letters = "aábcdðeéfghiíjklmnoópqrstþuúvwxyýzåäæöøǫþ";
        String expectedLongBranchRunes = "ᛅᛅᛒᛋᛏᚦᛁᛁᚠᚴᚼᛁᛁᛁᚴᛚᛘᚾᚢᚢᛒᚴᚱᛋᛏᚦᚢᚢᚢᚢᛋᚢᚢᛋᚢᛅᛅᚢᚢᚢᚦ";
        String expectedShortTwigRunes = "ᛆᛆᛒᛌᛐᚦᛁᛁᚠᚴᚽᛁᛁᛁᚴᛚᛘᚿᚢᚢᛒᚴᚱᛌᛐᚦᚢᚢᚢᚢᛌᚢᚢᛌᚢᛆᛆᚢᚢᚢᚦ";
        String expectedStavelessRunes = "⸝⸝ˏ╵⸍וᛁᛁᛙᛍᚽᛁᛁᛁᛍ⸌⠃⸜ˎˎˏᛍ◟╵⸍ו╮╮╮╮╵╮╮╵ˎ⸝⸝ˎˎˎו";

        YoungerFuthark youngerFuthark = new YoungerFuthark();

        // Expected to use long branch as default.
        String longBranchResult = youngerFuthark.lettersToRunes(letters);

        // Change to short twig.
        youngerFuthark.useShortTwig();
        String shortTwigResult = youngerFuthark.lettersToRunes(letters);

        // Switch back to long branch
        youngerFuthark.useLongBranch();
        String secondLongBranchResult = youngerFuthark.lettersToRunes(letters);

        // Switch to staveless.
        youngerFuthark.useStaveless();
        String stavelessResult = youngerFuthark.lettersToRunes(letters);

        assertEquals(expectedLongBranchRunes, longBranchResult);
        assertEquals(expectedShortTwigRunes, shortTwigResult);
        assertEquals(expectedLongBranchRunes, secondLongBranchResult);
        assertEquals(expectedStavelessRunes, stavelessResult);
    }

    public void testConstructorsWithVariantSettings() {
        String letters = "aábcdðeéfghiíjklmnoópqrstþuúvwxyýzåäæöøǫþ";
        String expectedLongBranchRunes = "ᛅᛅᛒᛋᛏᚦᛁᛁᚠᚴᚼᛁᛁᛁᚴᛚᛘᚾᚢᚢᛒᚴᚱᛋᛏᚦᚢᚢᚢᚢᛋᚢᚢᛋᚢᛅᛅᚢᚢᚢᚦ";
        String expectedShortTwigRunes = "ᛆᛆᛒᛌᛐᚦᛁᛁᚠᚴᚽᛁᛁᛁᚴᛚᛘᚿᚢᚢᛒᚴᚱᛌᛐᚦᚢᚢᚢᚢᛌᚢᚢᛌᚢᛆᛆᚢᚢᚢᚦ";

        YoungerFuthark youngerFutharkDefault = new YoungerFuthark();
        YoungerFuthark youngerFutharkLongBranch = new YoungerFuthark(YoungerFuthark.Variant.LONG_BRANCH);
        YoungerFuthark youngerFutharkShortTwig = new YoungerFuthark(YoungerFuthark.Variant.SHORT_TWIG);

        String defaultResult = youngerFutharkDefault.lettersToRunes(letters);
        String shortTwigResult = youngerFutharkShortTwig.lettersToRunes(letters);
        String longBranchResult = youngerFutharkLongBranch.lettersToRunes(letters);

        assertEquals(expectedLongBranchRunes, defaultResult);
        assertEquals(expectedShortTwigRunes, shortTwigResult);
        assertEquals(expectedLongBranchRunes, longBranchResult);
    }
}
