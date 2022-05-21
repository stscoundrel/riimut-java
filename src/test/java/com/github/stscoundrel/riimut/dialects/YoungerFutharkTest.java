package com.github.stscoundrel.riimut.dialects;

import junit.framework.TestCase;

public class YoungerFutharkTest extends TestCase {
    public void testTransformsLettersToRunes() {
        String letters = "aábcdðeéfghiíjklmnoópqrstþuúvwxyýzåäæöøǫþ";
        String runes = "ᛅᛅᛒᛋᛏᚦᛁᛁᚠᚴᚼᛁᛁᛁᚴᛚᛘᚾᚢᚢᛒᚴᚱᛋᛏᚦᚢᚢᚢᚢᛋᚢᚢᛋᚢᛅᛅᚢᚢᚢᚦ";

        Dialect youngerFuthark = new YoungerFuthark();
        String result = youngerFuthark.lettersToRunes(letters);

        assertEquals(runes, result);
    }

    public void testTransformsRunesToLetters() {
        String runes = "ᚠᚢᚦᚬᚱᚴᚼᚽᚾᚿᛁᛅᛆᛋᛌᛏᛐᛒᛘᛚᛦ:";
        String letters = "fuþorkhhnniaassttbmlR ";

        Dialect youngerFuthark = new YoungerFuthark();
        String result = youngerFuthark.runesToLetters(runes);

        assertEquals(letters, result);
    }

    public void testTransformsTextContentToRunes() {
        // From Old Groms runestone.
        String letters = "auk tani karþi kristna";
        String runes = "ᛅᚢᚴ:ᛏᛅᚾᛁ:ᚴᛅᚱᚦᛁ:ᚴᚱᛁᛋᛏᚾᛅ";

        Dialect youngerFuthark = new YoungerFuthark();
        String result = youngerFuthark.lettersToRunes(letters);

        assertEquals(runes, result);
    }

    public void testTransformsRunesToTextContent() {
        // From Old Groms runestone.
        String runes = "ᛅᚢᚴ:ᛏᛅᚾᛁ:ᚴᛅᚱᚦᛁ:ᚴᚱᛁᛋᛏᚾᛅ";
        String letters = "auk tani karþi kristna";

        Dialect youngerFuthark = new YoungerFuthark();
        String result = youngerFuthark.runesToLetters(runes);

        assertEquals(letters, result);
    }
}
