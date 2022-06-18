package io.github.stscoundrel.riimut.dialects;

import junit.framework.TestCase;

public class MedievalFuthorkTest extends TestCase {
    public void testTransformsLettersToRunes() {
        String letters = "aábcdðeéfghiíjklmnoóǫpqrstuúvwxyýzåäæœöøþ ";
        String runes = "ᛆᛆᛒᚴᚦᚦᚽᚽᚠᚵᚼᛁᛁᛁᚴᛚᛘᚿᚮᚮᚰᛕᚴᚱᛋᛏᚢᚢᚠᚠᛋᛦᛦᛋᚮᛅᛅᚯᚯᚯᚦ:";

        Dialect dialect = new MedievalFuthork();
        String result = dialect.lettersToRunes(letters);

        assertEquals(runes, result);
    }

    public void testTransformsRunesToLetters() {
        String runes = "ᚠᚢᚦᚮᚱᚴᚼᚿᛁᛆᛌᛋᛐᛏᛒᛘᛚᛦᚯᛅᚰᛕᚽ:";
        String letters = "fuþorkhniassttbmlyøæǫᴘe ";

        Dialect dialect = new MedievalFuthork();
        String result = dialect.runesToLetters(runes);

        assertEquals(letters, result);
    }

    public void testTransformsTextContentToRunes() {
        // From Lords Prayer in Old Norse.
        String letters = "Faðer uor som ast i himlüm, halgað warðe þit nama";
        String runes = "ᚠᛆᚦᚽᚱ:ᚢᚮᚱ:ᛋᚮᛘ:ᛆᛋᛏ:ᛁ:ᚼᛁᛘᛚᚢᛘ,:ᚼᛆᛚᚵᛆᚦ:ᚠᛆᚱᚦᚽ:ᚦᛁᛏ:ᚿᛆᛘᛆ";

        Dialect dialect = new MedievalFuthork();
        String result = dialect.lettersToRunes(letters);

        assertEquals(runes, result);
    }

    public void testTransformsRunesToTextContent() {
        // From Lords Prayer in Old Norse.
        String runes = "ᚠᛆᚦᚽᚱ:ᚢᚮᚱ:ᛋᚮᛘ:ᛆᛋᛏ:ᛁ:ᚼᛁᛘᛚᚢᛘ:ᚼᛆᛚᚵᛆᚦ:ᚠᛆᚱᚦᚽ:ᚦᛁᛏ:ᚿᛆᛘᛆ";

        // Wont tell apart eth & thorn in mid sentence.
        String letters = "faþer uor som ast i himlum halgaþ farþe þit nama";

        Dialect dialect = new MedievalFuthork();
        String result = dialect.runesToLetters(runes);

        assertEquals(letters, result);
    }
}
