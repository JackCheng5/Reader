package sunshine.app.com.example.v_caiwch.blindreader;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;

import sunshine.app.com.example.v_caiwch.blindreader.com.gesture_onscroll_listener.MyGestureListener;
import sunshine.app.com.example.v_caiwch.blindreader.com.marked_words.MarkedWords;

public class MainActivity extends Activity {

    private View gesture_listener_view;
    private static TextToSpeech tts = null;
    private MediaPlayer mp = null;


    private GestureDetectorCompat mDetector;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0x123: {
                    mp.start();
                    mp.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                        @Override
                        public boolean onError(MediaPlayer mp, int what, int extra) {
                            Log.d("ox123:", "media wrong");
                            return false;
                        }
                    });
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {

                            Log.d("ox123:", "media success");
                            listen_onScroll_and_do_fun();
                        }
                    });
                }
                break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gesture_listener_view = findViewById(R.id.gesture_listener_view);

        mDetector = new GestureDetectorCompat(this, new MyGestureListener(new MyGestureListener.OnGestureScrollListener() {
            @Override
            public void scrollDown() {
                Log.d("GestureDetectorCompat,", "down");
            }

            @Override
            public void scrollUp() {
                Log.d("GestureDetectorCompat,", "up");
            }

            @Override
            public void onDoubleTap() {
                Log.d("MainActivity", "" + MarkedWords.getSb_repeat().toString());
                tts.speak(MarkedWords.getSb_repeat().toString(), TextToSpeech.QUEUE_ADD, null);
            }
        }));
    }

    @Override
    protected void onStart() {
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = tts.setLanguage(Locale.CHINA);
                    if (result != TextToSpeech.LANG_COUNTRY_AVAILABLE && result != TextToSpeech.LANG_AVAILABLE) {
                        Toast.makeText(MainActivity.this, "暂时不支持中文", Toast.LENGTH_SHORT);
                    }
                }
            }
        });
        mp = MediaPlayer.create(this, R.raw.welcome);
        handler.sendEmptyMessage(0x123);
        Log.d("onStart:", "what happened?");
        super.onStart();
    }

    @Override
    protected void onResume() {
        handler.sendEmptyMessage(0x123);
        super.onResume();
    }

    @Override
    protected void onStop() {
        if (tts != null) tts.shutdown();
        mp.stop();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        if (tts != null) tts.shutdown();
        mp.stop();
        super.onDestroy();
    }

    public void listen_onScroll_and_do_fun() {

        gesture_listener_view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mDetector.onTouchEvent(event);
                return true;
            }
        });
    }
}
