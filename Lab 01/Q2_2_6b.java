import java.util.Scanner;

public class Q2_2_6b {
	public static void main(String[] args) {
		Scanner Shuriky = new Scanner(System.in);
		double a11 = Shuriky.nextDouble(); // nhap so a11
		double a12 = Shuriky.nextDouble(); // nhap so a12
		double b1 = Shuriky.nextDouble(); // nhap so b1
		double a21 = Shuriky.nextDouble();// nhap so a21
		double a22 = Shuriky.nextDouble();// nhap so a22
		double b2 = Shuriky.nextDouble();// nhap so b2
		// a11 * x1 + a12 * x2 = b1
		// a21 * x1 + a22 * x2 = b2
		double detM = a11 * a22 - a12 * a21;
		if(detM != 0)
		{
			double x1 = (b1 * a22 - a12 * b2) / detM;
	        double x2 = (a11 * b2 - b1 * a21) / detM;
			System.out.println("He phuong trinh co nghiem DUY NHAT la: ");
			System.out.println("x1: " + x1);
			System.out.println("x2: " + x2);
		}
		else
		{
			if ((a11 * b2 == b1 * a21) && (a12 * b2 == b1 * a22))
			{
				System.out.println("He phuong trinh vo so nghiem");
			}
			else
				System.out.println("He phuong trinh vo nghiem");
		}
		}
}
