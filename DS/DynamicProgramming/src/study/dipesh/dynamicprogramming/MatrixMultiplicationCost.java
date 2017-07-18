package study.dipesh.dynamicprogramming;

public class MatrixMultiplicationCost {

	public static void main(String args[]) {
		int arr[] = new int[] { 4, 2, 3, 5, 3, 4, 6, 7 };
		int size = arr.length;

		System.out.println("Minimum number of multiplications is " + solve(arr, size));
	}

	static int solve(int p[], int n){
		int[][] T = new int [n][n];


		// m is the size of the matrix
		int m =  n-1;

		for (int L =2; L <= m; L++){

			for (int i = 1; i <= m-L+1; i++){
				int j = i+L-1;
				T[i][j] = Integer.MAX_VALUE;
				for(int k = i; k < j; k++){
					int q = T[i][k] + T[k+1][j] + p[i-1]*p[k]*p[j];
					if(q < T[i][j]){
						T[i][j] = q;
					}
				}
			}
		}

		return T[1][m];

	}
}
