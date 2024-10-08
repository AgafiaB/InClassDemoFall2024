public interface QueueADT<Unicorn> {
    public boolean isEmpty(); 
    public void removeAll(); 
    public Unicorn peek() throws QueueException; 
    public Unicorn dequeue() throws QueueException; 
    public void enqueue(Unicorn item); 
}
