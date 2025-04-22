import java.util.Scanner;

public class Q6_6 {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        System.out.print("Nhap so hang cua 2 ma tran: ");
        int r = num.nextInt();
        System.out.println("");
        System.out.print("Nhap so cot cua 2 ma tran: ");
        int c = num.nextInt();
        System.out.println("");
        long[][] a = new long[r][c];
        
        System.out.println("Nhap ma tran so 1: ");

        for (int i = 0; i < r; i++)
        for (int j = 0; j < c; j++)
        {
            a[i][j] = num.nextLong();
        }
        
        System.out.println("Nhap ma tran so 2: ");
        
        long[][] b = new long[r][c];
        for (int i = 0; i < r; i++)
        for (int j = 0; j < c; j++)
        {
            b[i][j] = num.nextLong();
        }
        
        long[][] result = new long[r][c];
        
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
            {
            	result[i][j] = a[i][j] + b[i][j];
            }
        System.out.println("Ket qua la: ");
        for (int i = 0; i < r; i++) {
        	for (int j = 0; j < c; j++)
            {
            	System.out.print(result[i][j] + " ");
            }
        	System.out.println("");
        }
            
        
        
        num.close();
    }
}