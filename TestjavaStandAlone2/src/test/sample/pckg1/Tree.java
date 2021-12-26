package test.sample.pckg1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Tree {
	
	TreeNode root;
	
	public void addNode(Integer val) {
		if(root == null) {
			TreeNode tnr = new TreeNode();
			tnr.value = val;
			this.root =  tnr;
		}else {
			TreeNode curNode = this.root;
			boolean findPlace = false;
			while(findPlace == false) {
				if(curNode.value > val) {
					if(curNode.left == null) {
						findPlace = true;
						TreeNode tn = new TreeNode();
						tn.value = val;
						curNode.left = tn;
						break;
					}else {
						curNode = curNode.left;
					}
				}else {
					if(curNode.right == null) {
						findPlace = true;
						TreeNode tn = new TreeNode();
						tn.value = val;
						curNode.right = tn;
						break;
					}else {
						curNode = curNode.right;
					}
					
				}
			}
			
		}
		
	}

	
	
	public void printTree(Tree tr) {
		
		List<TreeNode> lstLevel1 = new ArrayList<>(); 
		List<TreeNode> lstLevel2 = new ArrayList<>();
		List<List<TreeNode>> listFinal = new ArrayList<>(); 
		
		lstLevel1.add(tr.root);
		
		while(!lstLevel1.isEmpty()) {
			System.out.println("size list "+lstLevel1.size());
			for(TreeNode tn:lstLevel1) {
				System.out.println(tn.value);
				if(tn.left!= null) {
					lstLevel2.add(tn.left);
				}else {
					if(tn.value !=0) {
						TreeNode dummy = new TreeNode();
						lstLevel2.add(dummy);
					}
				}
				if(tn.right!= null) {
					lstLevel2.add(tn.right);
				}else {
					if(tn.value !=0) {
						TreeNode dummy = new TreeNode();
						lstLevel2.add(dummy);
					}
				}
			}
			System.out.println("loop running");
			
			listFinal.add(lstLevel1);
			lstLevel1 = new ArrayList<>(); 
			lstLevel1 = lstLevel2;	
			lstLevel2 = new ArrayList<>(); 
		}
		
		int level = 2;
		System.out.println("final list levels - "+listFinal.size());
		int finalListSize = listFinal.size();
		
		
		
		
		List<Integer> loopTimes = new ArrayList<>();
		int loopNo = 2;
		loopTimes.add(0);
		loopTimes.add(loopNo);
		for(int i = 2; i < finalListSize+1; i++ ) {
			loopNo = loopNo + calculatePower(2,(i));
			loopTimes.add(loopNo);
		}
		
		loopTimes =loopTimes.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println("final loop time list - "+loopTimes);

		
		System.out.println(" ");
		System.out.println(" -----------------------------------------------------going to print the tree ---------------------------------------------------");
		System.out.println(" ");
		
		for(List<TreeNode> treeNodeList:listFinal) {
//			System.out.print(" "+loopTimes.get(level-1));
			for(int j=0 ; j < loopTimes.get(level-1) ; j++) {
				System.out.print(" ");
			}

			for(TreeNode trNd:treeNodeList) {
				if(trNd != null){
					if(trNd.value != 0) {
						System.out.print(trNd.value);
					}else {
						System.out.print(" ");
					}
				}else {
					System.out.print("   ");
				}

				if (level > 1) {
					for (int j = 0; j < loopTimes.get(level-2); j++) {
						System.out.print(" ");
					}
				}
			}
			level += 1;
			System.out.println(" ");
			System.out.println(" --------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(" ");
			
		}
				
	}
	
	
	public void printpath(Tree t, Integer val) {
		TreeNode curNode = t.root;
		List<Integer> pathList = new ArrayList<>();
		
		if(curNode != null) {
			boolean find = false;
			while(!find) {
				System.out.println("searching"+curNode.value);
				if(val == curNode.value) {
					pathList.add(curNode.value);
					find = true;
				}
				else if(val < curNode.value) {
					pathList.add(curNode.value);
					if((curNode.left == null)) {
						break;
					}else {
						curNode= curNode.left;
					}
					
					
				}else {
					pathList.add(curNode.value);
					if((curNode.right == null)) {
						break;
					}else {
						curNode= curNode.right;
					}
				}
			}
			
			if(find == false) {
				System.out.println("value "+ val +" not exists in tree");
			}else {
				System.out.println("path to value " + val + " is " + pathList);
			}
			
			
		}else {
			System.out.println("no path for value - " + val);
		}
		
		
	}
	
	
    static int calculatePower(int num, int power){
        int answer = 1;
        if(num > 0 && power==0){
            return answer;
        }
        else if(num == 0 && power>=1){
            return 0;
        }
        else{
            for(int i = 1; i<= power; i++){
                answer = answer*num;
            }
            return answer;
        }
    }
	
	public static void main(String args[]) {
		Tree tr = new Tree();
/*		tr.addNode(24);
		tr.addNode(12);
		tr.addNode(48);
		tr.addNode(8);
		tr.addNode(18);
		tr.addNode(40);
		tr.addNode(80);
		
		tr.addNode(04);
		tr.addNode(10);
		tr.addNode(16);
		tr.addNode(20);		
		tr.addNode(27);
		tr.addNode(42);
		tr.addNode(75);
		tr.addNode(82);
		
		tr.addNode(02);
		tr.addNode(07);
		tr.addNode(9);
		tr.addNode(11);		
		tr.addNode(12);
		tr.addNode(17);
		tr.addNode(19);
		tr.addNode(21);
		
		tr.addNode(25);
		tr.addNode(29);
		tr.addNode(41);
		tr.addNode(45);		
		tr.addNode(71);
		tr.addNode(77);
		tr.addNode(81);
		tr.addNode(87);
		*/
		
		
		tr.addNode(40);
		
		tr.addNode(20);
		tr.addNode(70);
		
		tr.addNode(15);
		tr.addNode(27);
		tr.addNode(54);
		tr.addNode(88);
		
		tr.addNode(11);
		tr.addNode(17);
		tr.addNode(24);
		tr.addNode(32);		
		tr.addNode(42);
		tr.addNode(60);
		tr.addNode(84);
		tr.addNode(92);
		
		tr.addNode(10);
		tr.addNode(12);
		tr.addNode(16);
		tr.addNode(18);		
		tr.addNode(21);
		tr.addNode(25);
		tr.addNode(29);
		tr.addNode(36);		
		tr.addNode(41);
		tr.addNode(47);
		tr.addNode(59);
		tr.addNode(61);		
		tr.addNode(80);
		tr.addNode(87);
		tr.addNode(90);
		tr.addNode(96);


		
		tr.printTree(tr);
		tr.printpath(tr,59);
		tr.printpath(tr,55);
		
	}

}
