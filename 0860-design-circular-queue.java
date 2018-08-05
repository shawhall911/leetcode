class MyCircularQueue {

    
    int [] data; 
    int head = -1;
    int tail = -1;
    int cap = 0;
    int size = 0;
    
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        
        data = new int [k];
        cap = k;
        size = 0;
        
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        
        if(cap > size) {
            tail = (tail+1) % cap;
            data[tail] = value;
            if(size == 0) head = tail;
            size ++;
            return true;
                
        }
        return false;
        
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(size > 0){
            int v = data[head];
            head = (head+1)%cap;
            size --;
            if(size == 0) head = tail = -1;
            return true;
        }
        return false;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(size > 0)
            return data[head];
        else
            return -1;
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(size > 0)
            return data[tail];
        else
            return -1;
        
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
        
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == cap;
        
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
