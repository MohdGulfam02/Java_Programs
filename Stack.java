
import java.util.Scanner;

class StackBody{
	
	static int tos = -1;
	Stack st = new Stack();
	Scanner s = new Scanner(System.in);
	
	void push(int stack[]) {
		if(tos == stack.length-1) {
			System.out.println("\nStack overflow!");
		}
		else {
			System.out.println("\nEnter the data:");
			int data = s.nextInt();
			tos ++;
			stack[tos] = data;
		}
	}
	
	void pop() {
		if(tos < 0) {
			System.out.println("\nStack underflow!");
			Stack.c = false;
		}else {
			tos --;
		}
	}
	
	void traverse(int stack[]) {
		for(int i=0;i<=tos;i++) {
			System.out.print(" "+stack[i]);
		}
	}
}
public class Stack {
	static int op;
	static boolean c = true;
	private static Scanner s;
  
	
	public static void main(String[] args) {
		s = new Scanner(System.in);
		int stackLength = 0;
		System.out.println("\n\nEnter the stack length you want :");
		stackLength = s.nextInt();
		int stack[] = new int[stackLength];
		while(c) {
			System.out.println("\n\nEnter the operation :");
			System.out.println("1. Push :");
			System.out.println("2. Pop :");
			System.out.println("3. Exit :");
			op = s.nextInt();
		
			StackBody sb = new StackBody();
			
			switch (op) {
			
			case 1:
				sb.push(stack);
				System.out.print("push -->");
				sb.traverse(stack);
				break;
			
			case 2:
				sb.pop();
				System.out.print("pop -->");
				sb.traverse(stack);
				break;
				
		
			case 3:
				System.out.println("\nExit form the program now restast to use again!");
				c = false;
				break;
				
			default :
				System.out.println("\nEnter correct operation");
			}
		}
	}
}