package com.talentboost.vmware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class provide the logic of Tree data structure that contains the letters
 * of all possible words.
 * 
 * @author KSamardzhiev
 *
 */
public class DTreeNew {
	/**
	 * This Map contains digit to letters mapping(e.g. phone numbers)
	 */
	private static final Map<Character, String> MAP_NUM = new HashMap<Character, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put('2', "abc");
			put('3', "def");
			put('4', "ghi");
			put('5', "jkl");
			put('6', "mno");
			put('7', "pqrs");
			put('8', "tuv");
			put('9', "wxyz");
		}
	};
	/**
	 * This variable stores the root of the tree.
	 */
	private Node root = new Node(' ');

	/**
	 * 
	 * @param word
	 *            - String of word which you want to insert to the tree.
	 * @author KSamardzhiev - This method insert the particular word in the
	 *         tree.
	 */
	public void insert(String word) {

		Node currentNode = root;

		for (int i = 0; i < word.length(); i++) {
			if (currentNode.contain(word.charAt(i))) {
				if (i == word.length() - 1) {
					currentNode = currentNode.getChild(word.charAt(i));
					currentNode.setIsWord(true);
				} else {
					currentNode = currentNode.getChild(word.charAt(i));
				}
			} else {
				if (i == word.length() - 1) {
					if (word.length() == 1 && word.charAt(0) != 'i') {
						currentNode.addChild(new Node(word.charAt(i), false));
					} else {
						currentNode.addChild(new Node(word.charAt(i), true));
					}

				} else {
					currentNode.addChild(new Node(word.charAt(i), false));
				}
				currentNode = currentNode.getChild(word.charAt(i));
			}
		}
	}

	/**
	 * 
	 * @param word
	 *            - String of the word which you want to see if the tree
	 *            contain.
	 *
	 * @return True if the tree contains this word and false otherwise.
	 */
	public boolean search(String word) {

		Node currentNode = root;

		for (int i = 0; i < word.length(); i++) {
			if (currentNode.contain(word.charAt(i))) {
				if (currentNode.getChild(word.charAt(i)).getIsWord() == true) {
					if (i == word.length() - 1) {
						return true;
					} else {
						currentNode = currentNode.getChild(word.charAt(i));
					}
				} else {
					currentNode = currentNode.getChild(word.charAt(i));
				}
			} else {
				return false;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param number
	 *            - String of number to which you want to see the word that
	 *            correspondence.
	 * @return List of all words that correspondence to this number with all
	 *         digit of the number.
	 */
	public List<String> numberToWord(String number) {
		List<String> result = new ArrayList<String>();
		searchWord(number, "", result, this.root);
		return result;
	}

	/**
	 * 
	 * @param number
	 *            - String of number to which you want to see the word that
	 *            correspondence.
	 * @return List of all words that correspondence to this number with all
	 *         digit of the number and with the words that correspondence only
	 *         to some of the digits.
	 */
	public List<String> numberToWords(String number) {
		List<String> result = new ArrayList<String>();
		searchWords(number, "", result, this.root);
		return result;
	}

	/**
	 * 
	 * @param number
	 *            - String of number to which you want to see the word that
	 *            correspondence.
	 * @param wordSoFar
	 *            - String of the word that is make so far.
	 * @param allWords
	 *            - List of all words that are find.
	 * @param curNode
	 *            - Node from which the recursion start.
	 * @author KSamardzhiev - This recursion method provide the logic of
	 *         searching words that correspondence to particular number (with
	 *         all digits).
	 */
	private void searchWord(String number, String wordSoFar, List<String> allWords, Node curNode) {
		Node currentNode = curNode;

		if (currentNode == null) {
			return;
		}

		if (number.length() == 0) {
			if (this.search(wordSoFar)) {
				allWords.add(wordSoFar);
			}

		} else {

			Character digit = number.charAt(0);
			number = number.substring(1);

			String children = MAP_NUM.get(digit);
			for (int i = 0; i < children.length(); i++) {

				searchWord(number, wordSoFar + currentNode.getChild(children.charAt(i)).getValue(), allWords,
						currentNode);
			}
		}
	}

	/**
	 * 
	 * @param number
	 *            - String of number to which you want to see the word that
	 *            correspondence.
	 * @param wordSoFar
	 *            - String of the word that is make so far.
	 * @param allWords
	 *            - List of all words that are find.
	 * @param curNode
	 *            - Node from which the recursion start.
	 * @author KSamardzhiev - This recursion method provide the logic of
	 *         searching words that correspondence to particular number (with
	 *         all digits and with some of the digits).
	 */
	private void searchWords(String number, String wordSoFar, List<String> allWords, Node curNode) {
		Node currentNode = curNode;

		if (currentNode == null) {
			return;
		}

		if (number.length() == 0) {
			if (this.search(wordSoFar)) {
				allWords.add(wordSoFar);
			}

		} else {

			if (this.search(wordSoFar)) {
				allWords.add(wordSoFar);
			}

			Character digit = number.charAt(0);
			number = number.substring(1);

			String children = MAP_NUM.get(digit);
			for (int i = 0; i < children.length(); i++) {

				searchWords(number, wordSoFar + currentNode.getChild(children.charAt(i)).getValue(), allWords,
						currentNode);
			}
		}
	}

	/**
	 * 
	 * @param number
	 *            - String of number to which you want to see the phrases that
	 *            correspondence.
	 * @return List of all phrases that correspondence to this number.
	 */
	public List<String> numberToPhrase(String number) {
		List<String> result = new ArrayList<String>();
		searchPhrase(number, "", result, this.root, "");
		return result;
	}

	/**
	 * 
	 * @param number
	 *            - String of number to which you want to see the word that
	 *            correspondence.
	 * @param wordSoFar
	 *            - String of the word that is make so far.
	 * @param allPhrases
	 *            - List of all phrases that are find.
	 * @param curNode
	 *            - Node from which the recursion start.
	 * @param phrase
	 *            - String of the phrase that is make so far.
	 * @author KSamardzhiev - This recursion method provide the logic of
	 *         searching phrases that correspondence to particular number.
	 */
	private void searchPhrase(String number, String wordSoFar, List<String> allPhrases, Node curNode, String phrase) {
		Node currentNode = curNode;

		if (currentNode == null) {
			return;
		}

		if (number.length() == 0) {
			if (search(wordSoFar)) {
				allPhrases.add(phrase + wordSoFar);
			}

		} else {
			if (this.search(wordSoFar)) {
				phrase += wordSoFar + '-';
				List<String> result = new ArrayList<String>();
				searchWords(number, "", result, curNode);
				for (String word : result) {
					allPhrases.add(phrase + word);
				}
				wordSoFar = "";
			}

			Character digit = number.charAt(0);
			number = number.substring(1);

			String children = MAP_NUM.get(digit);
			for (int i = 0; i < children.length(); i++) {

				searchPhrase(number, wordSoFar + currentNode.getChild(children.charAt(i)).getValue(), allPhrases,
						currentNode, phrase);
			}
		}
	}

}
