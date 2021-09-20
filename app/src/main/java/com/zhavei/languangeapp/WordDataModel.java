package com.zhavei.languangeapp;

public class WordDataModel {

    private String laDefaultTranslation;

    private String IndoAppTranslation;

    public WordDataModel(String defaultTrasnlation, String languangeTranslation) {
        laDefaultTranslation = defaultTrasnlation;
        IndoAppTranslation = languangeTranslation;
    }

    public String getDefaultTrasnlation() {
        return laDefaultTranslation;
    }

    public String getLanguangeTranslation() {
        return IndoAppTranslation;
    }

}

//public class NumbersWord {
//
//    /**
//     * Default translation for the word
//     */
//    private String mDefaultTranslation;
//
//    /**
//     * Miwok translation for the word
//     */
//    private String mMiwokTranslation;
//
//    /**
//     * Create a new Word object.
//     *
//     * @param defaultTranslation is the word in a language that the user is already familiar with
//     *                           (such as English)
//     * @param miwokTranslation   is the word in the Miwok language
//     */
//    public NumbersWord(String defaultTranslation, String miwokTranslation) {
//        mDefaultTranslation = defaultTranslation;
//        mMiwokTranslation = miwokTranslation;
//    }
//
//    /**
//     * Get the default translation of the word.
//     */
//    public String getDefaultTranslation() {
//        return mDefaultTranslation;
//    }
//
//    /**
//     * Get the Miwok translation of the word.
//     */
//    public String getMiwokTranslation() {
//        return mMiwokTranslation;
//    }
//}