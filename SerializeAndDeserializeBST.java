package LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * This class is the structure of the node
 */
class TreeNode {
	
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x) { 
		this.val = x; 
		this.left = null;
		this.right = null;
	}
}
/**
 * This class Serializes a BST to a String and Deserializes the String back to the BST. 
 * @author Hyder Nabi
 */
public class SerializeAndDeserializeBST {
	/**
	 * Encodes a tree to a single string.
	 * @param root of the Tree
	 * @return Serialized String.
	 */
    public String serialize(TreeNode root) {
        
    	if(root == null) return "";
    	
    	String data = "";
    	
    	Queue<TreeNode> queue = new ArrayDeque<>();
    	queue.offer(root); 
    	
    	while(!queue.isEmpty()) {
    		TreeNode node = queue.poll();
    		
    		data += ((node.val == Integer.MAX_VALUE)?"null":node.val) + "-"; //'-' is acts as separator
    		
    		if(node.val == Integer.MAX_VALUE)continue;
    		
    		if(node.left != null) {
    			queue.offer(node.left);
    		} else {
    			queue.offer(new TreeNode(Integer.MAX_VALUE));
    		}
    		
    		if(node.right != null) {
    			queue.offer(node.right);
    		} else {
    			queue.offer(new TreeNode(Integer.MAX_VALUE));
    		}
    	}
    	return data;    	
        
    }
    
    /**
     * Decodes your encoded data to tree.
     * @param data : Serialized String
     * @return Root of BST
     */
    public TreeNode deserialize(String data) {
        
    	if(data.equals("")) return null;
    	
    	String[] arr = data.split("-");
    	
    	TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
    	
    	Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
    	queue.offer(root);
    	
    	int index = 1;
    	
    	while(!queue.isEmpty() && index<data.length()) {
    		TreeNode node = queue.poll();
    		
    		if(!arr[index].equals("null")) {
    			node.left = new TreeNode(Integer.valueOf(arr[index]));
    			queue.offer(node.left);
    		}
    		index++;
    		if(!arr[index].equals("null")) {
    			node.right = new TreeNode(Integer.valueOf(arr[index]));
    			queue.offer(node.right);
    		}
    		index++;
    		
    	}
    	return root;    	
    }
}
