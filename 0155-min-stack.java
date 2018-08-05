class MinStack {

    Stack<Integer> st = new Stack();
    Stack<Integer> minst = new Stack();
    
    /** initialize your data structure here. */
    public MinStack() { 
        
       
        
    }
    
    public void push(int x) {
        
        st.push(x);
        if(!minst.isEmpty()) {
            int m = minst.peek();
            if(x <= m) minst.push(x);
        }
        else
            minst.push(x);
    }
    
    public void pop() {
        if(!st.isEmpty()) {
            int x = st.peek();
            st.pop();
            int cur = minst.peek();
            if(x == cur)
                minst.pop();
        }
    }
    
    public int top() {
        if(!st.isEmpty())
            return st.peek();
        else
            return -1;
    }
    
    public int getMin() {
        if(!minst.isEmpty()){
            int x = minst.peek();
            return x;
        }
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
