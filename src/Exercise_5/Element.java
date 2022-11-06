package Exercise_5;

public class Element {
    private int x;
    private int y;

    public Element(int x1, int y1) {
        this.x = x1;
        this.y = y1;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    void setX(int x1) {
        this. x = x1;
    }

    void setY(int y1) {
        this.y = y1;
    }

    public int hashCode() {
        int result = 0;
        result = 31 * result + this.x;
        result = 31 * result + this.y;
        return result;
    }

}