package cn.huas.xueshe.util;

import android.util.Log;

/**
 * Created by 74071 on 2017/2/8.
 */

public class L {


    private L() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    private static final String TAG = "tagWay";
    private static boolean debug = true;
    private static boolean warring = true;
    public static String lastString = "";

    public static void e(String msg) {
        if (debug)
            Log.e(TAG, msg);
        System.out.println(msg);
    }

    public static void e(String msg, String tag) {
        if (debug)
            Log.e(tag, msg);
    }

    public static void w(String msg) {
        if (warring)
            lastString = msg;
        Log.e(TAG, msg);
        System.out.println(msg);
    }
}
