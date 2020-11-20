import java.util.Scanner;

public class Fibonacci {

	private static Scanner sc;
	void fiboByDirect(int n) {
		long a = 0,b = 1,c;
		System.out.println("\nThe fibonacci series by direct method are : ");
		for(int i = 0;i < n;i++) {
			if(i == 0) {
				System.out.print(""+a);
			}else if(i == 1) {
				System.out.print(" "+b);
			}else {
				c = a + b;
				System.out.print(" "+c);
				a = b;
				b = c;
			}
		}
	}
	long fiboByRecursion(int n) {
		if(n == 1)
			return 0;
		else if (n == 2 || n == 3)
			return 1;
		else {
			return fiboByRecursion(n-1)+fiboByRecursion(n-2);
		}
	}
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Fibonacci obj = new Fibonacci();
		System.out.println("\nEnter the number upto which you want to find fibonacci series :");
		int n = sc.nextInt();
		obj.fiboByDirect(n);
		System.out.println("\n\nThe fibonacci series by recursion method are : ");
		for(int i = 1;i <= n;i ++) {
			System.out.print(" "+obj.fiboByRecursion(i));
		}
	}
}
