public class Main {
    public static void main(String[] args) {
        var queue = Queue.of(7);
        queue.enqueue(544);
        queue.dequeue();
        queue.print();
    }
}
