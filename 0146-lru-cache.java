class LRUCache {
    private int capacity;
    private HashMap<Integer, DoubleListNode> hm;
    private DoubleListNode head = null;
    private DoubleListNode tail = null;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.hm = new HashMap<Integer, DoubleListNode>(capacity);
    }
    
    public int get(int key) {
        if (!this.hm.containsKey(key)) return -1;
        
        DoubleListNode node = this.hm.get(key);
        this.moveNodeToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        DoubleListNode node = null;
        if (this.hm.containsKey(key)) {
            node = this.hm.get(key);            
            node.val = value;
        } else { 
            if (this.hm.size() == this.capacity) {
                this.hm.remove(this.tail.key);
                DoubleListNode tailPrev = this.tail.prev;
                if (tailPrev != null) tailPrev.next = null;
                this.tail.prev = null;
                this.tail = tailPrev;
            }
            node = new DoubleListNode(key, value);
            hm.put(key, node);
        }
        
        this.moveNodeToHead(node);
    }
    
    private void moveNodeToHead(DoubleListNode node) {
        if (node == this.head) return;
        if (node == this.tail) this.tail = this.tail.prev;
        
        if (node.next != null) node.next.prev = node.prev;
        if (node.prev != null) node.prev.next = node.next;
        node.prev = null;
        node.next = this.head;
        if (this.head != null) this.head.prev = node;
        this.head = node;
        
        if (this.tail == null) this.tail = node;
    }
}

class DoubleListNode {
    public int key;
    public int val;
    public DoubleListNode prev;
    public DoubleListNode next;
    public DoubleListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
