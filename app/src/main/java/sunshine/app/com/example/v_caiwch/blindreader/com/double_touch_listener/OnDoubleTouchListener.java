package sunshine.app.com.example.v_caiwch.blindreader.com.double_touch_listener;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by v-caiwch on 2017/2/23.
 */

public class OnDoubleTouchListener implements View.OnTouchListener {
    private long lastTouchTime = 0;
    private int touch_count;
    private static final int intervalTime = 1000;
    private DoubleClickCallback dcc;

    public interface DoubleClickCallback {
        void onDoubleClick();
    }

    public OnDoubleTouchListener(DoubleClickCallback dcc) {
        super();
        this.dcc = dcc;
        touch_count = 0;
    }

    @Override
    public boolean onTouch(final View v, final MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            touch_count++;
            Log.d("OnDoubleTouchListener", "1," + touch_count);
            if (touch_count == 1) {
                lastTouchTime = System.currentTimeMillis();
            } else if (touch_count == 2) {
                long now_click_time = System.currentTimeMillis();
                if (now_click_time - lastTouchTime < intervalTime) {
                    Log.d("OnDoubleTouchListener", "2," + touch_count);
                    if (dcc != null) {
                        dcc.onDoubleClick();
                        Log.d("OnDoubleTouchListener", "3," + dcc.toString());

                    } else {
                        Log.d("OnDoubleTouchListener", "4, onTouch error");
                    }

                }
                lastTouchTime = 0;
                touch_count = 0;
            }

        }
        return true;
    }


}
