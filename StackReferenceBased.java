public class StackReferenceBased<Unicorn> implements StackADT<Unicorn> {

    Node<Unicorn> top;
    int size; 

    public StackReferenceBased() {
        this.top = null; 
        this.size = 0; 
    }

    @Override
    public boolean isEmpty() {
        return (this.top == null); 
    }

    @Override
    public void push(Unicorn newItem) {
        Node<Unicorn> newNode = new Node<>(newItem); 
        newNode.setNext(this.top);
        this.top = newNode; 
        this.size++; 
    }

    @Override
    public Unicorn pop() throws StackException {
        if (this.isEmpty()) {
            throw new StackException("Stack is empty"); 
        }

        Unicorn popped = this.top.getItem(); 
        this.top = this.top.getNext(); 
        this.size--; 
        return popped; 
    
    }

    @Override
    public Unicorn peek() throws StackException {
        if(this.isEmpty()) {
            throw new StackException("Stack is empty"); 
        }
        return this.top.getItem(); 
    }

    @Override
    public void popAll() {
        this.top = null; 
        this.size = 0; 
    }
    
    public int getSize() {
        return size;
    }

    public void reverseStack() {
        StackReferenceBased<Unicorn> newStack = new StackReferenceBased<>(); 

        while (!this.isEmpty()) {
            newStack.push(this.pop()); 
        }
        
        this.top = newStack.top; 
    }

    @Override 
    public String toString() {
        String s = "[";
        Node<Unicorn> currentNode = this.top; 

        while(currentNode != null) {
            s = s + currentNode.getItem().toString(); 

            currentNode = currentNode.getNext(); 
            
            if (currentNode != null) {
                s = s + ", "; 
            }
        }

        s = s + "]"; 
    }




} 