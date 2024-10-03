public class StackArrayBased<Unicorn> implements StackADT<Unicorn>{
    private static final int MAX_CAPACITY = 50; 
    private int top; // index for top of stack

    private Object[] items; // holds stack items

    public StackArrayBased() {
        this.items = new Object[MAX_CAPACITY];
        this.top = -1; // use -1 to indicate empty
    }

    // determine if the stack is empty
    @Override
    public boolean isEmpty() {
        return (this.top == -1); 
    }

    public boolean isFull() {
        return (this.top == MAX_CAPACITY - 1); 
    }

    // add a new item to the stack
    @Override
    public void push(Unicorn newItem) throws StackException {
        if (this.isFull()) {
            throw new StackException("Stack is full");
        }

        this.top++; 
        this.items[this.top] = newItem; 
    }
    
    // remove and return stack top
    @Override
    public Unicorn pop() throws StackException {
        if (this.isEmpty()) {
            throw new StackException("Stack is empty"); 
        }

        Unicorn retrieved = (Unicorn) this.items[this.top]; // cast Object to type Unicorn
        this.items[this.top] = null; 
        this.top--; 

        return retrieved; 
    } 
    
    // returns stack top
    @Override
    public Unicorn peek() throws StackException {
        if (this.isEmpty()) {
            throw new StackException("Stack is empty"); 
        }

        return (Unicorn) this.items[this.top]; // cast Object to type Unicorn
    }
    
    @Override
    public void popAll() {
        this.top = -1; 
        this.items = new Object[MAX_CAPACITY]; // erases 50 old memory locations, replaces them w/ 50 new ones
    }

    @Override
    public String toString() {
        String s = "["; 
        for (int i = top; i >= 0; i--) {
            s = s + this.items[i].toString(); 
            if (i != 0) {
                s = s + ", ";
            } 
            
        }
        return s + "]"; 
    }
}
