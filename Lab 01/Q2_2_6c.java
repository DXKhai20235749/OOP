import java.util.Scanner;

public class Q2_2_6c {
	public static void main(String[] args)
	{
		Scanner Shuriky = new Scanner(System.in);
		double a = Shuriky.nextDouble(); // nhap a
		double b = Shuriky.nextDouble(); // nhap b
		double c = Shuriky.nextDouble(); // nhap c
		double delta = b*b - 4 * a * c;
		if(delta > 0)
		{
			System.out.println("Phuong trinh co hai nghiem:");
			double x1 = (-b + Math.sqrt(delta)) / 2 / a;
			double x2 = (-b - Math.sqrt(delta)) / 2 / a;
			System.out.println("x1: "+ x1);
			System.out.println("x2: "+ x2);
		}
		else if (delta == 0)
		{
			System.out.println("Phuong trinh co nghiem duy nhat: ");
			double x = -b/2/a;
			System.out.println("x: " + x);
		}
		else if (delta < 0)
		System.out.println("Phuong trinh vo nghiem");
	}
	
}
