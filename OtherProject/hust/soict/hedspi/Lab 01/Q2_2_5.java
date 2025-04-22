import java.util.Scanner;
public class Q2_2_5 {
	public static void main(String[] args) {
		Scanner Shuriky = new Scanner(System.in);
		int num1 = Shuriky.nextInt(); // nhap so thu 1
		int num2 = Shuriky.nextInt(); // nhap so thu 2
		System.out.println("Tong: "+( num1 + num2));
		System.out.println("Hieu: "+( num1 - num2));
		System.out.println("Tich: "+( num1 * num2));
		if (num2 == 0)
		{
			System.out.println("Khong chia duoc");
		}
		else
			System.out.println("Thuong: "+ ((double) num1 / num2));
		Shuriky.close();
	}
	
}
