package cn.huas.xueshe.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by 74071 on 2017/4/9.
 */
public class StringUtilsTest {

    @Test
    public void timeToStringT() {
        String time = "445555000";
        assertEquals("1970-01-06 11:45:55", StringUtils.timeToString(time));
    }

    @Test
    public void StringToTimeT() {
        String time = "1970-01-06 11:45:55";
        assertEquals("445555000", StringUtils.StringTotime(time));
    }
}