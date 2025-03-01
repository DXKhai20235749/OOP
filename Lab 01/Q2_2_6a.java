import java.util.Scanner;

public class Q2_2_6a {
	public static void main(String[] args)
	{
		Scanner Shuriky = new Scanner(System.in);
		double a = Shuriky.nextDouble(); // nhap a
		double b = Shuriky.nextDouble(); // nhap b
		double x = -b/a;
		if(a == 0)
		{
			if(b == 0)
			{
				System.out.println("Phuong Trinh Vo So Nghiem");
			}
			else
				System.out.println("Phuong Trinh Vo Nghiem");
		}
		else
		System.out.println(x);
	}
}
