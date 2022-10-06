

public class Main {
    public static void main(String[] args) {
        var stack = Stack.of(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.pop();
        stack.print();
    }
}