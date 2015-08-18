package com.talentboost.vmware;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DTreeTest {

	private DTreeNew testTree;
	private String file = "filteredWords";
	@Before
	public void setUp() throws Exception {
		testTree = new DTreeNew();
		FillDTree.fill(file, testTree);
	}

	@Test
	public void testSearchInDTree() {
		assertEquals(true, testTree.search("abbé"));
	}
	
	@Test
	public void testSearchInDTreeOtherWord() {
		assertEquals(true, testTree.search("conscientious"));
	}
	
	@Test
	public void testSearchInDTreeNotEqual() {
		assertEquals(false, testTree.search("wonn"));
	}
	
	@Test
	public void testSearchInDTreeNotEqualOtherWord() {
		assertEquals(false, testTree.search("boosterss"));
	}
	
	@Test
	public void testSearchInDTreeTalent() {
		assertEquals(true, testTree.search("talent"));
	}
	
	@Test
	public void testSearchInDTreeBoost() {
		assertEquals(true, testTree.search("boost"));
	}
	
	@Test
	public void testSearchInDTreeClass() {
		assertEquals(true, testTree.search("class"));
	}
	
	@Test
	public void testSearchInDTreeWhitespace() {
		assertEquals(false, testTree.search(" "));
	}
	
	@Test
	public void testNumberToWordGood() {
		List<String> words = testTree.numberToWord("4663");
		assertEquals(true, words.contains("good"));
	}
	
	@Test
	public void testNumberToWordEarth() {
		List<String> words = testTree.numberToWord("32784");
		assertEquals(true, words.contains("earth"));
	}
	
	@Test
	public void testNumberToWordWonderful() {
		List<String> words = testTree.numberToWord("966337385");
		assertEquals(true, words.contains("wonderful"));
	}
	
	

}
