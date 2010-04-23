package com.integrallis.modernjee.seam.bookstore.util;

public class PigLatinWithATwist {
	
	int i = 0;
	
	public String translate(String word) {
		return convertPigLatinWord(word);
	}

	public static boolean isVowel(char c) {
		if (c == 'a' || c == 'A') {
		return (true);
		 
		} else if (c == 'e' || c == 'E') {
		return (true);
		 
		} else if (c == 'i' || c == 'I') {
		return (true);
		} else if (c == 'o' || c == 'O') {
		return (true);
		 
		} else if (c == 'u' || c == 'U') {
		return (true);
		 
		} else {
		return (false);
		 
		}
	}
	
	public String convertPigLatinWord(String englishWord) {
		int length = englishWord.length();

		if (englishWord.charAt(length - 1) == '.'
		|| englishWord.charAt(length - 1) == '!'
		|| englishWord.charAt(length - 1) == '?') {

		char ch = englishWord.charAt(0);
		String rest = englishWord.substring(1, length - 1);
		return (rest + "-" + ch + "ay" + englishWord.charAt(length - 1) + "\""+" ");

		} else if ((englishWord.charAt(0) == 't' || englishWord.charAt(0) == 'T')
		&& englishWord.charAt(1) == 'h') {
		return (convertTh(englishWord)+" ");

		} else if (isVowel(englishWord.charAt(0))) {
		return (englishWord + "-way"+" ");

		} else {
		char ch = englishWord.charAt(0);
		String rest = englishWord.substring(1);
		return (rest + "-" + ch + "ay"+" ");

		}

	}

	public String convertTh(String tWord) {
		String th = tWord.substring(0,2);
		String rest = tWord.substring(2);
		return (rest + "-" + th+ "ay");
	}	
}