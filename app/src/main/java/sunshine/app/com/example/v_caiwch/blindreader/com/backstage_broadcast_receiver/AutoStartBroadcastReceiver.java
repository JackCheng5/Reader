//package sunshine.app.com.example.v_caiwch.blindreader.com.backstage_broadcast_receiver;
//
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.util.Log;
//
//import sunshine.app.com.example.v_caiwch.blindreader.com.backstage_service.MySensorService;
//
///**
// * Created by v-caiwch on 2017/2/20. 随手机系统开启而开启服务
// */
//public class AutoStartBroadcastReceiver extends BroadcastReceiver {
//    private static final String ACTION = "android.intent.action.BOOT_COMPLETED";
//
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        if (intent.getAction().equals(ACTION)) {
//            Intent startIntent = new Intent(context, MySensorService.class);
//            context.startService(startIntent);
//            Log.d("BroadcastReceiver", "启动~");
//        }
//    }
//}
