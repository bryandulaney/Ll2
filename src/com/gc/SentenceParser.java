package com.gc;

import java.util.ArrayList;
import java.util.Random;

public class SentenceParser {
	private static Random rand = new Random();
	private static String[] paragraphs;
	private static ArrayList<String> listOfTargets = new ArrayList<String>();
	private static String[] tempArray;
	private static int max;
	private static int randomNum;
	private static String[] arrayOfTargets;
	
	public static Holder parseParagraphsIntoSentences(Holder ourHolder) {
		paragraphs = ourHolder.getTargets();
		
		for (int i = 0; i < paragraphs.length; i++) {
			tempArray = paragraphs[i].split("(?<=[.?!])\\s+(?=[A-Z])");
			max = tempArray.length;
			randomNum = rand.nextInt(max);
			listOfTargets.add(tempArray[randomNum]);
		}
		
		arrayOfTargets = new String[listOfTargets.size()];
		for (int i = 0; i < arrayOfTargets.length; i++) {
			arrayOfTargets[i] = listOfTargets.get(i);
		}
		
		ourHolder = new Holder(ourHolder, arrayOfTargets);
		
		return ourHolder;
	}
}