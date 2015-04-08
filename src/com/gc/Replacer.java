package com.gc;

public class Replacer {
	
	public static Holder replaceTargetsWithTranslations(Holder ourHolder) {
		String[] targets = ourHolder.getTargets();
		String[] translations = ourHolder.getTranslations();
		System.out.println("array length=" + translations.length);
		
		StringBuilder body = new StringBuilder(ourHolder.getBody());
		System.out.println("body length=" + body.length());
		
		System.out.println("length="+ translations.length);
		
		for (int i = 0; i < translations.length; i++) {
			translations[i] = "<a href=\"#\" class=\"tip\" title=\"" + targets[i] + "\">" + translations[i] + "</a>";
			int startIndex = body.indexOf(targets[i]);
			body.replace(startIndex, startIndex+targets[i].length(), translations[i]);
		}
		
		ourHolder.setBody(body.toString());
		
		return ourHolder;
	}

}