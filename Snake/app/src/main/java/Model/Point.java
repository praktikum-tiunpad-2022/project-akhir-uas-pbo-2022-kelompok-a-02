package Model;

public class Point {
    private int point;

    public Point() {
        this.point = 0;
    }

    public Point(int point) {
        this.point = point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getPoint() {
        return this.point;
    }

    public void addPoint() {
        this.point += 5;
    }
}
