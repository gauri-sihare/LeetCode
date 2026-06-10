class MyHashSet {
    boolean[] something;
    public MyHashSet() {
        something = new boolean[10000001];
    }
    
    public void add(int key) {
        something[key] = true;   // uss array me jaake ussi key ko index maan k ussi pe true krdo.
    }
    
    public void remove(int key) {
        something[key] = false;
    }
    
    public boolean contains(int key) {
        return something[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */