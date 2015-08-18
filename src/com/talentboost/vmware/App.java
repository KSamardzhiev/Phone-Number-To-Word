package com.talentboost.vmware;

import java.util.List;

public class App {

	public static void main(String[] args) {

		DTreeNew treeWords = new DTreeNew();
		FillDTree.fill("filteredWords", treeWords);
		String phrase = "4264663";
		String word = "966 337 385";
		List<String> phrases = treeWords.numberToPhrase(phrase);
		List<String> words = treeWords.numberToWord(word);
		
		for (String wordPhone : words) {
			System.out.println(wordPhone);
		}
		System.out.println(words.size());
	}
}
