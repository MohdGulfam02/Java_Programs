import java.util.Scanner;

public class Factorial {

	private static Scanner sc;
	long factByRecursion(int n) {
	
		if (n == 0 || n == 1)
			return 1;
		else
			return n*factByRecursion(n-1);
	
	}
	
	void factByDirect(int n) {
		System.out.println("\nThe factorial of "+n+" by direct method is : ");
		long f = 1;
		for(int i = 1;i <= n;i ++) {
			f = f * i;
		}
		System.out.println(""+f);
	}
	
	public static void main(String[] args) {
		
		int n;
		Factorial obj = new Factorial();
		sc = new Scanner(System.in);
		System.out.println("\nEnter the number to find factorial :");
		n = sc.nextInt();	
		System.out.println("\nThe factorial of "+n+" by recursion method is : "+obj.factByRecursion(n));
		obj.factByDirect(n);
	}
}
