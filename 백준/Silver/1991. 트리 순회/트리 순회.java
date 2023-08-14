

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static Node head_node=new Node('A',null,null);
	
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			char root=st.nextToken().charAt(0);
			char left=st.nextToken().charAt(0);
			char right=st.nextToken().charAt(0);
			
			add_node(head_node,root,left,right);
		}
		
		preorder(head_node);
		System.out.println();
		inorder(head_node);
		System.out.println();
		postorder(head_node);
	}
	public static void add_node(Node n, char root, char left, char right ) {
		if(n.c==root) {
			if(left=='.') {
				n.left=null;
			}
			else n.left=new Node(left,null,null);
			
			if(right=='.') {
				n.right=null;
			}
			else n.right=new Node(right,null,null);
		}
		else {
			if(n.left!=null) add_node(n.left,root,left,right);
			if(n.right!=null) add_node(n.right,root,left,right);
		}
	}
	public static void preorder(Node node) {
		if(node==null) return;
		System.out.print(node.c);
		preorder(node.left);
		preorder(node.right);
	}
	public static void inorder(Node node) {
		if(node==null) return;
		inorder(node.left);
		System.out.print(node.c);
		inorder(node.right);
	}
	public static void postorder(Node node) {
		if(node==null) return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.c);
	}
	public static class Node{
		char c;
		Node left;
		Node right;
		public Node(char c, Node left, Node right) {
			this.c=c;
			this.left=left;
			this.right=right;
		}
	}

}

