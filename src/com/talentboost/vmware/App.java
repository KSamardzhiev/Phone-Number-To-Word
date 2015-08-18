package com.talentboost.vmware;

import java.util.List;

public class App {

	public static void main(String[] args) {

		DTreeNew treeWords = new DTreeNew();
		FillDTree.fill("filteredWords", treeWords);
		//String phrase = "43335968"; 
		String phrase = "4262665"; //i-am-cool
		//String phrase = "45453968";
		//String phrase = "433354663";
		String word = "966337385";
		List<String> phrases = treeWords.numberToPhrase(phrase);
		List<String> words = treeWords.numberToWord(word);
		
		for (String phrasePhone : phrases) {
			System.out.println(phrasePhone);
		}
		System.out.println(words.size());
	}
}
