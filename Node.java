public class Node <E> {
    private E item; 
    private Node <E> nextNode; // using a Node to make a Node

    public Node(E nodeItem) {
        this.item =nodeItem; 
        this.nextNode = null; 
    }

    public E getItem() {
        return this.item; // is this immutable??
    }

    public void setNext(Node<E>) nextNode {
        this.nextNode = nextNode; 
    }

    public Node<E> getNext() {
        return this.nextNode; 
    }

    @Override
    public String toString() {
        if (this.next == null) {
            return "(" + this.item.toString() + ", null)"; 
        } else {
            String remaining = this.nextNode.toString(); 
            return "(" + this.item.toString() + ", " + remaining + ")"; 
        }
    }
}
