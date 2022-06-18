package io.github.stscoundrel.riimut.dialects;

import junit.framework.TestCase;

public class YoungerFutharkTest extends TestCase {
    public void testTransformDefaultsToLongBranch() {
        String letters = "aábcdðeéfghiíjklmnoópqrstþuúvwxyýzåäæöøǫþ";
        String runes = "ᛅᛅᛒᛋᛏᚦᛁᛁᚠᚴᚼᛁᛁᛁᚴᛚᛘᚾᚢᚢᛒᚴᚱᛋᛏᚦᚢᚢᚢᚢᛋᚢᚢᛋᚢᛅᛅᚢᚢᚢᚦ";

        YoungerFuthark youngerFuthark = new YoungerFuthark();
        String result = youngerFuthark.lettersToRunes(letters);

        assertEquals(runes, result);
    }

    public void testTransformsLettersToLongBranchRunes() {
        String letters = "aábcdðeéfghiíjklmnoópqrstþuúvwxyýzåäæöøǫþ";
        String runes = "ᛅᛅᛒᛋᛏᚦᛁᛁᚠᚴᚼᛁᛁᛁᚴᛚᛘᚾᚢᚢᛒᚴᚱᛋᛏᚦᚢᚢᚢᚢᛋᚢᚢᛋᚢᛅᛅᚢᚢᚢᚦ";

        YoungerFuthark youngerFuthark = new YoungerFuthark();
        String result = youngerFuthark.lettersToLongBranchRunes(letters);

        assertEquals(runes, result);
    }

    public void testTransformsLettersToShortTwigRunes() {
        String letters = "aábcdðeéfghiíjklmnoópqrstþuúvwxyýzåäæöøǫþ";
        String runes = "ᛆᛆᛒᛌᛐᚦᛁᛁᚠᚴᚽᛁᛁᛁᚴᛚᛘᚿᚢᚢᛒᚴᚱᛌᛐᚦᚢᚢᚢᚢᛌᚢᚢᛌᚢᛆᛆᚢᚢᚢᚦ";

        YoungerFuthark youngerFuthark = new YoungerFuthark();
        String result = youngerFuthark.lettersToShortTwigRunes(letters);

        assertEquals(runes, result);
    }

    public void testTransformsRunesToLetters() {
        // Both long branch & short twig should produce same letters.
        String longBranchRunes = "ᚠᚢᚦᚬᚱᚴᚼᚽᚾᚿᛁᛅᛆᛋᛌᛏᛐᛒᛘᛚᛦ:";
        String shortTwigRunes = "ᚠᚢᚦᚬᚱᚴᚽᚽᚿᚿᛁᛆᛆᛌᛌᛐᛐᛒᛘᛚᛦ:";
        String letters = "fuþorkhhnniaassttbmlR ";

        YoungerFuthark youngerFuthark = new YoungerFuthark();
        String result1 = youngerFuthark.runesToLetters(longBranchRunes);
        String result2 = youngerFuthark.runesToLetters(shortTwigRunes);

        assertEquals(letters, result1);
        assertEquals(letters, result2);
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

        YoungerFuthark youngerFuthark = new YoungerFuthark();

        // Expected to use long branch as default.
        String longBranchResult = youngerFuthark.lettersToRunes(letters);

        // Change to short twig.
        youngerFuthark.useShortTwig();
        String shortTwigResult = youngerFuthark.lettersToRunes(letters);

        // Switch back to long branch
        youngerFuthark.useLongBranch();
        String secondLongBranchResult = youngerFuthark.lettersToRunes(letters);

        assertEquals(expectedLongBranchRunes, longBranchResult);
        assertEquals(expectedShortTwigRunes, shortTwigResult);
        assertEquals(expectedLongBranchRunes, secondLongBranchResult);
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
