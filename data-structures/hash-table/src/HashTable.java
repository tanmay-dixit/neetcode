import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HashTable {
    private final int size = 7;
    private final Node[] dataMap;

    public HashTable() {
        dataMap = new Node[size];
    }

    public void print() {
        for (int currentIndex = 0; currentIndex < size; currentIndex++) {
            System.out.println("Index = " + currentIndex);
            var currentNode = dataMap[currentIndex];
            while (currentNode != null) {
                System.out.println("    {" + currentNode.getKey() + " = " + currentNode.getValue() + "}");
                currentNode = currentNode.getNext();
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash = (hash + c * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        int index = hash(key);
        var newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            var temp = dataMap[index];
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    public int get(String key) {
        int index = hash(key);
        var currentNode = dataMap[index];
        while (currentNode != null) {
            if (Objects.equals(key, currentNode.getKey())) {
                return currentNode.getValue();
            } else {
                currentNode = currentNode.getNext();
            }
        }
        return -1;
    }

    public List<String> keys() {
        var keys = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            var currentNode = dataMap[i];
            while (currentNode != null) {
                keys.add(currentNode.getKey());
                currentNode = currentNode.getNext();
            }
        }
        return List.copyOf(keys);
    }

}
