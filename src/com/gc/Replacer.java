package com.gc;

public class Replacer {
	
	private static final String HTML_TAG_ONE = "<class=\"languageLearner\" title=\"";
	private static final String HTML_TAG_TWO = "\">";
	private static final String HTML_TAG_THREE = "</class>";
	private static String[] targetSentences;
	private static String[] translatedAndTaggedSentences;
	private static StringBuilder originalBody;
	private static String newBody;
	private static int startIndex;

	public static Holder replaceTargetsWithTranslations(Holder ourHolder) {
		targetSentences = ourHolder.getTargets();
		translatedAndTaggedSentences = ourHolder.getTranslations();
		originalBody = new StringBuilder(ourHolder.getBody());
		
		for (int i = 0; i < translatedAndTaggedSentences.length; i++) {
			translatedAndTaggedSentences[i] = HTML_TAG_ONE + targetSentences[i] + HTML_TAG_TWO + translatedAndTaggedSentences[i] + HTML_TAG_THREE;
			startIndex = originalBody.indexOf(targetSentences[i]);
			originalBody.replace(startIndex, startIndex+targetSentences[i].length(), translatedAndTaggedSentences[i]);
		}
		
		newBody = originalBody.toString();
		
		ourHolder.setBody(newBody);
		
		return ourHolder;
	}

}