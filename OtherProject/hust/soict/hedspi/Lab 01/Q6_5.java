import java.util.Arrays;
import java.util.Scanner;

public class Q6_5 {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        long[] a = new long[n];
        
        for (int i = 0; i < a.length; i++) {
            a[i] = num.nextLong();
        }
        
        for (int i = 0; i < a.length; i++) {
            Arrays.sort(a);
        }
        
        long sum = 0;
        long product = 1;
        
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            product *= a[i];
        }
        
        System.out.print("Sorted array issssss: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        
        System.out.println("Product: " + product);
        System.out.println("Sum: " + sum);
        
        num.close();
    }
}
