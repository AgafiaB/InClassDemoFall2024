public class FavoriteList implements ListADT <Favorite> {
    private Favorite[] favorites; 
    private int size; 
    private static final int maxSize = 50; // by making it static, 50 is stored only once 
}

// create an empty list
public FavoriteList() {
    this.size = 0; 
    this.favorites = new Favorite[maxSize]; // important to use the constant here (50 null spots open)
}

@Override
public boolean isEmpty() {
    return (this.size == 0)
    
}

public boolean isFull() {
    return (this.size == maxSize); // USE THE CONSTANT
}

@Override
public int getSize() {
    return this.size; 
}

@Override
public void add(int index, Favorite f) throws ListException {
    Favorite temp; 
    // check for exceptions
    if (this.isFull()) { // this reads cleanly 
        throw new ListException("List is at maximum capacity."); 
    }
    if (index > this.getSize()) { // because size 49 (for example) is index 48, but we are okay if 
                                    // it is placed in 49 if the last element placed was in index 48
        throw new ListException();
    }
    if (index < 0) {
        throw new ListException();
    }

    // shift elements to the right - do NOT use recursion // we need to start at where the 
    for (int i = this.getSize(); i > index; i--) {
        this.favorites[i] = this.favorites[i - i]; 
    }

    // insert new element
    this.favorites[index] = f; 

    // increment size of the FavoriteList
    this.size++; 

}

@Override 
public void removeAll() {
    
}

