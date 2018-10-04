package 알코리즘;

import java.util.Scanner;

// 트리의 순회
public class Baek1991 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        char[] r = sc.nextLine().toCharArray();

        Tree tree = new Tree(r[0],r[2],r[4]);


        for(int i=1;i<n;i++){
            char[] a = sc.nextLine().toCharArray();
            tree.add(a[0],a[2],a[4]);
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);


    }

    private static class Node{
        char data;
        Node leftChild;
        Node rightChild;

        public Node(char data) {
            this.data = data;
        }

    }

    private static class Tree{

        Node root;

        public Tree(char data, char left, char right){
            root = new Node(data);

            if(left != '.') root.leftChild = new Node(left);
            if(right != '.') root.rightChild = new Node(right);
        }

        void add(char data, char left, char right){
            next(root.leftChild,data,left,right);
            next(root.rightChild,data,left,right);
        }

        void next(Node node, char data, char left, char right){
            if(node == null) return;

            if(node.data == data){
                if(left != '.') node.leftChild = new Node(left);
                if(right != '.') node.rightChild = new Node(right);
            }else{
                next(node.leftChild,data,left,right);
                next(node.rightChild,data,left,right);
            }

        }


        void preOrder(Node node){
            System.out.print(node.data);
            if(node.leftChild!=null) preOrder(node.leftChild);
            if(node.rightChild!=null) preOrder(node.rightChild);
        }

        void inOrder(Node node){
            if(node.leftChild!=null) inOrder(node.leftChild);
            System.out.print(node.data);
            if(node.rightChild!=null) inOrder(node.rightChild);
        }

        void postOrder(Node node){
            if(node.leftChild!=null) postOrder(node.leftChild);
            if(node.rightChild!=null) postOrder(node.rightChild);
            System.out.print(node.data);
        }


    }


}
