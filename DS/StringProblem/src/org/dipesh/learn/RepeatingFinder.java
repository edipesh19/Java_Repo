package org.dipesh.learn;

public class RepeatingFinder {
	
	public static boolean repeating(String s) {
		if (s == null || s.length() <= 1) {
			return false;
		}
		
		char[] arr = s.toCharArray();
		
		int start = 0;
		int end = 1;
		int endPat = 0;
		boolean val = false;
		
		while(arr.length > end) {
			if(arr[start] == arr[end]) {
				int patLength = endPat;
				for(int i = 0; i <= patLength; i++) {
					if(arr.length > end && arr[i] == arr[end]) {
						end++;
						val = true;
					}
					else {
						endPat = end-1;
						val = false;
					}
				}
			}
			else {
				endPat = end;
				end++;
				val = false;
			}
		}
		return val;
	}
	
	public static void main(String[] args) {
		String[] s = {"hashhashhashh", "xaxaxaxxaxaxaxxaxaxax", "abcabcd", "abcdabcd"};
		for(int i = 0; i < s.length; i++) {
			System.out.println(repeating(s[i]));
		}
	}

}
