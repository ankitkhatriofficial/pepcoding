import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }
  
    static class BSTPair{
        boolean isBST;
        int min;
        int max;
        Node root;
        int size;
    }
    
    public static BSTPair findLargestBST(Node node){
        if(node == null){
            BSTPair bp = new BSTPair();
            bp.isBST = true;
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.size = 0;
            bp.root = null;
            return bp;
        }
        
        BSTPair lPair = findLargestBST(node.left);
        BSTPair rPair = findLargestBST(node.right);
        
        BSTPair myPair = new BSTPair();
        myPair.isBST = lPair.isBST && rPair.isBST &&
                        node.data >= lPair.max &&
                        node.data <= rPair.min;
        
        myPair.min = Math.min(node.data, Math.min(lPair.min, rPair.min));
        myPair.max = Math.max(node.data, Math.max(lPair.max, rPair.max));
        
        if(myPair.isBST){
            myPair.root = node;
            myPair.size = lPair.size + rPair.size + 1;
        }else if(lPair.size > rPair.size){
            myPair.root = lPair.root;
            myPair.size = lPair.size;
        }else{
            myPair.root = rPair.root;
            myPair.size = rPair.size;
        }
        
        return myPair;
    }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    
    BSTPair res = findLargestBST(root);
    System.out.println(res.root.data + "@" + res.size);
  }

}