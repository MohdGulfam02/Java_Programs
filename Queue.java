import java.util.Scanner;

class QueueStore{
	final int SIZE = 10;
	int[] queue = new int[SIZE];
	int end = 0;
	int front = -1;
	Queue object = new Queue();
	void enqueue(int data) {
		if(front == -1) {
			front++;
			queue[front] = data;
			end = front;
			traverse("Enqueue");
		}else {
			end++;
			queue[end] = data;
			traverse("Enqueue");
		}
	}
	
	void dequeue() {
			
		if(front == end) {
			System.out.print("\nNothing in the queue ");
			Queue.condition = false;
		}
		else {
			front++;
			traverse("Dequeue");
		}
		
	}
	
	void traverse(String str) {
		System.out.print(str +"--> ");
		for(int i = front ;i <= end; i++) {
			System.out.print(" "+queue[i]);
		}
	}
}

public class Queue {
	
	public static boolean condition = true;
	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		
		QueueStore obj = new QueueStore();
		
		while(condition == true) {
			System.out.println("\nEnter the Operation :\n1. Enqueue \n2. Dequeue \n3. Exit");
			int op = input.nextInt();
			switch (op){
			case 1:
				System.out.println("\nEnter the element to enqueue the queue :");
				int data = input.nextInt();
				obj.enqueue(data);
				break;
				
			case 2:
				obj.dequeue();
				break;
				
			case 3:
				condition = false;
				break;
			
			default:
				System.out.println("\nEnter correct operaion!");
			}
		}
	}

}
