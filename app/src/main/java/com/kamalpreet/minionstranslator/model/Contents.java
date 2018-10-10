package com.kamalpreet.minionstranslator.model;

import com.google.gson.annotations.SerializedName;

public class Contents
{
    @SerializedName("translation")
    private String translation;

    @SerializedName("translated")
    private String translatedText;

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }
}
