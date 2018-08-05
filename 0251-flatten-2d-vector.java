public class Vector2D implements Iterator<Integer> {
    private List<List<Integer>> vec;
    int row = -1;
    int col = 0;
    List<Integer> currentRow = null;
    
    public Vector2D(List<List<Integer>> vec2d) {
        this.vec = vec2d;
        if (this.vec != null) this.setCurrent();
    }

    @Override
    public Integer next() {
        Integer result = this.currentRow.get(this.col);
        
        this.col++;
        this.setCurrent();
        
        return result;
    }

    @Override
    public boolean hasNext() {
        return this.currentRow != null;
    }
    
    private void setCurrent() {
        while (this.currentRow == null || this.col == this.currentRow.size()) {
            this.row++;
            if (this.row < this.vec.size()) {
                this.currentRow = this.vec.get(this.row);
                this.col = 0;
            } else {
                this.currentRow = null;
                break;
            }
        }
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
