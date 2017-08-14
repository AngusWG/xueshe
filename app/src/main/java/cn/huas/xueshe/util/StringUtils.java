package cn.huas.xueshe.util;

import android.app.Activity;
import android.telephony.TelephonyManager;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static android.content.Context.TELEPHONY_SERVICE;

/**
 * Created by breeze66 on 2016/10/28.
 */

public class StringUtils {

    /**
     * MD5算法加密
     *
     * @param plainText
     * @return
     */
    public static String Md5(String plainText) {
        StringBuffer buffer = new StringBuffer("");
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i = 0;
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buffer.append("0");
                buffer.append(Integer.toHexString(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static String getSerialNumber() {
        L.e("Get IMEI Star");
        Activity test = new Activity();
        TelephonyManager mTm = (TelephonyManager) test.getSystemService(TELEPHONY_SERVICE);
        String imei = mTm.getDeviceId();
        L.e("Get IMEI Success");
        return imei;
    }

    public static String timeToString(String timeString) {
        if (timeString == "" || timeString == null) {
            return "error";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long time = Long.valueOf(timeString);
        String d = format.format(time);
        java.util.Date date = null;
        try {
            date = format.parse(d);
        } catch (ParseException e) {
            L.e("时间戳转换失败");
            e.printStackTrace();
        }
        return d;
    }

    public static String StringTotime(String string) {
        if (string == "" || string == null) {
            return "error";
        }
        //Date或者String转化为时间戳
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = "1970-01-06 11:45:55";
        java.util.Date date = null;
        try {
            date = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        System.out.print("Format To times:"+date.getTime());
        return String.valueOf(date.getTime());
    }

}
