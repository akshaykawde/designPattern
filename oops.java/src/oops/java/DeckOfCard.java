package oops.java;
import java.util.*;

public class DeckOfCard {
static DeckOfCard DeckOfCard=new DeckOfCard();
Node[] head=new Node[4];
 static class Node
 {
	 String data;
	 Node next;
	 Node(String data)
	 {
		 this.data=data;
		 next=null;
	 }
 }
	 public static void main(String[] args)
	 {
		 for(int i=0;i<4;i++)
		 {
			 for(int j=0;j<9;j++)
			 {
				 String Card=DeckOfCard.getRank()+" "+DeckOfCard.getSuit();
				 DeckOfCard.addData(Card,1);
			 }
		 }
		 DeckOfCard.printCards();
		 }
	 private void printCards()
	 {
		 for(int i=0;i<4;i++)
		 {
			 Node NewNode=DeckOfCard.head[i];
			 while(NewNode!=null)
			 {
				 System.out.println(i+" " +NewNode.data);
				 NewNode=NewNode.next;
				 System.out.println(i+" "+NewNode.data);
				 NewNode=NewNode.next;
			 }
		 }
	 }
	 void addData(String data, int Player)
	 {
		 Node newNode=new Node(data);
		 Node curNode=DeckOfCard.head[Player],PrevNode=null;
		 if(curNode==null)
		 {
			 DeckOfCard.head[Player]=newNode;
			 return;
		 }
		 if(curNode.data.compareTo(data)>0)
		 {
			 DeckOfCard.head[Player]=newNode;
			 newNode.next=curNode;
			 return;
		 }
		 while((curNode.next!=null)&&(data.compareTo(curNode.data)<0))
		 {
			 PrevNode=curNode;
			 curNode=curNode.next;
		 }
		 if(curNode.data==data)
		 {
			 PrevNode.next=curNode.next;
		 }
		 if(data.compareTo(curNode.data)<0)
		 {
			 PrevNode.next=newNode;
			 newNode.next=curNode;
			 return;
		 }
		 if(curNode.next==null)
		 {
			curNode.next=newNode;
			return;
		}
		 
	 }
	 String getRank()
	 {
		 int RandomRank=(int)((Math.random()*(14-1)));
		 String RankArray[]= {"ace","2","3","4","5","6","7","8","9","10","jack","King","Queen"};
		 return RankArray[RandomRank];
	}
	 String getSuit()
	 {
		String Suit=new String();
		int suit=(int)(Math.random()*4);
		switch (suit)
		{
		case 0:
			Suit="Clubs";
			break;
		case 1:
			Suit="Diamonds";
			break;
		case 2:
			Suit="Hearts";
			break;
		case 3:
			Suit="Spades";
			break;
		}
		return Suit;
	 }
 }


