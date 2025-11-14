public class fibonacci_iterative {
    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int prev1 = 1;  
        int prev2 = 0;  
        int current = 0;

        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));
    }
}

