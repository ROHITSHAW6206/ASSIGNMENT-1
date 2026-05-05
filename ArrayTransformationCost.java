import java.util.*;

public class ArrayTransformationCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sc.close();
        }

        int k = sc.nextInt();

        int remainder = arr[0] % k;
        for (int i = 1; i < n; i++) {
            if (arr[i] % k != remainder) {
                System.out.println(-1);
                return;
            }
        }

        int[] normalized = new int[n];
        for (int i = 0; i < n; i++) {
            normalized[i] = arr[i] / k;
        }

        
        Arrays.sort(normalized);
        int median = normalized[n / 2];

        long operations = 0;
        for (int i = 0; i < n; i++) {
            operations += Math.abs(normalized[i] - median);
        }

        System.out.println(operations);
        sc.close();
    }
}