package ui;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import model.HashFunction;

public class Main {

	public static void main(String[] args) {
		//Set<String> hash = new HashSet<>();
		//primary goal: convert input strings into a hash that controls duplicates
//		Map<String,String> states = new HashMap<>();
//		states.put("MO", "Missouri");
//		states.put("AK", "Arkansas");
//		states.put("AZ", "Arizona");
//		System.out.println(states.get("MO"));

//		int x = 1;
//		int y = 2;
//		System.out.println(x & y);
//		System.out.println(x | y);
//		System.out.println(x << 2);
//		System.out.println(x >>> 1);
//		System.out.println(x ^ y);
//		System.out.println(x ^ ~x);
		HashFunction hash = new HashFunction();
		System.out.println(hash.getHash("bar"));
		System.out.println(hash.getHash("arb"));
		System.out.println(hash.getHash("a"));
		System.out.println(hash.getHash("A"));
		System.out.println(hash.getHash("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		System.out.println(hash.getHash("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"));
		System.out.println(hash.getHash("aaaaaaaaabaaaaaaaaaaaaaaaaaaaaaa"));
		System.out.println(hash.getHash("b"));
		System.out.println(hash.getHash("c"));
		System.out.println(hash.getHash("D"));

	}

}

