public class Main {
    public static void main(String[] args) {
        var table = new HashTable();
        table.set("nails", 100);
        table.set("tile", 50);
        table.set("lumber", 80);
        table.set("bolts", 200);
        table.set("screws", 140);
        table.print();
    }
}