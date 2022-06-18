package io.github.stscoundrel.riimut.dialects;

import junit.framework.TestCase;

public class ElderFutharkTest extends TestCase {
    public void testTransformsLettersToRunes() {
        String letters = "aábcdðeéfghiíjklmnŋoópqrstþuúvwxyýzåäæöøǫþ";
        String runes = "ᚨᚨᛒᚲᛞᚦᛖᛖᚠᚷᚻᛁᛁᛃᚲᛚᛗᚾᛜᛟᛟᛈᚲᚱᛋᛏᚦᚢᚢᚹᚹᛋᛁᛁᛉᛟᛇᛇᚢᚢᛟᚦ";

        Dialect dialect = new ElderFuthark();
        String result = dialect.lettersToRunes(letters);

        assertEquals(runes, result);
    }

    public void testTransformsRunesToLetters() {
        String runes = "ᚠᚢᚦᚨᚱᚲᚷᚹᚺᚻᚾᛁᛃᛇᛈᛉᛊᛋᛏᛒᛖᛗᛚᛜᛝᛟᛞ:";
        String letters = "fuþarkgwhhnijïpzsstbemlŋŋod ";

        Dialect dialect = new ElderFuthark();
        String result = dialect.runesToLetters(runes);

        assertEquals(letters, result);
    }

    public void testTransformsTextContentToRunes() {
        // From 4th century axe in Jutland
        String letters = "wagagastiz alu wihgu sikijaz aiþalataz";
        String runes = "ᚹᚨᚷᚨᚷᚨᛋᛏᛁᛉ:ᚨᛚᚢ:ᚹᛁᚻᚷᚢ:ᛋᛁᚲᛁᛃᚨᛉ:ᚨᛁᚦᚨᛚᚨᛏᚨᛉ";

        Dialect dialect = new ElderFuthark();
        String result = dialect.lettersToRunes(letters);

        assertEquals(runes, result);
    }

    public void testTransformsRunesToTextContent() {
        // From 4th century axe in Jutland
        String runes = "ᚹᚨᚷᚨᚷᚨᛋᛏᛁᛉ:ᚨᛚᚢ:ᚹᛁᚻᚷᚢ:ᛋᛁᚲᛁᛃᚨᛉ:ᚨᛁᚦᚨᛚᚨᛏᚨᛉ";
        String letters = "wagagastiz alu wihgu sikijaz aiþalataz";

        Dialect dialect = new ElderFuthark();
        String result = dialect.runesToLetters(runes);

        assertEquals(letters, result);
    }
}
