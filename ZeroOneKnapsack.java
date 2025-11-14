import java.util.*;

public class ZeroOneKnapsack {
	public static int knapsack(int val[], int wt[], int W, int i, int dp[][]) {
		if (i == 0 || W == 0)
			return 0;

		if (dp[i][W] != -1)
			return dp[i][W];

		if (wt[i - 1] <= W) {
			int ansOne = val[i - 1] + knapsack(val, wt, W - wt[i - 1], i - 1, dp);
			int ansTwo = knapsack(val, wt, W, i - 1, dp);
			dp[i][W] = Math.max(ansOne, ansTwo);
			return dp[i][W];
		} else {
			return knapsack(val, wt, W, i - 1, dp);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Take number of items
		System.out.print("Enter number of items: ");
		int n = sc.nextInt();

		int val[] = new int[n];
		int wt[] = new int[n];

		System.out.println("Enter values of items:");
		for (int i = 0; i < n; i++) {
			val[i] = sc.nextInt();
		}

		System.out.println("Enter weights of items:");
		for (int i = 0; i < n; i++) {
			wt[i] = sc.nextInt();
		}

		System.out.print("Enter Knapsack capacity W: ");
		int W = sc.nextInt();

		int[][] dp = new int[n + 1][W + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}

		int result = knapsack(val, wt, W, n, dp);
		System.out.println("Maximum profit is: " + result);

		sc.close();
	}
}
