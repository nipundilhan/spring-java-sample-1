package test.sample.pckg2;

public class RemoveLRU {
	
	
	Node2 root;
	public final static int size = 4;
	int filledNumber = 1;
	
	public void add(String val) {
		
		if(root == null) {
			Node2 n = new Node2();
			n.value = val;
			this.root =  n;
		}else {
			if(filledNumber < size) {
				filledNumber +=1;
				Node2 n = new Node2();
				n.value = val;
				
				Node2 curNode = this.root;
				while(curNode.next != null) {
					curNode = curNode.next;
				}
				
				curNode.next = n;
			}else {
				Node2 curNode = this.root.next;
				this.root = curNode;
				
				while(curNode.next != null) {
					curNode = curNode.next;
				}
				
				Node2 n = new Node2();
				n.value = val;
				curNode.next = n;
				
				
			}
		}
		

			
		}
	
	
		public void printLinkedListt() {
		
			Node2 curNode = this.root;
			while(curNode.next != null) {
				System.out.print(curNode.value+" -> ");
				curNode = curNode.next;
			}
			System.out.println(curNode.value);
		}
		
		public static void main(String args[]) {
			
			RemoveLRU rlru =  new RemoveLRU();
			rlru.add("kamal");
			rlru.add("amal");
			rlru.printLinkedListt();
			rlru.add("nimal");
			rlru.add("samal");
			rlru.printLinkedListt();

			rlru.add("nayani");
			rlru.printLinkedListt();
			rlru.add("kamani");
			rlru.printLinkedListt();
			
			
			
		}
		
		
		
	

}
