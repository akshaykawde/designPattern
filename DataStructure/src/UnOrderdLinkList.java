
//package Package;
import java.util.Scanner;
public class UnOrderdLinkList {
	static Node head;
	static class Node
	{
		int data;
		Node next;
		Node()
		
		{
		next=null;	
		}
		Node(int data)
		{
			
		this.data=data;
		this.next=null;
		}
	
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int x;
		for(int i=0;i<5;i++)
		{
			System.out.println("enter number");
			x=sc.nextInt();
			//insertLastPosition(x);
			insertAtFirstPosition(x);
			
		}
		System.out.println("Linllist is");
		DisplayLinkedlist();
		System.out.println("enter number that you should to be deleted");
		int serchelemet=sc.nextInt();
		boolean isElementFound=search(serchelemet);
		if(isElementFound==true)
		{
			removeDuplicateElement(serchelemet);
		}
		else
		{
			insertLastPosition(serchelemet);
		}
		System.out.println("Linllist is");
		DisplayLinkedlist();
		sc.close();
	}
	public static void insertLastPosition(int x)
	{
		
		Node newNode=new Node(x);
		
		
		Node tempNode=head;
		
		if(tempNode==null)
		{
			head=newNode;
			return;
		}
		else
		{
			while(tempNode.next!=null)
			{
				tempNode=tempNode.next;
			}
			tempNode.next=newNode;
		}	
	
		
	}
	public static void DisplayLinkedlist()
	{
		Node tempNode=head;
		while(tempNode!=null)
		{
			System.out.print("|"+tempNode.data+"|->");
			tempNode=tempNode.next;
		}	
	}
	public static void insertAtFirstPosition(int x)
	{
		Node newNode=new Node(x);
		Node tempNode=head;
		if(tempNode==null)
		{
			head=newNode;
		}
		else
		{
			head=newNode;
			newNode.next=tempNode;
		}
		
	}
	public static boolean search(int serchelemet)
	{
		Node tempNode=head;
		while(tempNode!=null)
		{
			if(tempNode.data==serchelemet)
			{	
				return true;
			}
			tempNode=tempNode.next;
	
		}
		return false;
	}
	public static void removeDuplicateElement(int serchelemet)
	{
		Node CurrentNode=head;
		Node prevNode=null;
		
		if(CurrentNode==null)
		{
			return;
		}
		else
		{
			if(CurrentNode.next==null && CurrentNode.data==serchelemet)
			{
				head=null;
				return;
			}
			else if (CurrentNode.next!=null && CurrentNode.data==serchelemet)
			{
                head = CurrentNode.next;
                return;
            }
			while(CurrentNode.next!=null)
			{
				if(CurrentNode.data==serchelemet)
				{
					prevNode.next=CurrentNode.next;
					//CurrentNode.next=null;
				}
				prevNode=CurrentNode;
				CurrentNode=CurrentNode.next;
			}
			prevNode.next=null;
		}
	}

}