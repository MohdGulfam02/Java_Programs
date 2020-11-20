import java.util.Scanner;
import java.lang.Math;

class CheckPrime{
	void checkPrime(int number) {
		boolean flag = false;
		for(int i = 2;i <= Math.sqrt(number);i++) {
			if(number % i == 0 ) {
				flag = true;
			}
		}
		if(flag == false && number != 1 ) {
			System.out.println("\nYes,It is a Prime number");
		}else {
			System.out.println("\nNot a Prime Number");
		}
	}
}

class FindPrime{
	void findPrime(int l,int u) {
		int j;
		System.out.println("\nPrime Numbers are ..");
		for(int i = l;i <= u;i ++) {
			for(j = 2;j <= i; j++) {
				if(i % j == 0) {
					break;
				}
			}
			if(i == j) {
				System.out.print(" "+i);
			}
		}
	}
}

class TwinPrime{
	void twinPrime(int lw, int up) {
		int j,p = 0;
		int[] twin = {0,0};
		System.out.println("\nTwin Prime Numbers are ..");
		for(int i = lw;i <= up;i ++) {
			for(j = 2;j <= i; j ++) {
				if(i % j == 0) {
					break;
				}
			}
			if(i == j) {
				if(p >= 2){
					p = 1;
					twin[0] = twin[1];
					twin[1] = 0;
					twin[p] = j;
					p++;
				}else {
					twin[p] = j;
					p++;
			    }
				if(twin[1] - twin[0] == 2) {
					System.out.println("{"+twin[0]+","+twin[1]+"}");
					i++;
				}
			}
		}
	}
}

public class Prime {

	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		boolean  condition = true;
		CheckPrime checkObj = new CheckPrime();
		FindPrime findObj = new FindPrime();
		TwinPrime twinObj = new TwinPrime();
		
		while(condition) {
			System.out.println("\n\nEnter the type : \n1.Check Prime or not :\n2.Find in Range :\n3.Find Twin Prime in range :\n4.Exit : ");
			int op = in.nextInt();
			
			switch(op) {
			case 1:
				System.out.println("\nEnter the number to check :");
				int data = in.nextInt();
				checkObj.checkPrime(data);
				break;
				
			case 2:
				System.out.println("\nEnter the lower range :");
				int l = in.nextInt();
				System.out.println("\nEnter the upper range :");
				int u = in.nextInt();
				findObj.findPrime(l,u);
				break;
				
			case 3:
				System.out.println("\nEnter the lower range :");
				int lw = in.nextInt();
				System.out.println("\nEnter the upper range :");
				int up = in.nextInt();
				twinObj.twinPrime(lw,up);
				break;
				
			case 4:
				condition = false;
				break;
				
			default :
				System.out.println("\nEnter correct input!");
			}
		}
	}
}
