package sunshine.app.com.example.v_caiwch.blindreader.com.gesture_onscroll_listener;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by v-caiwch on 2017/2/27.
 */

public class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

    private OnGestureScrollListener onGestureScrollListener;
    private static final int distance = 888;

    public interface OnGestureScrollListener {
        void scrollDown();
        void scrollUp();
        void onDoubleTap();
    }

    public MyGestureListener(OnGestureScrollListener onGestureScrollListener) {
        this.onGestureScrollListener = onGestureScrollListener;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

        Log.d("MyGestureListener:", String.valueOf(e1.getY() - e2.getY()));
        if (e1.getY() - e2.getY() > distance) {
            onGestureScrollListener.scrollUp();
        } else if (e1.getY() - e2.getY() < -distance) {
            onGestureScrollListener.scrollDown();
        }
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        onGestureScrollListener.onDoubleTap();
        return true;
    }
}
