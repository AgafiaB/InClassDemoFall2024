public class QueueCircular<T> implements QueueADT<T> { 
    private Node<T> rear; 

    // create empty queue
    public QueueCircular() { 
        this.rear = null; 
    }

    @Override
    public boolean isEmpty() {
        return this.rear == null; 
    }

    @Override
    public void removeAll() {
        this.rear = null; 
    }

    @Override
    public T peek() throws QueueException {
        if (this.isEmpty()) {
            throw new QueueException("Queue is empty"); 
        }
        return this.rear.getNext().getItem(); 
    }

    // Incomplete - still need to set rear to null if there was only one item

    @Override
    public T dequeue() throws QueueException {
        if (this.isEmpty()) {
            throw new QueueException("Queue is empty"); 
        }
        T retrievedItem = this.rear.getNext().getItem(); 
        Node<T> front = this.rear.getNext();
        
        
        return retrievedItem; 
    }

    @Override
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (this.isEmpty()) {
            this.front = newNode;
        } else {

            this.rear.setNext(newNode); 
        }

        this.rear = newNode; 
    }

    @Override
    public String toString() {
        String s = "["; 
        Node<T> current = this.front; 
        while(current!= null) {
            s = s + current.getItem().toString(); 
            if(current.getNext() != null) {
                s = s + ", "; 

                current = current.getNext(); 
            }
            
        }
        return s + "]"; 
    }
}
