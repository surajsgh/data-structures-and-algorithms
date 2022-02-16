import java.util.HashMap;
import java.util.List;

//  For both Hit and Miss
//  Time Complexity : O(1)

//  Linked list node code
class ListNode {
    int key;
    int value;
    ListNode prev;
    ListNode next;

    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

//  LRU Cache code
public class LRUCache {
    //  Variables
    private HashMap<Integer, ListNode> map;
    private int capacity;
    private int count;
    private ListNode head;
    private ListNode tail;

    //  Constructor for initialization
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count = 0;
    }

    //  Add a node to the head
    public void addToHead(ListNode node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    //  Delete the least recently used node
    public void deleteNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //  Get the value
    public int get(int key) {
        if (map.get(key)!=null) {
            ListNode node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            System.out.println("Got the value : " + result + " for the key: " + key);
            return result;
        }
        else {
            System.out.println("Did not get any value for " + key);
        }
        return -1;
    }

    //  Add the key-value pair
    public void set(int key, int value) {
        System.out.println("Going to set the key value pair as : key: " + key + " and value: " + value);
        if (map.get(key)!=null) {
            ListNode node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }
        else {
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            }
            else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }
    }
}
