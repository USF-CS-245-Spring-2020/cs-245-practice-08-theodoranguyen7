public class BST<T>{
    Node root;

    public BST(){
        this.root = null;
    }


    /**
     * This function determines if the element is in the tree. The function will recursively call itself on right
     * if the element is greater than the node. If it is not, the function will recursively call itself on the left.
     * */
    public boolean find(Comparable element){
        return find(root, element);
    }

    protected boolean find(Node node, Comparable element){
        if(node == null){ //This is the base case for when the node is not found.
            return false;
        }
        if(element.compareTo(node.getData()) == 0){ //This checks the current node.
            return true;
        }
        else if(node.getData().compareTo(element) < 0){
             return find(node.getRight(), element);
        }
        else{
             return find( node.getLeft(), element);
        }
    }


    /**
     * This function inserts the element into the tree. Depending on the element,
     * it will be either inserted on the right or left of the tree. The function also rebuilds
     * the tree if the child is where the node was inserted.
     * */
    public void insert(Comparable element){
        this.root = insert(this.root, element);
}

    protected Node insert(Node node, Comparable element){
        if(node == null){
            return new Node(element);
        }
        if(node.getData().compareTo(element) < 0){
            node.setRight(insert(node.getRight(), element));
        }
        else{
            node.setLeft(insert(node.getLeft(), element));
        }
        return node;
    }


    /**
     * This function prints all the data from the left first and then all the data from the right
     * of the tree.
     * */
    public void print(){
        print(root);
    }

    private void print(Node node){
        if(node != null){
            print(node.getLeft());
            System.out.println(node.getData());
            print(node.getRight());
        }
    }


    /**
     * This function deletes an element from the tree. After removal, the tree will rebuild
     * itself in order to support itself.
     * */
    public void delete(Comparable element){
        root = delete(root, element);
    }

    protected Node delete(Node node, Comparable element){
        if(node == null){
            return null;
        }
        if(node.getData().compareTo(element) > 0){
            node.setRight(delete(node.getRight(), element));
            return node;
        }
        else if(node.getData().compareTo(element) < 0){
            node.setLeft(delete(node.getLeft(), element));
            return node;
        }
        else{
            if(node.getLeft() == null){
                return node.getRight();
            }
            else if(node.getRight() == null){
                return node.getLeft();
            }
            else{
                if(node.getRight().getLeft() == null){
                    node.setData(node.getRight().getData());
                    node.setRight(node.getRight().getRight());
                }
                else{
                    node.setData(removeSmallest(node.getRight()));
                }

                return node;
            }
        }
    }

    Comparable removeSmallest(Node node){
        if(node.getLeft().getLeft() == null){
            Comparable<T> smallest = node.getLeft().getData();
            node.setLeft(node.getLeft().getRight());
            return smallest;
        }
        else{
            return removeSmallest(node.getLeft());
        }
    }
}
