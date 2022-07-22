package com.example.study.demo.datastructure;

import org.bouncycastle.jcajce.provider.symmetric.Noekeon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTreeDemo {

    public static void main(String[] args) {
        int[] arr={13,7,8,3,29,6,1};
        HuffmanTreeDemo demo=new HuffmanTreeDemo();
        Node node= demo.genHuffmanTree(arr);
        node.preOrder();
    }

    public  Node genHuffmanTree(int[] arr){
        List<Node> nodes=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            Node node=new Node(arr[i]);
            nodes.add(node);
        }
        Collections.sort(nodes);
//        System.out.println(nodes);

        while (nodes.size()>1){
            Node leftNode=nodes.get(0);
            Node rightNode=nodes.get(1);
            Node parentNode=new Node(leftNode.value+rightNode.value);
            parentNode.left=leftNode;
            parentNode.right=rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parentNode);
            Collections.sort(nodes);
        }
        return nodes.get(0);
    }

    class Node implements Comparable<Node>{
        public int value;//权值
        public Node left;
        public Node right;

        public Node(int value){
            this.value=value;
        }

        //前序遍历
        public void preOrder(){
            if (this==null){
                System.out.println("空树 无法遍历！");
                return;
            }
            System.out.println(this);
            if (this.left!=null){
                this.left.preOrder();
            }
            if (this.right!=null){
                this.right.preOrder();
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
        @Override
        public int compareTo(Node o) {
            return this.value-o.value;
        }
    }





}
