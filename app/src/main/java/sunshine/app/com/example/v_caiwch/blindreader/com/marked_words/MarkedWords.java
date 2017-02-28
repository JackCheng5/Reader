package sunshine.app.com.example.v_caiwch.blindreader.com.marked_words;

/**
 * Created by v-caiwch on 2017/2/22.
 */

public class MarkedWords {

    private static final String mw_AfterTip = "提示完毕请操作.";
    private static final String mw_TakePhoto = "从上到下在屏幕上滑动,打开拍照读字功能.";
    private static final String mw_ReadBook = "从下到上在屏幕上滑动,打开电子书.";
    private static final String mw_RepeatTip = "重复提示,请双击屏幕,";


//    private static StringBuilder sb_welcome = new StringBuilder();
    private static StringBuilder sb_repeat = new StringBuilder();
    static {

//        sb_welcome.append("欢迎使用,小才子阅读器,请根据语音,执行正确操作." + "\n");
//        sb_welcome.append(mw_TakePhoto + "\n");
//        sb_welcome.append(mw_ReadBook + "\n");
//        sb_welcome.append(mw_RepeatTip + "\n");
//        sb_welcome.append(mw_AfterTip + "\n");


        sb_repeat.append(mw_TakePhoto + "\n");
        sb_repeat.append(mw_ReadBook + "\n");
        sb_repeat.append(mw_RepeatTip + "\n");
        sb_repeat.append(mw_AfterTip + "\n");
    }


//    public static StringBuilder getSb_welcome(){
//        return sb_welcome;
//    }
    public static StringBuilder getSb_repeat() {
        return sb_repeat;
    }
}
