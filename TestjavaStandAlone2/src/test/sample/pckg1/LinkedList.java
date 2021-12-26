package test.sample.pckg1;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
	
	Node head = null;
	int size = 0;
	
	
	public void addanyWay(int val) {
		
		if(this.head == null) {
			Node nh = new Node();
			nh.value = val;
			this.head = nh;
		}else {
			Node curNode = head;
			
			while(curNode.next != null) {
				curNode = curNode.next;
			}
			
			Node n = new Node();
			n.value = val;
			curNode.next = n;		
		}		
	}
	
	
	public void addAscending(int val) {
		
		if(size < 4) {
			size = size +=1;
			if (this.head == null) {
				Node nh = new Node();
				nh.value = val;
				this.head = nh;
			} else {
				comman(val);
			}
		}else {
			
			Node curNode = head;
			this.head = curNode.next;
			comman(val);
			
		}
		
	}
	
	
	public void comman(int val) {
		Node curNode = this.head;
		if(val <= curNode.value ) {
			Node n = new Node();
			n.value = val;
			n.next = curNode;
			this.head = n;
		}else {
			while (curNode.next != null) {	
				if( val <= curNode.next.value) {
					break;
				}
				curNode = curNode.next;

			}
			if(curNode.next == null) {
				Node n = new Node();
				n.value = val;
				curNode.next = n;
			}else {
				Node n = new Node();
				n.value = val;
				n.next = curNode.next;
				curNode.next= n;						
			}
			
		}
	}
	
	
	public void printLinkedList(LinkedList lnklst) {
		
		if(lnklst.head != null) {
			Node curNd = lnklst.head ;
			
			while(curNd.next != null) {
				System.out.print(curNd.value +" -> ");
				curNd = curNd.next;
			}
			
			System.out.println(curNd.value);
		}
		
		
		
	}
	
	
	
	
	public static void main(String args[]) {
		
		LinkedList lnklst = new LinkedList();
		System.out.println("start");
//		lnklst.addanyWay(2);
//		lnklst.addanyWay(5);
//		lnklst.addanyWay(8);
//		lnklst.addanyWay(4);
		
//		lnklst.addAscending(11);
//		lnklst.addAscending(8);
//		lnklst.addAscending(2);
//		lnklst.addAscending(4);
//		lnklst.printLinkedList(lnklst);
//		lnklst.addAscending(1);
//		lnklst.printLinkedList(lnklst);
//		lnklst.addAscending(5);
//		
//		System.out.println("end adding");
//		lnklst.printLinkedList(lnklst);
//		System.out.println("end printing");
		
		List<Integer> lst = new ArrayList<>(); 
		lst.add(12);lst.add(10);lst.add(16);lst.add(1);
		lst.sort(null);
		

		
		
		
	}

}
