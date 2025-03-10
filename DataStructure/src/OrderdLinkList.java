import java.util.*;

public class OrderdLinkList {
	static OrderdLinkList Oll=new OrderdLinkList();
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
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of element insert or delet from Linklist");
		int noOfElements = sc.nextInt();
		System.out.println("enter value to insert in Linklist");
		for(int i=1;i<=noOfElements;i++)
		{
			int x=sc.nextInt();
			insertionBySorting(x);
		}
		System.out.println("enter number");
		int searchelement =sc.nextInt();
		boolean isElementFound=search(searchelement);
		if(isElementFound==true)
		{
			removeDuplicateElement(searchelement);
		}
		else
		{
			insertionBySorting(searchelement);
		}
		
		System.out.println("updated LinkList is");
		DisplayLinkedlist();
		sc.close();
	}
	public static void insertionBySorting(int x)
	{		
		Node newNode=new Node(x);
		Node CurrentNode=head;
		Node prevNode=null;
		if(CurrentNode==null)
		{
			head=newNode;
		}
		else if(CurrentNode.next==null && x >CurrentNode.data){
		CurrentNode.next=newNode;
		return;
		}
		else if(CurrentNode.next==null  && x<CurrentNode.data){
			head=newNode;
			newNode.next=CurrentNode;
			}
		else
		{
			while(CurrentNode.next!=null && x>CurrentNode.data)
			{
				prevNode=CurrentNode;
				CurrentNode=CurrentNode.next;
				
			}
			if( newNode.data < CurrentNode.data)
			{
				 prevNode.next=newNode;
				 newNode.next=CurrentNode;
			}
			else if(newNode.data>CurrentNode.data)
			{
				CurrentNode.next=newNode;
				return;
			}
		}
		
	}
	public static boolean search(int searchElement)
	{
		Node tempNode=head;
		while(tempNode!=null)
		{
			if(tempNode.data==searchElement)
			{
				return true;
			}
			tempNode=tempNode.next;
		}
		return false;
	}
	
	public static void removeDuplicateElement(int searchelement)
	{
		Node CurrentNode=head;
		Node prevNode=null;
		
		if(CurrentNode==null)
		{
			return;
		}
		else
		{
			if(CurrentNode.next==null && CurrentNode.data==searchelement)
			{
				head=null;
				return;
			}
			else 
			{
				while(CurrentNode.next!=null)
				{
					if(CurrentNode.data==searchelement)
					{
						prevNode.next=CurrentNode.next;
						//CurrentNode.next=null;
						return;
					}
					prevNode=CurrentNode;
					CurrentNode=CurrentNode.next;
				}
				prevNode.next=CurrentNode.next;
				
			}
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
}