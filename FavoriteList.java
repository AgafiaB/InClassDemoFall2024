public class FavoriteList implements ListADT<Favorite> {
    private Favorite[] favorites;
    private int size;
    private static final int MAX_SIZE = 50; // by making it static, 50 is stored only once


    // create an empty list
    public FavoriteList() {
        this.size = 0;
        this.favorites = new Favorite[MAX_SIZE]; // important to use the constant here (50 null spots open)
    }

@Override
public boolean isEmpty() {
    return (this.size == 0);
    
}

    public boolean isFull() {
        return (this.size == MAX_SIZE); // USE THE CONSTANT
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void add(int index, Favorite f) throws ListException {
        
        // check for exceptions
        if (this.isFull()) { // this reads cleanly
            throw new ListException("List is at maximum capacity.");
        }
        if (index > this.getSize()) { // because size 49 (for example) is index 48, but we are okay if
                                      // it is placed in 49 if the last element placed was in index 48
            throw new ListException("yeet");
        }
        if (index < 0) {
            throw new ListException("yeet");
        }

        // shift elements to the right - do NOT use recursion // we need to start at
        // where the
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
        for (int i = 0; i < this.getSize(); i++) {
            this.favorites[i] = null; 
        }
    }

    @Override
    public void remove(int index) throws ListException {
        // Exceptions
        if (index < 0 || index >= this.getSize()) {
            throw new ListException("Index out of range!"); 
         }

        // remove element and shift elements to the right of the element one place to
        // the left
        for (int i = index; i < this.getSize() - 1; i++) {
            this.favorites[i] = this.favorites[i + 1];
        }

        this.size--; // user cannot access the extra last Favorite that still remains 
        // SMOKE AND MIRRORS 


    }

    @Override
    public Favorite get(int index) throws ListException {
        if (index < 0 || index >= this.getSize()) {
           throw new ListException("Index out of range!");
        }
        return this.favorites[index]; 
    }

    @Override 
    public String toString() {
        String s = ""; 
        for (int i = 0; i < this.getSize(); i++) {
            if (i == this.getSize() - 1) {
                s = s + this.get(i).toString(); 
            } else {
                s = s + this.get(i).toString() + ", ";
            
        }
    }
    return "[" + s + "]"; 
    
    
    }
}
