import java.util.Scanner;
public class LinkedList {
	static Scanner sc;
	private static int data,countOfNodes = 1,position,countOfCreation = 0;
	private static boolean condition = true;
	
	Node head ;
	
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public static LinkedList insert(LinkedList list,int data) {
		
		countOfNodes ++;
		Node new_node = new Node(data);
		new_node.next = null;
		
		if(position == 1) {
			new_node.next = list.head;
			list.head = new_node;
		}else if (position > 1){
			Node pointer = list.head;
			int i = 1;
			while(i < position -1) {
				pointer = pointer.next;
				i++;
			}
			new_node.next = pointer.next;
			pointer.next = new_node;
		}else {
			if(list.head == null) {
				list.head = new_node;
			}else {
				Node currNode = list.head;
				while(currNode.next != null) {
					currNode = currNode.next;
				}
				
				currNode.next = new_node;
			}
		}		
		return list;
	}
	
	public static void printList(LinkedList list) {
		Node pointer = list.head;
		System.out.print("\nList --> ");
		while(pointer != null) {
			System.out.print(" " + pointer.data);
			pointer = pointer.next;
		}
	}
	
	public static LinkedList createLinkedList(LinkedList list) {
		if (countOfCreation < 1) {
			sc = new Scanner(System.in);
			System.out.println("\nEnter the number of nodes :");
			int countOfNode = sc.nextInt();
			
			for(int i = 1;i <= countOfNode; i ++) {
				System.out.println("\nEnter the data to store in a list :");
				data = sc.nextInt();
				insert(list, data);
			}
			printList(list);
			countOfCreation ++;
			
		}else {
			System.out.println("\nList already present!");
		}
		return list;
	}
	
	public static LinkedList insertAtBeginning(LinkedList list,int data) {
		position = 1;
		insert(list,data);
		return list;
	}
	
	public static LinkedList insertAtIndex(LinkedList list,int data,int position){
		insert(list,data);		
		return list;
	}
	
	public static LinkedList insertAtEnd(LinkedList list,int data) {
		position = countOfNodes;
		insert(list,data);
		return list;
	}
	
	public static LinkedList deleteAtEnd(LinkedList list) {
		countOfNodes--;
		Node pointer = list.head;
		while(pointer.next.next != null) {
			pointer = pointer.next;
		}
		pointer.next = null;
		
		return list;
	}
	
	public static LinkedList deleteFromBeginning(LinkedList list) {
		countOfNodes--;
		Node pointer = list.head;
		list.head = pointer.next;
		return list;
	}

	public static LinkedList deleteAtIndex(LinkedList list, int position) {
		countOfNodes--;
		if(position == 1)
			deleteFromBeginning(list);
		else if(position == countOfNodes)
			deleteAtEnd(list);
		else {
			int i = 1;
			Node pointer = list.head;
			while(i < position-1) {
				pointer = pointer.next;
				i++;
			}
			pointer.next = pointer.next.next;
		}
		return list;
	}
	
	public static LinkedList searchList(LinkedList list, int element) {
		Node pointer = list.head;
		boolean flag = false;
		int i;
		lebel1 :{
			for(i = 1;i <= countOfNodes;i ++) {
				if(pointer.data == element) {
					flag = true;
					break;
				}else {
					pointer = pointer.next;
					if(pointer == null)
					{
						System.out.println("\nElement not found! ");
						break lebel1;
					}
				}
			}
			if(flag)
				System.out.println("\nYes,element is found ,the index is :"+i);
		}
		return list;
	}
	
	public static LinkedList sortList(LinkedList list) {
		
		int temp;
		for(Node i = list.head;i != null;i = i.next) {
			for(Node j = i.next;j != null;j = j.next) {
				if(i.data > j.data) {
					temp = i.data;
					i.data = j.data;
					j.data = temp;
				}
			}
		}
		
		return list;
	}

	public static LinkedList deleteElement(LinkedList list,int data) {
		
		Node pointer = list.head;
		lebel :{
			if(pointer.data == data) { 
				countOfNodes--;
				list.head = pointer.next;
				}
			else {
				while(pointer.next.data != data) {
					pointer = pointer.next;
					if(pointer.next == null) {
						System.out.println("\nElement not found!");
						break lebel;
					}
				}
				countOfNodes--;
				pointer.next = pointer.next.next;
			}
		}
		return list;
	}
	
	public static void main(String [] args) {
		LinkedList list = new LinkedList();
		sc = new Scanner(System.in);
		
		while(condition == true) {
			System.out.println("\n\nChoose the operation \n1. Create LinkedList :\n2. Insert at beginning :\n3. Insert at index :\n4. Insert at the end :\n5. Delete from end : \n6. Delete from beginning : \n7. Delete by index : \n8. Search the data :\n9. Sort the list : \n10. Delete the data :\n11. Exit");
			int op = sc.nextInt();
			
			switch(op) {
			case 1:
				createLinkedList(list);
				break;
			
			case 2:
				System.out.println("\nEnter the data to insert at beginning :");
				data = sc.nextInt();
				insertAtBeginning(list,data);
				printList(list);
				break;
			
			case 3:
				if(countOfNodes == 1) {
					System.out.println("\nNo List is there! \nFirst create a list.");
				}else {
					System.out.println("\nEnter the data to insert :");
					data = sc.nextInt();
					System.out.println("\nEnter the index or postion :");
					position = sc.nextInt();
					insertAtIndex(list,data,position);
					printList(list);
					}
				break;
				
			case 4:
				if(countOfNodes == 1) {
					System.out.println("\nNo List is there! \nFirst create a list.");
				}else {
					System.out.println("\nEnter the data to insert at the end :");
					data = sc.nextInt();
					insertAtEnd(list,data);
					printList(list);
				}
				break;
				
			case 5:
				if(countOfNodes == 1) {
					System.out.println("\nNothing to delete!  \nFirst create a list.");
				}else {
					deleteAtEnd(list);
					printList(list);
				}
				break;
				
			case 6:
				if(countOfNodes == 1) {
					System.out.println("\nNothing to delete!  \nFirst create a list.");
				}else {
					deleteFromBeginning(list);
					printList(list);
				}
				break;
				
			case 7:
				if(countOfNodes == 1) {
					System.out.println("\nNothing to delete!  \nFirst create a list.");
				}else {
					System.out.println("\nEnter the index or position to delete the data :");
					position = sc.nextInt();
					deleteAtIndex(list,position);
					printList(list);
				}
				break;
				
			case 8:
				if(countOfNodes == 1) {
					System.out.println("\nNothing to search in the list  \nFirst create a list.");
				}else {
					System.out.println("\nEnter the element to search :");
					int element = sc.nextInt();
					searchList(list,element);
				}
				break;
			
			case 9:
				if(countOfNodes == 1) {
					System.out.println("\nNo List is there to sort!  \nFirst create a list.");
				}else {
					sortList(list);
					printList(list);
				}
				break;
			
			case 10:
				if(countOfNodes == 1) {
					System.out.println("\nNothing to delete!  \nFirst create a list.");
				}else {
					System.out.println("\nEnter the  element to delete :");
					int data = sc.nextInt();
					deleteElement(list,data);
					printList(list);
				}
				break;
				
			case 11:
				condition = false;
				break;
				
			default:
				System.out.println("\nWrong input!"); 
			}	
		}
	}
}