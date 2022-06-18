package com.github.stscoundrel.riimut.dialects;

public interface Dialect {
    public String lettersToRunes(String content);

    public String runesToLetters(String content);
}