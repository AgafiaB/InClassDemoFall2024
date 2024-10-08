## QueueADT
This abstract data type will provide operations for a queue for generic (QueueItemType) data types. 

# +createQueue()
Creates an empty queue. 

# +isEmpty() : boolean
Returns true if the queue is empty and false otherwise. 

# +removeAll() 
Removes all the items in the queue. 

# +peek() : QueueItemType throws QueueException
Returns the item at the front of the queue without modifying the queue. 

# +dequeue : QueueItemType throws QueueException
Removes and returns the item at the front of the queue. 

# +enqueue(item : QueueItemType)
Adds the given item to the end of the queue. If the queue has a maximum capacity, then an exception is thrown when the queue is full. 


