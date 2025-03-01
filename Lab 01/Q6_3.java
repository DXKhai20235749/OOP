import java.util.Scanner;
public class Q6_3 {
	public static void main(String[] args)
	{
		Scanner num = new Scanner(System.in);
		int n = num.nextInt();
		for(int i = 0; i<n; i++)
		{
			for(int j = 0; j<n-i-1; j++)
			{
				System.out.print(" ");
			}
			for(int k = 0; k<2*i+1;k+=1)
			System.out.print("*");
			System.out.println("");
		}
		num.close();
	}
}
