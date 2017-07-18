package study.dipesh.dynamicprogramming;



public class LongestCommonSubsequence {

	public static void main(String args[]){
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";

        int result = lcs.lcsDynamic(str1.toCharArray(), str2.toCharArray());
        System.out.print(result);
}

	private int lcsDynamic(char[] charArray1, char[] charArray2) {
		int row = charArray1.length +1;
		int col = charArray2.length +1;
		int[][] T = new int[row][col];

		for(int i = 1; i < row; i++){
			for (int j = 1; j < col; j++){
				if(charArray1[i-1] == charArray2[j-1]){
					T[i][j] = 1 + T[i-1][j-1];
				}else{
					T[i][j] = Math.max(T[i-1][j], T[i][j-1]);
				}
			}
		}

		// Print the characters
		for(int i = row-1, j = col-1; i > 0 && j > 0; i--){
			if (T[i][j] != T[i-1][j] || T[i][j] != T[i][j-1]){
				System.out.print(charArray2[j-1] + " ");
				j--;
			} else{
				int x = j;
				while(T[i][x] == T[i][x-1]){
					x--;
				}
				j = x;
			}
		}

		System.out.println();

		return T[row-1][col-1];
	}
}
