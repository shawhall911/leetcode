class RandomizedSet {
    private HashMap<Integer, Integer> hm;
    private List<Integer> list;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.hm = new HashMap<Integer, Integer>();
        this.list = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (this.hm.containsKey(val)) return false;
        this.list.add(val);
        this.hm.put(val, this.list.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!this.hm.containsKey(val)) return false;
        int i = hm.get(val);
        int lastIndex = this.list.size() - 1;
        int lastVal = this.list.get(lastIndex);
        this.list.set(i, this.list.get(lastIndex));
        this.list.remove(lastIndex);
        this.hm.put(lastVal, i);
        this.hm.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        Double index = random.nextDouble() * this.list.size();
        return this.list.get(index.intValue());
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
