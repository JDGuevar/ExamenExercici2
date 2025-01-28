import java.awt.Color;

/**
 *
 * @author Alumne
 */
public class TimedCircle {
    private final int x;
    private final int y;
    private final Color color;
    private final long creationTime;

    /**
     *
     * @param x
     * @param y
     * @param color
     */
    public TimedCircle(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.creationTime = System.currentTimeMillis();
    }

    /**
     *
     * @return
     */
    public int getX() { return x; }

    /**
     *
     * @return
     */
    public int getY() { return y; }

    /**
     *
     * @return
     */
    public Color getColor() { return color; }

    /**
     *
     * @return
     */
    public long getCreationTime() { return creationTime; }
}