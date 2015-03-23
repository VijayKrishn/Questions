import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class InterviewQuestions {

	int treeheight, arrayMax, arrayMin;
	
	public boolean checkAnagram(String one, String two){
		boolean check = false;
		if(one.length() != two.length())
			return false;
		else{
			int[] alpharr = new int[26];
			char arr1[] = one.toLowerCase().toCharArray();
			char arr2[] = two.toLowerCase().toCharArray();
			for(int i=0; i<arr1.length; i++){
				alpharr[(int)(arr1[i]-'a')]++;
				alpharr[(int)(arr2[i]-'a')]--;
			}
			for(int i=0; i< alpharr.length; i++){
				if(alpharr[i] != 0){
					check = false;
					break;
				}
				else
					check = true;
			}
			return check;
		}
 	}
	
	static class Node{
		Node left, right;
		int value;
		public Node(int val){
			value = val; 
		}
	}
	
	public Node sortedArrayToBST(int[] arr, int left, int right){
		if(left > right)
			return null;
		int mid = (left + right)/2;
		if(left == right)
			return new Node(arr[left]);
		Node root = new Node(arr[mid]);
	    root.left = sortedArrayToBST(arr, left, mid-1);
		root.right = sortedArrayToBST(arr, mid+1, right);
		return root;
	}
	
	public void traverseTreeInorder(Node root){
		if(root != null){
			traverseTreeInorder(root.left);
			System.out.print(root.value+ " ");
			traverseTreeInorder(root.right);
		}
	}
	
	public void levelOrderTraverse(Node root){
		Queue<Node> levels = new LinkedList<Node>();
		levels.add(root);
		while(!levels.isEmpty()){
			root = levels.remove();
			System.out.print(root.value + " ");
			if(root.left != null)
				levels.add(root.left);
			if(root.right != null)
				levels.add(root.right);
		}
	}
	
	public int treeHeight(Node root){
		if(root == null)
			return -1;
		else
			treeheight = Math.max(treeHeight(root.left)+1, treeHeight(root.right)+1);
		return treeheight;
	}
	
	public int intersectionTwoArrays(int[] arr1, int []arr2){
		int diff,intersection;
		diff = intersection =0;
		if(arr1.length != arr2.length)
			diff = Math.abs(arr1.length - arr2.length);
		if(arr1.length > arr2.length){
			for(int i = diff, j = 0; i < arr1.length; i++, j++){
				if(arr1[diff] == arr2[j])
					intersection = arr1[diff];
				else
					intersection = -Integer.MAX_VALUE;
			}
		}
		return intersection;
	}
	
	static class LinkedNode{
		LinkedNode next;
		LinkedNode nextbig;
		int val;
		public LinkedNode(int val){
			this.val = val;
			next = null;
			nextbig = null;
		}
	}
	
	public void pointNextHighest(LinkedNode head){
		if(head == null);
		else{
		Stack<LinkedNode> stack =  new Stack<LinkedNode>();
		while(head.next != null){
			stack.push(head);
			head = head.next;
			while(!stack.isEmpty()){
				if(stack.peek().val < head.val){
					stack.pop().nextbig = head;
				}
				else
					break;
			}
		}
	}
	}
	
	public void printPathsTree(Node root){
		
	}
	
	public void checkPathSum(Node root, int sum){
		
	}
	
	public void checkBinaryPallindrome(){
		String binary;
		for(int i=1; i<= 100; i++){
			binary = Integer.toBinaryString(i);
			char[] arr = binary.toCharArray();
			int j = 0;
			int k = arr.length -1;
			boolean check = false;
			while(j<=k){
				if(arr[j] == arr[k]){
					j++;
					k--;
					check = true;
				}
				else{
					check = false;
					break;
				}
			}
			if(check)
				System.out.println(i + " : "+ binary);
		}
	}
	
	public int missingNumberInArray(int []arr){
		int arrsum = 0;
		int seqsum = 0;
		int noofTerms = 0;
		for(int i =0; i<arr.length; i++){
			arrsum += arr[i];
			if(arr[i] > arrayMax)
				arrayMax = arr[i];
			if(arr[i] < arrayMin)
				arrayMin = arr[i];
		}
		noofTerms = arrayMax - arrayMin + 1;
		seqsum = ((noofTerms)*(2*arrayMin + (noofTerms - 1)))/2;
		return (seqsum-arrsum);
	}
	
	public static void main(String[] args){
		int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int arr2[] = {1,5,4,6,3,2,8,9,13,11,12,10};
		InterviewQuestions obj = new InterviewQuestions();
		Node root = obj.sortedArrayToBST(arr, 0, 14);
		System.out.println(obj.checkAnagram("cinema", "iceman"));
		System.out.println(root.value);
		obj.traverseTreeInorder(root);
		System.out.println();
		obj.levelOrderTraverse(root);
		System.out.println();
		System.out.println(obj.treeHeight(root));
		System.out.println(obj.missingNumberInArray(arr2));
		obj.checkBinaryPallindrome();
	}
}
