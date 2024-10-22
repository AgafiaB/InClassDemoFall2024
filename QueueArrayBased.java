public class QueueArrayBased<Unicorn> implements QueueADT<Unicorn>{
    private Object[] queueArray; 
    private int size; // size of the array
    private static final int MAX_CAPACITY = 50; 

    public QueueArrayBased() {
        this.size = 0; 
        this.queueArray = new Object[MAX_CAPACITY]; // Hey, Memory, we need 50 spots
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0; 
    }

    public boolean isFull() {
        return this.size == MAX_CAPACITY; 
    }

    @Override
    public void removeAll() {
        this.size = 0;
        this.queueArray = new Object[MAX_CAPACITY]; 
    }

    @Override
    public Unicorn peek() throws QueueException {
        if (this.isEmpty()) {
            throw new QueueException("Error in peek() method in QueueArrayBased.java: queue is empty"); 
        }
         return (Unicorn) this.queueArray[0]; 
    }

    @Override
    public Unicorn dequeue() throws QueueException {
        if (this.isEmpty()) {
            throw new QueueException("Error in dequeue() method in QueueArrayBased.java: queue is empty."); 
        }
        // 1. retrieve from index 0
        Unicorn retrievedItem = (Unicorn) this.queueArray[0]; 

        // 2. remove first element, shift everything to the left once
        this.queueArray[0] = null; // to ensure that memory is freed 
        for (int i = 1; i < this.size; i++) {
            this.queueArray[i - 1] = this.queueArray[i]; 
        }
        // 3. decrement size by 1
        this.size--; 
        // return retrieved item
        return retrievedItem; 
    }

    @Override
    public void enqueue(Unicorn item) throws QueueException{
        if (this.isFull()) {
           throw new QueueException("Error in enqueue() method in QueueArrayBased.java: queue is full."); 
        }
        this.queueArray[this.size] = item; 
        this.size++; 
    }

    @Override 
    public String toString() {
        String s = "["; 
        for (int i = 0; i < this.size; i++) {
            s = s + this.queueArray[i].toString(); 
            if (i != this.size-1) {
                s = s + ", "; 
            }
        }
        return s + "]"; 
    }

    
}
