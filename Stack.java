import java.util.Scanner;

class StackMethod{
	final int SIZE = 10;
	int[] stack = new int[SIZE];
	int tos = -1;
//	Stack object = new Stack();
	
	void push(int data) {
		if(tos == 10) {
			System.out.println("\nStack overflow!");
		}else {
			tos++;
			stack[tos] = data;
			traverse("Push");
		}
	}
	
	void pop() {
		if(tos == -1) {
			System.out.print("\nStack underflow!");
			Stack.condition = false;
		}
		else {
			tos--;
			traverse("Dequeue");
		}
		
	}
	
	void traverse(String str) {
		System.out.print(str +"--> ");
		for(int i = 0 ;i <= tos; i++) {
			System.out.print(" "+stack[i]);
		}
	}
}
public class Stack {

	static boolean condition = true;
	static Scanner input = new Scanner(System.in);
	static StackMethod obj = new StackMethod();
	
	public static void main(String[] args) {
			
		while(condition == true) {
			System.out.println("\nEnter the Operation :\n1. Push \n2. Pop \n3. Exit");
			int op = input.nextInt();
			switch (op){
			case 1:
				System.out.println("\nEnter the element :");
				int data = input.nextInt();
				obj.push(data);
				break;
				
			case 2:
				obj.pop();
				break;
				
			case 3:
				System.out.println("\nByee byee :) \nRerun the code if want to use stack. ");
				condition = false;
				break;
			
			default:
				System.out.println("\nEnter correct operaion!");
			}
		}
	}
}

