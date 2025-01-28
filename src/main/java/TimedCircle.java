import java.awt.Color;

public class TimedCircle {
    private final int x;
    private final int y;
    private final Color color;
    private final long creationTime;

    public TimedCircle(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.creationTime = System.currentTimeMillis();
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public Color getColor() { return color; }
    public long getCreationTime() { return creationTime; }
}