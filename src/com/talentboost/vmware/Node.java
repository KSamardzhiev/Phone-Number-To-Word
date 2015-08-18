package com.talentboost.vmware;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provide logic of each Node in DTreeNew class
 * 
 * @author KSamardzhiev
 *
 */
public class Node {
	/**
	 * This Map stored the children of each instance of the class Node (e.g the
	 * children of particular node).
	 */
	private Map<Character, Node> children = new HashMap<Character, Node>();
	/**
	 * This variable stores the value of the Node.
	 */
	private char value;
	/**
	 * This boolean variable stores the state of each Node. True if the node
	 * value is end of existing word and false if the node value is not end of
	 * existing word
	 */
	private boolean isWord = false;

	/**
	 * 
	 * @param value
	 *            - character value of particular node(instance of the class
	 *            Node)
	 * @author KSamardzhiev - This constructor make instance of the class Node
	 *         with set particular value.
	 */
	public Node(char value) {
		this.value = value;
	}

	/**
	 * 
	 * @param value
	 *            - character value of particular node(instance of the class
	 *            Node).
	 * @param isWord
	 *            - state of the Node (true if the node value is end of existing
	 *            word and false if the node value is not end of existing word).
	 * @author KSamardzhiev - This constructor make instance of the class Node
	 *         with set particular value and boolean state of this Node.
	 */
	public Node(char value, boolean isWord) {
		this.value = value;
		this.isWord = isWord;
	}

	/**
	 * 
	 * @param ch
	 *            - Letter which map the particular Node.
	 * @return Node - The child Node that correspondence to particular letter
	 *         (e.g. letter 'a' will return this child thats value is equal to
	 *         'a').
	 */
	public Node getChild(char ch) {
		return children.get(ch);
	}

	/**
	 * 
	 * @param ch
	 *            - Letter which map the particular Node.
	 * @return True if the map of the Node contains element thats value is equal
	 *         to the parameter and false otherwise.
	 */
	public boolean contain(char ch) {
		if (children.containsKey(ch)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param node
	 *            - Instance of the class Node.
	 * @author KSamardzhiev - put new key - value in the map of children of the
	 *         Node.
	 */
	public void addChild(Node node) {
		children.put(node.getValue(), node);
	}

	/**
	 * 
	 * @return - The value of the Node.
	 */
	public char getValue() {
		return this.value;
	}

	/**
	 * 
	 * @return - The map of all children of the Node.
	 */
	public Map<Character, Node> getAllChilds() {
		return this.children;
	}

	/**
	 * 
	 * @return - State of the Node (true if node value is end of existing word
	 *         and false otherwise).
	 */
	public boolean getIsWord() {
		return this.isWord;
	}

	/**
	 * 
	 * @param isWord
	 *            - State of the node.
	 * @author KSamardzhiev - This method provide ability to set state of the
	 *         node.
	 */
	public void setIsWord(boolean isWord) {
		this.isWord = isWord;
	}
}