import java.util.*;

public class FractionalKnapsack_ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of items (n):");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Number of items must be positive.");
            sc.close();
            return;
        }

        int[] value = new int[n];
        int[] weight = new int[n];

        System.out.println("Enter " + n + " values (space separated):");
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }

        System.out.println("Enter " + n + " weights (space separated):");
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
            if (weight[i] < 0) {
                System.out.println("Weights must be non-negative. Exiting.");
                sc.close();
                return;
            }
        }

        System.out.println("Enter knapsack capacity (W):");
        int W = sc.nextInt();
        if (W < 0) {
            System.out.println("Capacity must be non-negative. Exiting.");
            sc.close();
            return;
        }

        double maxValue = fractionalKnapsack(W, weight, value, n);
        System.out.printf("Maximum value in the knapsack = %.2f%n", maxValue);

        sc.close();
    }

    static double fractionalKnapsack(int W, int[] weight, int[] value, int n) {
        double[][] items = new double[n][2];

        for (int i = 0; i < n; i++) {
            items[i][0] = (double) weight[i];
            if (weight[i] == 0) {
                items[i][1] = value[i] > 0 ? Double.POSITIVE_INFINITY : 0.0;
            } else {
                items[i][1] = (double) value[i] / (double) weight[i];
            }
        }

        Arrays.sort(items, (a, b) -> Double.compare(a[1], b[1]));

        double remaining = (double) W;
        double totalValue = 0.0;

        for (int i = 0; i < n; i++) {
            if (weight[i] == 0 && value[i] > 0) {
                totalValue += value[i];
            }
        }

        int idx = n - 1;
        while (remaining > 0 && idx >= 0) {
            double wt = items[idx][0];
            double vPerW = items[idx][1];

            if (wt == 0.0) {
                idx--;
                continue;
            }

            double take = Math.min(remaining, wt);
            totalValue += take * vPerW;
            remaining -= take;
            idx--;
        }

        return totalValue;
    }
}
