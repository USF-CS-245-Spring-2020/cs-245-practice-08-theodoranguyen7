/**
 * This whole java class is creating setters and getters functions that will be called
 * in BST.java
 * */

public class Node {
    private Node left;
    private Node right;
    private Comparable data;


    public Node(Comparable data){
        this.data = data;
    }

    public void setLeft(Node node){
        this.left = node;
    }

    public void setRight(Node node){
        this.right = node;
    }

    public Node getLeft(){
        return this.left;
    }

    public Node getRight(){
        return this.right;
    }

    public void setData(Comparable data){
        this.data = data;
    }

    @Override
    public String toString(){
        return data.toString();
    }

    public Comparable getData(){
        return this.data;
    }
}


