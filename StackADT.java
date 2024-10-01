public interface StackADT<Unicorn> {
    // determine if the stack is empty
    public boolean isEmpty(); 

    // add a new item to the stack
    public void push(Unicorn newItem); 

    // remove and return stack top
    public Unicorn pop() throws StackException; 

    // returns stack top
    public Unicorn peek() throws StackException; 

    public void popAll(); 
    
}
