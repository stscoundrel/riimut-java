package io.github.stscoundrel.riimut.dialects;

import junit.framework.TestCase;

public class FuthorcTest extends TestCase {
    public void testTransformsLettersToRunes() {
        String letters = "aábcdðeéfghiíïʒjklmnŋoóǫpqrstuúvwxyýzåäæœöøþ ";
        String runes = "ᚪᚪᛒᚳᛞᛞᛖᛖᚠᚷᚻᛁᛇᛇᛇᛡᚳᛚᛗᚾᛝᚩᚩᚩᛈᚳᚱᛋᛏᚢᚢᚹᚹᛉᚣᚣᛉᚩᚫᚫᛟᛟᛟᚦ:";

        Dialect dialect = new Futhorc();
        String result = dialect.lettersToRunes(letters);

        assertEquals(runes, result);
    }

    public void testTransformsRunesToLetters() {
        String runes = "ᚠᚢᚦᚩᚱᚳᚷᚹᚻᚾᛁᛡᛄᛇᛈᛉᛋᚴᛏᛒᛖᛗᛚᛝᛟᛞᚪᚫᚣᛠ:";
        String letters = "fuþorcgwhnijjïpxsstbemlŋœdaæyea ";

        Dialect dialect = new Futhorc();
        String result = dialect.runesToLetters(runes);

        assertEquals(letters, result);
    }

    public void testTransformsTextContentToRunes() {
        // From 8th century Franks Casket, in late West Saxon.
        String letters = "fisc.flodu.ahofonferg | enberig |";
        String runes = "ᚠᛁᛋᚳ.ᚠᛚᚩᛞᚢ.ᚪᚻᚩᚠᚩᚾᚠᛖᚱᚷ:|:ᛖᚾᛒᛖᚱᛁᚷ:|";

        Dialect dialect = new Futhorc();
        String result = dialect.lettersToRunes(letters);

        assertEquals(runes, result);
    }

    public void testTransformsRunesToTextContent() {
        // From 8th century Franks Casket, in late West Saxon.
        String runes = "ᚠᛁᛋᚳ.ᚠᛚᚩᛞᚢ.ᚪᚻᚩᚠᚩᚾᚠᛖᚱᚷ:|:ᛖᚾᛒᛖᚱᛁᚷ:|";
        String letters = "fisc.flodu.ahofonferg | enberig |";

        Dialect dialect = new Futhorc();
        String result = dialect.runesToLetters(runes);

        assertEquals(letters, result);
    }
}
