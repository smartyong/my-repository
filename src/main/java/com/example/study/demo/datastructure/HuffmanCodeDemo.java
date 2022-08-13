package com.example.study.demo.datastructure;

import java.util.*;

public class HuffmanCodeDemo {

    public static Map<Character,String> huffmanCodeMap=new HashMap<>();
//    public static StringBuilder codes=new StringBuilder();

    public static void main(String[] args) {

        String content="i like like like java do you like a java";
        System.out.println(content);
        HashMap<Character, Integer> charsCount = getCharsCount(content);
        Node huffmantree = genHuffmantree(charsCount);
//        huffmantree.preOrder();
        getCharsCode(huffmantree,"",new StringBuilder());
        System.out.println(huffmanCodeMap);

        //霍夫曼编码
        String s =convertContent(content);//
        System.out.println(s);

        //霍夫曼解码 还原
        System.out.println(getOriString(s,huffmanCodeMap));

    }

    /**
     * 霍夫曼 解码 还原
     * @param hufStr
     * @return
     */
    public static String getOriString(String hufStr,Map<Character,String> huffmanCodeMap){
        StringBuilder stringBuilder=new StringBuilder();
        HashMap<String,Character> reverseMap=new HashMap<>();
        huffmanCodeMap.forEach((c,s)->{
            reverseMap.put(s,c);
        });
        for (int i=0; i <hufStr.length() ;) {
            boolean loop=true;
            int index=i+1;
            while (loop){
                String str=hufStr.substring(i,index);
               if (reverseMap.get(str)!=null){
                   stringBuilder.append(reverseMap.get(str));
                   loop=false;
               }else {
                   index++;
               }
            }
            i=index;
        }
        return stringBuilder.toString();
    }

    /**
     * 将字符串 按霍夫曼编码
     * @param content
     * @return
     */
    public static String convertContent(String content){
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <content.length() ; i++) {
            sb.append(huffmanCodeMap.get(content.charAt(i)));
        }
        return sb.toString();
    }

    public static void getCharsCode(Node node,String code,StringBuilder sb){
        StringBuilder sb2=new StringBuilder(sb);
        sb2.append(code);
        if (node!=null){
            if (node.c==null){//非叶子节点  递归
                getCharsCode(node.left,"0",sb2);
                getCharsCode(node.right,"1",sb2);
            }else {//叶子节点
                huffmanCodeMap.put(node.c,sb2.toString());
            }
        }
    }

    public static HashMap<Character,Integer> getCharsCount(String  str){
        HashMap<Character,Integer> charCountMap=new HashMap<>();
        if (str==null){
            return null;
        }
        for (int i = 0; i <str.length() ; i++) {
            Character s=str.charAt(i);
            if (charCountMap.get(s)==null){
                charCountMap.put(s,1);
            }else {
                charCountMap.put(s,charCountMap.get(s)+1);
            }
        }
        return charCountMap;
    }

    public static Node genHuffmantree(HashMap<Character,Integer> map){
        List<Node> nodes=new ArrayList<>();
        map.forEach((s,i)->{
            Node node=new Node(i,s);
            nodes.add(node);
        });
        while (nodes.size()>1){
            Collections.sort(nodes);
            Node leftNode=nodes.get(0);
            Node rightNode=nodes.get(1);
            Node parentNode=new Node(leftNode.value+rightNode.value);
            parentNode.left=leftNode;
            parentNode.right=rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parentNode);
        }
       return nodes.get(0);
    }

}
class Node implements Comparable<Node>{
    public int value;
    public Character c;
    public Node left;
    public Node right;

    public Node(int value){
       this.value=value;
    }

    public Node(int value,char c){
        this.c=c;
        this.value=value;
    }

    public String preSearchChar(char c){

        if (this.c!=null&&this.c==c){
            return "0";
        }
        if (this.left!=null){
            this.left.preSearchChar(c);
        }

        return null;
    }

    public void preOrder(){
        if (this==null){
            System.out.println("空树无法遍历！");
            return;
        }
        System.out.println(this.toString());
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
                ", c=" + c +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }
}
