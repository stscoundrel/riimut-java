# Riimut

Transform latin letters to runes &amp; vice versa. Java version.

Includes transformers for four main runic alphabets:

- Elder Futhark
- Younger Futhark
- Medieval Futhork
- Futhorc (Anglo-Frisian runes)

## Install

As Maven dependency.

```xml
<dependency>
  <groupId>io.github.stscoundrel</groupId>
  <artifactId>riimut</artifactId>
  <version>0.5.0</version> <!-- Note! Check latest release number -->
</dependency>
```

For alternative install methods, see the [Maven Central Repo](https://search.maven.org/artifact/io.github.stscoundrel/riimut)

### Usage

Text to runes:
```java
// Ships four runic dialects under Riimut namespace.
import io.github.stscoundrel.riimut.dialects.YoungerFuthark;
import io.github.stscoundrel.riimut.dialects.ElderFuthark;
import io.github.stscoundrel.riimut.dialects.MedievalFuthork;
import io.github.stscoundrel.riimut.dialects.Futhorc;

// They all implement common "Dialect" interface 
import io.github.stscoundrel.riimut.dialects.Dialect;

Dialect youngerFuthark = new YoungerFuthark();
Dialect elderFuthark = new ElderFuthark();
Dialect medievalFuthork = new MedievalFuthork();
Dialect futhorc = new Futhorc();

// From Old Groms runestone.
String content = "auk tani karþi kristna";
String result1 = youngerFuthark.lettersToRunes(content);
System.out.println(result1); // ᛅᚢᚴ:ᛏᛅᚾᛁ:ᚴᛅᚱᚦᛁ:ᚴᚱᛁᛋᛏᚾᛅ

// From 4th century axe in Jutland
String content = "wagagastiz alu wihgu sikijaz aiþalataz";
String result2 = elderFuthark.lettersToRunes(content);
System.out.println(result2); // ᚹᚨᚷᚨᚷᚨᛋᛏᛁᛉ:ᚨᛚᚢ:ᚹᛁᚻᚷᚢ:ᛋᛁᚲᛁᛃᚨᛉ:ᚨᛁᚦᚨᛚᚨᛏᚨᛉ

// From Lord's Prayer, in Old Norse.
String content = "Faðer uor som ast i himlüm, halgað warðe þit nama";
String result3 = medievalFuthork.lettersToRunes(content);
System.out.println(result3); // ᚠᛆᚦᚽᚱ:ᚢᚮᚱ:ᛋᚮᛘ:ᛆᛋᛏ:ᛁ:ᚼᛁᛘᛚᚢᛘ,:ᚼᛆᛚᚵᛆᚦ:ᚠᛆᚱᚦᚽ:ᚦᛁᛏ:ᚿᛆᛘᛆ

// From 8th century Franks Casket, in late West Saxon.
String content = "fisc.flodu.ahofonferg | enberig |";
String result4 = futhorc.lettersToRunes(content);
System.out.println(result4); // ᚠᛁᛋᚳ.ᚠᛚᚩᛞᚢ.ᚪᚻᚩᚠᚩᚾᚠᛖᚱᚷ:|:ᛖᚾᛒᛖᚱᛁᚷ:|

```

Runes to text:
```java

// All four dialects contain runesToLetters method.
import io.github.stscoundrel.riimut.dialects.YoungerFuthark;

YoungerFuthark youngerFuthark = new YoungerFuthark();
String runicText = "ᛅᚢᚴ:ᛏᛅᚾᛁ:ᚴᛅᚱᚦᛁ:ᚴᚱᛁᛋᛏᚾᛅ";
String latinText = youngerFuthark.runesToLetters(runicText);

System.out.println(latinText); // "auk tani karþi kristna"

```

#### Rune variants in Younger Futhark

Younger Futhark comes with long branch (Danish) and short twig (Norwegian & Swedish) variants.
```java

import io.github.stscoundrel.riimut.dialects.YoungerFuthark;

String letters = "aábcdðeéfghiíjklmnoópqrstþuúvwxyýzåäæöøǫþ";
YoungerFuthark youngerFuthark = new YoungerFuthark();

// Comes with named methods per style.
String longBranch = youngerFuthark.lettersToLongBranchRunes(letters)
String shortTwig = youngerFuthark.lettersToShortTwigRunes(letters)

System.out.println(longBranch); // ᛅᛅᛒᛋᛏᚦᛁᛁᚠᚴᚼᛁᛁᛁᚴᛚᛘᚾᚢᚢᛒᚴᚱᛋᛏᚦᚢᚢᚢᚢᛋᚢᚢᛋᚢᛅᛅᚢᚢᚢᚦ"
System.out.println(shortTwig); // ᛆᛆᛒᛌᛐᚦᛁᛁᚠᚴᚽᛁᛁᛁᚴᛚᛘᚿᚢᚢᛒᚴᚱᛌᛐᚦᚢᚢᚢᚢᛌᚢᚢᛌᚢᛆᛆᚢᚢᚢᚦ

// Instance can also be created with default style. Then lettersToRunes will use that style.
YoungerFuthark youngerFutharkLongBranch = new YoungerFuthark(YoungerFuthark.Variant.LONG_BRANCH);
YoungerFuthark youngerFutharkShortTwig = new YoungerFuthark(YoungerFuthark.Variant.SHORT_TWIG);

// Or you can switch the style of instance at will.
youngerFutharkLongBranch.useShortTwig();
youngerFutharkShortTwig.useLongBranch();

```

There is also a "staveless" variant of Younger Futhark. However, staveless runes are less trivial to display without custom fonts, so some inscriptions may not be perfect a match. IN lieu of proper runic unicode, they are other characters that have similar shape. For example, the more dot-like notations use braille unicode. Therefore, be extra critical before trusting the staveless variant.

```java

import io.github.stscoundrel.riimut.dialects.YoungerFuthark;

String letters = "fuþoRkhniastbmlR";

// Can be initialized with staveless enum
YoungerFuthark youngerFuthark = new YoungerFuthark(YoungerFuthark.Variant.STAVELESS);

// ...Or called with named method on any Younger Futhark instance.
String staveless = youngerFuthark.lettersToStavelessRunes(letters)

System.out.println(staveless); // ᛙ ╮ ו ˎ ⡄ ᛍ ᚽ ⸜ ᛁ ⸝ ╵ ⸍ ˏ ⠃ ⸌ ⡄ "

// Same style switch exists for staveless too.
youngerFuthark.useStaveless();

```

#### What's in the name?

"Riimut" is the Finnish word for "runes".
