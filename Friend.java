public class Friend {
    public String username; 
    private boolean status; // true - online

    public Friend(String username, boolean status) {
        this.username = username; 
        this.status = status; 
    }

    public Friend(String username) {
        this.username = username; 
        this.status = false; 
    }

    public boolean isOnline() {
        return this.status; 
    }

    public void setStatus(boolean online) {
        this.status = online; 
    }

    @Override
    public String toString() {
        String s = this.status ? "Online" : "Offline"; // ternary operator 
        return this.name + " " + s; 
    }
}