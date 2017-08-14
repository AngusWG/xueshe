package cn.huas.xueshe.util;

import org.junit.Before;
import org.junit.Test;

import cn.huas.xueshe.bean.User;

/**
 * Created by 74071 on 2017/3/26.
 */
public class JsonUtilsTest {
    User[] user = new User[5];

    @Before
    public void setUp() throws Exception {

        int i = 10;
        for (User us : user) {
            us = new User();
            us.setUserHead("www.3366.cn " + i);
            us.setUserEmail("7402626@qq.com " + i);
            us.setUserId(+i * 10000);
            us.setUserName("fuck " + i);
            us.setUserNum(i * 100);
            us.setUserPassword("password " + i);
            us.setUserQq("qq" + i);
            us.setUserTel("Tel" + i);
            us.setUserSex("男");
            i += 10;
        }
    }

    @Test
    public void getObjectJsonString() throws Exception {

    }

    @Test
    public void getObjectArrayJson() throws Exception {

    }

    @Test
    public void jsonToJsonObject() throws Exception {
//        JsonUtils.jsonToJsonObject(seas,"data");

    }

    @Test
    public void getObjectToJsonObject() throws Exception {


    }

    @Test
    public void getMapJson() throws Exception {

    }

    @Test
    public void getStringArrayJson() throws Exception {

    }

}