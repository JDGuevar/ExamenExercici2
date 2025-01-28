public interface CircleDrawingListener {
    void onCircleAdded(TimedCircle circle);
    void onCircleRemoved(TimedCircle circle);
    void onAllCirclesCleared();
}