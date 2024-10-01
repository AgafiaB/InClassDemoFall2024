public class FriendsList implements ListADT<Friend> {
    // all we need to access the list is the head node
    private Node<Friend> head; // first node in the list (index 0)
    private int numFriends; 

    public FriendsList() {
        this.numFriends = 0; 
        this.head = null; // references nothing
    }

    public FriendsList(Friend firstFriend) {
        this.head = new Node<Friend>(firstFriend);
        this.numFriends = 1; 
    }

    @Override
    public boolean isEmpty() {
        return this.numFriends == 0; 
    }

    @Override
    public int getSize() {
        return this.numFriends; 
    }

    // precondition: index must be >= 0 
    private Node<Friend> getNodeAt(int index) {
        Node<Friend> node = this.head; 
        for (int i = 1; i <= index; i++) {
            node = node.getNext(); 
        }

        return node; 
    }

    @Override
    public void add(int index, Friend newFriend) throws ListException {
        if(index < 0 || index > this.getSize()) {
            throw new ListException("Index " + index + " invalid for list of size " + this.getSize());
        }
        Node<Friend> newNode = new Node<Friend>(newFriend);

        if (index == 0) {
            newNode.setNext(this.head); 
            this.head = newNode; 
        } else { 
            Node<Friend> predecessor = this.getNodeAt(index - 1); // remember to reuse 
            Node<Friend> successor = predecessor.getNext();
            predecessor.setNext(newNode); 
            newNode.setNext(successor);
        }
    }

// REMEMBER TO THINK ABOUT THE BOUNDARY CASES
    @Override
    public void remove(int index) throws ListException {
        if (index == 0) {
            this.head = this.head.getNext(); 
        }else{
            Node<Friend> predecessor = this.getNodeAt(index - 1);
            Node<Friend> nodeToRemove = predecessor.getNext(); // we don't want to run another for loop b/c it would be inefficient 
            Node<Friend> successor = nodeToRemove.getNext(); 

            predecessor.setNext(successor); 
            nodeToRemove.setNext(null); // optional but being careful
        }

        this.numFriends--; 
    }

    @Override
    public void removeAll() {
        this.numFriends = 0; 
        this.head = null; 
    }

    @Override
    public Friend get(int index) throws ListException {
        if (index < 0 || index > this.getSize() - 1) {
            throw new ListException("Index " + index + " invalid for list of size " + this.getSize());
        }

        Node<Friend> node = this.getNodeAt(index); 
        return node.getItem(); 
    }

    @Override 
    public String toString() {
        StringBuilder string = new StringBuilder("[");  
        // fix comma issue
        if (!this.isEmpty()) {
            Node<Friend> current = this.head; 
            for (int i = 0; i < this.getSize(); i++)
            string.append(current.getItem().toString() + ", "); 
        }

    }

    private int indexOf(Friend friend) {
        Node<Friend> node = this.head; 
        for (int i = 0; i < this.getSize(); i++) {
            if (node.getItem().username.equals(friend.username)) {
                return i; 
            }
            node = node.getNext(); 
        }
        return -1; 
    }
}
    

