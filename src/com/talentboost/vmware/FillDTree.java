package com.talentboost.vmware;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * This class provide logic of filling particular Tree with words.
 * 
 * @author KSamardzhiev
 *
 */
public class FillDTree {
	/**
	 * 
	 * @param file
	 *            - File from which to read the words.
	 * @param tree
	 *            - Instance of class DTreeNew which the method fills with
	 *            words.
	 */
	public static void fill(String file, DTreeNew tree) {

		Scanner fileReader = null;
		try {
			fileReader = new Scanner(new FileReader(file));
			while (fileReader.hasNext()) {
				String word = fileReader.next();
				tree.insert(word);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			fileReader.close();
		}
	}
}
