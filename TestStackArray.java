public class TestStackArray {
    public static void main(String[] args) {
        StackArrayBased<Character> letters = new StackArrayBased<>(); 

        for (char c = 'a'; c <= 'z'; c++) {
            Character ch = c; 
            letters.push(ch); 
        }

        System.out.println("Original Stack (all letters): " + letters.toString());
    }
}
