package com.gc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ParagraphParser {
	
	private static String body;
	private static Document doc;
	private static Elements pTags;
	private static String[] paragraphs;
	
	public static Holder parseBodyIntoParagraphs(Holder ourHolder) {
		body = ourHolder.getBody();
		doc = Jsoup.parse(body);
		pTags = doc.select("p");
		paragraphs = new String[pTags.size()];
		
		for (int i = 0; i < paragraphs.length; i++) {
			paragraphs[i] = pTags.get(i).text();
		}
		
		ourHolder = new Holder(ourHolder, paragraphs);
		
		return ourHolder;
	}
	
}