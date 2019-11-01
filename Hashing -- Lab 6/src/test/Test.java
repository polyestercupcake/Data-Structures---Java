package test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import model.HashFunction;

/**
 * This class handles testing hash codes against words in the dictionary.
 * Special thanks to https://github.com/dwyl/english-words for words.txt
 * 
 * @author cberkstresser
 *
 */
public class Test {
	/** a list of dictionary words for testing the hash. */
	private List<String> dictionary = new ArrayList<>();
	/** a list of dictionary words for testing the hash (filtered by uniqueness). */
	private Set<String> dictionaryUnique = new HashSet<>();
	/** a list of hashes generated from the dictionary words. */
	private List<String> dictionaryHashes = new ArrayList<>();
	/** a list of unique hashes generated from the dictionary words. */
	private Set<String> dictionaryUniqueHashes = new HashSet<>();
	/** The hash function to test */
	private HashFunction f;

	/**
	 * Constructor.
	 * 
	 * @param f The hash function to test and for which to show statistics.
	 */
	public Test(HashFunction f) {
		this.f = f;
		fillInput();
	}

	/**
	 * Fill the input from the text file of dictionary words.
	 */
	private void fillInput() {
		String n;
		try {
			Scanner in = new Scanner(Paths.get("words.txt"));
			while (in.hasNextLine()) {
				String word = in.nextLine();
				dictionary.add(word);
				dictionaryUnique.add(word);
				dictionaryHashes.add(f.getHash(word));
				dictionaryUniqueHashes.add(f.getHash(word));
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Show the stats on the effictiveness of your hash function.
	 */
	private void printResults() {
		System.out.println("Total words hashed: " + dictionary.size());
		System.out.println("Total unique words hashed: " + dictionaryUnique.size());
		System.out.println("Total hashes: " + dictionaryHashes.size());
		System.out.printf("Total unique hashes: %d (%.2f%% - Should be sufficiently close to 100%%)\n",
				dictionaryUniqueHashes.size(),
				((double) dictionaryUniqueHashes.size() / dictionaryHashes.size() * 100));
	}

	/**
	 * Good ole main.
	 * 
	 * @param args Command line arguments that can be passed into the program.
	 */
	public static void main(String[] args) {
		Test tester = new Test(new HashFunction());
		tester.printResults();
	}

}
