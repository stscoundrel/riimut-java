package com.github.stscoundrel.riimut.dialects;

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
}
