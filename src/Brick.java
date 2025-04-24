public class Brick {
    private int start;
    private int end;
    private int height;
    private int fallHeight;

    public Brick(int start, int end) {
        this.start = start;
        this.end = end;
        this.height = 0;
        fallHeight = 0;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String toString() {
        return start + "," + end + " --> Height: " + height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getFall() {
        return fallHeight;
    }

    public void setFall(int fallHeight) {
        this.fallHeight = fallHeight;
    }
}