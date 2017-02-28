//package sunshine.app.com.example.v_caiwch.blindreader.com.backstage_service;
//
//import android.app.Service;
//import android.content.Intent;
//import android.os.IBinder;
//import android.support.annotation.Nullable;
//import android.util.Log;
//
//import sunshine.app.com.example.v_caiwch.blindreader.com.sensor_monitor_listener.SensorManagerHelper;
//
///**
// * Created by v-caiwch on 2017/2/22.
// */
//
//public class MySensorService extends Service {
//    private SensorManagerHelper sensorManagerHelper = null;
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    @Override
//    public void onCreate() {
//        sensorManagerHelper = new SensorManagerHelper(this);
//        sensorManagerHelper.setOnShakeListener(new SensorManagerHelper.OnShakeListener() {
//            @Override
//            public void onShake() {
//                Log.d("MySensorService", "haha");
//            }
//        });
//        super.onCreate();
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        sensorManagerHelper.start();
//        return super.onStartCommand(intent, flags, startId);
//    }
//
//    @Override
//    public void onDestroy() {
//        sensorManagerHelper.stop();
//        super.onDestroy();
//    }
//
//}
