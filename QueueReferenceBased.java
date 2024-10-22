public class QueueReferenceBased<T> implements QueueADT<T> {

    private Node<T> front; 
    private Node<T> rear; 

    // create empty queue
    public QueueReferenceBased() {
        this.front = null; 
        this.rear = null; 
    }

    @Override
    public boolean isEmpty() {
        return this.front == null; 
    }

    @Override
    public void removeAll() {
        this.front = null; 
        this.rear = null; 
    }

    @Override
    public T peek() throws QueueException {
        if (this.isEmpty()) {
            throw new QueueException("Queue is empty"); 
        }
        return this.front.getItem(); 
    }

    @Override
    public T dequeue() throws QueueException {
        if (this.isEmpty()) {
            throw new QueueException("Queue is empty"); 
        }
        T retrievedItem = this.front.getItem(); 
        this.front = this.front.getNext(); 
        
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
