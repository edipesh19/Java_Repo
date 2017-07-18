package study.dipesh.dynamicprogramming;

import java.util.Scanner;

public class ZeroOneKnapsack {

	public static void main(String[] args)

	{

		Scanner scan = new Scanner(System.in);
		ZeroOneKnapsack ks = new ZeroOneKnapsack();

		System.out.println("Enter number of elements ");

		int n = scan.nextInt();

		int[] wt = new int[n + 1];

		int[] val = new int[n + 1];

		System.out.println("Enter weight for " + n + " elements");

		for (int i = 1; i <= n; i++)

			wt[i] = scan.nextInt();

		System.out.println("Enter value for " + n + " elements");

		for (int i = 1; i <= n; i++)

			val[i] = scan.nextInt();

		System.out.println("Enter knapsack weight ");

		int W = scan.nextInt();

		ks.solve(wt, val, W, n);
		scan.close();

	}

	private void solve(int[] wt, int[] val, int w, int n) {
		int col = w+1;
		int row = n +1;
		int[][] T = new int[row][col];
		int[] selectedItems = new int[row];

		// Fill the decission matrix
		for (int i = 1; i < row; i++){
			for(int j = 1; j < col; j++){
				if(j < wt[i]){
					T[i][j] = T[i-1][j];
				} else{
					int m1 = val[i] + T[i-1][j-wt[i]];
					int m2 = T[i-1][j];
					T[i][j] = Math.max(m1, m2);
				}
			}
		}
		System.out.println("Max value = " + T[row-1][col-1]);

		// Iterate to get the items
		for(int i = row -1, j = col-1; i > 0; i--){
			if(T[i][j] > T[i-1][j]){
				selectedItems[i] = 1;
				j = j - wt[i];
			}else{
				selectedItems[i] = 0;
			}
		}

		System.out.print("Selected items =");
		for(int i = 0; i < row; i++){
			if (selectedItems[i] ==1){
				System.out.print(" " + wt[i]);
			}
		}

		System.out.println();


	}
}
