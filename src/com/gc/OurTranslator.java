package com.gc;

import java.util.List;

import org.apache.commons.lang3.text.WordUtils;

import com.gtranslate.Language;
import com.neovisionaries.i18n.LanguageCode;

public class OurTranslator {
	
	private static final String ORIGIN_LANGUAGE = Language.ENGLISH;
	private static String desiredLanguage;
	private static List<LanguageCode> languageCode;
	private static String[] targetSentences;
	private static String[] translations;

	public static Holder translateSentences(Holder ourHolder) {

		desiredLanguage = WordUtils.capitalize(ourHolder.getLanguage());
		targetSentences = ourHolder.getTargets();
		translations = new String[targetSentences.length];
		languageCode = LanguageCode.findByName(desiredLanguage);
		desiredLanguage = languageCode.get(0).toString();

		for (int i = 0; i < targetSentences.length; i++) {
			translations[i] = GoogleTranslate.googleTranslateApi(targetSentences[i], ORIGIN_LANGUAGE, desiredLanguage);
		}

		ourHolder = new Holder(ourHolder, targetSentences, translations);

		return ourHolder;
	}
}