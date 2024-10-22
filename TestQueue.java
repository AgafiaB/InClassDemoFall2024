public class TestQueue {
    public static void main(String[] args) {
        // QueueArrayBased<Integer> queue = new QueueArrayBased<Integer>(); 
        QueueReferenceBased<Integer> queue = new QueueReferenceBased<>(); 
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        System.out.println("Test Enqueue");
        System.out.println(queue);

        for (int i = 0; i < 5; i++) {
            queue.dequeue();
        }
    }
}
