package com.daily.challenges;

import java.util.*;


/*
*
1239. Maximum Length of a Concatenated String with Unique Characters

You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.
Return the maximum possible length of s.
A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are:
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
* */
public class MaxLengthOfConcatStringWithUniqueChars {
	public static int maxLength(String[] A)
	{
		List<Set<Character> > dp = new ArrayList<>(Arrays.asList(new HashSet<>()));
		int res = 0;
		for (String s : A) {
			Set<Character> currentSet = new HashSet<>();
			for (char c : s.toCharArray())
				currentSet.add(c);
			if (currentSet.size() < s.length()){
				continue; // duplicate chars in current string
			}
			for (int i = dp.size() - 1; i >= 0; --i) {
				Set<Character> lastSet = new HashSet<>(dp.get(i));
				if (!Collections.disjoint(currentSet, lastSet)){
					continue; // if 1 or more char common
				}
				Set<Character> newSet = new HashSet<>();
				newSet.addAll(currentSet);
				newSet.addAll(lastSet);
				dp.add(newSet);
				res = Math.max(res, lastSet.size() + currentSet.size());
			}
		}
		return res;
	}

	public static void main(String[] args)
	{
		//String[] v = { "ab", "cd", "ab" };
		String[] v = { "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"};
		int ans = maxLength(v);
		System.out.println(
			ans); // resultant answer string : cfbdghzest
	}
}
