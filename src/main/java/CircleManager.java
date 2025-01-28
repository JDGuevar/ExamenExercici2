
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.awt.Color;

public class CircleManager {

    private final List<TimedCircle> circles = new ArrayList<>();
    private final List<CircleDrawingListener> listeners = new ArrayList<>();
    private final Random random = new Random();
    private static final long CIRCLE_LIFETIME = 5000; // 5 seconds

    public void addCircle(int x, int y) {
        Color randomColor = new Color(
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256)
        );
        //TODO: Afegeix els cercles

        TimedCircle circle = new TimedCircle(x, y, randomColor);
        circles.add(circle);
        notifyCircleAdded(circle);
    }

    public void checkAndRemoveExpiredCircles() {
        boolean removed = false;
        long currentTime = System.currentTimeMillis();
        Iterator<TimedCircle> iterator = circles.iterator();
        while (iterator.hasNext()) {
            // TODO: Comprova que no es colin cercles
            TimedCircle circle = iterator.next();
            if (currentTime - circle.getCreationTime() >= CIRCLE_LIFETIME) {
                iterator.remove();
                notifyCircleRemoved(circle);
            }
        }
    }

    public void clearAllCircles() {
        circles.clear();
        notifyAllCirclesCleared();
    }

    public List<TimedCircle> getCircles() {
        return circles;
    }

    public void addListener(CircleDrawingListener listener) {
        listeners.add(listener);
    }

    public void removeListener(CircleDrawingListener listener) {
        listeners.remove(listener);
    }

    private void notifyCircleAdded(TimedCircle circle) {
        for (CircleDrawingListener listener : listeners) {
            listener.onCircleAdded(circle);
        }
    }

    private void notifyCircleRemoved(TimedCircle circle) {
        for (CircleDrawingListener listener : listeners) {
            listener.onCircleRemoved(circle);
        }
    }

    private void notifyAllCirclesCleared() {
        for (CircleDrawingListener listener : listeners) {
            listener.onAllCirclesCleared();
        }
    }
}
