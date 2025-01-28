
/**
 *
 * @author Alumne
 */
public interface CircleDrawingListener {

    /**
     *
     * @param circle
     */
    void onCircleAdded(TimedCircle circle);

    /**
     *
     * @param circle
     */
    void onCircleRemoved(TimedCircle circle);

    /**
     *
     */
    void onAllCirclesCleared();
}